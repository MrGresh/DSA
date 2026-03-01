class Solution {
    public static int minCost(int[] arr) {
        int ans = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int x : arr) pq.add(x);
        while(pq.size()>1) {
            int x = pq.poll()+pq.poll();
            ans += x;
            pq.add(x);
        }
        return ans;
    }
}
