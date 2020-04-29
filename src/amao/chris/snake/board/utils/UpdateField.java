package amao.chris.snake.board.utils;

import amao.chris.snake.board.StatsPanel;
import amao.chris.snake.board.utils.enums.FieldType;
import amao.chris.snake.board.utils.enums.UpdateAction;
import com.sun.istack.internal.Nullable;

import javax.swing.*;
import java.awt.*;

public class UpdateField extends JTextField {

    public UpdateField(final String text, final FieldType fieldType) {
        super(text);

        setFocusable(false);

        setOpaque(false);
        setBorder(null);
        setEditable(false);
        setHorizontalAlignment(JTextField.CENTER);

        switch (fieldType) {
            case PLAYER_STATS:
                setFont(new Font("Arial", Font.PLAIN, 16));
                setForeground(Color.GREEN);
                break;
            case GAME_OVER:
                setFont(new Font("Arial", Font.BOLD, 16));
                setForeground(Color.RED);
                setVisible(false);
                break;
            case EXIT_INFO:
                setFont(new Font("Arial", Font.PLAIN, 16));
                setForeground(Color.WHITE);
                break;
        }
    }

    public void updateField(final UpdateAction updateAction) {
        switch (updateAction) {
            case SCORE_UPDATE:
                StatsPanel.updatePlayerScore(1);
                setText("Score: " + StatsPanel.getPlayerScore());
                break;
            case GAME_OVER:
                if (isVisible()) setVisible(false);
                else setVisible(true);
                break;
        }
    }

}
