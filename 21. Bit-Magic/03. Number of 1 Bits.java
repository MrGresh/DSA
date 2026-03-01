class Solution {
    public int countSetBits(int n) {
        int ans = 0;
        while(n>0) {
            if((n&1)==1) ans++;
            n>>=1;
        }
        return ans;
    }
}
-----------------------------------------------
class Solution {
    public int countSetBits(int n) {
        int ans = 0;
        while(n>0) {
            ans++;
            n = n & (n-1); // Turn Off Rightmost set bit
        }
        return ans;
    }
}
