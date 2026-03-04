class Solution {
    public int makeConnected(int n, int[][] connections) {
        int requiredCables = n-1;
        if (connections.length < requiredCables) return -1; // Not enough cables
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        for (int[] conn : connections) {
            int pu = find(parent, conn[0]);
            int pv = find(parent, conn[1]);
            if (pu != pv) {
                parent[pu] = pv;
                requiredCables--;
            }
        }
        return requiredCables;
    }
    private int find(int[] parent, int x) {
        if (parent[x] != x) parent[x] = find(parent, parent[x]); // Path compression
        return parent[x];
    }
}
