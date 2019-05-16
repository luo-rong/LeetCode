public class SortList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private ListNode getMiddleNode(ListNode head) {
        ListNode node = head;
        ListNode middle = new ListNode(-1);
        middle.next = node;
        while (node != null && node.next != null) {
            node = node.next.next;
            middle = middle.next;
        }
        node = middle.next;
        middle.next = null;
        return node;
    }

    private ListNode marge(ListNode head1, ListNode head2) {
        ListNode node1 = head1, node2 = head2;
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (node1 != null || node2 != null) {
            while (node1 != null && (node2 == null || node1.val <= node2.val)) {
                node.next = node1;
                node = node.next;
                node1 = node1.next;
            }
            while (node2 != null && (node1 == null || node1.val > node2.val)) {
                node.next = node2;
                node = node.next;
                node2 = node2.next;
            }
        }
        return head.next;
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode middle = getMiddleNode(head);
        head = sortList(head);
        middle = sortList(middle);
        return marge(head, middle);
    }
}