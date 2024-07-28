package algo.practice.v2.utils;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-20
 */
public class StringUtil {

    public static String repeatString(String str, int times) {
        return new String(new char[times]).replace("\0", str);
    }

    public static boolean isEmpty(String str) {
        return str == null || str.isEmpty();
    }
}
