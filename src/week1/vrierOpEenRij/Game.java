package week1.vrierOpEenRij;

import java.util.Scanner;

public class Game {

    private Board currentBoard;
    private int currentPlayer;

    // User-interface
    //private final Observer displayBoard = new ViewConsole();
    private final Observer displayBoard = new ViewGraphics();
    private final Scanner scanner = new Scanner(System.in);

    private void finishTurn() {
        if (currentPlayer==Board.PLAYER1) {
            currentPlayer=Board.PLAYER2;
        } else if (currentPlayer==Board.PLAYER2) {
            currentPlayer=Board.PLAYER1;
        } else {
            throw new IllegalStateException("Invalid current player");
        }
    }

    private void doMove(int column) {
        currentBoard=currentBoard.doMove(currentPlayer, column);
        finishTurn();
        displayBoard.displayBoard(currentBoard);
    }

    private void doTurnComputer() {
        int column=0;
        while(!currentBoard.isValidMove(column)) { column++; }
        if (column<Board.NUMBER_OF_COLS) {
            doMove(column);
        } else {
            throw new IllegalStateException("No valid move possible");
        }
    }

    private void doTurnHuman() {
        System.out.print("Jij bent aan de beurt. In welke kolom wil je de steen werpen? (1-"+Board. NUMBER_OF_COLS+")");
        int column = Integer.parseInt(scanner.nextLine().trim())-1;
        doMove(column);
    }

    public void runGame() {
        currentBoard=new Board();
        currentPlayer=Board.PLAYER1;
        while(!currentBoard.isFinished()) {
            if (currentPlayer==Board.PLAYER1) {
                doTurnComputer();
            } else {
                doTurnHuman();
            }
        }
        if (currentBoard.isWinner(Board.PLAYER1)) {
            System.out.println("Speler 1 (COMPUTER) heeft gewonnen!");
        } else if (currentBoard.isWinner(Board.PLAYER2)) {
            System.out.println("Speler 2 (MENS) heeft gewonnen!");
        } else {
            System.out.println("Er is geen winnaar.");
        }

    }

}