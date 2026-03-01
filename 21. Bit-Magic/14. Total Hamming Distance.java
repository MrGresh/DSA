class Solution {
    public int totalHammingDistance(int[] nums) {
        int ans = 0;
        for(int i=0;i<=31;i++) {
            int ones = 0;
            for(int ele : nums) {
                if(((ele>>i)&1)==1) ones++;
            }
            int zeros = nums.length - ones;
            ans += (zeros*ones);
        }
        return ans;
    }
}
