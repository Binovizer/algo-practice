package algo.arraysandstring;

import java.util.HashSet;
import java.util.Set;

/**
 * The type UniqueCharacters
 *
 * @author Mohd Nadeem
 */
public class UniqueCharacters {

    public boolean hasUniqueCharacters(String string) {
        if (string.length() > 256) {
            return false;
        }
        Set<Character> uniques = new HashSet<>();
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (uniques.contains(c)) {
                return false;
            }
            uniques.add(c);
        }
        return true;
    }

    public boolean hasUniqueCharactersV2(String string) {
        if (string.length() > 256) {
            return false;
        }
        boolean[] arr = new boolean[256];
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (arr[c]) {
                return false;
            }
            arr[c] = true;
        }
        return true;
    }

    public boolean hasUniqueCharactersV3(String string) {
        if (string.length() > 26) {
            return false;
        }
        int checker = 0;
        for (int i = 0; i < string.length(); i++) {
            int val = string.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) {
                return false;
            }
            checker |= 1 << val;
        }
        return true;
    }
}
