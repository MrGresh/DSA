class TN {
    Map<Character, TN> childs = new HashMap<>();
    int starts = 0;
} 
class Solution {
    static TN root;
    Solution() {
        root = new TN();
    }
    static String[] findPrefixes(String[] words, int N) {
        for(String word : words) insert(word);
        String[] ans = new String[N];
        int idx = -1;
        for (int i = 0; i < N; i++) {
            ans[i] = findPrefix(words[i]);
        }
        return ans;
    }
    static void insert(String word) {
        TN node = root;
        for(char ch : word.toCharArray()) {
            node.childs.putIfAbsent(ch, new TN());
            node = node.childs.get(ch);
            node.starts++;
        }
    }
    static String findPrefix(String word) {
        StringBuilder res = new StringBuilder();
        TN node = root;
        for(char ch : word.toCharArray()) {
            node = node.childs.get(ch);
            res.append(ch);
            if(node.starts==1) break;
        }
        return res.toString();
    }
};
