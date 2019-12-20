package arraysandstring;

/**
 * The type StringCompression
 *
 * @author Mohd Nadeem
 */
public class StringCompression {

  public String compress(String string) {
    StringBuilder ans = new StringBuilder();
    int count = 0;
    for (int i = 0; i < string.length(); i++) {
      count++;
      if (i + 1 >= string.length() || string.charAt(i) != string.charAt(i + 1)) {
        ans.append(string.charAt(i)).append(count);
        count = 0;
      }
    }
    return ans.length() > string.length() ? string : ans.toString();
  }
}
