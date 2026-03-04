class Solution {
    public int minTime(int[] arr, int k) {
        int sum = 0, max = arr[0];
        for(int x: arr) {
            sum += x;
            max = Math.max(max, x);
        }
        int l = max, r = sum, ans = sum;
        while(l<=r) {
            int m = l+(r-l)/2;
            if(isPossible(arr, k, m)) {
                ans = m;
                r = m - 1;
            } else l = m + 1;
        }
        return ans;
    }
    boolean isPossible(int[] arr, int k, int time) {
        int currTime = 0;
        for(int x : arr) {
            if(currTime+x<=time) currTime += x;
            else {
                if(x>time) return false;
                currTime = x;
                k--;
                if(k==0) return false;
            }
        }
        return true;
    }
}
