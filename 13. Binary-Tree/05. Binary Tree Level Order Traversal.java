class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root!=null) q.add(root);
        while(!q.isEmpty()) {
            List<Integer> tmp = new ArrayList<>();
            int size = q.size();
            while(size-->0) {
                TreeNode node = q.poll();
                tmp.add(node.val);
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
            }
            res.add(tmp);
        }
        return res;
    }
}
