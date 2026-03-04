// For Directed Acyclic Graph (DAG): Graph shouldn't conatins any cycle
class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        boolean[] vis = new boolean[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++) {
            if(!vis[i]) dfs(i, adj, vis, st);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!st.isEmpty()) res.add(st.pop());
        return res;
    }
    static void dfs(int i, List<List<Integer>> adj, boolean[] vis, Stack<Integer> st) {
        vis[i] = true;
        for(int x : adj.get(i)) {
            if(!vis[x]) dfs(x, adj, vis, st);
        }
        st.push(i);
    }
}
-------------------------------------------------------------------------------------------------------
// Safe DFS with cycle detection
class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<V;i++) adj.add(new ArrayList<>());
        for(int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }
        int[] state = new int[V];
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<V;i++) {
            if(state[i]==0 && dfs(i, adj, state, st)) return new ArrayList<>();;
        }
        ArrayList<Integer> res = new ArrayList<>();
        while(!st.isEmpty()) res.add(st.pop());
        return res;
    }
    static boolean dfs(int i, List<List<Integer>> adj, int[] state, Stack<Integer> st) {
        state[i] = 1;
        for(int x : adj.get(i)) {
            if(state[x]==1) return true;
            if(state[x]==0 && dfs(x, adj, state, st)) return true;
        }
        state[i] = 2;
        st.push(i);
        return false;
    }
}
