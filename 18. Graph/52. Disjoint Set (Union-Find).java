class DisjointSet {
    private int[] parent;
    private int[] rank;
    private int[] size;
    private int count; // number of disjoint sets

    public DisjointSet(int n) {
        parent = new int[n];
        rank = new int[n];
        size = new int[n];
        count = n;

        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 0;
            size[i] = 1;
        }
    }

    // Find with path compression
    public int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    // Simple union (no rank/size optimization)
    public boolean unionSimple(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) return false;

        parent[pu] = pv;
        count--;
        return true;
    }

    // Union by rank
    public boolean unionByRank(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) return false;

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        } else if (rank[pv] < rank[pu]) {
            parent[pv] = pu;
        } else {
            parent[pv] = pu;
            rank[pu]++;
        }
        count--;
        return true;
    }

    // Union by size
    public boolean unionBySize(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv) return false;

        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        count--;
        return true;
    }

    // Get number of disjoint sets
    public int getCount() {
        return count;
    }

    // Get size of set containing element u
    public int getSize(int u) {
        return size[find(u)];
    }
}
