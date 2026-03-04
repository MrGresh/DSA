class Solution {
    private int timer = 1;
    int[] disc;
    int[] low;
    boolean[] visited;
    public ArrayList<Integer> articulationPoints(int n, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        disc = new int[n];
        low = new int[n];
        visited = new boolean[n];
        boolean[] isAP = new boolean[n]; // Use boolean array to avoid duplicates

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, -1, adj, isAP);
            }
        }
        
        // Print all nodes marked as Articulation Points
        for(int i=0; i<n; i++) if(isAP[i]) ans.add(i);
        if(ans.size()==0) ans.add(-1);
        return ans;
    }
    private void dfs(int u, int p, ArrayList<ArrayList<Integer>> adj, boolean[] isAP) {
        visited[u] = true;
        disc[u] = low[u] = timer++;
        int children = 0;

        for (int v : adj.get(u)) {
            if (v == p) continue;

            if (visited[v]) {
                low[u] = Math.min(low[u], disc[v]);
            } else {
                children++;
                dfs(v, u, adj, isAP);
                low[u] = Math.min(low[u], low[v]);

                // Condition 1: Non-root node
                if (p != -1 && low[v] >= disc[u]) isAP[u] = true;
            }
        }

        // Condition 2: Special case for root
        if (p == -1 && children > 1) isAP[u] = true;
    }
}
----------------------------------------------------------------------------------------------------
class Solution {
    private int timer = 1;
    int[] disc;
    int[] low;
    public ArrayList<Integer> articulationPoints(int n, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> ans = new ArrayList<Integer>();
        disc = new int[n];
        low = new int[n];
        boolean[] isAP = new boolean[n]; // Use boolean array to avoid duplicates

        for (int i = 0; i < n; i++) {
            if (disc[i] == 0) {
                dfs(i, -1, adj, isAP);
            }
        }
        
        // Print all nodes marked as Articulation Points
        for(int i=0; i<n; i++) if(isAP[i]) ans.add(i);
        if(ans.size()==0) ans.add(-1);
        return ans;
    }
    private void dfs(int u, int p, ArrayList<ArrayList<Integer>> adj, boolean[] isAP) {
        disc[u] = low[u] = timer++;
        int children = 0;

        for (int v : adj.get(u)) {
            if (v == p) continue;

            if (disc[v] > 0) {
                low[u] = Math.min(low[u], disc[v]);
            } else {
                children++;
                dfs(v, u, adj, isAP);
                low[u] = Math.min(low[u], low[v]);

                // Condition 1: Non-root node
                if (p != -1 && low[v] >= disc[u]) isAP[u] = true;
            }
        }

        // Condition 2: Special case for root
        if (p == -1 && children > 1) isAP[u] = true;
    }
}
