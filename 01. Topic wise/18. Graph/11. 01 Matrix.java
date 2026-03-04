class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r=mat.length, c=mat[0].length;
        boolean[][] vis = new boolean[r][c];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(mat[i][j]==0) {
                    vis[i][j] = true;
                    q.add(new int[] {i, j, 0});
                }
            }
        }
        while(!q.isEmpty()) {
            int[] e = q.poll();
            int i = e[0], j=e[1], dis = e[2];
            if(i-1>=0 && !vis[i-1][j]) {
                vis[i-1][j] = true;
                mat[i-1][j] = dis+1;
                q.add(new int[] {i-1, j, dis+1});
            }
            if(j-1>=0 && !vis[i][j-1]) {
                vis[i][j-1] = true;
                mat[i][j-1] = dis+1;
                q.add(new int[] {i, j-1, dis+1});
            }
            if(i+1<r && !vis[i+1][j]) {
                vis[i+1][j] = true;
                mat[i+1][j] = dis+1;
                q.add(new int[] {i+1, j, dis+1});
            }
            if(j+1<c && !vis[i][j+1]) {
                vis[i][j+1] = true;
                mat[i][j+1] = dis+1;
                q.add(new int[] {i, j+1, dis+1});
            }
        }
        return mat;
    }
}
-----------------------------------------------------------------------------------------------------------
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int r=mat.length, c=mat[0].length;
        boolean[][] vis = new boolean[r][c];
        Queue<int[]> q = new LinkedList<>();
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if(mat[i][j]==0) {
                    vis[i][j] = true;
                    q.add(new int[] {i, j});
                }
            }
        }
        int dis = -1;
        while(!q.isEmpty()) {
            dis++;
            int size = q.size();
            for(int k=1;k<=size;k++) {
                int[] e = q.poll();
                int i = e[0], j=e[1];
                mat[i][j]=dis;
                if(i-1>=0 && !vis[i-1][j]) {
                    vis[i-1][j] = true;
                    q.add(new int[] {i-1, j});
                }
                if(j-1>=0 && !vis[i][j-1]) {
                    vis[i][j-1] = true;
                    q.add(new int[] {i, j-1});
                }
                if(i+1<r && !vis[i+1][j]) {
                    vis[i+1][j] = true;
                    q.add(new int[] {i+1, j});
                }
                if(j+1<c && !vis[i][j+1]) {
                    vis[i][j+1] = true;
                    q.add(new int[] {i, j+1});
                }
            }
        }
        return mat;
    }
}
