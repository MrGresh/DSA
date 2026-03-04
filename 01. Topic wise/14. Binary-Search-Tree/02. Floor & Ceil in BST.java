class Solution {
    int floor(Node root, int x) {
        int ans = -1;
        while(root!=null) {
            if(root.data==x) return x;
            else if(x<root.data) root=root.left;
            else {
                ans = root.data;
                root=root.right;
            }
        }
        return ans;
    }
}
----------------------------------------------------
class Solution {
    int ceil(Node root, int x) {
        int ans = -1;
        while(root!=null) {
            if(root.data==x) return x;
            else if(x<root.data) {
                ans = root.data;
                root=root.left;
            }
            else root=root.right;
        }
        return ans;
    }
}
