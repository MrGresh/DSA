class Solution {
    List<List<String>> res;
    int[][] chassBoard;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        chassBoard = new int[n][n];
        for(int j=0;j<n;j++) {
            chassBoard[0][j] = 1;
            putOtherQueens(1);
            chassBoard[0][j] = 0;
        }
        return res;
    }
    void putOtherQueens(int i) {
        if(i==chassBoard.length) {
            List<String> curr = new ArrayList<>();
            for(int[] rows : chassBoard) {
                StringBuilder currRow = new StringBuilder();
                for(int val : rows) {
                    currRow.append(val==0 ? "." : "Q");
                }
                curr.add(currRow.toString());
            }
            res.add(curr);
            return;
        }
        for(int j=0;j<chassBoard.length;j++) {
            if(isPossibleToPutHere(i, j)) {
                chassBoard[i][j] = 1;
                putOtherQueens(i+1);
                chassBoard[i][j] = 0;
            }
        }
    }
    boolean isPossibleToPutHere(int i, int j) {
        for(int row=0;row<chassBoard.length;row++) {if(row!=i && chassBoard[row][j]==1) return false;}
        int r=i-1, c=j-1;
        while(r>=0 && c>=0) {if(chassBoard[r--][c--]==1) return false;}
        r=i+1;c=j+1;
        while(r<chassBoard.length && c<chassBoard.length) {if(chassBoard[r++][c++]==1) return false;}
        r=i-1;c=j+1;
        while(r>=0 && c<chassBoard.length) {if(chassBoard[r--][c++]==1) return false;}
        r=i+1;c=j-1;
        while(r<chassBoard.length && c>=0) {if(chassBoard[r++][c--]==1) return false;}
        return true;
    }
}
