class Solution {
    public int subtractProductAndSum(int n) {
        int sum = 0, mul = 1;
        while(n>0) {
            int d = n%10;
            sum += d;
            mul *= d;
            n /= 10;
        }
        return (mul-sum);
    }
}
