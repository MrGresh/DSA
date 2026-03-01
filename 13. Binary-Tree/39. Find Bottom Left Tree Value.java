class Solution {
    public int findBottomLeftValue(TreeNode root) {
        int ans = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        if(root!=null) q.offer(root);
        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=1;i<=size;i++) {
                TreeNode node = q.poll();
                if(i==1) ans = node.val;
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
        }
        return ans;
    }
}
