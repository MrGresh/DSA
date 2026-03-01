class Solution {
    Set<Long> subTreeSums;

    public int maxProduct(TreeNode root) {
        subTreeSums = new HashSet<>();
        long maxAns = 0;
        long totalTreeSum = 0;
        
        totalTreeSum = dfsSum(root);
        
        for (long part1 : subTreeSums) {
            long part2 = totalTreeSum - part1;
            maxAns = Math.max(maxAns, part1*part2);
        }
        
        return (int) (maxAns % 1000000007);
    }

    long dfsSum(TreeNode root) {
        if (root == null) return 0;
        long sum = root.val + dfsSum(root.left) + dfsSum(root.right);
        subTreeSums.add(sum);
        return sum;
    }
}
