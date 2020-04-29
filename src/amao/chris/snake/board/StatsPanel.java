package amao.chris.snake.board;

import amao.chris.snake.board.utils.enums.FieldType;
import amao.chris.snake.board.utils.UpdateField;

import javax.swing.*;
import java.awt.*;

public class StatsPanel extends JPanel {

    protected int height, width;
    protected Color color;

    protected UpdateField playerScore, gameOver, exitInfo;
    private static int PLAYER_SCORE = 0;

    public StatsPanel(final int height, final int width, final Color color) {
        this.height = height;
        this.width = width;
        this.color = color;

        setLayout(new GridLayout(1, 3));
        setPreferredSize(new Dimension(width, height));
        setBackground(color);

        playerScore = new UpdateField("Score: " + PLAYER_SCORE, FieldType.PLAYER_STATS);
        add(playerScore);

        gameOver = new UpdateField("Game Over", FieldType.GAME_OVER);
        add(gameOver);

        exitInfo = new UpdateField("Press ESC to exit", FieldType.EXIT_INFO);
        add(exitInfo);
    }

    public UpdateField getField(final FieldType fieldType) {
        switch (fieldType) {
            case PLAYER_STATS:
                return playerScore;
            case GAME_OVER:
                return gameOver;
            case EXIT_INFO:
                return exitInfo;
        }
        return null;
    }

    public static int getPlayerScore() {
        return PLAYER_SCORE;
    }

    public static void updatePlayerScore(final int update) {
        PLAYER_SCORE += update;
    }

}