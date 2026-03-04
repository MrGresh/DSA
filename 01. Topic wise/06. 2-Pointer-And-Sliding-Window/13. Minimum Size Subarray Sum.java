class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, start=0, end=0, windowSum = 0;
        while(end<nums.length) {
            windowSum += nums[end];
            while(windowSum>=target) {
                ans = Math.min(ans, end-start+1);
                windowSum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
------------------------------------------------------------
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = 0;
        int l=1, r = nums.length;
        while(l<=r) {
            int m = l+(r-l)/2;
            if(isPossible(target, nums, m)) {
                ans = m;
                r = m-1;
            } else l = m+1;
        }
        return ans;
    }
    boolean isPossible(int target, int[] nums, int windowSize) {
        int sum = 0;
        for(int i=0;i<windowSize;i++) sum += nums[i];
        if(sum>=target) return true;
        for(int i=windowSize;i<nums.length;i++) {
            sum -= nums[i-windowSize];
            sum += nums[i];
            if(sum>=target) return true;
        }
        return false;
    }
}
