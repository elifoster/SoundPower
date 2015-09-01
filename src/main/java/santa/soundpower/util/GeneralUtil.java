package santa.soundpower.util;

public class GeneralUtil {

    /**
     * @param min Minimum range
     * @param max Maximum range
     * @param x   Number being tested against
     * @return true if x is between min and max, else false
     */
    public static boolean isBetween(int min, int max, int x) {
        if (x > min && x < max) {
            return true;
        } else {
            return false;
        }
    }
}
