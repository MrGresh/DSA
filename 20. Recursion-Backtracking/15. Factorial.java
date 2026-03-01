class Solution {
    int factorial(int n) {
        if(n==0 || n==1) return 1;
        if(n==2) return 2;
        return n*factorial(n-1);
    }
}
