ListNode mergeKLists(ListNode[] lists) {
    if(lists.length==0) return null;
    ListNode newHead = lists[0];
    for(int i=1;i<lists.length;i++) {
        newHead = mergeTwoLists(newHead, lists[i]);
    }
    return newHead;
}
------------------------------------------------------------
ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
    for (ListNode list : lists) {
        if (list != null) pq.add(list);
    }
    ListNode dummy = new ListNode(-1);
    ListNode tail = dummy;
    while (!pq.isEmpty()) {
        ListNode smallest = pq.poll();
        tail.next = smallest;
        if (smallest.next != null) pq.add(smallest.next);
        tail = tail.next;
    }
    return dummy.next;
}
