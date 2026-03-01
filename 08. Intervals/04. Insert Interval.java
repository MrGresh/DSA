class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int j=0, i=0;
        while(i<intervals.length) {
            if(intervals[i][1]<newInterval[0]) {
                res.add(intervals[i]);
                i++;
            } else break;
        }
        if(i==intervals.length) res.add(newInterval);
        else {
            int startTime = Math.min(intervals[i][0], newInterval[0]);
            int endTime = newInterval[1];
            while(i<intervals.length) {
                if(newInterval[1]>=intervals[i][1]) i++;
                else {
                    if(intervals[i][0]<=newInterval[1]) {
                        endTime = intervals[i][1];
                        i++;
                    }
                    break;
                }
            }
            res.add(new int[] {startTime, endTime});
        }
        while(i<intervals.length) {
            res.add(intervals[i]);
            i++;
        }
        int[][] ans = new int[res.size()][2];
        int idx = -1;
        for(int[] intr: res) ans[++idx] = intr;
        return ans;
    }
}
