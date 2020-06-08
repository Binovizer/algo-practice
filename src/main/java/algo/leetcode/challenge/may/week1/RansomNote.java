package algo.leetcode.challenge.may.week1;

public class RansomNote {

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] count = new int[26];
        for (char c : magazine.toCharArray()) {
            count[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (--count[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String magazine = "aab";
        String ransomNoteString = "bb";
        RansomNote ransomNote = new RansomNote();
        boolean canConstruct = ransomNote.canConstruct(ransomNoteString, magazine);
        System.out.println("canConstruct = " + canConstruct);
    }
}
