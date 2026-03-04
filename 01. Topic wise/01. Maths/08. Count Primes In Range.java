class Solution {
    int countPrimes(int L, int R) {
        int[] isPrime = new int[R+1];
        Arrays.fill(isPrime, 1);
        if (R >= 0) isPrime[0] = 0;
        if (R >= 1) isPrime[1] = 0;

        for (int i = 2; i * i <= R; i++) {
            if (isPrime[i]==1) {
                for (int j = i * i; j <= R; j += i) isPrime[j] = 0;
            }
        }
        
        for(int i=1;i<=R;i++) isPrime[i] += isPrime[i-1];
        
        return (L == 0) ? isPrime[R] : isPrime[R] - isPrime[L - 1];
    }
};
