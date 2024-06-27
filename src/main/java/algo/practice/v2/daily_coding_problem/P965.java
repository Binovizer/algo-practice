package algo.practice.v2.daily_coding_problem;

/**
 * The type P963
 *
 * @author nadeem Date : 14/03/24
 */
public class P965 {
    public static boolean isValidUTF8(int[] data) {
        int remainingBytes = 0;

        for (int value : data) {
            if (remainingBytes == 0) {
                if ((value >> 5) == 0b110) remainingBytes = 1; // 2-byte character
                else if ((value >> 4) == 0b1110) remainingBytes = 2; // 3-byte character
                else if ((value >> 3) == 0b11110) remainingBytes = 3; // 4-byte character
                else if ((value >> 7) != 0) return false; // 1-byte character must start with 0
            } else {
                if ((value >> 6) != 0b10) return false; // Following bytes must start with 10
                remainingBytes--;
            }
        }

        return remainingBytes == 0; // Ensure all characters are complete
    }

    public static void main(String[] args) {
        int[] data = {226, 130, 172}; // Euro sign (€) in UTF-8
        System.out.println(isValidUTF8(data) ? "Valid UTF-8" : "Invalid UTF-8");

        int[] invalidData = {240, 144, 128}; // Invalid because last byte does not start with 10
        System.out.println(isValidUTF8(invalidData) ? "Valid UTF-8" : "Invalid UTF-8");
    }
}
