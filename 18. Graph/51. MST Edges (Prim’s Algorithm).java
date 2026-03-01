class Edge {
    int src, dest, weight;
    Edge(int src, int dest, int weight, ) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
}

class Solution {
    public List<Edge> spanningTree(int V, int[][] edges) {
        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i < V; i++) graph.add(new ArrayList<>());
        
        for (int[] e : edges) {
            graph.get(e[0]).add(new Edge(e[0], e[1], e[2]));
            graph.get(e[1]).add(new Edge(e[1], e[0], e[2]));
        }

        boolean[] vis = new boolean[V];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.weight));
        List<Edge> mstEdges = new ArrayList<>();

        // Start from vertex 0
        pq.add(new Edge(-1, 0, 0));

        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int u = current.dest;

            if (vis[u]) continue;
            vis[u] = true;

            // Skip the dummy starting edge
            if (current.src != -1) {
                mstEdges.add(current);
            }

            for (Edge e : graph.get(u)) {
                if (!vis[e.dest]) pq.add(e);
            }
        }

        return mstEdges;
    }
}
