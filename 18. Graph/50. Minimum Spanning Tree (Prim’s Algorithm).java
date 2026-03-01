class Edge {
    int dest, weight;
    Edge(int x, int y) {
        dest = x;
        weight = y;
    }
}
class Solution {
    public int spanningTree(int V, int[][] edges) {
        List<List<Edge>> graph = new ArrayList<>();
        for(int i=1;i<=V;i++) graph.add(new ArrayList<>());
        for(int[] e : edges) {
            graph.get(e[0]).add(new Edge(e[1], e[2]));
            graph.get(e[1]).add(new Edge(e[0], e[2]));
        }
        boolean[] vis = new boolean[V];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        int totalWeight = 0;

        // Start from vertex 0
        pq.add(new Edge(0, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.dest;

            if (vis[u]) continue;
            vis[u] = true;
            totalWeight += current.weight;

            for (Edge e : graph.get(u)) {
                if (!vis[e.dest]) pq.add(e);
            }
        }

        return totalWeight;
    }
}
