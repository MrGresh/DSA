class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, curr = slow, nxt = null;
        while (curr != null) {
            nxt = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nxt;
        }

        ListNode firstPointer = head, secondPointer = prev;
        while (secondPointer != null) {
            if (firstPointer.val != secondPointer.val) return false;
            firstPointer = firstPointer.next;
            secondPointer = secondPointer.next;
        }

        return true;
    }
}
