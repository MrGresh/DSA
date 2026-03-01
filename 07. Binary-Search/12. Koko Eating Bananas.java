class Solution {
    public int kokoEat(int[] arr, int k) {
        int max = arr[0];
        for(int x: arr) {
            if(x>max) max=x;
        }
        int l=1, r=max, ans = Integer.MAX_VALUE;
        while(l<=r) {
            int m = l+(r-l)/2;
            if(isPossible(arr, k, m)) {
                ans = m;
                r = m-1;
            } else l = m+1;
        }
        return ans;
    }
    boolean isPossible(int[] arr, int k, int speed) {
        int time = 0;
        for(int b: arr) {
            time += b%speed==0 ? b/speed : (b/speed)+1;
            if(time>k) return false;
        }
        return time<=k;
    }
}
