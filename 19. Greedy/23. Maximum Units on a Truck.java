class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int ans = 0;
        for(int[] arr : boxTypes) {
            if(arr[0]<=truckSize) {
                ans += arr[0]*arr[1];
                truckSize -= arr[0];
            }
            else {
                ans += truckSize*arr[1];
                return ans;
            }
            if(truckSize==0) return ans;
        }
        return ans;
    }
}
