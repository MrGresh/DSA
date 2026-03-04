class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-3;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skipping duplicates
            int l = i+1, r = nums.length-1;
            while(l<r) {
                int val = nums[i]+nums[l]+nums[r];
                if(val==0) {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    int lVal = nums[l], rVal = nums[r];
                    while (l < r && nums[l] == lVal) l++; // skipping duplicates
                    while (l < r && nums[r] == rVal) r--; // skipping duplicates
                } else if(val>0) r--;
                else l++;
            }
        }
        return res;
    }
}
