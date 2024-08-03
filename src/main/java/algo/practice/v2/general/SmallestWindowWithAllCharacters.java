package algo.practice.v2.general;

public class SmallestWindowWithAllCharacters {
    public static void main(String[] args) {
        SmallestWindowWithAllCharacters smallestWindowWithAllCharacters =
                new SmallestWindowWithAllCharacters();
        String smallestWindow = smallestWindowWithAllCharacters.smallestWindow("ADOBECODEBANC", "ABC");
        System.out.println(smallestWindow);
    }

    public String smallestWindow(String haystack, String needle) {
        int[] hash = new int[256];
        for (int i = 0; i < needle.length(); i++) {
            hash[needle.charAt(i)]++;
        }
        int start = 0;
        int end = 0;
        int minLen = Integer.MAX_VALUE;
        int minStart = 0;
        int count = needle.length();
        while (end < haystack.length()) {
            if (hash[haystack.charAt(end)] > 0) {
                count--;
            }
            hash[haystack.charAt(end)]--;
            end++;
            while (count == 0) {
                if (end - start < minLen) {
                    minStart = start;
                    minLen = end - start;
                }
                hash[haystack.charAt(start)]++;
                if (hash[haystack.charAt(start)] > 0) {
                    count++;
                }
                start++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : haystack.substring(minStart, minStart + minLen);
    }
}
