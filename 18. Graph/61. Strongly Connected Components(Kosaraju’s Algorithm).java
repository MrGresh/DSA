class Solution {
    public int kosaraju(ArrayList<ArrayList<Integer>> adj) {
        int V = adj.size();
        boolean[] visited = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        // Step 1: DFS to get nodes in order of finishing time
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs1(i, adj, visited, stack);
            }
        }

        // Step 2: Reverse the graph (Transpose)
        ArrayList<ArrayList<Integer>> adjRev = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adjRev.add(new ArrayList<>());
        }
        for (int i = 0; i < V; i++) {
            for (int neighbor : adj.get(i)) {
                adjRev.get(neighbor).add(i);
            }
        }

        // Step 3: DFS on reversed graph in order of stack
        int sccCount = 0;
        List<List<Integer>> sccList = new ArrayList<>();
        Arrays.fill(visited, false); // Reset visited array
        
        while (!stack.isEmpty()) {
            int node = stack.pop();
            if (!visited[node]) {
                sccCount++;
                List<Integer> component = new ArrayList<>();
                dfs2(node, adjRev, visited, component);
                sccList.add(component);
            }
        }

        return sccCount; // sccCount is equal to sccList.size()
    }

    private void dfs1(int curr, ArrayList<ArrayList<Integer>> adj, boolean[] visited, Stack<Integer> stack) {
        visited[curr] = true;
        for (int neighbor : adj.get(curr)) {
            if (!visited[neighbor]) {
                dfs1(neighbor, adj, visited, stack);
            }
        }
        stack.push(curr); // Push to stack after visiting all neighbors
    }

    private void dfs2(int curr, ArrayList<ArrayList<Integer>> adjRev, boolean[] visited, List<Integer> component) {
        visited[curr] = true;
        component.add(curr);
        for (int neighbor : adjRev.get(curr)) {
            if (!visited[neighbor]) {
                dfs2(neighbor, adjRev, visited);
            }
        }
    }
}
