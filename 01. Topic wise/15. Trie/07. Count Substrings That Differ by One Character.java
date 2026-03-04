// Trie Approach Is Not Good For This
class Solution {
    public int countSubstrings(String s, String t) {
        int m = s.length(), n = t.length();
        int count = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int diff = 0;
                for (int k = 0; i + k < m && j + k < n; k++) {
                    if (s.charAt(i + k) != t.charAt(j + k)) {
                        diff++;
                    }
                    if (diff > 1) break;
                    if (diff == 1) count++;
                }
            }
        }

        return count;
    }
}
