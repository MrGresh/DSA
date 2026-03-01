class Solution {
    public int numIdenticalPairs(int[] arr) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : arr) {
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        for(int x : map.values()) {
            res += (x*(x-1))/2;
        }
        return res;        
    }
}
