class Solution {
    public int[] leastPrimeFactor(int n) {
        int[] spf = new int[n + 1];
        
        // 1. Every number's LPF is initially itself (case for primes)
        for (int i = 1; i <= n; i++) {
            spf[i] = i;
        }
        
        // 2. Sieve logic
        // We start from 2 and go up to n
        for (int i = 2; i * i <= n; i++) {
            // If i is prime, it can be the LPF for its multiples
            if (spf[i] == i) {
                for (int j = i * i; j <= n; j += i) {
                    // Update only if it hasn't been updated by a smaller prime
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }
        
        return spf;
    }
}
