class Solution {
    public boolean isPalindrome(String s) {
        int l = 0, r = s.length()-1;
        while(l<=r) {
            while(l<r && !((s.charAt(l)>='a' && s.charAt(l)<='z') || (s.charAt(l)>='A' && s.charAt(l)<='Z') || (s.charAt(l)>='0' && s.charAt(l)<='9'))) l++;
            while(l<r && !((s.charAt(r)>='a' && s.charAt(r)<='z') || (s.charAt(r)>='A' && s.charAt(r)<='Z') || (s.charAt(r)>='0' && s.charAt(r)<='9'))) r--;
            char c1 = (s.charAt(l)>='A' && s.charAt(l)<='Z') ? (char)(s.charAt(l)+32) : s.charAt(l);
            char c2 = (s.charAt(r)>='A' && s.charAt(r)<='Z') ? (char)(s.charAt(r)+32) : s.charAt(r);
            if(c1!=c2) return false;
            l++;r--;
        }
        return true;
    }
}
