class Solution {
    public int countNegatives(int[][] a) {
        int res = 0;
        int i=0;
        for(int j=a[0].length-1;j>=0;j--) {
            while(i<a.length) {
                if(a[i][j]<0) {
                    res += (a.length-i);
                    break;
                }
                else i++;
            }
        }
        return res;
    }
}
