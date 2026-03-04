public void radixSort(int[] arr) {
    int max = Arrays.stream(arr).max().getAsInt();

    // Do counting sort for every digit. 
    // Instead of passing digit number, exp is passed (10^i)
    for (int exp = 1; max / exp > 0; exp *= 10) {
        countSortByDigit(arr, exp);
    }
}

private void countSortByDigit(int[] arr, int exp) {
    int n = arr.length;
    int[] output = new int[n];
    int[] count = new int[10];

    for (int i = 0; i < n; i++) count[(arr[i] / exp) % 10]++;
    for (int i = 1; i < 10; i++) count[i] += count[i - 1];

    for (int i = n - 1; i >= 0; i--) {
        output[count[(arr[i] / exp) % 10] - 1] = arr[i];
        count[(arr[i] / exp) % 10]--;
    }
    System.arraycopy(output, 0, arr, 0, n);
}
