class TrieNode {
    TrieNode[] children = new TrieNode[2];
}

class Solution {
    private TrieNode root = new TrieNode();
    void insert(int num) {
        TrieNode node = root;
        for (int i = 30; i >= 0; i--) { // 30 bits is enough for 10^9
            int bit = (num >> i) & 1;
            if (node.children[bit] == null) node.children[bit] = new TrieNode();
            node = node.children[bit];
        }
    }

    int findMaxXor(int num) {
        TrieNode node = root;
        
        int maxXor = 0;
        for (int i = 30; i >= 0; i--) {
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

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int n = nums.length;
        int q = queries.length;
        int[] ans = new int[q];

        int[][] offlineQueries = new int[q][3];
        for (int i = 0; i < q; i++) {
            offlineQueries[i][0] = queries[i][0];
            offlineQueries[i][1] = queries[i][1];
            offlineQueries[i][2] = i;
        }

        Arrays.sort(nums);
        Arrays.sort(offlineQueries, (a, b) -> Integer.compare(a[1], b[1]));

        int numsIdx = 0;
        for (int i = 0; i < q; i++) {
            int xi = offlineQueries[i][0];
            int mi = offlineQueries[i][1];
            int originalIdx = offlineQueries[i][2];

            while (numsIdx < n && nums[numsIdx] <= mi) insert(nums[numsIdx++]);

            if (numsIdx == 0) ans[originalIdx] = -1;
            else ans[originalIdx] = findMaxXor(xi);
        }

        return ans;
    }
}
