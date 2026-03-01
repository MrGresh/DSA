class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head, prevOfCurr = null, ans = new ListNode(-1);
        while(true) {
            ListNode last = curr;
            for(int i=1;i<k;i++) {
                if(last!=null) last = last.next;
                else break;
            }
            if(last==null) break;
            ListNode nextGroupHead = last.next;
            last.next = null;
            ListNode newHead = reverseList(curr);
            if(ans.val==-1) ans = newHead;
            curr.next = nextGroupHead;
            if(prevOfCurr!=null) prevOfCurr.next= newHead;
            prevOfCurr = curr;
            curr = nextGroupHead;
        }
        return ans;
    }
    ListNode reverseList(ListNode head) {
        ListNode curr = head, nxt = null, prev = null;
        while(curr!=null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }
        return prev;
    }
}
