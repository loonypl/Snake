package amao.chris.snake.board;

import amao.chris.snake.board.listeners.KeyHandler;

import javax.swing.*;
import java.awt.*;

public class GameBoard extends JFrame {

    public GameBoard(final String title, final Color backgroundColor) {
        super(title);

        Container c = getContentPane();
        c.setBackground(backgroundColor);

        FlowLayout flowLayout = new FlowLayout();
        flowLayout.setVgap(0);
        flowLayout.setHgap(0);
        setLayout(flowLayout);

        addKeyListener(new KeyHandler());

        setFocusable(true);
        requestFocusInWindow();
    }

}
