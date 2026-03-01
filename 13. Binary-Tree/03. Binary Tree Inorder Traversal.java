// Recursive
class Solution {
    List<Integer> res;
    public List<Integer> inorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        rec(root);
        return res;
    }
    void rec(TreeNode root) {
        if(root==null) return;
        rec(root.left);
        res.add(root.val);
        rec(root.right);
    }
}
------------
// Iterative
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> st = new Stack<>();
        while(!st.isEmpty() || root!=null) {
            while(root!=null) {
                st.push(root);
                root = root.left;
            }
            TreeNode node = st.pop();
            res.add(node.val);
            root = node.right;
        }
        return res;
    }
}
