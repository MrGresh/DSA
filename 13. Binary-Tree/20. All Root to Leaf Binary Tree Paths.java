class Solution {
    List<String> res;
    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        StringBuilder curr = new StringBuilder();
        rec(root, new StringBuilder());
        return res;
    }
    void rec(TreeNode root, StringBuilder curr) {
        int lengthBeforeAppend = curr.length();
        if(lengthBeforeAppend!=0) curr.append("->");
        curr.append(String.valueOf(root.val));
        if(root.left==null && root.right==null) {
            res.add(curr.toString());
            curr.setLength(lengthBeforeAppend);
            return;
        }
        if(root.left!=null) rec(root.left, curr);
        if(root.right!=null) rec(root.right, curr);
        curr.setLength(lengthBeforeAppend);
    }
}
