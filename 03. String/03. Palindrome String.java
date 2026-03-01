class Solution {
    boolean isPalindrome(String s) {
        return isPal(s, 0, s.length()-1);
    }
    boolean isPal(String s, int l, int r) {
        if(l>=r) return true;
        return (s.charAt(l)==s.charAt(r)) && isPal(s, l+1, r-1);
    }
};
-----------------------------
class Solution {
    boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}
