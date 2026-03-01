class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeftBranch(root); // Initialize stack with leftmost path
    }

    // Push all left children of the node onto the stack
    private void pushLeftBranch(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    // Returns the next smallest number
    public int next() {
        TreeNode current = stack.pop();
        pushLeftBranch(current.right);
        return current.val;
    }

    // Returns true if there is a next smallest number
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
