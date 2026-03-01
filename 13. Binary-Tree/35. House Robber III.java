public int[] dfs(TreeNode root) {
    if (root == null) return new int[]{0, 0}; // {not_robbed, robbed}

    int[] left = dfs(root.left);
    int[] right = dfs(root.right);

    // Option 1: Rob this node (can't rob children)
    int robbed = root.val + left[0] + right[0];

    // Option 2: Don't rob this node (can rob children or not, pick max)
    int notRobbed = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

    return new int[]{notRobbed, robbed};
}
