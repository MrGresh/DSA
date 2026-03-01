class Solution {
    public int getDecimalValue(ListNode head) {
        ListNode curr = head, prev = null, nxt = null;
        while(curr!=null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        
        int ans = 0, i = 1;
        while(prev!=null) {
            if(prev.val==1) ans += i;
            prev = prev.next;
            i *= 2;
        }
        return ans;
    }
}
