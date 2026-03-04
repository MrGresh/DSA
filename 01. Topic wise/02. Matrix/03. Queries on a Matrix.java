class Solution {
    public int[][] solveQueries(int n, int[][] Queries) {
        // We use size n + 1 to handle boundary conditions (c + 1 or d + 1)
        int[][] diff = new int[n + 1][n + 1];
        
        // Step 1: Process all queries in O(Q)
        for (int[] q : Queries) {
            int a = q[0], b = q[1], c = q[2], d = q[3];
            
            diff[a][b]++;
            if (d + 1 < n) diff[a][d + 1]--;
            if (c + 1 < n) diff[c + 1][b]--;
            if (c + 1 < n && d + 1 < n) diff[c + 1][d + 1]++;
        }
        
        // Step 2: Compute 2D Prefix Sum in O(n^2)
        int[][] res = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Formula: current = diff + top + left - top_left
                int top = (i > 0) ? res[i - 1][j] : 0;
                int left = (j > 0) ? res[i][j - 1] : 0;
                int topLeft = (i > 0 && j > 0) ? res[i - 1][j - 1] : 0;
                
                res[i][j] = diff[i][j] + top + left - topLeft;
            }
        }
        
        return res;
    }
}
