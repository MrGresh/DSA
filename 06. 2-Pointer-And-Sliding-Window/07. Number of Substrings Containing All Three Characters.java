class Solution {
    public int numberOfSubstrings(String s) {
        int ans = 0;
        int[] lastIndex = new int[3];
        Arrays.fill(lastIndex, -1);
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            lastIndex[ch-'a'] = i;
            if(lastIndex[0]!=-1 && lastIndex[1]!=-1 && lastIndex[2]!=-1) {
                ans += 1 + Math.min(Math.min(lastIndex[0], lastIndex[1]), lastIndex[2]);
            }
        }
        return ans;
    }
}
