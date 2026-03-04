class Solution {
    static List<Integer> firstNegInt(int arr[], int k) {
        List<Integer> res = new ArrayList<>();
        Deque<Integer> dq = new LinkedList<>();
        int start = 0, end = 0;
        while(end < arr.length) {
            if(arr[end]<0) dq.addLast(end);
            if(end-start+1==k) {
                res.add(dq.isEmpty() ? 0 : arr[dq.peekFirst()]);
                if(!dq.isEmpty() && start==dq.peekFirst()) dq.pollFirst();
                start++;
            }
            end++;
        }
        return res;
    }
}
