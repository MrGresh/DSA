class Solution {
    public String smallestGoodBase(String n) {
        long num = Long.parseLong(n);
        long ans = num-1;
        for(int bits=64;bits>=3;bits--) {
            long l = 2, r = num-2; // base range
            while(l<=r) {
                long base = l+(r-l)/2;
                int res = posibility(base, num, bits);
                if(res==0) return String.valueOf(base);
                else if(res>0) r = base-1;
                else l = base+1;
            }
        }
        return String.valueOf(ans);
    }

    int posibility(long base, long num, int bits) {
        long mul = 1;
        long sum = 1;

        for (int i = 2; i <= bits; i++) {
            if (mul > (num - sum) / base) {
                return 1; // overflow
            }
            mul *= base;
            sum += mul;
            if (sum == num) return 0;
            if (sum > num) return 1;
        }
        return -1;
    }
}
