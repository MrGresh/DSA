class Solution {
    public long sumSubmatrices(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        long totalSum = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // Number of submatrices containing mat[i][j]
                long count = (long) (i + 1) * (j + 1) * (n - i) * (m - j);
                totalSum += (count * mat[i][j]);
            }
        }

        return totalSum;
    }
}
