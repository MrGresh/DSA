class Solution {
    public static boolean checkRedundancy(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            if (ch == ')') {
                boolean isOperatorFound = false;

                while (stack.peek() != '(') {
                    char top = stack.pop();
                    if (top == '+' || top == '-' || top == '*' || top == '/') {
                        isOperatorFound = true;
                    }
                }
                stack.pop();

                if (!isOperatorFound) return true;
            } else stack.push(ch);
        }
        
        return false;
    }
}
