class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        curr.add(String.valueOf(s.charAt(0)));
        palindromePartitioning(s, curr, 1);
        return res;
    }
    void palindromePartitioning(String s, List<String> curr, int idx) { // inefficient : generating all possible paritions and then checking for solution
        if(idx==s.length()) {
            for(String str : curr) {
                if(!isPalindrome(str)) return;
            }
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(String.valueOf(s.charAt(idx)));
        palindromePartitioning(s, curr, idx+1);
        curr.removeLast();
        String lastString = curr.remove(curr.size() - 1);
        curr.add(lastString+String.valueOf(s.charAt(idx)));
        palindromePartitioning(s, curr, idx+1);
    }
}
----------------------------------------------------------------------------------------------
// Efficient
class Solution {
    List<List<String>> res;
    public List<List<String>> partition(String s) {
        res = new ArrayList<>();
        List<String> curr = new ArrayList<>();
        for(int i=0;i<s.length();i++) {
            String str = s.substring(0, i + 1);
            if(isPalindrome(str)) {
                curr.add(str);
                palindromePartitioning(s, curr, i+1);
                curr.removeLast();
            }
        }
        return res;
    }
    void palindromePartitioning(String s, List<String> curr, int idx) { //  efficient : direclty generating palindrome partitons
        if(idx==s.length()) {
            res.add(new ArrayList<>(curr));
            return;
        }
        for(int i=idx;i<s.length();i++) {
            String str = s.substring(idx, i + 1);
            if(isPalindrome(str)) {
                curr.add(str);
                palindromePartitioning(s, curr, i+1);
                curr.removeLast();
            }
        }
    }
}
