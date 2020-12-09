package algo.interview.challenges.leetcode.dec.week1;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2020-12-06
 */
public class FlowerbedPlant {

    public static void main(String[] args) {
        int[] flowerbed = {1, 0, 0, 0, 1};
        int n = 2;
        FlowerbedPlant flowerbedPlant = new FlowerbedPlant();
        boolean canPlant = flowerbedPlant.canPlant(flowerbed, n);
        System.out.println("canPlant = " + canPlant);
    }

    private boolean canPlant(int[] flowerbed, int n) {
        for (int i = 0; i < flowerbed.length && n > 0; i++) {
            if (flowerbed[i] == 1) {
                i++; // Increment by 2
                continue;
            }
            if ((i == 0 || flowerbed[i - 1] == 0)
                    && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                i++; // Increment by 2
                n--;
            }
        }
        return (n == 0);
    }
}
