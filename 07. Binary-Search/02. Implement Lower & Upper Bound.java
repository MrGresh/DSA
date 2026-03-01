class Solution {
    // lower bound: smallest index in the sorted array where the element is greater than or equal to the given number.
    int lowerBound(int[] arr, int target) {
        int l=0, r=arr.length-1, ans=arr.length;
        while(l<=r) {
            int m = l+(r-l)/2;
            if(arr[m]>=target) {
                ans = m;
                r=m-1;
            } else l=m+1;
        }
        return ans;
    }
    // upper bound : smallest index in the sorted array where the element is greater than the given number.
    int upperBound(int[] arr, int target) {
        int l=0, r=arr.length-1, ans=arr.length;
        while(l<=r) {
            int m = l+(r-l)/2;
            if(arr[m]>target) {
                ans = m;
                r=m-1;
            } else l=m+1;
        }
        return ans;
    }
}
