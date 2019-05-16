import java.util.HashSet;
import java.util.Set;

public class GetIntersectionNode {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        Set<ListNode> nodeSet;
        nodeSet = new HashSet<>();
        ListNode node = headA;
        while (node != null) {
            nodeSet.add(node);
            node = node.next;
        }
        node = headB;
        while (node != null && !nodeSet.contains(node)) {
            node = node.next;
        }
        return node;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pA = headA, pB = headB;
        while (pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

    public static void main(String[] args) {
        GetIntersectionNode getIntersectionNode = new GetIntersectionNode();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        System.out.println(getIntersectionNode.getIntersectionNode(head, head));
    }
}
