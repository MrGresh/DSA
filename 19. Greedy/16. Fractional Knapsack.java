class Solution {
    public double fractionalKnapsack(int[] val, int[] wt, int capacity) {
        int[][] item = new int[val.length][2];
        for(int i=0;i<val.length;i++) {
            item[i][0] = val[i];
            item[i][1] = wt[i];
        }
        Arrays.sort(item, (a, b) -> Double.compare((double)b[0]/b[1], (double)a[0]/a[1]));
        double ans = 0;
        for(int[] v: item) {
            if(v[1]<=capacity) {
                ans += v[0];
                capacity -= v[1];
                if(capacity==0) break;
            } else {
                ans += v[0]*((double)capacity/v[1]);
                break;
            }
        }
        return ans;
    }
}
