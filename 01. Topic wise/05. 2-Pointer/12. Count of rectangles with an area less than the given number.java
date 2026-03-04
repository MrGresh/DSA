public long countPairsWithSmallProduct(int[] arr, int n, int k) {
    Arrays.sort(arr);
    
    int left = 0;
    int right = n - 1;
    long count = 0;

    while (left < right) {
        long product = (long) arr[left] * arr[right];
        if (product < k) {
            count += (right - left);
            left++;
        } else right--;
    }
    
    return count;
}
