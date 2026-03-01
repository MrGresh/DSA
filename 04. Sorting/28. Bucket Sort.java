public void bucketSort(float[] arr) {
    int n = arr.length;
    if (n <= 0) return;

    // 1. Create n empty buckets
    List<Float>[] buckets = new ArrayList[n];
    for (int i = 0; i < n; i++) buckets[i] = new ArrayList<>();

    // 2. Put array elements in different buckets
    for (int i = 0; i < n; i++) {
        int bucketIndex = (int) (arr[i] * n); // Index calculation
        buckets[bucketIndex].add(arr[i]);
    }

    // 3. Sort individual buckets and concatenate
    int index = 0;
    for (int i = 0; i < n; i++) {
        Collections.sort(buckets[i]); // Usually Insertion Sort
        for (float val : buckets[i]) {
            arr[index++] = val;
        }
    }
}
