public class DetectCycle {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }

    }

    public ListNode detectCycle(ListNode head) {
        ListNode A = head, B = head;
        while (B != null && B.next != null) {
            A = A.next;
            B = B.next.next;
            if (A == B) break;
        }
        if (B == null || B.next == null) {
            return null;
        }
        B = head;
        while (A != B) {
            A = A.next;
            B = B.next;
        }
        return A;
    }
}
