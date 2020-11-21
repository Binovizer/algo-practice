package algo.interview.recursion;

/**
 * This class helps return the kth symbol of grammar
 * Leetcode : https://leetcode.com/problems/k-th-symbol-in-grammar/
 *
 * @author Nadeem 2020-11-21
 */
public class KthSymbolOfGrammar {

    public static void main(String[] args) {
        int n = 4;
        int k = 5;
        KthSymbolOfGrammar kthSymbolOfGrammar = new KthSymbolOfGrammar();
        int kthSymbol = kthSymbolOfGrammar.kthSymbolOfGrammar(n, k);
        System.out.println("kthSymbol = " + kthSymbol);
    }

    /**
     * Returns kth symbol of grammar
     *
     * @param n the n
     * @param k the k
     * @return the kth symbol
     */
    private int kthSymbolOfGrammar(int n, int k) {
        if(n==1 && k ==1){
            return 0;
        }
        int mid = (int) Math.pow(2, n-2);
        if(k <= mid){
            return kthSymbolOfGrammar(n-1, k);
        } else {
            int symbol = kthSymbolOfGrammar(n - 1, k - mid);
            return complement(symbol);
        }
    }

    /**
     * Complements the symbol
     *
     * @param symbol the symbol
     * @return the complement of the symbol
     */
    private int complement(int symbol) {
        return 1 - symbol;
    }
}
