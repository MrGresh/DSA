class Solution {
    List<Integer> res1, res2;
    char l = '1';
    public ArrayList<Integer> merge(Node root1, Node root2) {
        res1 = new ArrayList<>();
        res2 = new ArrayList<>();
        l = '1';
        rec(root1);
        l='2';
        rec(root2);
        ArrayList<Integer> ans = new ArrayList<>();
        int i=0, j=0;
        while(i<res1.size() && j<res2.size()) {
            ans.add(res1.get(i)<=res2.get(j) ? res1.get(i++) : res2.get(j++));
        }
        while(i<res1.size()) ans.add(res1.get(i++));
        while(j<res2.size()) ans.add(res2.get(j++));
        return ans;
    }
    void rec(Node root) {
        if(root==null) return;
        rec(root.left);
        if(l=='1') res1.add(root.data);
        else res2.add(root.data);
        rec(root.right);
    }
}
