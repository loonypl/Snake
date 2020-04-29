package amao.chris.snake.board.proper.snake;

import amao.chris.snake.Snake;
import amao.chris.snake.board.proper.Drawable;
import amao.chris.snake.board.proper.snake.enums.Movement;
import amao.chris.snake.board.proper.utils.Coords;

import java.awt.*;

public class Tail implements Drawable {

    protected Coords coords;

    protected int width, height;
    protected Color color;

    protected Movement movement;

    public Tail(final int width, final int height, final Color color, final Coords coords, final Movement movement) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.coords = coords;
        this.movement = movement;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Snake.getBackgroundColor());
        g.fillRect(this.coords.x * Snake.getGridGap(), this.coords.y * Snake.getGridGap(), this.width, this.height);
        g.setColor(Snake.getReplaceColor());
        g.drawRect(this.coords.x * Snake.getGridGap(), this.coords.y * Snake.getGridGap(), this.width, this.height);

        move();
        g.setColor(this.color);
        g.fillRect(this.coords.x * Snake.getGridGap(), this.coords.y * Snake.getGridGap(), this.width, this.height);
    }

    protected void move() {
        switch (this.movement) {
            case UP:
                this.coords.y -= 1;
                break;
            case LEFT:
                this.coords.x -= 1;
                break;
            case DOWN:
                this.coords.y += 1;
                break;
            case RIGHT:
                this.coords.x += 1;
                break;
        }
    }

    public Coords getCoords() {
        return this.coords;
    }

    public void setCoords(final Coords coords) {
        this.coords = coords;
    }

    public Movement getMovement() {
        return this.movement;
    }

    public void setMovement(final Movement movement) {
        this.movement = movement;
    }

}
