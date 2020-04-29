package amao.chris.snake.board.proper.apple;

import amao.chris.snake.Snake;
import amao.chris.snake.board.proper.Drawable;
import amao.chris.snake.board.proper.utils.Coords;

import java.awt.*;

public class Apple implements Drawable {

    protected Coords coords;

    protected int width, height;
    protected Color color;

    public Apple(final int width, final int height, final Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.coords = new Coords(0, 0);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(this.color);
        g.fillRect(this.coords.x * Snake.getGridGap(), this.coords.y * Snake.getGridGap(), this.width, this.height);
    }

    public Coords getCoords() {
        return this.coords;
    }

}
