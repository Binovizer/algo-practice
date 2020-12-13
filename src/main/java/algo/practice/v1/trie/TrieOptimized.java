package algo.practice.v1.trie;

/**
 * The type Trie
 *
 * @author Mohd Nadeem
 */
public class TrieOptimized {

    TrieNodeOptimized root;

    public static void main(String[] args) {
        TrieOptimized trie = new TrieOptimized();
        trie.root = new TrieNodeOptimized();
        trie.insert("geeks");
        trie.insert("geez");
        trie.insert("geer");
        System.out.println(trie.contains("geer"));
        System.out.println(trie.contains("gees"));
        System.out.println(trie.contains("geeks"));
    }

    public void insert(String word) {
        TrieNodeOptimized current = root;
        for (Character c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                current.children.put(c, new TrieNodeOptimized(c, false));
            }
            current = current.children.get(c);
        }
        current.isEndOfTheWord = true;
    }

    public boolean contains(String word) {
        TrieNodeOptimized current = root;
        for (Character c : word.toCharArray()) {
            if (!current.children.containsKey(c)) {
                return false;
            }
            current = current.children.get(c);
        }
        return (current != null && current.isEndOfTheWord);
    }
}
