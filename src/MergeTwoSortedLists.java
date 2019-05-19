public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode list = head;
        while ((l1 != null) && (l2 != null)) {
            if (l1.val < l2.val) {
                list.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                list.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            list = list.next;
        }
        if (l1 != null) {
            list.next = l1;
        } else if (l2 != null) {
            list.next = l2;
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        ListNode l1 = node;
        node.next = new ListNode(8);
        node = node.next;
        node.next = new ListNode(9);

        node = new ListNode(1);
        ListNode l2 = node;
        node.next = new ListNode(8);
        node = node.next;
        node.next = new ListNode(9);

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode l = mergeTwoSortedLists.mergeTwoLists(l1, l2);

        while (l != null) {
            System.out.print(l.val + " -> ");
            l = l.next;
        }
    }
}
