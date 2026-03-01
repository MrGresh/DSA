class Solution {
    public int[] searchRange(int[] arr, int target) {
        int[] res = new int[2];
        res[0] = -1; res[1] = -1;
        
        int l = 0, r = arr.length-1;
        while(l<=r) {
            int m = l + (r-l)/2;
            if(arr[m]>target) r = m-1;
            else if(arr[m]<target) l = m+1;
            else {
                res[0] = m;
                r = m-1;
            }
        }
        l = 0; r = arr.length-1;
        while(l<=r) {
            int m = l + (r-l)/2;
            if(arr[m]>target) r = m-1;
            else if(arr[m]<target) l = m+1;
            else {
                res[1] = m;
                l = m+1;
            }
        }
        return res;
    }
}
