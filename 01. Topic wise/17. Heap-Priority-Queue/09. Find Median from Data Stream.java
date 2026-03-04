class MedianFinder {
    private PriorityQueue<Integer> max;  // Max Heap
    private PriorityQueue<Integer> min; // Min Heap

    public MedianFinder() {
        max = new PriorityQueue<>(Collections.reverseOrder());
        min = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (max.isEmpty() || num <= max.peek()) max.offer(num);
        else min.offer(num);

        // Balance the heaps
        if (max.size() > min.size() + 1) min.offer(max.poll());
        else if (min.size() > max.size()) max.offer(min.poll());
    }

    public double findMedian() {
        if (max.size() == min.size()) return (max.peek() + min.peek()) / 2.0;
        else return max.peek();
    }
}
