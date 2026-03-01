class Solution {
    public int[][] merge(int[][] arr) {
        Arrays.sort(arr, (a, b) -> Integer.compare(a[1], b[1]));
        ArrayList<int[]> res = new ArrayList<>();
        res.add(arr[0]);
        for(int i=1;i<arr.length;i++) {
            int[] e = arr[i];
            int[] last = res.get(res.size()-1);
            if(e[0]<=last[1]) {
                res.remove(res.size()-1);
                last[1] = e[1];
                last[0] = Math.min(last[0], e[0]);
                while(res.size()>0 && last[0]<=res.get(res.size()-1)[1]) {
                    last[0] = Math.min(last[0], res.get(res.size()-1)[0]);
                    res.remove(res.size()-1);
                }
                res.add(last);
            } else res.add(e);
        }
        int[][] ans = new int[res.size()][2];
        int idx = -1;
        for(int[] t: res) ans[++idx] = t;
        return ans;
    }
}
