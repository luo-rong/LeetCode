package _328_OddEvenLinkedList;

public class OddEvenLinkedList {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        ListNode evenNode = head, oddNode;
        ListNode oddHead = head == null ? null : head.next;
        while (evenNode != null && (oddNode = evenNode.next) != null) {
            evenNode.next = oddNode.next;
            if (evenNode.next != null) {
                evenNode = evenNode.next;
                oddNode.next = evenNode.next;
            }
        }
        if (oddHead != null) {
            evenNode.next = oddHead;
        }
        return head;
    }
}
