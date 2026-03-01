// Course Schedule
class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDeg = new int[n];
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] t : prerequisites) {
            graph.get(t[1]).add(t[0]);
            inDeg[t[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) queue.offer(i);
        }
        
        int cnt = 0;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            cnt++;
            for (int nei : graph.get(curr)) {
                inDeg[nei]--;
                if (inDeg[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }
        
        return cnt == n;
    }
}
-----------------------------------------------------------------------
// Course Schedule II
class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] inDeg = new int[n];
        
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] t : prerequisites) {
            graph.get(t[1]).add(t[0]);
            inDeg[t[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDeg[i] == 0) queue.offer(i);
        }
        
        int[] ans = new int[n];
        int idx = -1;
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            ans[++idx] = curr;
            for (int nei : graph.get(curr)) {
                inDeg[nei]--;
                if (inDeg[nei] == 0) {
                    queue.offer(nei);
                }
            }
        }
        
        return idx==n-1 ? ans : new int[0];
    }
}
