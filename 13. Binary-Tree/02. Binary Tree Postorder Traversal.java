// Recursive
class Solution {
    List<Integer> res;
    public List<Integer> postorderTraversal(TreeNode root) {
        res = new ArrayList<>();
        rec(root);
        return res;
    }
    void rec(TreeNode root) {
        if(root==null) return;
        rec(root.left);
        rec(root.right);
        res.add(root.val);
    }
}
---------------
// Iterative
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root==null) return res;
        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()) {
            TreeNode node = st.pop();
            res.addFirst(node.val);
            if(node.left!=null) st.push(node.left);
            if(node.right!=null) st.push(node.right);
        }
        return res;
    }
}
