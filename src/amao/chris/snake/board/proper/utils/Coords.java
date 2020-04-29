package amao.chris.snake.board.proper.utils;

import amao.chris.snake.board.GamePanel;

public class Coords {

    public int x, y;

    public Coords(final int x, final int y) {
        this.x = x;
        this.y = y;
    }

    public void randomize() {
        int randX = IntegerUtils.getRandomInRange(0, GamePanel.getGrid().getXGaps() - 1);
        int randY = IntegerUtils.getRandomInRange(0, GamePanel.getGrid().getYGaps() - 1);
        this.x = randX;
        this.y = randY;
    }

}
