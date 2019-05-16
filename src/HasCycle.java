import java.util.HashSet;
import java.util.Set;

public class HasCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private Set<ListNode> nodeSet;

    public boolean hasCycle(ListNode head) {
        nodeSet = new HashSet<>();
        ListNode node = head;
        while (node != null && !nodeSet.contains(node)) {
            nodeSet.add(node);
            node = node.next;
        }
        return node != null;
    }

    public static void main(String[] args) {
        HasCycle hasCycle = new HasCycle();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        ListNode node = head.next;
        node.next = head;
        System.out.println(hasCycle.hasCycle(head));
    }
}
