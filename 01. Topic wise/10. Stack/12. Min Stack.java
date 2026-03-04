class MinStack {
    Stack<Integer> st;
    Map<Integer, Integer> minMap;
    public MinStack() {
        st = new Stack<>();
        minMap = new HashMap<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(st.size()==1) minMap.put(1, val);
        else {
            int lastMin = minMap.get(st.size()-1);
            minMap.put(st.size(), Math.min(lastMin, val));
        }
    }
    
    public void pop() {
        if (!st.isEmpty()) {
            minMap.remove(st.size());
            st.pop();
        }
    }
    
    public int top() {
        return st.isEmpty() ? -1 : st.peek();
    }
    
    public int getMin() {
        return minMap.isEmpty() ? -1 : minMap.get(st.size());
    }
}
-------------------------------------------------------------------------------
class MinStack {
    Stack<Integer> st;
    Stack<Integer> minStack;
    public MinStack() {
        st = new Stack<>();
        minStack = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        if(minStack.isEmpty() || val<=minStack.peek()) minStack.push(val);
    }
    
    public void pop() {
        if (!st.isEmpty()) {
            if(st.peek().equals(minStack.peek())) minStack.pop();
            st.pop();
        }
    }
    
    public int top() {
        return st.isEmpty() ? -1 : st.peek();
    }
    
    public int getMin() {
        return minStack.isEmpty() ? -1 : minStack.peek();
    }
}
