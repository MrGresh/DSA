class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        return countSumLessEqual(nums, k) - countSumLessEqual(nums, k-1);
    }
    int countSumLessEqual(int[] nums, int goal) {
        if(goal<0) return 0;
        int ans=0, start=0, end=0, oddCount=0;
        while(end<nums.length) {
            oddCount += nums[end]%2!=0 ? 1 : 0;
            while(oddCount>goal) {
                oddCount -= nums[start]%2!=0 ? 1 : 0;
                start++;
            }
            ans += end-start+1;
            end++;
        }
        return ans;
    }
}
