class Solution {
    public int numSpecial(int[][] mat) {
        int count = 0;
        int[] rows = new int[mat.length];
        int[] cols = new int[mat[0].length];
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                if(mat[i][j]==1) {
                    rows[i]++;
                    cols[j]++;
                } 
            }
        }
        for(int i=0;i<mat.length;i++) {
            for(int j=0;j<mat[0].length;j++) {
                if(mat[i][j]==1 && rows[i]==1 && cols[j]==1) count++; 
            }
        }
        return count;
    }
}
