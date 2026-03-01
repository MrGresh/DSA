class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int i = 0;
        for(int[] row : mat) {
            sum += row[i];
            if(i != row.length-1-i) sum += row[row.length-1-i];
            i++;
        }
        return sum;
    }
}
