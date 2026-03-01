class Solution {
    public int removeStones(int[][] stones) {
        int OFFSET = 10001; // To separate row and column indices
        UnionFind uf = new UnionFind(2 * OFFSET);
        for (int[] stone : stones) {
            int row = stone[0];
            int col = stone[1] + OFFSET;
            uf.union(row, col);
        }
        Set<Integer> uniqueRoots = new HashSet<>();
        for (int[] stone : stones) {
            int root = uf.find(stone[0]); // OR uf.find(stone[1] + OFFSET)
            uniqueRoots.add(root);
        }
        return stones.length - uniqueRoots.size();
    }
}
class UnionFind {
    int[] parent;
    public UnionFind(int size) {
        parent = new int[size];
        for (int i = 0; i < size; i++) parent[i] = i;
    }
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]); // Path compression
        return parent[x];
    }
    public void union(int x, int y) {
        int px = find(x);
        int py = find(y);
        if (px != py) parent[py] = px;
    }
}
