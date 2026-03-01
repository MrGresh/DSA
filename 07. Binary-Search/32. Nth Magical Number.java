class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        final int MOD = 1000000007;

        if(a==b) return (int)( (((long)a)*n) % MOD );

        long lcm = ((long) a * b) / gcd(a, b);
        
        long low = Math.min(a, b);
        long high = low * n;
        
        while (low < high) {
            long mid = low + (high - low) / 2;
            long magicalNumbersTillMid = mid / a + mid / b - mid / lcm;
            
            if (magicalNumbersTillMid < n) low = mid + 1;
            else if(magicalNumbersTillMid > n) high = mid-1;
            else { // magicalNumbersTillMid == n
                if(mid%a==0 || mid%b==0) return (int)(mid % MOD); // if mid is a magical Number
                else high = mid-1;
            }
        }
        
        return (int) (low % MOD);
    }
    
    private int gcd(int x, int y) {
        return y == 0 ? x : gcd(y, x % y);
    }
}
