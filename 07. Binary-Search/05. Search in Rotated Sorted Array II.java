class Solution {
    public boolean search(int[] nums, int k) {
        int l = 0, r = nums.length-1;
        while(l<=r) {
            int m = l+(r-l)/2;
            if(nums[m]==k) return true;
            if(nums[l]==nums[m] && nums[r]==nums[m]) {
                l++;
                r--;
                continue;
            }
            // Determine which side is sorted
            if(nums[m]>=nums[l]) { // Left side is sorted
                if(k>=nums[l] && k<nums[m]) r=m-1;
                else l=m+1;
            }
            else { // Right side is sorted means nums[m]<nums[l]
                if(k>nums[m] && k<=nums[r]) l=m+1;
                else r=m-1;
            }
        }
        return false;
    }
}
