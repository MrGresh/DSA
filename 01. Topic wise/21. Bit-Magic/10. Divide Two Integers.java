class Solution {
    public int divide(int n, int div) {
        if(n==Integer.MIN_VALUE && div == -1) return Integer.MAX_VALUE;
        boolean isNeg = (n<0) ^ (div<0);

        Long N = Math.abs((long) n);
        Long Div = Math.abs((long) div);

        int ans = 0;
        while(N>=Div) {
            Long tempDiv = Div;
            while((tempDiv<<1) <= N) tempDiv <<= 1;
            N -= tempDiv;
            ans += (tempDiv/Div);
        }
        return isNeg ? -ans : ans;
    }
}
------------------------------
N = 22, Div = 3
22-12, 12/3 = 4
10-6, 6/3 = 2
4-3, 3/3 = 1
1, 3 No
Answer = 4+2+1 = 7
