class NumArray {
    private int[] prefixSum;

    public NumArray(int[] nums) {
        if (nums.length == 0) return;
        
        prefixSum = new int[nums.length];
        prefixSum[0] = nums[0];
        
        // Precompute the sums in O(N)
        for (int i = 1; i < nums.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        // Answer each query in O(1)
        if (left == 0) return prefixSum[right];
        return prefixSum[right] - prefixSum[left - 1];
    }
}
