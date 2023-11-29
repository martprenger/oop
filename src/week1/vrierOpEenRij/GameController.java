package week1.vrierOpEenRij;

import edu.princeton.cs.introcs.DrawListener;

public class GameController implements DrawListener {
    private Game game;

    public GameController(Game game) {
        this.game = game;
    }
    @Override
    public void mouseClicked(double x, double y) {
        int column = (int) (x / 40);
        if (game.isHumanTurn() && !game.getCurrentBoard().isFinished()) {
            game.doMove(column);
        }
    }
}
