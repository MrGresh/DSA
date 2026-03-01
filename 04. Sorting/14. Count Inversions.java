class Solution {
    static int inversionCount(int arr[]) {
        return mergeSort(arr, 0, arr.length-1);
    }
    static int mergeSort(int[] arr, int l, int r) {
        if(l==r) return 0;
        int m = l + (r-l)/2;
        int a = mergeSort(arr, l, m);
        int b = mergeSort(arr, m+1, r);
        return a + b + merge(arr, l, m, r);
    }
    static int merge(int[] arr, int l, int m, int r) {
        int res = 0;
        int[] sortedArray = new int[r-l+1];
        int k = 0;
        int i = l, j = m+1;
        for (int left = l; left <= m; left++) {
            int low = m + 1;
            int high = r;
            int idx = -1;

            while (low <= high) {
                int mid = low + (high - low) / 2;
                if (arr[left] > arr[mid]) {
                    idx = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
            if(idx!=-1) res += (idx-m);
        }
        while(i<=m && j<=r) {
            if(arr[i]<=arr[j]) sortedArray[k++] = arr[i++];
            else sortedArray[k++] = arr[j++];
        }
        while(i<=m) sortedArray[k++] = arr[i++];
        while(j<=r) sortedArray[k++] = arr[j++];
        
        for(int a=0;a<sortedArray.length;a++) arr[a+l] = sortedArray[a];
        return res;
    }
}
