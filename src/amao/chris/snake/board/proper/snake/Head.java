package amao.chris.snake.board.proper.snake;

import amao.chris.snake.Snake;
import amao.chris.snake.board.GamePanel;
import amao.chris.snake.board.proper.Drawable;
import amao.chris.snake.board.proper.snake.enums.Movement;
import amao.chris.snake.board.proper.utils.Coords;
import amao.chris.snake.board.proper.utils.IntegerUtils;
import amao.chris.snake.board.utils.enums.FieldType;
import amao.chris.snake.board.utils.enums.UpdateAction;
import amao.chris.snake.board.utils.sound.SoundUtils;

import java.awt.*;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class Head implements Drawable {

    protected Coords coords;
    protected Movement movement;

    protected int width, height;
    protected Color color;

    protected LinkedList<Tail> tail;

    protected SoundUtils POINT_SCORE_SOUND;
    protected SoundUtils GAME_OVER_SOUND;
    protected boolean GAME_OVER_SOUND_PLAYED = false;

    public Head(final int width, final int height, final Color color) {
        this.width = width;
        this.height = height;
        this.color = color;
        this.coords = new Coords(0, 0);
        this.movement = Movement.UP;
        this.tail = new LinkedList<>();
        try {
            GAME_OVER_SOUND = new SoundUtils("game_over.mp3");
            POINT_SCORE_SOUND = new SoundUtils("point_score.mp3");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void draw(Graphics g) {
        if (ateApple()) {
            POINT_SCORE_SOUND.play();

            Snake.getStatsPanel().getField(FieldType.PLAYER_STATS).updateField(UpdateAction.SCORE_UPDATE);
            GamePanel.getApple().getCoords().randomize();

            if (this.tail.size() == 0) {
                switch (this.movement) {
                    case UP:
                        this.tail.add(new Tail(this.width, this.height, Color.ORANGE, new Coords(this.coords.x, this.coords.y + 1), this.movement));
                        break;
                    case LEFT:
                        this.tail.add(new Tail(this.width, this.height, Color.ORANGE, new Coords(this.coords.x + 1, this.coords.y), this.movement));
                        break;
                    case DOWN:
                        this.tail.add(new Tail(this.width, this.height, Color.ORANGE, new Coords(this.coords.x, this.coords.y - 1), this.movement));
                        break;
                    case RIGHT:
                        this.tail.add(new Tail(this.width, this.height, Color.ORANGE, new Coords(this.coords.x - 1, this.coords.y), this.movement));
                        break;
                }
            } else {
                Tail along = this.tail.get(this.tail.size() - 1);
                switch (along.getMovement()) {
                    case UP:
                        this.tail.add(new Tail(this.width, this.height, Color.ORANGE, new Coords(along.getCoords().x, along.getCoords().y + 1), along.getMovement()));
                        break;
                    case LEFT:
                        this.tail.add(new Tail(this.width, this.height, Color.ORANGE, new Coords(along.getCoords().x + 1, along.getCoords().y), along.getMovement()));
                        break;
                    case DOWN:
                        this.tail.add(new Tail(this.width, this.height, Color.ORANGE, new Coords(along.getCoords().x, along.getCoords().y - 1), along.getMovement()));
                        break;
                    case RIGHT:
                        this.tail.add(new Tail(this.width, this.height, Color.ORANGE, new Coords(along.getCoords().x - 1, along.getCoords().y), along.getMovement()));
                        break;
                }
            }
        }

        if (!(inBorder()) && !(hurtItself())) {
            Snake.getStatsPanel().getField(FieldType.GAME_OVER).updateField(UpdateAction.GAME_OVER);
            if (!(GAME_OVER_SOUND_PLAYED)) {
                GAME_OVER_SOUND_PLAYED = true;
                GAME_OVER_SOUND.play();
            }
        } else {
            //
            g.setColor(Snake.getBackgroundColor());
            g.fillRect(this.coords.x * Snake.getGridGap(), this.coords.y * Snake.getGridGap(), this.width, this.height);
            g.setColor(Snake.getReplaceColor());
            g.drawRect(this.coords.x * Snake.getGridGap(), this.coords.y * Snake.getGridGap(), this.width, this.height);

            move();
            g.setColor(this.color);
            g.fillRect(this.coords.x * Snake.getGridGap(), this.coords.y * Snake.getGridGap(), this.width, this.height);
            //
            for (int i = 0; i < this.tail.size(); i++) {
                final int index = i;
                if (i == 0) {
                    final Movement mo = this.movement;
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            tail.get(index).setMovement(mo);
                        }
                    }, 0);
                } else {
                    final Movement mo = this.tail.get(i - 1).getMovement();
                    new Timer().schedule(new TimerTask() {
                        @Override
                        public void run() {
                            tail.get(index).setMovement(mo);
                        }
                    }, 0);
                }
                //
                this.tail.get(i).draw(g);
            }
        }
    }

    public Coords getCoords() {
        return this.coords;
    }

    public void randomizeMovement() {
        final int r = IntegerUtils.getRandomInRange(0, 3);
        switch (r) {
            case 0:
                this.movement = Movement.UP;
                break;
            case 1:
                this.movement = Movement.LEFT;
                break;
            case 2:
                this.movement = Movement.DOWN;
                break;
            case 3:
                this.movement = Movement.RIGHT;
                break;
        }
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

    public void setMovement(final Movement movement) {
        this.movement = movement;
    }

    public Movement getMovement() {
        return this.movement;
    }

    protected boolean ateApple() {
        return (GamePanel.getApple().getCoords().x == this.coords.x && GamePanel.getApple().getCoords().y == this.coords.y);
    }

    protected boolean inBorder() {
        return (this.coords.x * Snake.getGridGap() <= GamePanel.getPanelWidth() && this.coords.x >= 0 && (this.coords.y + 1) * Snake.getGridGap() <= GamePanel.getPanelHeight() && this.coords.y >= 0);
    }

    protected boolean hurtItself() {
        for (final Tail t : this.tail) {
            if (this.coords.x == t.getCoords().x && this.coords.y == t.getCoords().y) return true;
        }
        return false;
    }

    public LinkedList<Tail> getTail() {
        return this.tail;
    }

}
