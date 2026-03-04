class WordFilter {
    private static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        int idx = -1;
    }
    private TrieNode root;

    public WordFilter(String[] words) {
        root = new TrieNode();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            // Insert all suffix#word combinations
            for (int j = 0; j < word.length(); j++) {
                insert(i, word.substring(j) + "#" + word);
            }
        }
    }

    private void insert(int index, String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            node.children.putIfAbsent(ch, new TrieNode());
            node = node.children.get(ch);
            node.idx = index; // store the latest index
        }
    }

    public int f(String pref, String suff) {
        String searchKey = suff + "#" + pref;
        TrieNode node = root;
        for (char ch : searchKey.toCharArray()) {
            if (!node.children.containsKey(ch)) return -1;
            node = node.children.get(ch);
        }
        return node.idx;
    }
}
