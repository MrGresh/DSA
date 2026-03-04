class Solution {
    public int countSquare(int[][] mat, int x) {
        int n = mat.length;
        int m = mat[0].length;
        
        // 1. Build 2D Prefix Sum Array
        // Long is used to prevent overflow for the sum
        long[][] pref = new long[n + 1][m + 1];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                pref[i + 1][j + 1] = mat[i][j] + pref[i][j + 1] 
                                     + pref[i + 1][j] - pref[i][j];
            }
        }
        
        int count = 0;
        int maxSide = Math.min(n, m);
        
        // 2. Iterate through all possible square side lengths L
        for (int L = 1; L <= maxSide; L++) {
            // 3. Iterate through all possible top-left corners (i, j)
            for (int i = 1; i <= n - L + 1; i++) {
                for (int j = 1; j <= m - L + 1; j++) {
                    
                    // 4. Calculate sum of square of size L starting at (i, j)
                    // Bottom-right corner is (i + L - 1, j + L - 1)
                    int r2 = i + L - 1;
                    int c2 = j + L - 1;
                    
                    long currentSum = pref[r2][c2] - pref[i - 1][c2] 
                                      - pref[r2][j - 1] + pref[i - 1][j - 1];
                    
                    if (currentSum == x) {
                        count++;
                    }
                }
            }
        }
        
        return count;
    }
}
