public class codefile{
    static int[] sort(int[]  arr){
        int k = 0;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]==0) {
                int t = arr[k];
                arr[k++] = arr[i];
                arr[i] = t;
            }
        }
        return arr;
    }
}
-----------------------------------------------------------------------
class Solution {
    public int[] sortArrayByParity(int[] nums) {
        int a = 0;
        for(int i=0;i<nums.length;i++) {
            if(nums[i]%2==0) {
                int t = nums[a];
                nums[a] = nums[i];
                nums[i] = t;
                a++;
            }
        }
        return nums;
    }
}
-----------------------------------------------------------------------
class Solution {
    void pushZerosToEnd(int[] arr) {
        int loc = -1;
        for(int i=0;i<arr.length;i++) {
            if(arr[i]>0) {
                ++loc;
                int t = arr[loc];
                arr[loc] = arr[i];
                arr[i] = t;
            }
        }
    }
}
