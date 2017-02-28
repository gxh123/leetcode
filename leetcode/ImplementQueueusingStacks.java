import java.util.Stack;

public class ImplementQueueusingStacks {

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        System.out.println(q.peek());
        q.pop();
        System.out.println(q.peek());
        q.pop();
        System.out.println(q.peek());
        q.pop();
    }

}

class MyQueue {
    private Stack<Integer> myQueue = new Stack<>();;

    // Push element x to the back of queue.
    public void push(int x) {
        Stack<Integer> reverse = new Stack<>();
        while (!this.myQueue.isEmpty()) {
            reverse.push(this.myQueue.pop());
        }
        reverse.push(x);
        while (!reverse.isEmpty()) {
            this.myQueue.push(reverse.pop());
        }
    }

    // Removes the element from in front of queue.
    public void pop() {
        myQueue.pop();
    }

    // Get the front element.
    public int peek() {
        return myQueue.peek();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return myQueue.isEmpty();
    }
}

// 更好的解法，时间复杂度更低
class MyQueue2 {

    Stack<Integer> input = new Stack<>();
    Stack<Integer> output = new Stack<>();

    public void push(int x) {
        input.push(x); // input放输入
    }

    public void pop() {
        peek();
        output.pop();
    }

    public int peek() {
        if (output.empty())
            while (!input.empty())
                output.push(input.pop());
        return output.peek(); // output输出，空了就把input里的都拿过来
    }

    public boolean empty() {
        return input.empty() && output.empty();
    }
}
