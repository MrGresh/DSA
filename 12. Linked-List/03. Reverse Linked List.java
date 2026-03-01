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
--------------------------------------------------------------
ListNode reverseList(ListNode head) {
    return rec(head,  null);
}
ListNode rec(ListNode curr, ListNode prev) {
    if(curr==null) return prev;
    ListNode nxt = curr.next;
    curr.next = prev;
    return rec(nxt, curr);
}
