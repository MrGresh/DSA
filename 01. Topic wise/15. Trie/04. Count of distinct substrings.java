class GfG {
    public static int countDistinctSubstring(String s) {
        Set<String> set = new HashSet<>();
        for(int i=0;i<s.length();i++) {
            StringBuilder str = new StringBuilder();
            for(int j=i;j<s.length();j++) {
                str.append(s.charAt(j));
                set.add(str.toString());
            }
        }
        set.add("");
        return set.size();
    }
}
---------------------------------------------------------------------
class TrieNode {
    Map<Character, TrieNode> child = new HashMap<>();
}
class Solution {
    public static int countSubs(String s) {
        int count = 0;
        TrieNode root = new TrieNode();
        for(int i=0;i<s.length();i++) {
            TrieNode node = root; 
            for(int j=i;j<s.length();j++) {
                if(!node.child.containsKey(s.charAt(j))) {
                    count++;
                    node.child.put(s.charAt(j), new TrieNode());
                }
                node = node.child.get(s.charAt(j));
            }
        }
        return count;
    }
}
