// By Sum
class NodeInfo {
    int sum;
    int min, max;
    boolean isBst;

    NodeInfo(int sum, int min, int max, boolean isBst) {
        this.sum = sum;
        this.min = min;
        this.max = max;
        this.isBst = isBst;
    }
}
class Solution {
    int maxBstSum;
    public int maxSumBST(TreeNode root) {
        maxBstSum = 0;
        traverse(root);
        return maxBstSum;
    }
    NodeInfo traverse(TreeNode root) {
        if (root == null) return new NodeInfo(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);

        NodeInfo left = traverse(root.left);
        NodeInfo right = traverse(root.right);

        if (left.isBst && right.isBst && root.val > left.max && root.val < right.min) {
            int currentSum = root.val + left.sum + right.sum; // if we add 1 instead of root.val then it will be : Maximum Size BST in Binary Tree
            maxBstSum = Math.max(maxBstSum, currentSum);
            return new NodeInfo(currentSum, Math.min(root.val, left.min), Math.max(root.val, right.max), true);
        }
        else return new NodeInfo(0, 0, 0, false);
    }
}
