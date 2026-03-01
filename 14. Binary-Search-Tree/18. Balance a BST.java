class Solution {
    List<Integer> res;
    public TreeNode balanceBST(TreeNode root) {
        res = new ArrayList<>();
        rec(root);
        return buildTree(0, res.size() - 1);
    }
    void rec(TreeNode root) {
        if(root==null) return;
        rec(root.left);
        res.add(root.val);
        rec(root.right);
    }
    TreeNode buildTree(int left, int right) {
        if (left > right) return null;
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(res.get(mid));
        root.left = buildTree(left, mid - 1);
        root.right = buildTree(mid + 1, right);
        return root;
    }
}
