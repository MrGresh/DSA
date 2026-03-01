class Solution {
    List<List<Integer>> adj;
    public boolean isCyclic(int V, int[][] edges) {
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new LinkedList<>());
        }
        int[] inDeg = new int[V];
        for(int[] e: edges) {
            adj.get(e[0]).add(e[1]);
            inDeg[e[1]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++) {
            if(inDeg[i]==0) q.add(i);
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            res.add(node);
            for(int nei: adj.get(node)) {
                inDeg[nei]--;
            if(inDeg[nei]==0) q.add(nei);
            }
        }
        return res.size()!=V;
    }
}
