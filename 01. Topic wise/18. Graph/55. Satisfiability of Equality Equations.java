class Solution {
    public boolean equationsPossible(String[] equations) {
        UnionFind uf = new UnionFind(26); // 26 lowercase letters
        // First pass: process all "==" equations
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int a = eq.charAt(0) - 'a';
                int b = eq.charAt(3) - 'a';
                uf.union(a, b);
            }
        }
        // Second pass: check all "!=" equations
        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int a = eq.charAt(0) - 'a';
                int b = eq.charAt(3) - 'a';
                if (uf.find(a) == uf.find(b)) return false;
            }
        }
        return true;
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
        if (px != py) parent[px] = py;
    }
}
