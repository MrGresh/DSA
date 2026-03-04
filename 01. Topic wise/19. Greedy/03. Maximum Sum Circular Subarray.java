class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int totalSum = 0;
        int currentMax = 0;
        int maxSum = nums[0];
        int currentMin = 0;
        int minSum = nums[0];

        for (int x : nums) {
            // Standard Kadane's for Maximum Subarray
            currentMax = Math.max(x, currentMax + x);
            maxSum = Math.max(maxSum, currentMax);

            // Kadane's for Minimum Subarray
            currentMin = Math.min(x, currentMin + x);
            minSum = Math.min(minSum, currentMin);

            totalSum += x;
        }

        // Edge Case: If all numbers are negative, maxSum will be the largest 
        // single element. totalSum - minSum would result in 0 (an empty subarray),
        // which is not allowed per the problem constraints.
        if (maxSum < 0) {
            return maxSum;
        }

        // Return the better of the two cases
        return Math.max(maxSum, totalSum - minSum);
    }
}
