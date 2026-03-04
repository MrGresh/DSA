class Solution {
    public int pivotInteger(int n) {
      if(n==1) return 1;
      int l = 1, r = n;
      while(l<=r) {
        int m = l + (r-l)/2;
        int leftSum = (m*(m+1))/2;
        int rightSum = m + (n*(n+1))/2 - leftSum;
        if(leftSum==rightSum) return m;
        if(leftSum<rightSum) l = m+1;
        else r = m-1;
      }
      return -1;
  }
}
--------------------------------------------
class Solution {
    public int pivotInteger(int n) {
        double x = Math.sqrt(n * (n + 1) / 2.0);
        if (x % 1 != 0) {
            return -1;
        } else {
            return (int) x;
        }
    }
}
