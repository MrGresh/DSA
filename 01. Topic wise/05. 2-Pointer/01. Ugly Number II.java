class Solution {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        
        int[] dp = new int[n];
        dp[0] = 1;
        int i = 0, j = 0, k = 0; // indexes pointers

        for (int x = 1; x < n; x++) {
            dp[x] = Math.min(dp[i]*2, Math.min(dp[j]*3, dp[k]*5));

            if (dp[x] == dp[i]*2) i++;
            if (dp[x] == dp[j]*3) j++;
            if (dp[x] == dp[k]*5) k++;
        }
        return dp[n - 1];
    }
}
