class Solution {
    public int[] nextGreaterElements(int[] arr) {
        int[] res = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        for(int i=arr.length-1;i>=0;i--) {
            while(!st.isEmpty() && arr[i]>=st.peek()) st.pop();
            st.push(arr[i]);
        }
        for(int i=arr.length-1;i>=0;i--) {
            while(!st.isEmpty() && arr[i]>=st.peek()) st.pop();
            res[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        }
        return res;
    }
}
