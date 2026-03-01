class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int max = nums[0];
        for(int x: nums) max = Math.max(max, x);
        int l=1, r=max, ans = max;
        while(l<=r) {
            int m = l+(r-l)/2;
            if(isPossible(nums, threshold, m)) {
                ans = m;
                r = m-1;
            } else l = m+1;
        }
        return ans;
    }
    boolean isPossible(int[] nums, int threshold, int x) {
        int sum = 0;
        for(int n: nums) {
            sum += (n + x - 1) / x;
            if(sum>threshold) return false;
        }
        return true;
    }
}
