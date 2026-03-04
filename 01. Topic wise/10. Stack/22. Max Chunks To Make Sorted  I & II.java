class Solution {
    public int maxChunksToSorted(int[] arr) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(arr[0]);
        for(int i=1;i<arr.length;i++) {
            if(arr[i]>=stack.peek()) {
                stack.push(arr[i]);
            }
            else {
                int max = stack.pop();
                while(!stack.isEmpty() && arr[i]<stack.peek()) {
                    stack.pop();
                }
                stack.push(max);
            }
        }
        return stack.size();
    }
}
