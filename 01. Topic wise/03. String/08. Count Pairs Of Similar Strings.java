class Solution {
    public int similarPairs(String[] s) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : s) {
            Set<Character> charSet = new HashSet<>();
            for (char c : word.toCharArray()) charSet.add(c);
            
            String key = charSet.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        
        int res = 0;
        for (int frequency : map.values()) {
            if (frequency > 1) {
                res += (frequency * (frequency - 1)) / 2; // Combination of pairs
            }
        }
        
        return res;
    }
}
