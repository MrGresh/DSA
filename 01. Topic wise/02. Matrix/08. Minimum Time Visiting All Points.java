class Solution {
    public int minTimeToVisitAllPoints(int[][] mat) {
        int res = 0;
        for(int i=0;i<mat.length-1;i++) {
            res += Math.max(Math.abs(mat[i+1][0]-mat[i][0]), Math.abs(mat[i+1][1]-mat[i][1]));
        }
        return res;
    }
}
