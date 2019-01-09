package pageObject;

import java.util.Random;

public class Helper {
    public static int getRandom(int range) {
        Random random = new Random();
        return random.nextInt(range);
    }
}