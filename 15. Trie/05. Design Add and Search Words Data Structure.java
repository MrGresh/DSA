class TrieNode {
    Map<Character, TrieNode> children = new HashMap<>();
    boolean isEndOfWord = false;
}

class WordDictionary {
    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
        }
        node.isEndOfWord = true;
    }
    
    public boolean search(String word) {
        TrieNode node = root;
        return searchingRec(node, word, 0);
    }
    boolean searchingRec(TrieNode root, String word, int idx) {
        if(idx==word.length()) return root.isEndOfWord;
        char ch = word.charAt(idx);
        if(ch=='.') {
            for(TrieNode t : root.children.values()) {
                if(searchingRec(t, word, idx+1)) return true;
            }
            return false;
        }
        else {
            if(!root.children.containsKey(ch)) return false;
            return searchingRec(root.children.get(ch), word, idx+1);
        }
    }
}
