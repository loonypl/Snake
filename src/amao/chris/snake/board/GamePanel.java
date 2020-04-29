package amao.chris.snake.board;

import amao.chris.snake.Snake;
import amao.chris.snake.board.proper.apple.Apple;
import amao.chris.snake.board.proper.grid.Grid;
import amao.chris.snake.board.proper.snake.Head;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class GamePanel extends JPanel {

    protected static int panelHeight, panelWidth;
    protected Color color;

    private static Grid grid;
    private static Head head;
    private static Apple apple;

    public GamePanel(final int height, final int width, final Color color) {
        panelHeight = height;
        panelWidth = width;
        this.color = color;

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(width, height));
        setBackground(color);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        //
        grid = new Grid(panelWidth, panelHeight, Snake.getGridGap(), Snake.getGridColor());
        grid.draw(g);

        apple = new Apple(Snake.getGridGap(), Snake.getGridGap(), Snake.getAppleColor());
        apple.getCoords().randomize();

        head = new Head(Snake.getGridGap(), Snake.getGridGap(), Snake.getHeadColor());
        head.getCoords().randomize();
        head.randomizeMovement();

        Timer gameTimer = new Timer();
        gameTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Graphics g2d = getGraphics();

                apple.draw(g2d);

                head.draw(g2d);
            }
        }, 0, Snake.getRefresh());
    }

    public static Grid getGrid() {
        return grid;
    }

    public static Head getHead() {
        return head;
    }

    public static Apple getApple() {
        return apple;
    }

    public static int getPanelWidth() {
        return panelWidth;
    }

    public static int getPanelHeight() {
        return panelHeight;
    }

}
