class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        int startCol = 0, endCol = cols - 1;
        
        while (startCol <= endCol) {
            int midCol = startCol + (endCol - startCol) / 2;
            
            int maxRow = 0;
            for (int i = 1; i < rows; i++) {
                if (mat[i][midCol] > mat[maxRow][midCol]) {
                    maxRow = i;
                }
            }
            
            boolean leftIsBig = midCol > 0 && mat[maxRow][midCol - 1] > mat[maxRow][midCol];
            boolean rightIsBig = midCol < cols - 1 && mat[maxRow][midCol + 1] > mat[maxRow][midCol];
            
            if (!leftIsBig && !rightIsBig) {
                return new int[] {maxRow, midCol};
            } else if (leftIsBig) {
                endCol = midCol - 1;
            } else {
                startCol = midCol + 1;
            }
        }
        
        return new int[] {-1, -1};
    }
}
