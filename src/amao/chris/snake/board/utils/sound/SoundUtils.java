package amao.chris.snake.board.utils.sound;

import com.sun.javafx.application.PlatformImpl;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.util.Duration;

import java.io.File;

public class SoundUtils {

    protected File file;
    protected Media media;
    protected MediaPlayer mediaPlayer;

    public SoundUtils(final String clipName) {
        PlatformImpl.startup(() -> {
            this.file = new File("./assets/" + clipName);
            this.media = new Media(this.file.toURI().toString());
            this.mediaPlayer = new MediaPlayer(this.media);
        });
    }

    public void play() {
        PlatformImpl.startup(() -> {
            this.mediaPlayer.seek(Duration.ZERO);
            this.mediaPlayer.play();
        });
    }

}
