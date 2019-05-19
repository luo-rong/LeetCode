public class RotateRight {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        ListNode node = head;
        int length = 1;
        while (node.next != null) {
            ++length;
            node = node.next;
        }
        k = length - k % length;
        node.next = head;
        while (k >= 0) {
            node = node.next;
            --k;
        }
        head = node.next;
        node.next = null;
        return head;
    }
}
