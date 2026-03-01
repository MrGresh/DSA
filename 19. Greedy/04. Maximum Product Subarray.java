// For Non-Negative Only
public int maxProductNonNegative(int[] nums) {
    int res = nums[0];
    int curMax = nums[0];
    for (int i = 1; i < nums.length; i++) {
        curMax = Math.max(nums[i], curMax * nums[i]);
        res = Math.max(res, curMax);
    }
    return res;
}
----------------------------------------------------------------------
class Solution {
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int res = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];

        for (int i = 1; i < nums.length; i++) {
            
            // If we hit a negative number, the max and min swap potential
            if (nums[i] < 0) {
                int temp = curMax;
                curMax = curMin;
                curMin = temp;
            }

            // Standard Kadane-like update for products
            curMax = Math.max(nums[i], nums[i] * curMax);
            curMin = Math.min(nums[i], nums[i] * curMin);

            // Update the global result
            res = Math.max(res, curMax);
        }

        return res;
    }
}
