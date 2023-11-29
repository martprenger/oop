package week1.vrierOpEenRij;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import edu.princeton.cs.introcs.Draw;

public class Game {
    private Board currentBoard;
    private int currentPlayer;
    private final List<Observer> observers;
    private final Scanner scanner = new Scanner(System.in);

    public Game() {
        observers = new ArrayList<>();
    }

    public Board getCurrentBoard() {
        return currentBoard;
    }

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    private void displayBoards() {
        for (Observer observer : observers) {
            observer.displayBoard(currentBoard);
        }
    }

    private void finishTurn() {
        if (currentPlayer==Board.PLAYER1) {
            currentPlayer=Board.PLAYER2;
        } else if (currentPlayer==Board.PLAYER2) {
            currentPlayer=Board.PLAYER1;
        } else {
            throw new IllegalStateException("Invalid current player");
        }
    }

    public void doMove(int column) {
        if (!currentBoard.isFinished()) {
            currentBoard = currentBoard.doMove(currentPlayer, column);
            finishTurn();
        }
        if (!currentBoard.isFinished()) {
            doTurnComputer();
        }
        displayBoards();
    }

    private void doTurnComputer() {
        int column=0;
        while(!currentBoard.isValidMove(column)) { column++; }
        if (column<Board.NUMBER_OF_COLS) {
            currentBoard=currentBoard.doMove(currentPlayer, column);
            finishTurn();
        } else {
            throw new IllegalStateException("No valid move possible");
        }
    }

    private void doTurnHuman() {
        System.out.print("Jij bent aan de beurt. In welke kolom wil je de steen werpen? (1-"+Board. NUMBER_OF_COLS+")");
        int column = Integer.parseInt(scanner.nextLine().trim())-1;
        doMove(column);
    }

    public boolean isHumanTurn() {
        return currentPlayer==Board.PLAYER2;
    }

    public void runGame() {
        currentBoard=new Board();
        currentPlayer=Board.PLAYER1;
        doTurnComputer();
        displayBoards();
    }

}