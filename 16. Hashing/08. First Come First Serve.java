class Solution {
    static int firstElement(int arr[], int k) {
        Map<Integer, Integer> m = new HashMap<>();
        for(int x : arr) {
            m.put(x, m.getOrDefault(x, 0)+1);
        }
        for(int x : arr) {
            if(m.get(x)==k) return x;
        }
        return -1;
    }
}
