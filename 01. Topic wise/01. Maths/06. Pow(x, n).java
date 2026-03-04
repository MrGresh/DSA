class Solution {
    public double myPow(double x, int n) {
        // Use long to prevent overflow when n is Integer.MIN_VALUE
        long N = n;
        
        // Handle negative power: x^(-n) = (1/x)^n
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        return fastPow(x, N);
    }

    private double fastPow(double x, long n) {
        if (n == 0) return 1.0;
        
        double half = fastPow(x, n / 2);
        
        // If n is even: (x^2)^(n/2)
        if (n % 2 == 0) {
            return half * half;
        } 
        // If n is odd: x * (x^2)^((n-1)/2)
        else {
            return half * half * x;
        }
    }
}
