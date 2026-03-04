class Solution {
    public String smallestSubsequence(String s) {
        int[] freq = new int[26];
        boolean[] vis = new boolean[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;
        StringBuilder sb = new StringBuilder(); // Monotonic Stack
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            freq[idx]--;

            if (vis[idx]) continue;

            while (sb.length() > 0 && c < sb.charAt(sb.length() - 1) && freq[sb.charAt(sb.length() - 1) - 'a'] > 0) {
                vis[sb.charAt(sb.length() - 1) - 'a'] = false;
                sb.deleteCharAt(sb.length() - 1);
            }

            sb.append(c);
            vis[idx] = true;
        }
        return sb.toString();
    }
}
