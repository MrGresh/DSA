class Solution {
    public ArrayList<Integer> prefixSum2D(int[][] mat, int[][] queries) {
        int m = mat.length;
        int n = mat[0].length;

        // Build 2D prefix sums in-place
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0) mat[i][j] += mat[i-1][j];
                if (j > 0) mat[i][j] += mat[i][j-1];
                if (i > 0 && j > 0) mat[i][j] -= mat[i-1][j-1];
            }
        }

        ArrayList<Integer> res = new ArrayList<>();

        // Answer queries in O(1)
        for (int[] q : queries) {
            int r1 = q[0], c1 = q[1], r2 = q[2], c2 = q[3];

            int sum = mat[r2][c2];
            if (r1 > 0) sum -= mat[r1-1][c2];
            if (c1 > 0) sum -= mat[r2][c1-1];
            if (r1 > 0 && c1 > 0) sum += mat[r1-1][c1-1];

            res.add(sum);
        }

        return res;
    }
}
