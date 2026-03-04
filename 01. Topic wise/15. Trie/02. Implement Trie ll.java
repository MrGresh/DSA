class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    int starts = 0, ends = 0;
}
public class Trie {
    private TrieNode root;
    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
            node.starts++;
        }
        node.ends++;
    }

    public int countWordsEqualTo(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) return 0;
            node = node.children.get(ch);
        }
        return node.ends;
    }

    public int countWordsStartingWith(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.children.containsKey(ch)) return 0;
            node = node.children.get(ch);
        }
        return node.starts;
    }

    public void erase(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
            node.starts--;
        }
        node.ends--;
    }
}
