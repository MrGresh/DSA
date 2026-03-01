class Solution {
    static int solve(int bt[]) {
        Arrays.sort(bt);
        int wt = 0, t = 0;
        for(int p: bt) {
            wt += t;
            t += p;
        }
        return wt/bt.length;
    }
}
