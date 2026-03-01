class Solution {
    private HashMap<Integer, Integer> indexMap; // Stores index of inorder values
    private int postIndex; // Tracks current index in postorder array

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        indexMap = new HashMap<>();
        postIndex = postorder.length - 1;

        for (int i = 0; i < inorder.length; i++) indexMap.put(inorder[i], i);

        return buildTreeHelper(postorder, 0, postorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] postorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        root.right = buildTreeHelper(postorder, indexMap.get(rootVal) + 1, inEnd);
        root.left = buildTreeHelper(postorder, inStart, indexMap.get(rootVal) - 1);

        return root;
    }
}
