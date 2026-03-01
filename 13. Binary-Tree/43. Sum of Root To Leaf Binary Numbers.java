class Solution {
    int ans = 0;
    public int sumRootToLeaf(TreeNode root) {
        ans = 0;
        rec(root, new StringBuilder());
        return ans;
    }
    void rec(TreeNode root, StringBuilder curr) {
        curr.append(root.val == 1 ? "1" : "0");
        if(root.left==null && root.right==null) {
            ans += getNumber(curr.toString());
            curr.deleteCharAt(curr.length() - 1);
            return;
        }
        if(root.left!=null) rec(root.left, curr);
        if(root.right!=null) rec(root.right, curr);
        curr.deleteCharAt(curr.length() - 1);
    }
    int getNumber(String str) {
        int num = 0, digit = 1;
        for(int i=str.length()-1;i>=0;i--) {
            int currDigit = str.charAt(i) == '1' ? 1 : 0;
            num += currDigit*digit;
            digit <<= 1; // digit *= 2;
        }
        return num;
    }
}
----------------------------------------------------------------------------------------------------
class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode node, int currentSum) {
        currentSum = (currentSum << 1) + node.val;
        if (node.left == null && node.right == null) {
            return currentSum;
        }
        
        int ans = 0;
        if(node.left!=null) ans += dfs(node.left, currentSum);
        if(node.right!=null) ans += dfs(node.right, currentSum);
        return  ans;
    }
}
