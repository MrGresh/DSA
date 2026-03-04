class Solution {
    public List<Integer> shortestPath(int n, int m, int[][] edges) {
        // Dijkstra
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) graph.add(new ArrayList<>());

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.get(u).add(new int[]{v, w});
            graph.get(v).add(new int[]{u, w});
        }

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        dist[1] = 0;
        pq.offer(new int[]{1, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];

            if (d > dist[u]) continue;

            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0], w = neighbor[1];
                if (d + w < dist[v]) {
                    dist[v] = d + w;
                    parent[v] = u;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        if (dist[n] == Integer.MAX_VALUE) return Arrays.asList(-1);

        List<Integer> path = new ArrayList<>();
        int node = n;
        while (node != -1) {
            path.add(node);
            node = parent[node];
        }
        Collections.reverse(path);
        path.add(0, dist[n]); // prepend total weight

        return path;
    }
}
