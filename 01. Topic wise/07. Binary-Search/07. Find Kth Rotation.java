class Solution {
    public int findKRotation(int nums[]) {
        int l=0, r=nums.length-1;
        while(l<r) {
            int m = l+(r-l)/2;
            if(nums[m]<=nums[r]) r=m;
            else l=m+1;
        }
        return l; // index of minimum value
    }
}
