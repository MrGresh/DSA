class Solution {
    static ArrayList<Integer> preGreaterEle(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        for(int i=1;i<arr.length;i++) {
            while(!st.isEmpty() && arr[i]>=st.peek()) st.pop();
            if(st.isEmpty()) res.add(-1);
            else res.add(st.peek());
            st.push(arr[i]);
        }
        return res;
    }
}
---------------------------------------------------------------------------
class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        ArrayList<Integer> res = new ArrayList<>();
        res.add(-1);
        Stack<Integer> st = new Stack<>();
        st.push(arr[0]);
        for(int i=1;i<arr.length;i++) {
            while(!st.isEmpty() && arr[i]<=st.peek()) st.pop();
            if(st.isEmpty()) res.add(-1);
            else res.add(st.peek());
            st.push(arr[i]);
        }
        return res;
    }
}
