class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] nextSmallerIndexes = new int[n];
        int[] previousSmallerIndexes = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) stack.pop();
            previousSmallerIndexes[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) stack.pop();
            nextSmallerIndexes[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int maxArea = 0;
        for (int i = 0; i < n; i++) {
            int width = nextSmallerIndexes[i] - previousSmallerIndexes[i] - 1;
            maxArea = Math.max(maxArea, heights[i] * width);
        }

        return maxArea;
    }
}
----------------------------------------------------------------------------------------------------
class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack<>(); // increasing order
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            int currentHeight = heights[i];

            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int nse = i;
                int pse = stack.isEmpty() ? -1 :stack.peek();
                maxArea = Math.max(maxArea, h * (nse-pse-1));
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            int h = heights[stack.pop()];
            int nse = n;
            int pse = stack.isEmpty() ? -1 : stack.peek();
            maxArea = Math.max(maxArea, h * (nse-pse-1));
        }
        return maxArea;
    }
}
