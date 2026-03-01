// When we are dealing specifically with a Directed Acyclic Graph (DAG), we don't actually need complex algorithms like Dijkstra. 
// Because there are no cycles, we can find the shortest path in linear time O(V + E) using Topological Sort.

import java.util.*;

class Solution {
    
    // Helper class for weighted edges
    class Pair {
        int node, weight;
        Pair(int n, int w) { node = n; weight = w; }
    }

    public int[] shortestPath(int V, int E, int[][] edges) {
        // 1. Build Adjacency List
        List<List<Pair>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) adj.add(new ArrayList<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(new Pair(edge[1], edge[2]));
        }

        // 2. Perform Topological Sort (DFS based)
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (!vis[i]) topoSort(i, adj, vis, st);
        }

        // 3. Distance array initialization
        int[] dist = new int[V];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0; // Starting from vertex 0

        // 4. Relax edges in Topological Order
        while (!st.isEmpty()) {
            int u = st.pop();

            // If the node has been reached, relax its outgoing edges
            if (dist[u] != Integer.MAX_VALUE) {
                for (Pair edge : adj.get(u)) {
                    int v = edge.node;
                    int weight = edge.weight;
                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                    }
                }
            }
        }

        // 5. Cleanup: replace Infinity with -1
        for (int i = 0; i < V; i++) {
            if (dist[i] == Integer.MAX_VALUE) dist[i] = -1;
        }

        return dist;
    }

    private void topoSort(int u, List<List<Pair>> adj, boolean[] vis, Stack<Integer> st) {
        vis[u] = true;
        for (Pair edge : adj.get(u)) {
            if (!vis[edge.node]) {
                topoSort(edge.node, adj, vis, st);
            }
        }
        st.push(u);
    }
}
