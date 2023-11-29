package week1.vrierOpEenRij;

import java.awt.Color;
import edu.princeton.cs.introcs.Draw; // Gebruik de Draw-klasse in plaats van StdDraw

public class ViewGraphics implements Observer {
    private Draw drawInstance; // Veld voor de instantie van Draw

    public ViewGraphics(Draw drawInstance) {
        this.drawInstance = drawInstance;
        this.drawInstance.setScale(0, Math.max(Board.NUMBER_OF_COLS, Board.NUMBER_OF_ROWS) * 40);
        this.drawInstance.clear(Color.BLUE);
    }

    @Override
    public void displayBoard(Board board) {
        for (int col = 0; col < Board.NUMBER_OF_COLS; col++) {
            for (int row = 0; row < Board.NUMBER_OF_ROWS; row++) {
                if (board.get(col, row) == Board.PLAYER1) {
                    this.drawInstance.setPenColor(Color.RED);
                } else if (board.get(col, row) == Board.PLAYER2) {
                    this.drawInstance.setPenColor(Color.YELLOW);
                } else {
                    this.drawInstance.setPenColor(Color.LIGHT_GRAY);
                }
                this.drawInstance.filledCircle(20 + col * 40, Board.NUMBER_OF_ROWS * 40 - (row * 40) - 20, 15);
                // Voeg hier logica toe voor het afhandelen van acties met muis/toetsenbord met behulp van this.drawInstance
            }
        }
        if(board.isFinished()){
            String winner;
            if (board.isWinner(Board.PLAYER1)) {
                winner = "Speler 1 (COMPUTER) heeft gewonnen!";
            } else if (board.isWinner(Board.PLAYER2)) {
                winner = "Speler 2 (MENS) heeft gewonnen!";
            } else {
                winner = "Er is geen winnaar.";
            }
            this.drawInstance.text(200,200,winner);
            // ben te lui om het mooi te maken.
        }
    }
}
