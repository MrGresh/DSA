class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        while(head!=null && head.next!=null && head.val==head.next.val) {
            int t = head.val;
            while(head!=null && head.val==t) head = head.next;
        }
        if(head==null) return null;
        ListNode curr = head;
        while(curr.next!=null && curr.next.next!=null) {
            if(curr.next.val==curr.next.next.val) {
                int t = curr.next.val;
                ListNode tmp = curr.next;
                while(tmp!=null && tmp.val==t)  tmp = tmp.next;
                curr.next = tmp;
            } else curr = curr.next;
        }
        return head;
    }
}
