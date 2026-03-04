class Solution {
    int target = 0, ans = 0;
    public int kthSmallest(TreeNode root, int k) {
        target = k;
        ans = 0;
        rec(root);
        return ans;
    }
    boolean rec(TreeNode root) {
        if(root==null) return false;
        if(rec(root.left)) return true;
        if(--target==0) {
            ans = root.val;
            return true;
        }
        return rec(root.right);
    }
}
----------------------------------------------------------------
class Solution {
    int target = 0, ans = 0;
    public int kthLargest(TreeNode root, int k) {
        target = k;
        ans = 0;
        rec(root);
        return ans;
    }
    boolean rec(TreeNode root) {
        if(root==null) return false;
        if(rec(root.right)) return true;
        if(--target==0) {
            ans = root.val;
            return true;
        }
        return rec(root.left);
    }
}
