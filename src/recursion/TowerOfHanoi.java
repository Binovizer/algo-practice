package recursion;

/**
 * The type TowerOfHanoi
 *
 * @author Mohd Nadeem
 */
public class TowerOfHanoi {

    public int towerOfHanoi(int n, char from, char to, char aux, int count){
        if(n == 1){
            count = count + 1;
            System.out.println("Move disc 1 from " + from + " to " + to);
            return count;
        }
        count = towerOfHanoi(n-1, from, aux, to, count);
        count = count + 1;
        System.out.println("Move disc " + n + " from " + from + " to " + to);
        count = towerOfHanoi(n-1, aux, to, from, count);
        return count;
    }

    public static void main(String[] args) {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        int count = towerOfHanoi.towerOfHanoi(3, 'A', 'C', 'B', 0);
        System.out.println("No of steps : " + count);
    }
}
