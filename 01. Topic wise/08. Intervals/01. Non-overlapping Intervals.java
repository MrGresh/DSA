class Solution {
    public int eraseOverlapIntervals(int[][] activities) {
        Arrays.sort(activities, (a, b) -> a[1]-b[1]);
        int ans = 0;
        int lastEnd = activities[0][1];
        for(int i=1;i<activities.length;i++) {
            if(activities[i][0] >= lastEnd){
                lastEnd = activities[i][1];
            } else ans += 1;
        }
        return ans;
    }
}
