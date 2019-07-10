package sort;

public class HeapSort {
    private int[] heap;
    private int size;

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    public int getFirstVal() {
        return size > 0 ? heap[0] : 0;
    }

    public void setFirstVal(int val) {
        heap[0] = val;
    }

    public int delLastVal() {
        return size > 0 ? heap[--size] : 0;
    }

    // i节点更新后，调整最大堆
    public void maxHeapify(int i) {
        int leftVal = (i << 1) + 1 < size ? heap[(i << 1) + 1] : Integer.MIN_VALUE;
        int rightVal = (i << 1) + 2 < size ? heap[(i << 1) + 2] : Integer.MIN_VALUE;
        if (leftVal >= rightVal && leftVal > heap[i]) {
            swap(i, (i << 1) + 1);
            maxHeapify((i << 1) + 1);
        } else if (rightVal > leftVal && rightVal > heap[i]) {
            swap(i, (i << 1) + 2);
            maxHeapify((i << 1) + 2);
        }
    }

    public void buildMaxHeap(int[] array) {
        this.size = array.length;
        this.heap = new int[size];
        System.arraycopy(array, 0, heap, 0, size);
        for (int i = (size >> 1) - 1; i >= 0; --i) {
            maxHeapify(i);
        }
    }

    // i节点更新后，调整最大堆
    public void minHeapify(int i) {
        int leftVal = (i << 1) + 1 < size ? heap[(i << 1) + 1] : Integer.MAX_VALUE;
        int rightVal = (i << 1) + 2 < size ? heap[(i << 1) + 2] : Integer.MAX_VALUE;
        if (leftVal <= rightVal && leftVal < heap[i]) {
            swap(i, (i << 1) + 1);
            minHeapify((i << 1) + 1);
        } else if (rightVal < leftVal && rightVal < heap[i]) {
            swap(i, (i << 1) + 2);
            minHeapify((i << 1) + 2);
        }
    }

    public void buildMinHeap(int[] array) {
        this.size = array.length;
        this.heap = new int[size];
        System.arraycopy(array, 0, heap, 0, size);
        for (int i = (size >> 1) - 1; i >= 0; --i) {
            minHeapify(i);
        }
    }

    private int[] ascendingSort(int[] array) {
        buildMinHeap(array);
        int[] ascArray = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            ascArray[i] = getFirstVal();
            setFirstVal(delLastVal());
            minHeapify(0);
        }
        return ascArray;
    }

    private int[] descendingSort(int[] array) {
        buildMaxHeap(array);
        int[] desArray = new int[array.length];
        for (int i = 0; i < array.length; ++i) {
            desArray[i] = getFirstVal();
            setFirstVal(delLastVal());
            maxHeapify(0);
        }
        return desArray;
    }

    public int[] sort(int[] array, boolean isAscendingOrder) {
        return isAscendingOrder ? ascendingSort(array) : descendingSort(array);
    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] nums = heapSort.sort(new int[]{1, 2, 3, 4, 5, 6, 7}, false);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
        System.out.println();
        nums = heapSort.sort(new int[]{7, 6, 5, 4, 3, 2, 1}, true);
        for (int num : nums) {
            System.out.print(num + ", ");
        }
    }
}
