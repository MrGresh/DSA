class Solution {
    public static void reverseStack(Stack<Integer> st) {
        if(st.isEmpty()) return;
        int ele = st.pop();
        reverseStack(st);
        insertAtBottom(st, ele);
    }
    static void insertAtBottom(Stack<Integer> st, int x) {
        if(st.isEmpty()) {
            st.push(x);
            return;
        }
        int ele = st.pop();
        insertAtBottom(st, x);
        st.push(ele);
    }
}
----------------------------------------------------------------------
class Solution {
    static void reverse(Stack<Integer> s) {
        Queue<Integer> q = new LinkedList<>();
        while(!s.isEmpty()) q.add(s.pop());
        while(!q.isEmpty()) s.push(q.poll());
    }
}
