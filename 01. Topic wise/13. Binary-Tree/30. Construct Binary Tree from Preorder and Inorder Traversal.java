class Solution {
    private HashMap<Integer, Integer> indexMap; // Stores index of inorder values
    private int preIndex; // Tracks current index in preorder array

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        indexMap = new HashMap<>();
        preIndex = 0;

        for (int i = 0; i < inorder.length; i++) indexMap.put(inorder[i], i);

        return buildTreeHelper(preorder, 0, preorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        int rootVal = preorder[preIndex++];
        TreeNode root = new TreeNode(rootVal);

        root.left = buildTreeHelper(preorder, inStart, indexMap.get(rootVal) - 1);
        root.right = buildTreeHelper(preorder, indexMap.get(rootVal) + 1, inEnd);

        return root;
    }
}
