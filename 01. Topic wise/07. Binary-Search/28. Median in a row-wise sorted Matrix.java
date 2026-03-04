class Solution {
    public int median(int[][] mat) {
        int r = mat.length;
        int c = mat[0].length;
        int k = ((r*c)/2)+1;
        return kthSmallest(mat, k);
    }
    public int kthSmallest(int[][] mat, int k) {
        int r = mat.length;
        int c = mat[0].length;
        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;
        for (int i = 0; i < r; i++) {
            low = Math.min(low, mat[i][0]);
            high = Math.max(high, mat[i][c - 1]);
        }
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
        int count = 0;
        for (int i = 0; i < mat.length; i++) {
            int low = 0, high = mat[i].length - 1;
            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (mat[i][mid] <= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            count += low;
        }
        return count;
    }
}
