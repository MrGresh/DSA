class Solution {
    public int kthFactor(int n, int k) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) {
                count++;
                if (count == k) return i;
            }
        }
        return -1;
    }
}
-----------------------------------------------------------------------
class Solution {
    public int kthFactor(int n, int k) {
        double root = Math.sqrt(n);
        
        // First pass: find small factors
        for (int i = 1; i < root; i++) {
            if (n % i == 0) {
                if (--k == 0) return i;
            }
        }
        
        // Second pass: find large factors in reverse order
        for (int i = (int)root; i >= 1; i--) {
            if (n % i == 0) {
                if (--k == 0) return n / i;
            }
        }
        
        return -1;
    }
}
