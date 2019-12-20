package trie;

public class TrieNode {

  public static final int ALPHABET_SIZE = 26;

  Character content;
  boolean isEndOfTheWord;
  TrieNode[] children;

  public TrieNode(Character content, boolean isEndOfTheWord) {
    this.content = content;
    this.isEndOfTheWord = isEndOfTheWord;
    this.children = new TrieNode[ALPHABET_SIZE];
  }

  public TrieNode() {
    this.content = '\0';
    this.isEndOfTheWord = false;
    this.children = new TrieNode[ALPHABET_SIZE];
  }
}
