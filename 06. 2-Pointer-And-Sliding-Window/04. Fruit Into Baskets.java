class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int start=0, end=0, ans=0;
        while(end<fruits.length) {
            map.put(fruits[end], map.getOrDefault(fruits[end], 0)+1);
            while(map.size()>2) {
                if(map.get(fruits[start])==1) {
                    map.remove(fruits[start]);
                } else {
                    map.put(fruits[start], map.get(fruits[start])-1);
                }
                start++;
            }
            ans = Math.max(ans, end-start+1);
            end++;
        }
        return ans;
    }
}
-------------------------------------------------------------------------------
class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int start=0, end=0, ans=0;
        while(end<fruits.length) {
            map.put(fruits[end], map.getOrDefault(fruits[end], 0)+1);
            if(map.size()>2) {
                if(map.get(fruits[start])==1) {
                    map.remove(fruits[start]);
                } else {
                    map.put(fruits[start], map.get(fruits[start])-1);
                }
                start++;
            }
            if(map.size()<=2) ans = Math.max(ans, end-start+1);
            end++;
        }
        return ans;
    }
}
