// Note: Array Contains Only 1 and -1 as elements
class Solution {
    public int longestSubarraySumGreaterThenZero(int[] arr, int k) {
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        int prefixSum = 0;
        int maxLen = 0;
        for (int i = 0; i < n; i++) {
            prefixSum += arr[i];
            if (prefixSum > 0) {
                maxLen = i + 1;
            } else if (map.containsKey(prefixSum - 1)) {
                maxLen = Math.max(maxLen, i - map.get(prefixSum - 1));
            }
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }
        return maxLen;        
    }
}
-----------------------------------------------------------------------------------------
// Note: Array Contains -ve, 0 and +ve as elements so above approach will not work
// Monotonic Stack
class Solution {
    public int longestSubarraySumGreaterThenZero(int[] arr) {
        int n = arr.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + arr[i];
        }
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= n; i++) {
            if (stack.isEmpty() || prefixSum[i] < prefixSum[stack.peek()]) {
                stack.push(i);
            }
        }
        int maxLen = 0;
        for (int j = n; j >= 0; j--) {
            while (!stack.isEmpty() && prefixSum[j] > prefixSum[stack.peek()]) {
                maxLen = Math.max(maxLen, j - stack.pop());
            }
        }
        return maxLen;
    }
}
