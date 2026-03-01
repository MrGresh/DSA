Node flatten(Node root) {
    if (root == null || root.next == null) {
        return root;
    }

    root.next = flatten(root.next);

    root = mergeTwoLists(root, root.next);

    return root;
}
Node mergeTwoLists(Node l1, Node l2) {
    Node dummy = new Node(0);
    Node curr = dummy;

    while (l1 != null && l2 != null) {
        if (l1.data <= l2.data) {
            curr.bottom = l1;
            l1 = l1.bottom;
        } else {
            curr.bottom = l2;
            l2 = l2.bottom;
        }
        curr = curr.bottom;
    }

    curr.bottom = (l1 != null) ? l1 : l2;

    return dummy.bottom;
}
