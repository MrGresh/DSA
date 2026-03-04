class Solution {
    public int xorOperation(int n, int start) {
        int res = 0;
        for(int i=0;i<n;i++) res ^= (start + 2*i);
        return res;
    }
}
-----------------------------------------------------------
class Solution {
    // Helper function to find XOR from 0 to x in O(1)
    private int computeXOR(int x) {
        if (x < 0) return 0;
        int rem = x % 4;
        if (rem == 0) return x;
        if (rem == 1) return 1;
        if (rem == 2) return x + 1;
        return 0; // if rem == 3
    }

    public int xorOperation(int n, int start) {
        // 1. Compute XOR of the shifted consecutive sequence: s to s + n - 1
        int s = start >> 1;
        int e = s + n - 1;
        int resShifted = computeXOR(e) ^ computeXOR(s - 1);

        // 2. Shift the result back to its original position
        int res = resShifted << 1;

        // 3. Determine the LSB (Least Significant Bit)
        // LSB is 1 only if: (start is odd) AND (n is odd)
        if ((start & 1) == 1 && (n & 1) == 1) {
            res = res | 1;
        }

        return res;
    }
}
