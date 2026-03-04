class Solution {
    public List<Integer> spiralOrder(int[][] mat) {
        List<Integer> ls = new ArrayList<>();
        int t = 0, l = 0, b = mat.length-1, r = mat[0].length-1;
        while(t<=b && l<=r) {
            for(int i=l;i<=r;i++) ls.add(mat[t][i]);
            t++;
            for(int i=t;i<=b;i++) ls.add(mat[i][r]);
            r--;
            if(t<=b) {
                for(int i=r;i>=l;i--) ls.add(mat[b][i]);
                b--;
            }
            if(l<=r) {
                for(int i=b;i>=t;i--) ls.add(mat[i][l]);
                l++;
            }
        }
        return ls;
    }
}
