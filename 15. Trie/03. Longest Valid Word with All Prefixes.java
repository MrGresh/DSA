class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEnd = false;
}
class Solution {
    private TrieNode root;
    public Solution() {
        root = new TrieNode();
    }
    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEnd = true;
    }
    public boolean isContainsAllPrefix(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node = node.children.get(ch);
            if(node.isEnd==false) return false;
        }
        return true;
    }
    public String longestValidWord(String[] words) {
        for(String str: words) insert(str);
        String ans = "";
        for(String word: words) {
            if(word.length()==ans.length() && (word.compareTo(ans)<0) && isContainsAllPrefix(word)) ans=word;
            else if(word.length()>ans.length() && isContainsAllPrefix(word)) ans=word;
        }
        return ans;
    }
}
