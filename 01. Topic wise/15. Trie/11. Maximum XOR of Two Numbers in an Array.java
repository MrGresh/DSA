class TrieNode {
    TrieNode[] children = new TrieNode[2];
}
class Solution {
    private TrieNode root = new TrieNode();
    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for(int x : nums) insert(x);
        for(int x : nums) ans = Math.max(ans, findMaxXor(x));
        return ans;
    }
    void insert(int num) {
        TrieNode node = root;
        for(int i=31;i>=0;i--) {
            int bit = (num >> i) & 1;
            if(node.children[bit]==null) node.children[bit] = new TrieNode();
            node = node.children[bit];
        }
    }
    int findMaxXor(int num) {
        TrieNode node = root;
        int maxXor = 0;
        for(int i=31;i>=0;i--) {
            int bit = (num >> i) & 1;
            int toggledBit = 1-bit;
            if(node.children[toggledBit]!=null) {
                maxXor |= (1<<i);
                node = node.children[toggledBit];
            }
            else node = node.children[bit];
        }
        return maxXor;
    }
}
