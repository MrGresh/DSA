// To return true if the count of divisors is odd, you should check if it's a perfect square:
public boolean isOddDivisors(int n) {
    if (n < 0) return false;
    int root = (int) Math.sqrt(n);
    return (root * root == n);
}
