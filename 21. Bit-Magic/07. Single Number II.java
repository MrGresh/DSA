class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i=0;i<=31;i++) {
            int count = 0;
            for(int ele : nums) {
                if(((ele>>i)&1)==1) count++;
            }
            if(count%3!=0) {
                int mask = 1<<i;
                ans |= mask;
            }
        }
        return ans;
    }
}
