class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int n, int target) {
        res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        for(int i=1;i<=9;i++) {
            if(i>target) continue;
            curr.add(i);
            helper(curr, i+1, target-i, n-1);
            curr.removeLast();
        }
        return res;
    }
    void helper(List<Integer> curr, int idx, int target, int n) {
        if(n==0) {
            if(target==0) res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<=9;i++) {
            if(target-i>=0) {
                curr.add(i);
                helper(curr, i+1, target-i, n-1);
                curr.removeLast();
            }
        }
    }
}
