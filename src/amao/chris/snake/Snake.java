package amao.chris.snake;

import amao.chris.snake.board.GameBoard;
import amao.chris.snake.board.GamePanel;
import amao.chris.snake.board.StatsPanel;

import javax.swing.*;
import java.awt.*;

public class Snake {

    private static JFrame board;

    private static int HEIGHT, WIDTH;

    private static Color BACKGROUND_COLOR = Color.DARK_GRAY;

    private static final int TOP_PANEL_HEIGHT = 50;
    private static final Color TOP_PANEL_COLOR = Color.GRAY;

    private static final int REFRESH = 50;

    private static final int GRID_GAP = 30;
    private static final Color GRID_COLOR = Color.LIGHT_GRAY;

    private static final Color APPLE_COLOR = Color.RED;
    private static final Color HEAD_COLOR = Color.GREEN;
    private static final Color TAIL_COLOR = Color.ORANGE;
    private static final Color REPLACE_COLOR = new Color(51, 51, 51);

    private static StatsPanel statsPanel;

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                board = new GameBoard("Snake", BACKGROUND_COLOR);

                board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                board.setUndecorated(true);

                ImageIcon imageIcon = new ImageIcon("./assets/icon.png");
                board.setIconImage(imageIcon.getImage());

                GraphicsEnvironment gen = GraphicsEnvironment.getLocalGraphicsEnvironment();
                GraphicsDevice gd = gen.getDefaultScreenDevice();
                gd.setFullScreenWindow(board);

                HEIGHT = gd.getFullScreenWindow().getHeight();
                WIDTH = gd.getFullScreenWindow().getWidth();

                statsPanel = new StatsPanel(TOP_PANEL_HEIGHT, WIDTH, TOP_PANEL_COLOR);
                board.add(statsPanel, BorderLayout.CENTER);

                GamePanel gamePanel = new GamePanel(HEIGHT - TOP_PANEL_HEIGHT, WIDTH, BACKGROUND_COLOR);
                board.add(gamePanel, BorderLayout.CENTER);
            }
        });
    }

    public static int getRefresh() {
        return REFRESH;
    }

    public static int getGridGap() {
        return GRID_GAP;
    }

    public static int getHeight() {
        return HEIGHT;
    }

    public static int getWidth() {
        return WIDTH;
    }

    public static Color getGridColor() {
        return GRID_COLOR;
    }

    public static int getTopPanelHeight() {
        return TOP_PANEL_HEIGHT;
    }

    public static Color getAppleColor() {
        return APPLE_COLOR;
    }

    public static Color getHeadColor() {
        return HEAD_COLOR;
    }

    public static Color getTailColor() {
        return TAIL_COLOR;
    }

    public static Color getBackgroundColor() {
        return BACKGROUND_COLOR;
    }

    public static Color getReplaceColor() {
        return REPLACE_COLOR;
    }

    public static StatsPanel getStatsPanel() {
        return statsPanel;
    }

}
