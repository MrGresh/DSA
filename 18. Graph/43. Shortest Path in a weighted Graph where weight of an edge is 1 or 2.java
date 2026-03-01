// 1-2 BFS is a specialized graph traversal technique used to find the shortest path in a graph where every edge weight is either 1 or 2.
class Solution {
    public int shortestPath(int V, int[][] edges, int src, int dst) {
        // We might need up to V + E nodes (one dummy node per weight-2 edge)
        List<List<Integer>> adj = new ArrayList<>();
        int totalNodes = V + edges.length; 
        for (int i = 0; i < totalNodes; i++) adj.add(new ArrayList<>());

        int dummyNodeId = V;
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            if (w == 1) {
                adj.get(u).add(v);
                adj.get(v).add(u);
            } else {
                // Split weight 2 into: u -> dummy -> v
                adj.get(u).add(dummyNodeId);
                adj.get(dummyNodeId).add(v);
                
                adj.get(v).add(dummyNodeId);
                adj.get(dummyNodeId).add(u);
                dummyNodeId++;
            }
        }

        // Standard BFS
        int[] dist = new int[totalNodes];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();

        q.offer(src);
        dist[src] = 0;

        while (!q.isEmpty()) {
            int curr = q.poll();
            if (curr == dst) return dist[dst];

            for (int neighbor : adj.get(curr)) {
                if (dist[neighbor] == -1) {
                    dist[neighbor] = dist[curr] + 1;
                    q.offer(neighbor);
                }
            }
        }
        return -1;
    }
}
