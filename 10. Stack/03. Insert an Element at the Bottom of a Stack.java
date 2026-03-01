class Solution {
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        if(st.isEmpty()) {
            st.push(x);
            return st;
        }
        int ele = st.pop();
        insertAtBottom(st, x);
        st.push(ele);
        return st;
    }
}
