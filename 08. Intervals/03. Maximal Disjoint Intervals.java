class Solution {
    public List<int[]> maxDisjointInterval(int[][] activities) {
        Arrays.sort(activities, (a, b) -> a[1]-b[1]);
        List<int[]> ans = new ArrayList<>();
        ans.add(new int[] {activities[0][0], activities[0][1]});
        int lastEnd = activities[0][1];
        for(int i=1;i<activities.length;i++) {
            if(activities[i][0] > lastEnd){
                ans.add(new int[] {activities[i][0], activities[i][1]});
                lastEnd = activities[i][1];
            }
        }
        return ans;
    }
}
