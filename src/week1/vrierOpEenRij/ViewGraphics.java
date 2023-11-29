package week1.vrierOpEenRij;

import java.awt.Color;
public class ViewGraphics implements Observer{

    public ViewGraphics() {
        StdDraw.setScale(0, Math.max(Board.NUMBER_OF_COLS,Board.NUMBER_OF_ROWS)*40);
        StdDraw.clear(Color.BLUE);
    }

    @Override
    public void displayBoard(Board board) {
        for(int col=0; col<Board.NUMBER_OF_COLS; col++) {
            for(int row=0; row<Board.NUMBER_OF_ROWS; row++) {
                if (board.get(col,row)==Board.PLAYER1) {
                    StdDraw.setPenColor(Color.RED);
                } else if (board.get(col,row)==Board.PLAYER2) {
                    StdDraw.setPenColor(Color.YELLOW);
                } else {
                    StdDraw.setPenColor(Color.LIGHT_GRAY);
                }
                StdDraw.filledCircle(20+col*40, Board.NUMBER_OF_ROWS*40-(row*40)+20, 15);
            }
        }
    }
}
