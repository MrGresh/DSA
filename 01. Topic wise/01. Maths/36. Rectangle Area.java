class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int ax= ax2-ax1, ay = ay2-ay1, areaA = ax*ay;
        int bx = bx2-bx1, by = by2-by1, areaB = bx*by;

        if(ax2<=bx1 || ax1>=bx2 || ay1>=by2 || ay2<=by1) return areaA + areaB;
        else {
            int x = Math.min(bx2, ax2) - Math.max(bx1, ax1);
            int y = Math.min(by2, ay2) - Math.max(by1, ay1);
            return areaA + areaB - x*y;
        }
    }
}
