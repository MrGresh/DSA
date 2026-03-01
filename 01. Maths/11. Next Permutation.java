class Solution {
    public void nextPermutation(int[] arr) {
        for(int i=arr.length-2;i>=0;i--) {
            if(arr[i]<arr[i+1]) {
                for(int j=arr.length-1;j>=(i+1);j--) {
                    if(arr[j]>arr[i]) {
                        int t = arr[i];
                        arr[i] = arr[j];
                        arr[j] = t;
                        Arrays.sort(arr, (i+1), arr.length);
                        return;
                    }
                }
            }
        }
        Arrays.sort(arr);
    }
}
