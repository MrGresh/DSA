class Solution {
    public int findCircleNum(int[][] mat) {
        int n = mat.length;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                }
            }
        }
        boolean[] vis = new boolean[n];
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfs(i, adj, vis);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfs(int node, List<List<Integer>> adj, boolean[] vis) {
        vis[node] = true;
        for (int neighbor : adj.get(node)) {
            if (!vis[neighbor]) dfs(neighbor, adj, vis);
        }
    }
}
--------------------------------------------------------------------------------------------------
class Solution {
    class UnionFind {
        private int[] parent;
        private int[] rank;
        private int count;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            count = n; // Initially, every city is its own province
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int i) {
            if (parent[i] == i) return i;
            return parent[i] = find(parent[i]); // Path compression
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI != rootJ) {
                // Union by rank
                if (rank[rootI] < rank[rootJ]) {
                    parent[rootI] = rootJ;
                } else if (rank[rootI] > rank[rootJ]) {
                    parent[rootJ] = rootI;
                } else {
                    parent[rootI] = rootJ;
                    rank[rootJ]++;
                }
                count--; // Reduce the number of independent sets
            }
        }

        public int getCount() {
            return count;
        }
    }

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        UnionFind dsu = new UnionFind(n);

        for (int i = 0; i < n; i++) {
            // Only need to check the upper triangle (j > i) because the matrix is symmetric
            for (int j = 0; j < n; j++) {
                if (i!=j && isConnected[i][j] == 1) {
                    dsu.union(i, j);
                }
            }
        }

        return dsu.getCount();
    }
}
