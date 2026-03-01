class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length-1;
        int[] res = new int[nums.length];
        int index = res.length-1;
        while(l<=r) {
            if(nums[l]*nums[l]>nums[r]*nums[r]) {
                res[index--] = nums[l]*nums[l++];
            }
            else res[index--] = nums[r]*nums[r--];
        }
        return res;
    }
}
