class Solution {
    public int longestValidParentheses(String s) {
        int left = 0, right = 0, maxLen = 0;
        
        // Left to right pass
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') left++;
            else right++;
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * right);
            } else if (right > left) {
                left = right = 0;
            }
        }

        // Right to left pass
        left = right = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') left++;
            else right++;
            if (left == right) {
                maxLen = Math.max(maxLen, 2 * left);
            } else if (left > right) {
                left = right = 0;
            }
        }

        return maxLen;
    }
}
---------------------------------------------------------------------------------
class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int ans = 0;
        for(int i=0;i<s.length();i++) {
            if(s.charAt(i)=='(') st.push(i);
            else {
                st.pop();
                if(st.isEmpty()) st.push(i);
                ans = Math.max(ans, i-st.peek());
            }
        }
        return ans;
    }
}
