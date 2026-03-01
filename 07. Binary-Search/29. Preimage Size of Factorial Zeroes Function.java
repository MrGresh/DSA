class Solution {
    public int preimageSizeFZF(int k) {
        // how many numbers exist which have k trailing zeros in factorials
        long l = 0, r = 5L * k;
        while(l<=r) {
            long m = l + (r-l)/2;
            int tailingZerosInFac = facTrailingZeros(m);
            if(tailingZerosInFac==k) return 5;
            else if(tailingZerosInFac>k) r = m-1;
            else l=m+1;
        }
        return 0;
    }
    public int facTrailingZeros(long n) {
        int res = 0;
        while (n > 0) {
            res += n / 5;
            n /= 5;
        }
        return res;

    } 
}
