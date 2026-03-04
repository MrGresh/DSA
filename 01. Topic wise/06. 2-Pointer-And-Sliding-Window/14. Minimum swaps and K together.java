class Solution {
    int minSwap(int[] arr, int k) {
        int n = arr.length;

        // Step 1: Count how many elements are ≤ k
        int count = 0;
        for (int num : arr) {
            if (num <= k) count++;
        }

        // Step 2: Count bad elements in the first window of size 'count'
        int bad = 0;
        for (int i = 0; i < count; i++) {
            if (arr[i] > k) bad++;
        }

        // Step 3: Slide the window and update the minimum bad count
        int minSwaps = bad;
        for (int i = count; i < n; i++) {
            // Remove the element going out of the window
            if (arr[i-count] > k) bad--;
            if (arr[i] > k) bad++;

            minSwaps = Math.min(minSwaps, bad);
        }

        return minSwaps;
    }
}
