class Solution {
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        DisjointSet ds = new DisjointSet(m * n);
        boolean[] land = new boolean[m * n];
        List<Integer> result = new ArrayList<>();
        int count = 0;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};

        for (int[] pos : positions) {
            int r = pos[0], c = pos[1];
            int idx = r * n + c;

            if (land[idx]) { // already land
                result.add(count);
                continue;
            }

            land[idx] = true;
            count++;

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nc < 0 || nr >= m || nc >= n) continue;
                int nIdx = nr * n + nc;
                if (land[nIdx] && ds.unionBySize(idx, nIdx)) count--;
            }
            result.add(count);
        }
        return result;
    }
}
___________________________________________________________________________________
class DisjointSet {
    private int[] parent, size;
    public DisjointSet(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public boolean unionBySize(int u, int v) {
        int pu = find(u), pv = find(v);
        if (pu == pv) return false;
        if (size[pu] < size[pv]) {
            parent[pu] = pv;
            size[pv] += size[pu];
        } else {
            parent[pv] = pu;
            size[pu] += size[pv];
        }
        return true;
    }
}
