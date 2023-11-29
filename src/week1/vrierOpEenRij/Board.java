package week1.vrierOpEenRij;

public class Board {

    public static final int NONE = 0;
    public static final int PLAYER1 = 1;
    public static final int PLAYER2 = 2;

    public static final int NUMBER_OF_COLS = 8;
    public static final int NUMBER_OF_ROWS = 8;

    private final int[][] board;

    public Board() {
        board=new int[NUMBER_OF_COLS][NUMBER_OF_ROWS];
    }

    public Board(Board board) {
        this();
        // De array wordt gekopiëerd, om onbedoelde wijzigingen in de array van het argument te voorkomen.
        for(int col=0; col<NUMBER_OF_COLS; col++) {
            for(int row=0; row<NUMBER_OF_ROWS; row++) {
                this.board[col][row]=board.get(col, row);
            }
        }
    }

    public Board(Board board, int player, int column) {
        this(board);
        boolean didNotMove = true;
        if (isValidMove(column)) {
            for(int col=0; col<NUMBER_OF_COLS; col++) {
                for (int row = NUMBER_OF_ROWS-1; row >= 0 ; row--) {
                    if ((col==column)&&(board.get(col, row)==0)&&didNotMove){
                        this.board[col][row] = player;
                        didNotMove = false;
                    } else {
                        this.board[col][row] = board.get(col, row);
                    }

                }
            }
        } else {
            throw new IllegalStateException("Invalid move");
        }
    }

    public Board doMove(int player, int column) {
        return new Board(this, player, column);
    }
    public int get(int column, int row) {
        return board[column][row];
    } // getter voor een steen op bepaalde positie
    public boolean isValidMove(int column) {
        return (board[column][0] == 0);
    } // kan in de kolom een steen worden geworpen?
    public boolean isFinished() {
        return (isWinner(PLAYER1)||isWinner(PLAYER2));

    } // is het spel afgelopen?
    public boolean isWinner(int player) {
        // Check horizontally for a win
        for (int row = 0; row < NUMBER_OF_ROWS; row++) {
            for (int col = 0; col <= NUMBER_OF_COLS - 4; col++) {
                if (board[row][col] == player &&
                        board[row][col + 1] == player &&
                        board[row][col + 2] == player &&
                        board[row][col + 3] == player) {
                    return true;
                }
            }
        }

        // Check vertically for a win
        for (int col = 0; col < NUMBER_OF_COLS; col++) {
            for (int row = 0; row <= NUMBER_OF_ROWS - 4; row++) {
                if (board[row][col] == player &&
                        board[row + 1][col] == player &&
                        board[row + 2][col] == player &&
                        board[row + 3][col] == player) {
                    return true;
                }
            }
        }

        // Check diagonally (top-left to bottom-right) for a win
        for (int row = 0; row <= NUMBER_OF_ROWS - 4; row++) {
            for (int col = 0; col <= NUMBER_OF_COLS - 4; col++) {
                if (board[row][col] == player &&
                        board[row + 1][col + 1] == player &&
                        board[row + 2][col + 2] == player &&
                        board[row + 3][col + 3] == player) {
                    return true;
                }
            }
        }

        // Check diagonally (bottom-left to top-right) for a win
        for (int row = 3; row < NUMBER_OF_ROWS; row++) {
            for (int col = 0; col <= NUMBER_OF_COLS - 4; col++) {
                if (board[row][col] == player &&
                        board[row - 1][col + 1] == player &&
                        board[row - 2][col + 2] == player &&
                        board[row - 3][col + 3] == player) {
                    return true;
                }
            }
        }
        return false; // No winning combination found
    }
    // heeft player gewonnen?
}
