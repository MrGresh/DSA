class Solution {
    int res = 0;
    int originalTarget;
    public int pathSum(TreeNode root, int targetSum) {
        originalTarget = targetSum;
        rec(root, (long) targetSum, true);
        return res;
    }

    void rec(TreeNode node, long targetSum, boolean isStart) {
        if (node == null) return;
        targetSum -= node.val;
        if (targetSum == 0) res++;

        rec(node.left, targetSum, false);
        rec(node.right, targetSum, false);

        if (isStart) {
            rec(node.left, originalTarget, true);
            rec(node.right, originalTarget, true);
        }
    }
}
