class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length, cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        // Initialize queue with all rotten oranges and count fresh ones
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 2) queue.offer(new int[]{i, j});
                else if (grid[i][j] == 1) freshCount++;
            }
        }

        if (freshCount == 0) return 0; // No fresh oranges to rot

        int minutes = -1;
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};

        while (!queue.isEmpty()) {
            minutes++;
            int size = queue.size();
            for (int i = 1; i <= size; i++) {
                int[] pos = queue.poll();
                for (int[] dir : directions) {
                    int r = pos[0] + dir[0], c = pos[1] + dir[1];
                    if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c] == 1) {
                        grid[r][c] = 2;
                        freshCount--;
                        queue.offer(new int[]{r, c});
                    }
                }
            }
        }

        return freshCount == 0 ? minutes : -1;
    }
}
