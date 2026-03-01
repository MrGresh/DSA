class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];
        if(originalColor==color) return image;
        image[sr][sc] = color;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {sr, sc});
        int[][] dirs = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        while(!q.isEmpty()) {
            int[] e = q.poll();
            for(int[] dir: dirs) {
                int i = dir[0]+e[0];
                int j = dir[1]+e[1];
                if(i>=0 && j>=0 && i<image.length && j<image[0].length && image[i][j]==originalColor) {
                    image[i][j] = color;
                    q.add(new int[] {i, j});
                }
            }
        }
        return image;
    }
}
