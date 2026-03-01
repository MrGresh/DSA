class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = (int)Math.pow(2, nums.length);
        for(int i=0;i<n;i++) {
            List<Integer> curr = new ArrayList<>();
            for(int j=0;j<nums.length;j++) {
                if(((i>>j)&1)==1) curr.add(nums[j]);
            }
            ans.add(curr);
        }
        return ans;
    }
}
