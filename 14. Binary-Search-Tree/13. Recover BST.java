class Solution {
    List<TreeNode> inorder;
    public void recoverTree(TreeNode root) {
        inorder = new ArrayList<>();
        traverse(root);
        TreeNode first = null, second = null;
        for (int i = 0; i < inorder.size() - 1; i++) {
            if (inorder.get(i).val > inorder.get(i + 1).val) {
                if (first == null) {
                    first = inorder.get(i);
                    second = inorder.get(i + 1);
                } else {
                    second = inorder.get(i + 1);
                    break;
                }
            }
        }
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    void traverse(TreeNode root) {
        if(root==null) return;
        traverse(root.left);
        inorder.add(root);
        traverse(root.right);
    }
}
--------------------------------------------------
class Solution {
    TreeNode first = null, second = null, prev = null;
    public void recoverTree(TreeNode root) {
        traverse(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    boolean traverse(TreeNode root) {
        if(root==null) return false;
        if(traverse(root.left)) return true;
        if (prev != null && root.val < prev.val) {
            if (first == null) {
                first = prev;
                second = root;
            }
            else {
                second = root;
                return true; // found both
            }
        }
        prev = root;
        return traverse(root.right);
    }
}
