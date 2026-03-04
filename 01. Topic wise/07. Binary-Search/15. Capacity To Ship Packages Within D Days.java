class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int ans = 0;
        int max = Integer.MIN_VALUE, sum = 0;
        for(int x : weights) {
            if(x>max) max = x;
            sum += x;
        }
        int l = max, r = sum;
        while(l<=r) {
            int m = l+(r-l)/2;
            if(isPossible(m, weights, days)) {
                ans = m;
                r = m-1;
            } else l = m+1;
        }
        return ans;
    }
    
    boolean isPossible(int shipWeight, int[] weights, int days) {
        int sum = 0;
        for(int x : weights) {
            if((sum+x)<=shipWeight) sum+=x;
            else {
                sum = x;
                days--;
                if(days==0) return false;
            }
        }
        return true;
    }
}
