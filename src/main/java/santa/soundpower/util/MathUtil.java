package santa.soundpower.util;

public class MathUtil {

    public static boolean isBetween(int min, int max, int x) {
        if (x > min && x < max) {
            return true;
        } else {
            return false;
        }
    }
}
