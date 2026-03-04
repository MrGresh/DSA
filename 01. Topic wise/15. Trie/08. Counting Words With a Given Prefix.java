class TrieNode {
    Map<Character, TrieNode> childs = new HashMap<>();
    int starts = 0;
}
class Solution {
    TrieNode root;
    Solution () {
        this.root = new TrieNode();
    }
    public int prefixCount(String[] words, String pref) {
        for(String word : words) insert(word);
        TrieNode node = root;
        for(char ch : pref.toCharArray()) {
            if(!node.childs.containsKey(ch)) return 0;
            node = node.childs.get(ch);
        }
        return node.starts;
    }
    void insert(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()) {
            node.childs.putIfAbsent(ch, new TrieNode());
            node = node.childs.get(ch);
            node.starts++;
        }
    }
}
