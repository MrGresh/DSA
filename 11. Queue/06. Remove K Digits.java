class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Character> dq = new ArrayDeque<>();
        for(int i=0;i<num.length();i++) {
            char ch = num.charAt(i);
            while(!dq.isEmpty() && ch<dq.peekLast() && k>0) {
                dq.removeLast();
                k--;
            }
            dq.addLast(ch);
        }
        while(!dq.isEmpty() && k>0) {
            dq.removeLast();
            k--;
        }
        while(!dq.isEmpty() && dq.peekFirst()=='0') dq.removeFirst();
        if(dq.isEmpty()) return "0";

        StringBuilder res = new StringBuilder();
        while(!dq.isEmpty()) res.append(dq.removeFirst());
        return res.toString();
    }
}
