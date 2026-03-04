ListNode detectCycle(ListNode head) {
    ListNode curr = head;
    Set<ListNode> set = new HashSet<>();
    while(curr!=null) {
        if(set.contains(curr)) return curr;
        set.add(curr);
        curr = curr.next;
    }
    return null;
}
----------------------------------------------------
ListNode detectCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while(fast!=null && fast.next!=null) {
        slow = slow.next;
        fast = fast.next.next;
        if(slow == fast) {
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }
            return slow;
        }
    }
    return null;
}
