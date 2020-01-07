package algo.trie;

/**
 * The type Trie
 *
 * @author Mohd Nadeem
 */
public class Trie {

    TrieNode root;

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.root = new TrieNode();
        trie.insert("geeks");
        trie.insert("geez");
        trie.insert("geer");
        System.out.println(trie.contains("geer"));
        System.out.println(trie.contains("gees"));
        System.out.println(trie.contains("geeks"));
    }

    public void insert(String word) {
        TrieNode current = root;
        for (Character c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode(c, false);
            }
            current = current.children[c - 'a'];
        }
        current.isEndOfTheWord = true;
    }

    public boolean contains(String word) {
        TrieNode current = root;
        for (Character c : word.toCharArray()) {
            if (current.children[c - 'a'] == null) {
                return false;
            }
            current = current.children[c - 'a'];
        }
        return (current != null && current.isEndOfTheWord);
    }
}
