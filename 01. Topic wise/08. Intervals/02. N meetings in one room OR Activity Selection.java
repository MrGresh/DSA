class Solution {
    public int maxMeetings(int start[], int end[]) {
        int[][] meetings = new int[start.length][2];
        for(int i=0;i<start.length;i++) {
            int[] meeting = new int[2];
            meeting[0] = start[i];
            meeting[1] = end[i];
            meetings[i] = meeting;
        }
        Arrays.sort(meetings, (a, b) -> a[1]-b[1]);
        int ans = 1;
        int lastEnd = meetings[0][1];
        for(int i=1;i<start.length;i++) {
            if(meetings[i][0] > lastEnd){
                ans+=1;
                lastEnd = meetings[i][1];
            }
        }
        return ans;
    }
}
