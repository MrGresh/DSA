class Solution {
    class Edge {
        int to;
        int price;
        Edge(int to, int price) {
            this.to = to;
            this.price = price;
        }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Edge>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] f : flights) {
            adj.get(f[0]).add(new Edge(f[1], f[2]));
        }

        int[] minCosts = new int[n];
        Arrays.fill(minCosts, Integer.MAX_VALUE);
        minCosts[src] = 0;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{src, 0});

        int stops = -1;
        
        // BFS limited by stops (K + 1 edges total)
        while (!queue.isEmpty() && ++stops <= k) {
            int size = queue.size();
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int u = curr[0];
                int costSoFar = curr[1];

                for (Edge edge : adj.get(u)) {
                    int v = edge.to;
                    int price = edge.price;

                    if (costSoFar + price < minCosts[v]) {
                        minCosts[v] = costSoFar + price;
                        queue.offer(new int[]{v, minCosts[v]});
                    }
                }
            }
        }

        return minCosts[dst] == Integer.MAX_VALUE ? -1 : minCosts[dst];
    }
}
------------------------------------------------------------------------------------------------
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Bellman-Ford
        int[] prices = new int[n];
        Arrays.fill(prices, Integer.MAX_VALUE);
        prices[src] = 0;
        for (int i = 1; i <= k+1; i++) {
            int[] temp = Arrays.copyOf(prices, n);
            for (int[] f : flights) {
                int u = f[0], v = f[1], cost = f[2];
                if (prices[u] != Integer.MAX_VALUE && prices[u] + cost < temp[v]) {
                    temp[v] = prices[u] + cost;
                }
            }
            prices = temp;
        }
        return prices[dst] == Integer.MAX_VALUE ? -1 : prices[dst];
    }
}
