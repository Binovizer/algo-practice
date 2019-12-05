package trie;

/**
 * The type PrintPossibleWords
 *
 * @author Mohd Nadeem
 */
public class PrintPossibleWords {

    private static int SIZE = 26;

    private static void searchWord(TrieNode root, boolean[] hash, String str) {
        // if we found word in trie / dictionary
        if (root.isEndOfTheWord)
            System.out.println(str);

        // traverse all child's of current root
        for (int K = 0; K < SIZE; K++)
        {
            if (hash[K] && root.children[K] != null )
            {
                // add current character
                char c = (char) (K + 'a');

                // Recursively search reaming character
                // of word in trie
                searchWord(root.children[K], hash, str + c);
            }
        }
    }

    private static void printAllWords(char[] arr, TrieNode root, int n) {
        // create a 'has' array that will store all
        // present character in arr[]
        boolean[] Hash = new boolean[SIZE];

        for (int i = 0 ; i < n; i++)
            Hash[arr[i] - 'a'] = true;

        // string to hold output words
        StringBuilder str = new StringBuilder();

        // Traverse all matrix elements. There are only
        // 26 character possible in char array
        for (int i = 0 ; i < SIZE ; i++)
        {
            // we start searching for word in dictionary
            // if we found a character which is child
            // of Trie root
            if (Hash[i] && root.children[i] != null )
            {
                str.append((char) (i + 'a'));
                searchWord(root.children[i], Hash, str.toString());
                str = new StringBuilder();
            }
        }
    }

    public static void main(String[] args) {
        String[] dict = {"go", "bat", "me", "eat", "goal", "boy", "run"} ;

        // Root Node of Trie
        Trie trie = new Trie();
        trie.root = new TrieNode('\0', false);

        // insert all words of dictionary into trie
        for (String s : dict) trie.insert(s);

        char[] arr = {'e', 'o', 'b', 'a', 'm', 'g', 'l'} ;
        int N = arr.length;

        printAllWords(arr, trie.root, N);
    }
}
