class Solution {
    public int kthSmallest(int[][] mat, int k) {
        int n = mat.length;
        int low = mat[0][0];
        int high = mat[n - 1][n - 1];
        int ans = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int val = countLessEqual(mat, mid);
            if (val >= k) {
                ans = mid;
                high = mid-1;
            }
            else low = mid+1;
        }
        return ans;
    }

    private int countLessEqual(int[][] mat, int target) {
        int n = mat.length;
        int count = 0;
        int row = n - 1;
        int col = 0;

        while (row >= 0 && col < n) {
            if (mat[row][col] <= target) {
                count += (row + 1);
                col++;
            } else row--;
        }
        return count;
    }
}
