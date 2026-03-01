class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Map<Double, List<int[]>> m = new HashMap<>();
        PriorityQueue<Double> minHeap = new PriorityQueue<>();
        for(int[] point : points) {
            double distance = point[0]*point[0] + point[1]*point[1]; // without root
            if(!m.containsKey(distance)) {
                List<int[]> values = new ArrayList<>();
                values.add(point);
                m.put(distance, values);
                minHeap.add(distance);
            } else m.get(distance).add(point);
        }
        
        int[][] res = new int[k][2];
        int idx = 0;
        while(idx < k) {
            for(int[] p : m.get(minHeap.poll())) {
                res[idx][0] = p[0];
                res[idx][1] = p[1];
                if(idx == k-1) return res;
                idx++;
            }
        }
        return res;
    }
}
