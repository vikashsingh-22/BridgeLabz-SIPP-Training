package StackAndQueue;
import java.util.Stack;

public class QueueUsingStacks {
    private Stack<Integer> inStack;
    private Stack<Integer> outStack;

    public QueueUsingStacks() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    // Enqueue operation: O(1)
    public void enqueue(int x) {
        inStack.push(x);
    }

    // Dequeue operation: Amortized O(1)
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (outStack.isEmpty()) {
            // Transfer all elements from inStack to outStack
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.pop();
    }

    // Peek front element: Amortized O(1)
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.peek();
    }

    // Check if queue is empty
    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public static void main(String[] args) {
        QueueUsingStacks queue = new QueueUsingStacks();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println(queue.dequeue()); // 10
        System.out.println(queue.peek());    // 20
        System.out.println(queue.dequeue()); // 20
        System.out.println(queue.dequeue()); // 30
        System.out.println(queue.isEmpty()); // true
    }
}
