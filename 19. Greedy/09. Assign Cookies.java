class Solution {
    public int findContentChildren(int[] g, int[] s) {
        if(s.length==0) return 0;
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        for(int c: s) {
            if(c>=g[i]) {
                i++;
                if(i==g.length) break;
            }
        }
        return i;
    }
}
