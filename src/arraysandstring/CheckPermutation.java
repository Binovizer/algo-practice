package arraysandstring;

/**
 * The type CheckPermutation
 *
 * @author Mohd Nadeem
 */
public class CheckPermutation {

    public boolean checkPermutation(String str1, String str2){
        int[] count = new int[256];
        if(str1.length() != str2.length()){
            return false;
        }
        for (int i = 0; i < str1.length(); i++) {
            int val = str1.charAt(i);
            ++count[val];
        }
        for (int i = 0; i < str2.length(); i++) {
            int val = str2.charAt(i);
            --count[val];
            if(count[val] < 0){
                return false;
            }
        }
        return true;
    }
}
