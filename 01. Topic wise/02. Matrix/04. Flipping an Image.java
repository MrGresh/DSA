class Solution {
    public int[][] flipAndInvertImage(int[][] input) {
        for(int[] row : input) {
            int i=0, j=row.length-1;
            while(i<=j) {
                int t = 1-row[i];
                row[i++] = 1-row[j];
                row[j--] = t;
            }
        }
        return input;        
    }
}
