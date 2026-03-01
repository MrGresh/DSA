class Solution {
    int[] parent;
    public int latestDayToCross(int row, int col, int[][] cells) {
        int n = row * col;
        parent = new int[n + 2]; // +2 for Virtual Left and Virtual Right
        for (int i = 0; i < n + 2; i++) parent[i] = i;
        
        int vLeft = 0;
        int vRight = n + 1;
        boolean[][] isWater = new boolean[row][col];
        
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        for (int i = 0; i < cells.length - 1; i++) {
            int r = cells[i][0] - 1;
            int c = cells[i][1] - 1;
            isWater[r][c] = true;
            
            int currIdx = r * col + c + 1;
            
            if (c == 0) union(currIdx, vLeft);
            if (c == col - 1) union(currIdx, vRight);
            
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < row && nc >= 0 && nc < col && isWater[nr][nc]) {
                    union(currIdx, nr * col + nc + 1);
                }
            }
            
            if (find(vLeft) == find(vRight)) return i;
        }
        
        return 0;
    }
    
    private int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }
    
    private void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) parent[rootI] = rootJ;
    }
}
