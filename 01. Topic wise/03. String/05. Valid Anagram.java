class Solution {
    public boolean isAnagram(String s1, String s2) {
        if(s1.length()!=s2.length()) return false;
        int[] afbs = new int[26];
        for(char c : s1.toCharArray()) afbs[c-'a']++;
        for(char c : s2.toCharArray()) afbs[c-'a']--;
        for(int x : afbs) if(x!=0) return false;
        return true;
    }
}
