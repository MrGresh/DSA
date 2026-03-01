// Recursive
class Solution {
    List<Integer> res;
    public List<Integer> preorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        rec(root);
        return res;
    }
    void rec(TreeNode root) {
        if(root==null) return;
        res.add(root.val);
        rec(root.left);
        rec(root.right);
    }
}
----------------
// Interative
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root==null) return res;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode node = st.pop();
            res.add(node.val);
            if(node.right!=null) st.push(node.right);
            if(node.left!=null) st.push(node.left);
        }
        return res;
    }
}
