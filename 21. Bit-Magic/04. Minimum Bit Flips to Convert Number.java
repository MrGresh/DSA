class Solution {
    public int minBitFlips(int start, int goal) {
		int diff = start^goal;
        int res = 0;
        while(diff>0) {
            if((diff&1)==1) res++;
            diff >>= 1;
        }
        return res;       
    }
}
-----------------------------------------------------------
class Solution {
    public int minBitFlips(int start, int goal) {
		int diff = start^goal;
        int res = 0;
        while(diff>0) {
            res++;
            diff = diff & (diff-1); // Turn Rightmost set bit off
        }
        return res;       
    }
}
