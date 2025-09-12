package LinkedList;

import java.util.Scanner;

class TextState {
    String content;
    TextState prev, next;

    public TextState(String content) {
        this.content = content;
        this.prev = this.next = null;
    }
}

public class TextEditorUndoRedo {
    private TextState head = null;
    private TextState current = null;
    private int size = 0;
    private final int MAX_HISTORY = 10;

    // Add a new state (typing or editing)
    public void addState(String content) {
        TextState newState = new TextState(content);

        // Clear redo history
        if (current != null) {
            current.next = null;
        }

        // Append new state
        if (head == null) {
            head = current = newState;
        } else {
            current.next = newState;
            newState.prev = current;
            current = newState;
        }

        // Maintain max history size
        size++;
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }

        System.out.println("New state saved.");
    }

    // Undo (move back)
    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Cannot undo.");
            return;
        }
        current = current.prev;
        System.out.println("Undo performed.");
    }

    // Redo (move forward)
    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Cannot redo.");
            return;
        }
        current = current.next;
        System.out.println("Redo performed.");
    }

    // Display current state
    public void displayCurrentState() {
        if (current == null) {
            System.out.println("Editor is empty.");
        } else {
            System.out.println("Current Text:\n\"" + current.content + "\"");
        }
    }

    // Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TextEditorUndoRedo editor = new TextEditorUndoRedo();

        while (true) {
            System.out.println("\n--- Text Editor Menu ---");
            System.out.println("1. Type/Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Show Current Text");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt(); sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter new text: ");
                    String content = sc.nextLine();
                    editor.addState(content);
                    break;

                case 2:
                    editor.undo();
                    break;

                case 3:
                    editor.redo();
                    break;

                case 4:
                    editor.displayCurrentState();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
