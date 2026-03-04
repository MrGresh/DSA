class Solution {
    public static int aggressiveCows(int[] position, int cows) {
        int ans = -1;
        Arrays.sort(position);
        int l = 1, r = position[position.length-1]-position[0];
        while(l<=r) {
            int m = l+(r-l)/2;
            if(isPossible(position, cows, m)) {
                ans = m;
                l = m+1;
            } else r = m-1;
        }
        return ans;         
    }
    static boolean isPossible(int[] position, int cows, int gap) {
        int reqPos = position[0];
        for(int x : position) {
            if(x>=reqPos) {
                cows--;
                if(cows==0) return true;
                reqPos = x+gap;
            }
        }
        return false;
    } 
}
