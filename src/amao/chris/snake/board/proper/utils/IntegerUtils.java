package amao.chris.snake.board.proper.utils;

import java.util.Random;

public class IntegerUtils {

    public static int getRandomInRange(final int min, final int max) {
        if (min >= max) throw new IllegalArgumentException("max must be > than min");
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
