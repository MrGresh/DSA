class Solution {
    Map<String, Set<Integer>> entryMap = Map.of(
        "up", Set.of(2, 3, 4),
        "down", Set.of(2, 5, 6),
        "left", Set.of(1, 4, 6),
        "right", Set.of(1, 3, 5)
    );
    
    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        return dfs(grid, 0, 0, vis);
    }

    boolean dfs(int[][] grid, int i, int j, boolean[][] vis) {
        int m = grid.length, n = grid[0].length;
        if (i == m - 1 && j == n - 1) return true;
        vis[i][j] = true;

        switch (grid[i][j]) {
            case 1: // left <-> right
                if (j > 0 && !vis[i][j - 1] && entryMap.get("left").contains(grid[i][j - 1]) && dfs(grid, i, j - 1, vis)) return true;
                if (j < n - 1 && !vis[i][j + 1] && entryMap.get("right").contains(grid[i][j + 1]) && dfs(grid, i, j + 1, vis)) return true;
                break;
            case 2: // up <-> down
                if (i > 0 && !vis[i - 1][j] && entryMap.get("up").contains(grid[i - 1][j]) && dfs(grid, i - 1, j, vis)) return true;
                if (i < m - 1 && !vis[i + 1][j] && entryMap.get("down").contains(grid[i + 1][j]) && dfs(grid, i + 1, j, vis)) return true;
                break;
            case 3: // left <-> down
                if (j > 0 && !vis[i][j - 1] && entryMap.get("left").contains(grid[i][j - 1]) && dfs(grid, i, j - 1, vis)) return true;
                if (i < m - 1 && !vis[i + 1][j] && entryMap.get("down").contains(grid[i + 1][j]) && dfs(grid, i + 1, j, vis)) return true;
                break;
            case 4: // right <-> down
                if (j < n - 1 && !vis[i][j + 1] && entryMap.get("right").contains(grid[i][j + 1]) && dfs(grid, i, j + 1, vis)) return true;
                if (i < m - 1 && !vis[i + 1][j] && entryMap.get("down").contains(grid[i + 1][j]) && dfs(grid, i + 1, j, vis)) return true;
                break;
            case 5: // left <-> up
                if (j > 0 && !vis[i][j - 1] && entryMap.get("left").contains(grid[i][j - 1]) && dfs(grid, i, j - 1, vis)) return true;
                if (i > 0 && !vis[i - 1][j] && entryMap.get("up").contains(grid[i - 1][j]) && dfs(grid, i - 1, j, vis)) return true;
                break;
            case 6: // right <-> up
                if (j < n - 1 && !vis[i][j + 1] && entryMap.get("right").contains(grid[i][j + 1]) && dfs(grid, i, j + 1, vis)) return true;
                if (i > 0 && !vis[i - 1][j] && entryMap.get("up").contains(grid[i - 1][j]) && dfs(grid, i - 1, j, vis)) return true;
                break;
        }
        return false;
    }
}
