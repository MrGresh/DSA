// Recursion
class Solution {
    int[][] grid;
    int n;
    boolean[][] vis;
    int ans;
    public int shortestPathBinaryMatrix(int[][] grid) {
        ans = Integer.MAX_VALUE;
        n = grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1) return -1;
        this.grid = grid;
        vis = new boolean[n][n];
        rec(0, 0, 1);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
    void rec(int i, int j, int len) {
        if(i==n-1 && j==n-1) {
            ans = Math.min(ans, len);
            return;
        }
        vis[i][j] = true;
        if(i-1 >= 0 && !vis[i-1][j] && grid[i-1][j]==0) rec(i-1, j, len+1);
        if(j-1 >= 0 && !vis[i][j-1] && grid[i][j-1]==0) rec(i, j-1, len+1);
        if(i+1 < n && !vis[i+1][j] && grid[i+1][j]==0) rec(i+1, j, len+1);
        if(j+1 < n && !vis[i][j+1] && grid[i][j+1]==0) rec(i, j+1, len+1);
        if(i-1 >= 0 && j-1 >= 0 && !vis[i-1][j-1] && grid[i-1][j-1]==0) rec(i-1, j-1, len+1);
        if(i+1 < n && j+1 < n && !vis[i+1][j+1] && grid[i+1][j+1]==0) rec(i+1, j+1, len+1);
        if(i-1 >= 0 && j+1 < n && !vis[i-1][j+1] && grid[i-1][j+1]==0) rec(i-1, j+1, len+1);
        if(i+1 < n && j-1 >= 0 && !vis[i+1][j-1] && grid[i+1][j-1]==0) rec(i+1, j-1, len+1);
        vis[i][j] = false;
    }
}
----------------------------------------------------------------------------------------------------
// Dijkstra
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

        int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1},  {1, 0},  {1, 1}};

        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[0][0] = 1;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.offer(new int[]{0, 0, 1}); // row, col, distance

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int r = curr[0], c = curr[1], d = curr[2];
            if (r == n - 1 && c == n - 1) return d;
            if(d > dist[r][c]) continue;

            for (int[] dir : directions) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 0 && d + 1 < dist[nr][nc]) {
                    dist[nr][nc] = d + 1;
                    pq.offer(new int[]{nr, nc, d + 1});
                }
            }
        }

        return dist[n-1][n-1]==Integer.MAX_VALUE ? -1 : dist[n-1][n-1];
    }
}
-----------------------------------------------------------------------------------------------------------------------
// BFS Based
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;
        int[] dx = {-1, 0, 1, 1, 1, -1, -1, 0};
        int[] dy = {1, -1, 1, 0, -1, -1, 0, 1};
        Queue<int[]> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][n];
        q.offer(new int[]{0, 0, 1});
        vis[0][0] = true;
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], dist = cur[2];
            if (x == n - 1 && y == n - 1) return dist;
            for (int d = 0; d < 8; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];
                if (nx >= 0 && ny >= 0 && nx < n && ny < n && grid[nx][ny] == 0 && !vis[nx][ny]) {
                    vis[nx][ny] = true;
                    q.offer(new int[]{nx, ny, dist + 1});
                }
            }
        }
        return -1;
    }
}
