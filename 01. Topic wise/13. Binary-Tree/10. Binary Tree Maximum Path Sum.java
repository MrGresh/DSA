class Solution {
    int ans = -1001;
    public int maxPathSum(TreeNode root) {
        rec(root);
        return ans;
    }

    private int rec(TreeNode node) {
        if (node == null) return 0;

        int leftMax = Math.max(0, rec(node.left));
        int rightMax = Math.max(0, rec(node.right));

        ans = Math.max(ans, node.val + leftMax + rightMax);

        return node.val + Math.max(leftMax, rightMax);
    }
}
