package _234_PalindromeLinkedList;

import com.sun.istack.internal.NotNull;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class PalindromeLinkedList {
    private ListNode getMidNode(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow.next;
        slow.next = null;
        return fast;
    }

    private ListNode reverseList(ListNode head) {
        ListNode curr = head, last = null, next;
        while (curr != null) {
            next = curr.next;
            curr.next = last;
            last = curr;
            curr = next;
        }
        return last;
    }

    private boolean compare(ListNode h1, ListNode h2) {
        while (h1 != null && h2 != null) {
            if (h1.val != h2.val) {
                return false;
            }
            h1 = h1.next;
            h2 = h2.next;
        }
        return true;
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode midNode = getMidNode(head);
        midNode = reverseList(midNode);
        return compare(head, midNode);
    }
}
