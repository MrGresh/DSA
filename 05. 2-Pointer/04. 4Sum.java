class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<=nums.length-4;i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue; // skipping duplicates
            for(int j=i+1;j<=nums.length-3;j++) {
                if (j>i+1 && nums[j] == nums[j - 1]) continue; // skipping duplicates
                int l = j+1, r = nums.length-1;
                while(l<r) {
                    long val = (long)nums[i]+nums[j]+nums[l]+nums[r];
                    if(val==target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        int lVal = nums[l], rVal = nums[r];
                        while (l < r && nums[l] == lVal) l++; // skipping duplicates
                        while (l < r && nums[r] == rVal) r--; // skipping duplicates
                    } else if(val>target) r--;
                    else l++;
                }
            }
        }
        return res;        
    }
}
