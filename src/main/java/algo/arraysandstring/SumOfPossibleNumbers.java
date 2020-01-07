package algo.arraysandstring;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type SumOfPossibleNumbers
 *
 * @author Mohd Nadeem
 */
public class SumOfPossibleNumbers {

    public static void main(String[] args) {
        String str = "1khjl12kl124l";

        SumOfPossibleNumbers sumOfPossibleNumbers = new SumOfPossibleNumbers();
        int sum = sumOfPossibleNumbers.sum(str);
        System.out.println("sum = " + sum);
    }

    private int sum(String str) {
        int sum = 0;
        String regex = "\\d+";
        Matcher matcher = Pattern.compile(regex).matcher(str);
        while (matcher.find()) {
            String group = matcher.group();
            sum += Integer.parseInt(group);
        }
        return sum;
    }
}
