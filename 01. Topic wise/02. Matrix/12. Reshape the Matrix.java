class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        if(mat.length*mat[0].length!=r*c) return mat;
        int[][] res = new int[r][c];
        int currI = 0, currJ = 0;
        for(int[] row: mat) {
            for(int x : row) {
                res[currI][currJ] = x;
                if(currJ!=c-1) currJ++;
                else {
                    currJ = 0;
                    if(currI!=r-1) currI++;
                    else return res;
                }
            }
        }
        return res;
    }
}
