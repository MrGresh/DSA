class Solution {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=arr.length-1;i>=0;i--) {
            while(!st.isEmpty() && arr[i]>=st.peek()) st.pop();
            res.addFirst(st.isEmpty() ? -1 : st.peek());
            st.push(arr[i]);
        }
        return res;
    }
}
-----------------------------------------------------------------------
class Solution {
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i=arr.length-1;i>=0;i--) {
            while(!st.isEmpty() && arr[i]<=st.peek()) st.pop();
            res.addFirst(st.isEmpty() ? -1 : st.peek());
            st.push(arr[i]);
        }
        return res;
    }
}
