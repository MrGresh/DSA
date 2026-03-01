class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        Stack<TreeNode> leftStack = new Stack<>();
        Stack<TreeNode> rightStack = new Stack<>();
        pushLeft(root, leftStack);
        pushRight(root, rightStack);

        while (!leftStack.isEmpty() && !rightStack.isEmpty()) {
            TreeNode leftNode = leftStack.peek();
            TreeNode rightNode = rightStack.peek();

            if (leftNode == rightNode) break;

            int sum = leftNode.val + rightNode.val;

            if (sum == k) {
                return true;
            } else if (sum < k) {
                TreeNode node = leftStack.pop();
                pushLeft(node.right, leftStack);
            } else {
                TreeNode node = rightStack.pop();
                pushRight(node.left, rightStack);
            }
        }

        return false;
    }

    private void pushLeft(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    private void pushRight(TreeNode root, Stack<TreeNode> stack) {
        while (root != null) {
            stack.push(root);
            root = root.right;
        }
    }
}
