class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        int firstcal = l1.val + l2.val;
        if(firstcal>9) {
            firstcal -= 10;
            carry = 1;
        }
        ListNode ansHead = new ListNode(firstcal);
        l1 = l1.next;
        l2 = l2.next;

        ListNode curr = ansHead;

        while(l1!=null && l2!=null) {
            int cal = l1.val+l2.val+carry;
            if(cal>9) {
                carry = 1;
                cal -= 10;
            } else carry = 0;
            curr.next = new ListNode(cal);
            curr = curr.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while(l1!=null) {
            int cal = l1.val+carry;
            if(cal>9) {
                carry = 1;
                cal -= 10;
            } else carry = 0;
            curr.next = new ListNode(cal);
            curr = curr.next;
            l1 = l1.next;
        }

        while(l2!=null) {
            int cal = l2.val+carry;
            if(cal>9) {
                carry = 1;
                cal -= 10;
            } else carry = 0;
            curr.next = new ListNode(cal);
            curr = curr.next;
            l2 = l2.next;
        }
        
        if(carry==1) curr.next = new ListNode(1);
        return ansHead;
    }
}
