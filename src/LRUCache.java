import java.util.*;

class LRUCache {
    class ListNode {
        int key, value;
        ListNode last, next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, ListNode> cacheHashMap;
    private ListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cacheHashMap = new HashMap<>();
        head = null;
        tail = null;
    }

    private void moveToHead(int key) {
        ListNode node = cacheHashMap.get(key);
        if (node == null || node == head) return;
        if (node.key == tail.key) {
            tail = tail.last;
        }
        node.last.next = node.next;
        if (node.next != null) {
            node.next.last = node.last;
        }
        node.last = null;
        node.next = head;
        head.last = node;
        head = node;
    }

    public int get(int key) {
        moveToHead(key);
        return cacheHashMap.get(key) != null ? cacheHashMap.get(key).value : -1;
    }

    public void put(int key, int value) {
        if (capacity == 0) return;
        if (cacheHashMap.get(key) != null) {
            cacheHashMap.get(key).value = value;
            moveToHead(key);
            return;
        }
        if (cacheHashMap.size() >= capacity) {
            cacheHashMap.remove(tail.key);
            if (cacheHashMap.size() == 0) {
                head = null;
                tail = null;
            } else {
                tail = tail.last;
                tail.next = null;
            }
        }

        ListNode node = new ListNode(key, value);
        if (cacheHashMap.size() == 0) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.last = node;
            head = node;
        }
        cacheHashMap.put(key, node);
    }

    public static void main(String[] args) {
        LRUCache obj = new LRUCache(2);
        obj.put(1, 1);
        obj.put(2, 2);
        System.out.println(obj.get(1));
        obj.put(3, 3);
        System.out.println(obj.get(2));
        obj.put(4, 4);
        System.out.println(obj.get(1));
        System.out.println(obj.get(3));
        System.out.println(obj.get(4));
    }
}


//class LRUCache {
//    private Queue<Integer> cacheUnitQueue;
//    private HashMap<Integer, Integer> cacheUnitHashMap;
//    private int capacity;
//
//    public LRUCache(int capacity) {
//        this.cacheUnitQueue = new LinkedBlockingQueue<>();
//        this.cacheUnitHashMap = new HashMap<>();
//        this.capacity = capacity;
//    }
//
//    public int get(int key) {
//        if (this.cacheUnitHashMap.get(key) != null) {
//            cacheUnitQueue.remove(key);
//            cacheUnitQueue.add(key);
//            return this.cacheUnitHashMap.get(key);
//        }
//        return -1;
//    }
//
//    public void put(int key, int value) {
//        if (cacheUnitHashMap.get(key) != null) {
//            cacheUnitQueue.remove(key);
//            cacheUnitQueue.add(key);
//            cacheUnitHashMap.put(key, value);
//        } else if (cacheUnitHashMap.size() < this.capacity) {
//            cacheUnitQueue.add(key);
//            cacheUnitHashMap.put(key, value);
//        } else {
//            while (cacheUnitHashMap.remove(cacheUnitQueue.remove()) == null) ;
//            cacheUnitQueue.add(key);
//            cacheUnitHashMap.put(key, value);
//        }
//    }
//
//    public static void main(String[] args) {
//        LRUCache obj = new LRUCache(2);
//        obj.put(2, 1);
//        obj.put(2, 2);
//        System.out.println(obj.get(2));
//        obj.put(1, 1);
//        obj.put(4, 1);
//        System.out.println(obj.get(2));
//    }
//}