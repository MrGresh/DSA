class TrieNode {
    Map<Character, TrieNode> childs = new HashMap<>();
    int starts = 0;
}

class Solution {
    TrieNode root;

    public Solution() {
        this.root = new TrieNode();
    }

    public int suffixCount(String[] words, String suff) {
        this.root = new TrieNode(); 
        for (String word : words) insert(reverse(word));
        TrieNode node = root;
        for (char ch : reverse(suff).toCharArray()) {
            if (!node.childs.containsKey(ch)) return 0;
            node = node.childs.get(ch);
        }
        return node.starts;
    }

    private void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.childs.putIfAbsent(ch, new TrieNode());
            node = node.childs.get(ch);
            node.starts++;
        }
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}
---------------------------------------------------------------------------------------------------
import java.util.*;

class TrieNode {
    Map<Character, TrieNode> childs = new HashMap<>();
    int starts = 0;
}

class Solution {
    TrieNode root;

    public Solution() {
        this.root = new TrieNode();
    }

    public int suffixCount(String[] words, String suff) {
        this.root = new TrieNode();

        for (String word : words) {
            insertSuffixes(word);
        }

        TrieNode node = root;
        for (char ch : (suff + "#").toCharArray()) {
            if (!node.childs.containsKey(ch)) {
                return 0;
            }
            node = node.childs.get(ch);
        }

        return node.starts;
    }

    private void insertSuffixes(String word) {
        for (int i = 0; i < word.length(); i++) {
            String suffixPattern = word.substring(i) + "#";
            insert(suffixPattern);
        }
    }

    private void insert(String pattern) {
        TrieNode node = root;
        for (char ch : pattern.toCharArray()) {
            node.childs.putIfAbsent(ch, new TrieNode());
            node = node.childs.get(ch);
            node.starts++;
        }
    }
}
