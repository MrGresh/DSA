class Solution {
    public int hIndex(int[] arr) {
        int l = 0, r = arr.length, ans = 0;
        while(l<=r) {
            int m = l+(r-l)/2;
            if(isPossible(arr, m)) {
                ans = m;
                l = m+1;
            } else r = m-1;
        }
        return ans;
    }
    boolean isPossible(int[] arr, int target) {
        int cnt=0;
        for(int x: arr) {
            if(x>=target) cnt++;
            if(cnt==target) return true;
        }
        return false;
    }
}
--------------------------------------------------------------------------
class Solution {
    public int hIndex(int[] arr) {
        Arrays.sort(arr);
        int l = 0, r = arr.length, ans = 0;
        while(l<=r) {
            int m = l+(r-l)/2;
            int cnt = arr.length-lowerBoundIndex(arr, m);
            if(cnt>=m) {
                ans = m;
                l = m+1;
            } else r = m-1;
        }
        return ans;
    }
    int lowerBoundIndex(int[] arr, int target) {
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
}
