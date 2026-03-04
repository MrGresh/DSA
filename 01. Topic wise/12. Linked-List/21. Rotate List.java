class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(k==0 || head == null || head.next == null) return head;
        int len = 1;
        ListNode curr = head;
        while(curr.next!=null) {
            len++;
            curr = curr.next;
        }
        k %= len;
        if(k==0) return head;
        ListNode slow = head, fast = head;
        for(int i=1;i<=k;i++) fast = fast.next;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next;
        }
        ListNode newHead = slow.next;
        slow.next = null;
        fast.next = head;
        return newHead;
    }
}
