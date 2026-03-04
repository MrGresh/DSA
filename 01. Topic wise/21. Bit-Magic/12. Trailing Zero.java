public class codefile{
    int solve(int n){
		if(n<0) n = -n;
        int res = 0;
        while((n&1)==0) {
            res+=1;
            n >>= 1;
        }
        return res;
    }
}
----------------------------
int solve(int n) {
    if (n == 0) return 32;
    if (n < 0) n = -n;     // Same as (~n + 1)
    
    // Step 1: Create the mask (e.g., 1100 ^ 1011 = 0111)
    int mask = n ^ (n - 1);
    
    return Integer.bitCount(mask) - 1;
}
