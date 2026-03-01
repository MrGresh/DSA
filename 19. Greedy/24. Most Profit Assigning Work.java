class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int[][] job = new int[difficulty.length][2];
        for(int i=0;i<difficulty.length;i++) {
            job[i][0] = difficulty[i];
            job[i][1] = profit[i];
        }
        Arrays.sort(job, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(worker);
        int ans = 0, j = 0, currMax = 0;
        for(int w : worker) {
            while(j<difficulty.length && w >= job[j][0]) {
                currMax = Math.max(currMax, job[j][1]);
                j++;
            }
            ans += currMax;
        }
        return ans;
    }
}
