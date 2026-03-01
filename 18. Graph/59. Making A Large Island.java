class Solution {
    public int largestIsland(int[][] grid) {
        int n = grid.length;
        DSU dsu = new DSU(n * n);
        boolean hasZero = false;

        // Step 1: Union adjacent 1s
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 1) {
                    int[][] neighbors = {{r+1, c}, {r, c+1}}; // Only need to check forward
                    for (int[] next : neighbors) {
                        int nr = next[0], nc = next[1];
                        if (nr < n && nc < n && grid[nr][nc] == 1) {
                            dsu.union(r * n + c, nr * n + nc);
                        }
                    }
                } else {
                    hasZero = true;
                }
            }
        }

        if (!hasZero) return n * n;

        int maxIsland = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        // Step 2: Try flipping each 0
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    Set<Integer> roots = new HashSet<>();
                    for (int[] d : dirs) {
                        int nr = r + d[0], nc = c + d[1];
                        if (nr >= 0 && nr < n && nc >= 0 && nc < n && grid[nr][nc] == 1) {
                            roots.add(dsu.find(nr * n + nc));
                        }
                    }
                    
                    int currentSize = 1; // The flipped 0 itself
                    for (int root : roots) {
                        currentSize += dsu.size[root];
                    }
                    maxIsland = Math.max(maxIsland, currentSize);
                }
            }
        }

        return maxIsland;
    }
}
___________________________________________________________________________________-
class DSU {
    int[] parent;
    int[] size;
    public DSU(int n) {
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int i) {
        if (parent[i] == i) return i;
        return parent[i] = find(parent[i]);
    }
    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI != rootJ) {
            // Union by size
            if (size[rootI] < size[rootJ]) {
                parent[rootI] = rootJ;
                size[rootJ] += size[rootI];
            } else {
                parent[rootJ] = rootI;
                size[rootI] += size[rootJ];
            }
        }
    }
}
