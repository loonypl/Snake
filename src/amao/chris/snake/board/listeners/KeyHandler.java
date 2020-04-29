package amao.chris.snake.board.listeners;

import amao.chris.snake.Snake;
import amao.chris.snake.board.GamePanel;
import amao.chris.snake.board.proper.snake.Tail;
import amao.chris.snake.board.proper.snake.enums.Movement;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;

public class KeyHandler implements KeyListener  {

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
        else if (e.getKeyCode() == KeyEvent.VK_UP && GamePanel.getHead().getMovement() != Movement.DOWN) {
            GamePanel.getHead().setMovement(Movement.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_LEFT && GamePanel.getHead().getMovement() != Movement.RIGHT) {
            GamePanel.getHead().setMovement(Movement.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN && GamePanel.getHead().getMovement() != Movement.UP) {
            GamePanel.getHead().setMovement(Movement.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT && GamePanel.getHead().getMovement() != Movement.LEFT) {
            GamePanel.getHead().setMovement(Movement.RIGHT);
        }
    }

}
