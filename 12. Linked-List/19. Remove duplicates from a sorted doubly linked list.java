Node removeDuplicates(Node head) {
    if(head.next==null) return head;
    Node curr = head.next;
    while(curr!=null) {
        if(curr.data==curr.prev.data) {
            curr.prev.next = curr.next;
            if(curr.next!=null) curr.next.prev = curr.prev;
        }
        curr = curr.next;
    }
}
-------------------------------------------------------------------
Node removeDuplicates(Node head) {
    if(head.next==null) return head;
    Node t = head;
    while(t!=null) {
        Node nxt = t.next;
        while(nxt!=null && nxt.data==t.data) nxt = nxt.next;
        t.next = nxt;
        if(nxt!=null) nxt.prev = t;
        t = t.next;
    }
    return head;
}
