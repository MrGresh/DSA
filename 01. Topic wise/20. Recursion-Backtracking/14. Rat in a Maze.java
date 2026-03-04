class Solution {
    ArrayList<String> res;
    public ArrayList<String> ratInMaze(int[][] maze) {
        res = new ArrayList<>();
        if(maze[0][0]==0 || maze[maze.length-1][maze.length-1]==0) return res;
        rec(0, 0, new StringBuilder(), new boolean[maze.length][maze.length], maze);
        return res;
    }
    void rec(int i, int j, StringBuilder path, boolean[][] vis, int[][] maze) {
        if(i==maze.length-1 && j==maze.length-1) {
            res.add(path.toString());
            return;
        }
        vis[i][j] = true;
        if(i+1<maze.length && !vis[i+1][j] && maze[i+1][j]==1) {
            path.append("D");
            rec(i+1, j, path, vis, maze);
            path.deleteCharAt(path.length() - 1);
        }
        if(j-1>=0 && !vis[i][j-1] && maze[i][j-1]==1) {
            path.append("L");
            rec(i, j-1, path, vis, maze);
            path.deleteCharAt(path.length() - 1);
        }
        if(j+1<maze.length && !vis[i][j+1] && maze[i][j+1]==1) {
            path.append("R");
            rec(i, j+1, path, vis, maze);
            path.deleteCharAt(path.length() - 1);
        }
        if(i-1>=0 && !vis[i-1][j] && maze[i-1][j]==1) {
            path.append("U");
            rec(i-1, j, path, vis, maze);
            path.deleteCharAt(path.length() - 1);
        }
        vis[i][j] = false;
    }
}
