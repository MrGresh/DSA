class Solution {
    public int largestSumAfterKNegations(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) minHeap.add(num);

        while (k-- > 0) {
            int smallest = minHeap.poll();
            minHeap.add(-smallest);
        }

        int sum = 0;
        for (int num : minHeap) sum += num;

        return sum;
    }
}
