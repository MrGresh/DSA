Brute Force : Store inorder result in a array then check wether that array is sorted or not
--------------------------------------------------------------------------------------------
class Solution {
    public boolean isValidBST(TreeNode root) {
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode node, long min, long max) {
        if (node == null) return true;
        return node.val > min && node.val < max && helper(node.left, min, node.val) && helper(node.right, node.val, max);
    }
}
