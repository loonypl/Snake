package amao.chris.snake.board.proper.grid;

import amao.chris.snake.board.proper.Drawable;

import java.awt.*;

public class Grid implements Drawable {

    protected int width, height, gap;
    protected int xgaps, ygaps;

    protected Color color;

    public Grid(final int width, final int height, final int gap, final Color color) {
        this.width = width;
        this.height = height;
        this.gap = gap;
        this.color = color;
        this.xgaps = width / gap;
        this.ygaps = height / gap;
    }

    @Override
    public void draw(Graphics g) {
        for (int x = 0; x < xgaps; x++) {
            int xpos = x * this.gap;
            for (int y = 0; y < ygaps; y++) {
                int ypos = y * this.gap;
                g.drawRect(xpos, ypos, this.gap, this.gap);
            }
        }
    }

    public int getXGaps() {
        return this.xgaps;
    }

    public int getYGaps() {
        return this.ygaps;
    }

}
