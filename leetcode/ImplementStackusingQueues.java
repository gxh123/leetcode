import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {

    public static void main(String[] args) {
        MyStack s = new MyStack();
        s.push(1);
        s.push(2);
        s.push(3);
        s.pop();
        s.push(4);
        s.pop();
        s.pop();
        s.pop();
    }

}

class MyStack {
    Queue<Integer> main = new LinkedList<>(); // 只存放最新的
    Queue<Integer> remain = new LinkedList<>(); // 存放剩下的

    // Push element x onto stack.
    public void push(int x) {
        if (!main.isEmpty()) {
            remain.offer(main.poll());
        }
        main.offer(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if (!empty()) {
            main.poll();
            int size = remain.size() - 1;
            while (size > 0) {
                main.offer(remain.poll());
                size--;
            }
            Queue<Integer> temp = main;
            main = remain;
            remain = temp;
        }
    }

    // Get the top element.
    public int top() {
        return main.peek();
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return main.isEmpty() && remain.isEmpty();
    }
}
