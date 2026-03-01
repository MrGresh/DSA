class Solution {
    public int assignHole(int[] M, int[] H) {
        Arrays.sort(M);
        Arrays.sort(H);
        int ans = Integer.MIN_VALUE;
        for(int i=0;i<M.length;i++) {
            ans = Math.max(ans, Math.abs(M[i]-H[i]));
        }
        return ans;
    }
};
