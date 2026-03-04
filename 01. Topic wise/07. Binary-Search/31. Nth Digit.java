class Bounds {
    long upperBound = -1;
    long lowerBound = -1;
}
class Solution {
    public int findNthDigit(int n) {
        if(n<10) return n;
        long l=10, r = Integer.MAX_VALUE;
        while(l<=r) {
            long m = l+(r-l)/2;
            Bounds bounds = getDigitRange(m);
            if(n>bounds.upperBound) l = m+1;
            else if(n<bounds.lowerBound) r = m-1;
            else {
                int distanceFromBack = (int)bounds.upperBound - n;
                m /= Math.pow(10,distanceFromBack);
                return (int) m%10;
            }
        }
        return -1; // never execute
    }
    Bounds getDigitRange(long n) {
        long totalDigits = 0, t =n;
        while(t>0) {
            totalDigits++;
            t /= 10;
        }
        long num = 10, lBound = 10, digits=2;
        while(digits<totalDigits) {
            lBound += (9*num*digits);
            num *= 10;
            digits++;
        }
        Bounds bounds = new Bounds();
        bounds.lowerBound = lBound + (totalDigits*(n-num));
        bounds.upperBound = bounds.lowerBound + (totalDigits-1);
        return bounds;
    }
}
