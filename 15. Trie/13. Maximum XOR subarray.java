class TrieNode {
    TrieNode[] children = new TrieNode[2];
}

class Solution {
    static int maxSubarrayXOR(int N, int[] arr) {
        TrieNode root = new TrieNode();
        insert(root, 0);

        int maxXor = 0;
        int prefixXor = 0;

        for (int num : arr) {
            prefixXor ^= num;
            insert(root, prefixXor);
            maxXor = Math.max(maxXor, query(root, prefixXor));
        }

        return maxXor;
    }

    private static void insert(TrieNode root, int num) {
        TrieNode node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) {
                node.children[bit] = new TrieNode();
            }
            node = node.children[bit];
        }
    }

    private static int query(TrieNode root, int num) {
        TrieNode node = root;
        int maxXor = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            int toggledBit = 1 - bit;
            if (node.children[toggledBit] != null) {
                maxXor |= (1 << i);
                node = node.children[toggledBit];
            } else {
                node = node.children[bit];
            }
        }
        return maxXor;
    }
}
