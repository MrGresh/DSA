class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n]; 
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            // If the node DOES NOT lead to a cycle, it is safe
            if (!hasCycle(i, graph, state)) {
                result.add(i);
            }
        }
        return result;
    }

    private boolean hasCycle(int node, int[][] graph, int[] state) {
        state[node] = 1; // Mark as 'Visiting'
        for (int neighbor : graph[node]) {
            if(state[neighbor]==1) return true;
            if (state[neighbor]==0 && hasCycle(neighbor, graph, state)) {
                return true; 
            }
        }
        state[node] = 2; // Mark as 'Processed/Safe'
        return false;
    }
}
----------------------------------------------------------------------------------------------
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> reverseGraph = new ArrayList<>();
        int[] newInDegree = new int[n];
        for (int i = 0; i < n; i++) reverseGraph.add(new ArrayList<>());
        for (int u = 0; u < n; u++) {
            for (int v : graph[u]) {
                reverseGraph.get(v).add(u);
                newInDegree[u]++; // newInDegree of u is outdegree of u before reverse
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (newInDegree[i] == 0) queue.offer(i);
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);
            for (int neighbor : reverseGraph.get(node)) {
                newInDegree[neighbor]--;
                if (newInDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }
        Collections.sort(result);
        return result;
    }
}
