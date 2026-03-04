class Solution {
    public int nthRoot(int n, int x) {
        long l=0L, r = (long)x;
        int ans = -1;
        while(l<=r) {
            long m = l+(r-l)/2;
            long val = (long)Math.pow(m, n);
            if(val==x) return (int)m;
            else if(val<x) l = m+1;
            else r = m-1;
        }
        return ans;
    }
}
