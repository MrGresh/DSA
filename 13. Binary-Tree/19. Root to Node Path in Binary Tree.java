public class Solution {
    List<Integer> res;
    public List<Integer> pathInATree(TreeNode root, int x) {
        res = new ArrayList<>();
        rec(root, x);
        return res;
    }
    boolean rec(TreeNode root, int x) {
        if(root==null) return false;
        res.add(root.data);
        if(root.data==x) return true;
        if(rec(root.left, x)) return true;
        if(rec(root.right, x)) return true;
        res.remove(res.size()-1);
        return false;
    }
}
