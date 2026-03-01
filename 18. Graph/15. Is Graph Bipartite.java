class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); // -1 means uncolored

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                Queue<Integer> queue = new LinkedList<>();
                queue.offer(i);
                color[i] = 0;

                while (!queue.isEmpty()) {
                    int node = queue.poll();
                    for (int neighbor : graph[node]) {
                        if (color[neighbor] == -1) {
                            color[neighbor] = 1 - color[node];
                            queue.offer(neighbor);
                        } else if (color[neighbor] == color[node]) {
                            return false; // Same color on both ends
                        }
                    }
                }
            }
        }

        return true;
    }
}
-----------------------------------------------------------------------------------------------------
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1); // -1 means uncolored

        for (int i = 0; i < n; i++) {
            if (color[i] == -1 && dfs(i, 0, color, graph)) return false;
        }
        return true;
    }
    boolean dfs(int i, int c, int[] color, int[][] graph) {
        color[i] = c;
        for(int nei: graph[i]) {
            if(color[nei]==-1 && dfs(nei, 1-c, color, graph)) return true;
            if(color[nei]==color[i]) return true;
        }
        return false;
    }
}
