class Solution {
    public int[] evenOddBit(int n) {
        int[] res = new int[2];
        for(int i=1;i<=32;i++) {
            if((n&1)==1) {
                if(i%2==0) res[1]++;
                else res[0]++;
            }
            n>>=1;
            if(n==0) break;
        }
        return res;   
    }
}
------------------------------------------------------------
class Solution {
    public int[] evenOddBit(int n) {
        // 0x55555555 is binary ...01010101 (even indices: 0, 2, 4...)
        // 0xAAAAAAAA is binary ...10101010 (odd indices: 1, 3, 5...)
        
        int evenCount = Integer.bitCount(n & 0x55555555);
        int oddCount = Integer.bitCount(n & 0xAAAAAAAA);
        
        return new int[]{evenCount, oddCount};
    }
}
