class Solution {
    public int findKthPositive(int[] arr, int k) {
        int l=0, r=arr.length-1, idx=-1;
        while(l<=r) {
            int m = l+(r-l)/2;
            int missings = arr[m] - m - 1;
            if(missings<k) {
                idx = m;
                l=m+1;
            }
            else r=m-1;
        }
        return idx + 1 + k;
    }
}
/*
missing = arr[idx] - idx - 1
more = k - missing
arr[idx] + more = idx + 1 + k
*/
