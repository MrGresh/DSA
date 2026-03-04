class Solution {
    public boolean checkTree(TreeNode root) {
        if(root==null) return true;
        if(root.left!=null || root.right!=null) {
            int l = root.left==null ? 0 : root.left.val;
            int r = root.right==null ? 0 : root.right.val;
            if(l+r!=root.val) return false;
        }
        return checkTree(root.left) && checkTree(root.right);
    }
}
----------------------------
class Solution {
    public boolean checkTree(TreeNode root) {
        int val = rec(root);
        return val==root.val;
    }
    int rec(TreeNode root) {
        if(root==null) return 0;
        if(!isLeaf(root)) {
            int l = rec(root.left);
            if(l==-101) return -101;
            int r = rec(root.right);
            if(r==-101) return -101;
            if(l+r!=root.val) return -101;
        }
        return root.val;
    }
    boolean isLeaf(TreeNode root) {
        return root.left==null && root.right==null;
    }
}
