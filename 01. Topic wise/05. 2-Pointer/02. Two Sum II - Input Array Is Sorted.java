class Solution {
    public int[] twoSum(int[] nums, int target) {
        int l = 0, r = nums.length-1;
        while(l<r) {
            int val = nums[l]+nums[r];
            if(val==target) return new int[] {l+1, r+1};
            else if(val>target) r--;
            else l++;
        }
        return new int[] {-1, -1};        
    }
}
