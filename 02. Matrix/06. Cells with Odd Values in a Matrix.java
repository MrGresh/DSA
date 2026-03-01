class Solution {
    public int oddCells(int m, int n, int[][] indices) {
        int[] rowCounts = new int[m];
        int[] colCounts = new int[n];
        
        int oddRows = 0, oddCols = 0;
        for (int[] index : indices) {
            rowCounts[index[0]]++;
            colCounts[index[1]]++;

            if(rowCounts[index[0]]%2!=0) oddRows++;
            else oddRows--;
            if(colCounts[index[1]]%2!=0) oddCols++;
            else oddCols--;
        }

        /*
        for (int rowCount : rowCounts) {
            if (rowCount % 2 != 0) oddRows++;
        }
        for (int colCount : colCounts) {
            if (colCount % 2 != 0) oddCols++;
        }
        */

        int totalOdd = (oddRows * n + oddCols * m) - 2 * oddRows * oddCols;

        return totalOdd;
    }
}
