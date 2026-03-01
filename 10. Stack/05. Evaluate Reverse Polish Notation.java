class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        for(String token : tokens) {
            if(token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int a = st.pop();
                int b = st.pop();
                if(token.equals("+")) st.push(a+b);
                else if(token.equals("-")) st.push(b-a);
                else if(token.equals("*")) st.push(a*b);
                else st.push(b/a);
            } else st.push(Integer.parseInt(token));
        }
        return st.pop();
    }
}
