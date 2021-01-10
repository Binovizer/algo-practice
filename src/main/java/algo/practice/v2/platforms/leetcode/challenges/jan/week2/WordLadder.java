package algo.practice.v2.platforms.leetcode.challenges.jan.week2;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * This is the description of what this type does
 *
 * @author Nadeem 2021-01-10
 */
public class WordLadder {

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        String[] list = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<String> wordList = Arrays.stream(list).collect(Collectors.toList());
        WordLadder wordLadder = new WordLadder();
        int ladderLength = wordLadder.ladderLength(beginWord, endWord, wordList);
        System.out.println("ladderLength = " + ladderLength);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        return ladderLength(beginWord, endWord, dict);
    }

    public int ladderLength(String beginWord, String endWord, Set<String> dict) {
        if (!dict.contains(endWord)) {
            return 0;
        }

        Queue<String> q = new ArrayDeque<>();
        q.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        int level = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String current = q.poll();
                if (current.equals(endWord)) {
                    return level;
                }
                char[] chars = current.toCharArray();
                for (int j = 0; j < current.length(); j++) {
                    char temp = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String neighbour = new String(chars);
                        if (neighbour.equals(endWord)) {
                            return level + 1;
                        }
                        if (dict.contains(neighbour) && !visited.contains(neighbour)) {
                            q.offer(neighbour);
                            visited.add(neighbour);
                        }
                    }
                    chars[j] = temp;
                }
            }
            level++;
        }
        return 0;
    }
}
