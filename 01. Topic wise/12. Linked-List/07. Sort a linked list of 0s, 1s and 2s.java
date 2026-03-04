class Solution {
    public Node segregate(Node head) {
        Node zeroHead = new Node(-1), oneHead = new Node(-1), twoHead = new Node(-1);
        Node currZero = zeroHead;
        Node currOne = oneHead;
        Node currTwo = twoHead;
        while(head!=null) {
            if(head.data==0) {
                currZero.next = head;
                currZero = currZero.next;
            } else if(head.data==1) {
                currOne.next = head;
                currOne = currOne.next;
            } else {
                currTwo.next = head;
                currTwo = currTwo.next;
            }
            head = head.next;
        }
        currTwo.next = null;
        currOne.next = twoHead.next;
        currZero.next = (oneHead.next != null) ? oneHead.next : twoHead.next;
        
        Node resultHead = (zeroHead.next != null) ? zeroHead.next : 
                         (oneHead.next != null) ? oneHead.next : twoHead.next;
        
        return resultHead;
    }
}
