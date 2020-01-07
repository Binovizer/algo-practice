package algo.utils;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Utility
 *
 * @author Mohd Nadeem
 */
public class Utility {

    public static <T> List<List<T>> twoDArrayToList(T[][] twoDArray) {
        return Arrays.stream(twoDArray).map(Arrays::asList).collect(Collectors.toList());
    }
}
