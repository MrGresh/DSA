class Solution {
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        sum = 0;
        calc(root, low, high);
        return sum;
    }
    void calc(TreeNode root, int low, int high) {
        if(root==null) return;
        if(root.val>=low && root.val<=high) sum += root.val;
        if(root.val>=low) calc(root.left, low, high);
        if(root.val<=high) calc(root.right, low, high);
    }
}
