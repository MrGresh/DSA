class Solution {
    public int maxSubArray(int[] arr) {
        int ans = arr[0];
        int currentMax = arr[0];

        for (int i = 1; i < arr.length; i++) {
            currentMax = Math.max(arr[i], currentMax + arr[i]);
            ans = Math.max(ans, currentMax);
        }

        return ans;
    }
}
