class Solution {
    class Node implements Comparable<Node> {
        int id, distance;
        Node(int id, int distance) {
            this.id = id;
            this.distance = distance;
        }

        // TreeSet needs a clear way to compare. 
        // If distances are equal, we compare IDs to avoid treating different nodes as "equal".
        @Override
        public int compareTo(Node other) {
            if (this.distance != other.distance) {
                return Integer.compare(this.distance, other.distance);
            }
            return Integer.compare(this.id, other.id);
        }
    }

    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new int[]{edge[1], edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        TreeSet<Node> set = new TreeSet<>();
        set.add(new Node(src, 0));

        while (!set.isEmpty()) {
            // pollFirst() retrieves and removes the smallest element
            Node current = set.pollFirst();
            int u = current.id;

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];

                if (dist[u] + weight < dist[v]) {
                    // 1. If the node is already in the set, remove the old version
                    if (dist[v] != Integer.MAX_VALUE) {
                        set.remove(new Node(v, dist[v]));
                    }
                    
                    // 2. Update the distance
                    dist[v] = dist[u] + weight;
                    
                    // 3. Re-insert with the new distance
                    set.add(new Node(v, dist[v]));
                }
            }
        }
        return dist;
    }
}
