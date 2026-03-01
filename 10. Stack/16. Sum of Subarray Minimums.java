class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long sum = 0;
        int MOD = 1_000_000_007;
        
        int[] left = new int[n]; // previous smaller
        int[] right = new int[n]; // next smaller
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n - i : st.peek() - i;
            st.push(i);
        }

        for (int i = 0; i < n; i++) {
            long count = (long) left[i] * right[i];
            sum = (sum + (count * arr[i])) % MOD;
        }

        return (int) sum;
    }
}
--------------------------------------------------------------------------------
For Smaller: 9 [13 11 11 [12] 11 11 11 13] 8
ps = 9 which is 4 steps in left
ns = 8 which is 5 steps in right
No of subarrays with 12 as Minimum = 4*5 = 20
Total Contribution = 12*20 = 240
