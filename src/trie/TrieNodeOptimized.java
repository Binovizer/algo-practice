package trie;

import java.util.HashMap;

public class TrieNodeOptimized {

    public static final int ALPHABET_SIZE = 26;

        Character content;
        boolean isEndOfTheWord;
        HashMap<Character, TrieNodeOptimized> children;

        public TrieNodeOptimized(Character content, boolean isEndOfTheWord) {
            this.content = content;
            this.isEndOfTheWord = isEndOfTheWord;
            this.children = new HashMap<>();
        }

        public TrieNodeOptimized(){
            this.content = '\0';
            this.isEndOfTheWord = false;
            this.children = new HashMap<>();
        }
    }