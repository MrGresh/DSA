class Solution {
    List<List<Integer>> adj;
    public boolean isCyclic(int V, int[][] edges) {
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new LinkedList<>());
        }
        for(int[] e: edges) adj.get(e[0]).add(e[1]);
        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(i, visited, recStack)) return true;
        }
        return false;
    }
    boolean isCyclicUtil(int i, boolean[] visited, boolean[] recStack) {
        visited[i] = true;
        recStack[i] = true;

        for (Integer neighbor : adj.get(i)) {
            if (recStack[neighbor]) return true;
            if (!visited[neighbor] && isCyclicUtil(neighbor, visited, recStack)) {
                return true;
            }
        }

        recStack[i] = false;
        return false;
    }
}
----------------------------------------------------------------------------------------------------------
class Solution {
    List<List<Integer>> adj;
    public boolean isCyclic(int V, int[][] edges) {
        int[] state = new int[V];
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new LinkedList<>());
        }
        for(int[] e: edges) adj.get(e[0]).add(e[1]);
        for (int i = 0; i < V; i++) {
            if (isCyclicUtil(i, state)) return true; // single visited array
        }
        return false;
    }
    boolean isCyclicUtil(int i, int[] state) {
        // Mark as 'Visiting' (Gray)
        state[i] = 1;

        for (Integer neighbor : adj.get(i)) {
            // Cycle detected: neighbor is currently being visited
            if (state[neighbor] == 1) return true;
            
            // If neighbor is unvisited, recurse
            if (state[neighbor] == 0 && isCyclicUtil(neighbor, state)) {
                return true;
            }
        }

        // Mark as 'Fully Processed' (Black)
        state[i] = 2;
        return false;
    }
}
