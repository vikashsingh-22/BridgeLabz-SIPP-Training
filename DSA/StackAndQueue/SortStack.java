import java.util.Stack;

public class SortStack {
    // Function to insert an element in sorted order
    public static void insertSorted(Stack<Integer> stack, int element) {
        // Base case: if stack is empty or top element is smaller than or equal to element
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }
        
        // Pop top element and recurse
        int top = stack.pop();
        insertSorted(stack, element);
        
        // Push back the top element
        stack.push(top);
    }
    
    // Function to sort the stack using recursion
    public static void sortStack(Stack<Integer> stack) {
        // Base case: if stack is empty, return
        if (stack.isEmpty()) {
            return;
        }
        
        // Pop top element
        int top = stack.pop();
        
        // Recursively sort the remaining stack
        sortStack(stack);
        
        // Insert the popped element back in sorted order
        insertSorted(stack, top);
    }
    
    // Main method for testing
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(4);
        stack.push(2);
        
        System.out.println("Original stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted stack: " + stack);
    }
}