class Solution {
    public int[] sumZero(int n) {
        int sum=0, num = 1;
        int[] res = new int[n];
        for(int i=0;i<n-1;i++) {
            res[i] = num;
            sum += num;
            num++;
        }
        res[n-1] = -sum;
        return res;
    }
}
