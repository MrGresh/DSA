class Field {
    private int day;
    private int val;
    Field(int a, int b) {
        day = a;
        val = b;
    }
    int getDay() {
        return day;
    }
    int getVal() {
        return val;
    }
}
class StockSpanner {
    Stack<Field> st;
    int curr_day = 0;
    public StockSpanner() {
        curr_day = 0;
        st = new Stack<>();
    }
    
    public int next(int price) {
        curr_day++;
        while(!st.isEmpty() && price>=st.peek().getVal()) st.pop();
        int ans = curr_day - (st.isEmpty() ? 0 : st.peek().getDay());
        st.push(new Field(curr_day, price));
        return ans;
    }
}
