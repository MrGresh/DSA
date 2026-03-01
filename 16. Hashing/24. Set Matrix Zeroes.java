class Solution {
    public void setZeroes(int[][] mat) {
        Set<Integer> targetRows = new HashSet<>();
        Set<Integer> targetCols = new HashSet<>();
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[i].length;j++) {
                if(mat[i][j]==0) {
                    targetRows.add(i);
                    targetCols.add(j);
                }
            }
        }
        for(int row : targetRows) Arrays.fill(mat[row], 0);
        for(int col : targetCols) {
            for(int i=0;i<mat.length;i++) mat[i][col] = 0;
        }
    }
}
