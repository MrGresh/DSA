// Undirected Graphs
class MinCycleUndirectedFW {
    static final int INF = 1_000_000_000;
    public static int findMinCycle(int V, int[][] edges) {
        int[][] dist = new int[V][V];

        for (int i = 0; i < V; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int[] e : edges) {
            dist[e[0]][e[1]] = Math.min(dist[e[0]][e[1]], e[2]);
            dist[e[1]][e[0]] = Math.min(dist[e[1]][e[0]], e[2]);
        }

        // Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Find minimum cycle
        int minCycle = INF;
        for (int u = 0; u < V; u++) {
            for (int v = u + 1; v < V; v++) { // avoid double counting
                if (dist[u][v] < INF && dist[v][u] < INF) {
                    minCycle = Math.min(minCycle, dist[u][v] + dist[v][u]);
                }
            }
        }

        return (minCycle == INF) ? -1 : minCycle;
    }
}
-----------------------------------------------------------------------------------------------------------
// Directed Graphs
class MinCycleDirectedFW {
    static final int INF = 1_000_000_000;
    public static int findMinCycle(int V, int[][] edges) {
        int[][] dist = new int[V][V];

        for (int i = 0; i < V; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        for (int[] e : edges) {
            dist[e[0]][e[1]] = Math.min(dist[e[0]][e[1]], e[2]);
        }

        // Floyd-Warshall
        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    if (dist[i][k] < INF && dist[k][j] < INF) {
                        dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                    }
                }
            }
        }

        // Find minimum cycle
        int minCycle = INF;
        for (int u = 0; u < V; u++) {
            for (int v = 0; v < V; v++) {
                if (u != v && dist[v][u] < INF && dist[u][v] < INF) {
                    minCycle = Math.min(minCycle, dist[u][v] + dist[v][u]);
                }
            }
        }

        return (minCycle == INF) ? -1 : minCycle;
    }
}
