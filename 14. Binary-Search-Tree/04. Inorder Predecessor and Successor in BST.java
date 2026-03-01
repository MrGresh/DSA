class Solution {
    public ArrayList<Node> findPreSuc(Node root, int key) {
        ArrayList<Node> ans = new ArrayList<>();
        ans.add(pre(root, key));
        ans.add(succ(root, key));
        return ans;
    }
    public Node succ(Node root, int x) {
        Node ans = new Node(-1);
        while(root!=null) {
            if(x<root.data) {
                ans = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ans;
    }
    public Node pre(Node root, int x) {
        Node ans = new Node(-1);
        while(root!=null) {
            if(x>root.data) {
                ans = root;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return ans;
    }
}
