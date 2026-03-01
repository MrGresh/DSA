class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int ans = Integer.MIN_VALUE, curr = 0;
        for(int i=0;i<k;i++) curr += cardPoints[i];
        ans = curr;
        int left = k-1, right = cardPoints.length-1;
        while(left>=0) {
            curr -= cardPoints[left--];
            curr += cardPoints[right--];
            ans = Math.max(ans, curr);
        }
        return ans;
    }
}
