class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack();
        for(int x: asteroids) {
            if(x>=0) st.push(x);
            else {
                while(!st.isEmpty() && st.peek()>0 && Math.abs(x)>st.peek()) st.pop();
                if(st.isEmpty() || st.peek()<0) st.push(x);
                else if(Math.abs(x)==st.peek()) st.pop();
            }
        }
        int[] ans = new int[st.size()];
        int k=st.size()-1;
        while(!st.isEmpty()) ans[k--] = st.pop();
        return ans;
    }
}
