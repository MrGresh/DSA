class Solution {
    public int largestPerimeter(int[] arr) {
       Arrays.sort(arr);
        if(arr.length==3) {
            if(arr[0]+arr[1]>arr[2]) return arr[0]+arr[1]+arr[2];
        }
        else {
            for(int i=arr.length-1;i>=2;i--) {
                if(arr[i-2]+arr[i-1]>arr[i]) return arr[i]+arr[i-1]+arr[i-2];
            }
        }
        return 0; 
    }
}
