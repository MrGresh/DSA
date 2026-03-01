class Solution {
    public int sumOfUnique(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int x : arr) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int sum = 0;
        for(int x : arr) {
            if(map.get(x)==1) sum += x;
        }
        return sum;        
    }
}
