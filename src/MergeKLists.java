public class MergeKLists {
    static public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    // 解法1 依次遍历寻找最小值，时间复杂度O(n*k)
    public ListNode mergeKLists1(ListNode[] lists) {
        ListNode head = new ListNode(0);
        ListNode node = head;
        boolean flag = false;
        while (!flag) {
            flag = true;
            int min = Integer.MAX_VALUE;
            int index = 0;
            for (int i = 0; i < lists.length; ++i) {
                if (lists[i] != null && lists[i].val < min) {
                    min = lists[i].val;
                    index = i;
                    flag = false;
                }
            }
            if (!flag) {
                node.next = new ListNode(min);
                node = node.next;
                lists[index] = lists[index].next;
            }
        }
        return head.next;
    }

    // 解法1 维护一个最小堆寻找最小值，时间复杂度O(n*log(k))
    private ListNode[] listNodes;

    private boolean isFirstNumSmallest(int x, int y, int z) {
        return x <= y && x <= z;    // 等号！！！
    }

    private boolean isFirstNumSmallest(int x, int y) {
        return x < y;
    }

    private void changeNum(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void heapAdjust(int[] heap, int parent, int length) {
        if (parent >= length / 2) return;
        int child = parent * 2 + 1;
        if (child + 1 >= length && isFirstNumSmallest(listNodes[heap[child]].val, listNodes[heap[parent]].val)) {
            changeNum(heap, parent, child);
        } else if (child + 1 < length) {
            if (isFirstNumSmallest(listNodes[heap[child]].val, listNodes[heap[parent]].val, listNodes[heap[child + 1]].val)) {
                changeNum(heap, parent, child);
                heapAdjust(heap, child, length);
            } else if (isFirstNumSmallest(listNodes[heap[child + 1]].val, listNodes[heap[parent]].val, listNodes[heap[child]].val)) {
                changeNum(heap, parent, child + 1);
                heapAdjust(heap, child + 1, length);
            }
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        listNodes = lists;
        int[] heap = new int[listNodes.length];
        int length = 0;
        for (int i = 0; i < listNodes.length; ++i) {
            if (lists[i] != null) {
                heap[length++] = i;
            }
        }
        for (int i = length / 2 - 1; i >= 0; --i) {
            heapAdjust(heap, i, length);
        }
        ListNode head = new ListNode(0);
        ListNode node = head;
        while (length > 0) {
            node.next = new ListNode(listNodes[heap[0]].val);
            node = node.next;
            if (listNodes[heap[0]].next != null) {
                listNodes[heap[0]] = listNodes[heap[0]].next;
            } else {
                changeNum(heap, 0, --length);
            }
            heapAdjust(heap, 0, length);
        }
        return head.next;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[]{null}; // new ListNode[]{}
        MergeKLists mergeKLists = new MergeKLists();
        ListNode listNode = mergeKLists.mergeKLists(lists);
        System.out.println();
        while (listNode != null) {
            System.out.print(listNode.val + " ");
            listNode = listNode.next;
        }
    }
}