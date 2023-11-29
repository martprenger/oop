package week1.vrierOpEenRij;

public class ViewConsole implements Observer {

    public char boardChar(int player) {
        if (player==Board.PLAYER1) {
            return 'O';
        }
        if (player==Board.PLAYER2) {
            return 'X';
        }
        return '.';
    }

    @Override
    public void displayBoard(Board board) {
        System.out.println();
        for(int row=0; row<Board.NUMBER_OF_ROWS; row++) {
            for(int col=0; col<Board.NUMBER_OF_COLS; col++) {
                System.out.print(boardChar(board.get(col,row)));
            }
            System.out.println();
        }

        if(board.isFinished()){
            if (board.isWinner(Board.PLAYER1)) {
                System.out.println("Speler 1 (COMPUTER) heeft gewonnen!");
            } else if (board.isWinner(Board.PLAYER2)) {
                System.out.println("Speler 2 (MENS) heeft gewonnen!");
            } else {
                System.out.println("Er is geen winnaar.");
            }
        }
    }

}