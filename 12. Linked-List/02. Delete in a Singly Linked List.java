class Solution {
    Node deleteNode(Node head, int x) {
        if(x==1) return head.next;
        
        Node curr = head;
        for(int i=1;i<x-1;i++) curr=curr.next;
        curr.next = curr.next.next;
        return head;
    }
}
