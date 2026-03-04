class Solution {
    public int trap(int[] arr) {
        int[] lmh = new int[arr.length];
        int[] rmh = new int[arr.length];
        lmh[0] = arr[0];
        for(int i=1;i<arr.length-1;i++) {
            lmh[i] = Math.max(arr[i], lmh[i-1]);
        }
        rmh[arr.length-1] = arr[arr.length-1];
        for(int i=arr.length-2;i>=1;i--) {
            rmh[i] = Math.max(arr[i], rmh[i+1]);
        }
        int res = 0;
        for(int i=1;i<arr.length-1;i++) {
            res += Math.min(lmh[i], rmh[i]) - arr[i];
        }
        return res;
    }
}
----------------------------------------------------------------
class Solution {
    public int trap(int[] height) {
        int l = 0, r = height.length - 1;
        int leftMax = 0, rightMax = 0;
        int totalWater = 0;

        while (l < r) {
            if (height[l] <= height[r]) {
                if (height[l] >= leftMax) leftMax = height[l];
                else totalWater += leftMax - height[l];
                l++;
            } else {
                if (height[r] >= rightMax) rightMax = height[r];
                else totalWater += rightMax - height[r];
                r--;
            }
        }

        return totalWater;
    }
}
