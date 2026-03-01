class Solution {
    static boolean armstrongNumber(int n) {
        int original = n;
        int sum = 0;
        int digits = String.valueOf(n).length();
        
        int temp = n;
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, digits);
            temp /= 10;
        }
        
        return sum == original;
    }
}
