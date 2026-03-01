class Solution {
    public int[][] transpose(int[][] input) {
        if(input.length==input[0].length) { // For Squared Matrix
            for(int i=1;i<input.length;i++) {
                for(int j=0;j<i;j++) {
                    int t = input[i][j];
                    input[i][j] = input[j][i];
                    input[j][i] = t;
                }
            }
            return input;
        } 
        else { // If Matrix is not squared
                int rows = input.length;
                int cols = input[0].length;
                int[][] transposed = new int[cols][rows]; // Swap dimensions

                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        transposed[j][i] = input[i][j]; // Assign transposed value
                    }
                }

                return transposed;

        }       
    }
}
