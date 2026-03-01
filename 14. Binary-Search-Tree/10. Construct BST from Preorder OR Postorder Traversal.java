class Solution {
    int currentIndex;
    public TreeNode bstFromPreorder(int[] pre) {
        currentIndex = 0;
        return buildBST(pre, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private TreeNode buildBST(int[] pre, int min, int max) {
        if (currentIndex > pre.length - 1) return null;
        int val = pre[currentIndex];
        if (val < min || val > max) return null;
        TreeNode root = new TreeNode(val);
        currentIndex++;
        root.left = buildBST(pre, min, val);
        root.right = buildBST(pre, val, max);
        return root;
    }
}
----------------------------------------------------------------------------------
class GFG {
    int currentIndex;
    public Node bstFromPostorder(int post[], int n) {
        currentIndex = n - 1;
        return buildBST(post, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    private Node buildBST(int[] post, int min, int max) {
        if (currentIndex < 0) return null;
        int val = post[currentIndex];
        if (val < min || val > max) return null;
        Node root = new Node(val);
        currentIndex--;
        root.right = buildBST(post, val, max);
        root.left = buildBST(post, min, val);
        return root;
    }
}
