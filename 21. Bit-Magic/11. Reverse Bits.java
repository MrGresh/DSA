public class Solution {
    public int reverseBits(int n) {
        int ans = 0;
        for(int i=0;i<=31;i++) {
            int bit = (n>>i)&1;
            if(bit==1) {
                int mask = 1<<(31-i);
                ans |= mask;
            }
        }
        return ans;
    }
}
