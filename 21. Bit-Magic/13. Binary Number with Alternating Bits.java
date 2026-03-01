boolean check(int n){
    int f = n&1;
    n>>=1;
    int s = n&1;
    n>>=1;
    boolean t = true;
    while(n>0) {
        int b = n&1;
        if((t && b!=f) || (!t && b!=s)) return false;
        t = !t;
        n>>=1;
    }
    return true;
}
---------------------------------------------------
class Solution {
    public boolean hasAlternatingBits(int n) {
        int xor = n ^ (n >> 1);
        return (xor & (xor + 1)) == 0;
    }
}

/*
n = 5

0101 = n
0010 = n>>1
---
0111 = n ^ (n >> 1) = xor
1000 = xor+1
----
0000 = xor & (xor + 1)
*/
