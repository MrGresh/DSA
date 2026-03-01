class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> permuteUnique(int[] nums) {
        ans = new ArrayList<>();
        Arrays.sort(nums);
        List<Integer> curr = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        for(int i=0;i<nums.length;i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            curr.add(nums[i]);
            vis[i] = true;
            rec(nums, curr, vis);
            curr.removeLast();
            vis[i] = false;
        }
        return ans;
    }
    void rec(int[] nums, List<Integer> curr, boolean[] vis) {
        if(curr.size()==nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for(int j=0;j<nums.length;j++) {
            if(!vis[j]) {
                if(j>0 && nums[j]==nums[j-1] && !vis[j-1]) continue;
                curr.add(nums[j]);
                vis[j] = true;
                rec(nums, curr, vis);
                vis[j] = false;
                curr.removeLast();
            }
        }
    }
}
