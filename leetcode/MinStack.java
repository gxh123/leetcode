import java.util.Stack;

public class MinStack {

    Stack<Integer> stack = new Stack<>();
    int min = Integer.MAX_VALUE;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {

    }

    public void pop() {

    }

    // public int top() {
    //
    // }
    //
    // public int getMin() {
    //
    // }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}

class HeapMin {
    private int[] Heap;
    private int size;

    public HeapMin() {
        Heap = new int[100];
        size = 0;
        Heap[0] = Integer.MIN_VALUE;
    }

    private int parent(int pos) {
        return pos / 2;
    }

    private boolean isleaf(int pos) {
        return ((pos > size / 2) && (pos <= size));
    }

    private void swap(int pos1, int pos2) {
        int tmp;
        tmp = Heap[pos1];
        Heap[pos1] = Heap[pos2];
        Heap[pos2] = tmp;
    }

    public void insert(int elem) {
        size++;
        Heap[size] = elem;
        int current = size;
        while (Heap[current] < Heap[parent(current)]) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public int removemin() {
        swap(1, size);
        size--;
        if (size != 0)
            pushdown(1);
        return Heap[size + 1];
    }

    private void pushdown(int position) {
        int smallestchild;
        while (!isleaf(position)) {
            smallestchild = 2 * position;
            if ((smallestchild < size) && (Heap[smallestchild] > Heap[smallestchild + 1]))
                smallestchild = smallestchild + 1;
            if (Heap[position] <= Heap[smallestchild])
                return;
            swap(position, smallestchild);
            position = smallestchild;
        }
    }
}
