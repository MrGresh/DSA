class Solution {
    public boolean isValid(String str) {
        Stack<Character> s = new Stack<>();
        char[] arr = str.toCharArray();
        for(char c : arr) {
            if(c=='(' || c=='{' || c=='[') s.push(c);
            else {
                if(s.isEmpty()) return false;
                if(c==')' && s.peek()=='(') s.pop();
                else if(c=='}' && s.peek()=='{') s.pop();
                else if(c==']' && s.peek()=='[') s.pop();
                else return false;
            }
        }
        if(s.isEmpty()) return true;
        return false;
    }
}
