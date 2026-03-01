class Solution {
    public int subarrayRanges(int[] arr) {
        int n = arr.length;
        return sumSubarrayMax(arr, n) - sumSubarrayMin(arr, n);
    }

    private int sumSubarrayMin(int[] arr, int n) {
        long sum = 0;
        int[] left = new int[n]; // previous smaller
        int[] right = new int[n]; // next smaller
        Deque<Integer> st = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) st.pop();
            left[i] = st.isEmpty() ? i + 1 : i - st.peek();
            st.push(i);
        }

        st.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] > arr[i]) st.pop();
            right[i] = st.isEmpty() ? n - i : st.peek() - i;
            st.push(i);
        }
        
        for (int i = 0; i < n; i++) {
            sum += (long) arr[i] * left[i] * right[i];
        }
        
        return (int)sum;
    }

    private int sumSubarrayMax(int[] arr, int n) {
        long sum = 0;
        int[] left = new int[n]; // previous greater
        int[] right = new int[n]; // next greater
        Deque<Integer> s = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!s.isEmpty() && arr[s.peek()] <= arr[i]) s.pop();
            left[i] = s.isEmpty() ? i + 1 : i - s.peek();
            s.push(i);
        }

        s.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!s.isEmpty() && arr[s.peek()] < arr[i]) s.pop();
            right[i] = s.isEmpty() ? n - i : s.peek() - i;
            s.push(i);
        }

        for (int i = 0; i < n; i++) {
            sum += (long) arr[i] * left[i] * right[i];
        }
        
        return (int)sum;
    }
}
--------------------------------------------------------------------------------------
For Smaller: 9 [13 11 11 [12] 11 11 11 13] 8
ps = 9 which is 4 steps in left
ns = 8 which is 5 steps in right
No of subarrays with 12 as Minimum = 4*5 = 20
Total Contribution = 12*20 = 240

For Larget: 9 13 [11 11 [12] 11 11 11] 13 8
pg = 13 which is 3 steps in left
ng = 13 which is 4 steps in right
No of subarrays with 12 as Maximum = 4*3 = 12
Total Contribution = 12*12 = 144

Total Contribution of 12 is : 144 - 240 = -96
