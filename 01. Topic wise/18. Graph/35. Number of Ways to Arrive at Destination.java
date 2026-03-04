class Solution {
    public int countPaths(int n, int[][] roads) {
        long MOD = 1_000_000_007;
        List<List<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        for (int[] r : roads) {
            adj.get(r[0]).add(new int[]{r[1], r[2]});
            adj.get(r[1]).add(new int[]{r[0], r[2]});
        }

        long[] dist = new long[n];
        long[] ways = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        
        dist[0] = 0;
        ways[0] = 1;

        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0}); // {city, time}

        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int u = (int) curr[0];
            long d = curr[1];

            if (d > dist[u]) continue;

            for (int[] neighbor : adj.get(u)) {
                int v = neighbor[0];
                long weight = neighbor[1];

                if (dist[u] + weight < dist[v]) {
                    ways[v] = ways[u]; // Found a better way, reset count to ways[u]
                    dist[v] = dist[u] + weight;
                    pq.offer(new long[]{v, dist[v]});
                } else if (dist[u] + weight == dist[v]) {
                    ways[v] = (ways[v] + ways[u]) % MOD; // Same distance, add the counts
                }
            }
        }

        return (int) ways[n - 1];
    }
}
