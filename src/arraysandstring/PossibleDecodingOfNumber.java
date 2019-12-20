package arraysandstring;

/**
 * The type PossibleDecodingOfNumber
 *
 * @author Mohd Nadeem
 */
public class PossibleDecodingOfNumber {

  public static void main(String[] args) {
    PossibleDecodingOfNumber possibleDecodingOfNumber = new PossibleDecodingOfNumber();
    int ans = possibleDecodingOfNumber.countDecoding(121);
    System.out.println("ans = " + ans);
  }

  private int countDecoding(int num) {
    char[] digits = String.valueOf(num).toCharArray();
    return countDecoding(digits, digits.length);
  }

  private int countDecoding(char[] digits, int n) {
    if (n == 0 || n == 1) {
      return 1;
    }
    int count = 0;
    if (digits[n - 1] > '0') {
      count += countDecoding(digits, n - 1);
    }
    if (digits[n - 2] <= '2' && digits[n - 1] < '7') {
      count += countDecoding(digits, n - 2);
    }
    return count;
  }
}
