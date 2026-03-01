class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        rec(root, targetSum, curr);
        return res;
    }
    void rec(TreeNode root, int targetSum, List<Integer> curr) {
        if(root==null) return;
        curr.add(root.val);
        targetSum -= root.val;
        if(root.left==null && root.right==null) {
            if(targetSum==0) res.add(new ArrayList<>(curr));
            curr.remove(curr.size()-1);
            return;
        }
        rec(root.left, targetSum, curr);
        rec(root.right, targetSum, curr);
        curr.remove(curr.size()-1);
    }
}
