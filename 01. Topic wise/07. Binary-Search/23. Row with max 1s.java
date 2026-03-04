class Solution {
    public int rowWithMax1s(int arr[][]) {
        int j=arr[0].length-1, i=0, ans=-1;
        while(i<arr.length && j>=0) {
            if(arr[i][j]==1) {
                j--;
                ans=i;
            }
            else i++;
        }
        return ans;
    }
}
