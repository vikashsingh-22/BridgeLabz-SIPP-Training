package LinkedList;

import java.util.Scanner;

class Task {
    int taskId;
    String name;
    int priority;
    String dueDate;
    Task next;

    public Task(int taskId, String name, int priority, String dueDate) {
        this.taskId = taskId;
        this.name = name;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }
}

class TaskScheduler {
    private Task head = null;
    private Task tail = null;
    private Task current = null;

    // Add at beginning
    public void addAtBeginning(Task newTask) {
        if (head == null) {
            head = tail = newTask;
            newTask.next = head;
        } else {
            newTask.next = head;
            head = newTask;
            tail.next = head;
        }
    }

    // Add at end
    public void addAtEnd(Task newTask) {
        if (head == null) {
            addAtBeginning(newTask);
        } else {
            tail.next = newTask;
            tail = newTask;
            tail.next = head;
        }
    }

    // Add at specific position (1-based index)
    public void addAtPosition(Task newTask, int position) {
        if (position <= 1 || head == null) {
            addAtBeginning(newTask);
            return;
        }

        Task temp = head;
        int count = 1;

        while (count < position - 1 && temp.next != head) {
            temp = temp.next;
            count++;
        }

        newTask.next = temp.next;
        temp.next = newTask;

        if (temp == tail) {
            tail = newTask;
        }
    }

    // Remove by Task ID
    public void removeById(int taskId) {
        if (head == null) return;

        Task temp = head;
        Task prev = tail;

        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    head = head.next;
                    tail.next = head;
                    if (temp == tail) { // only one node
                        head = tail = null;
                    }
                } else if (temp == tail) {
                    tail = prev;
                    tail.next = head;
                } else {
                    prev.next = temp.next;
                }

                System.out.println("Task removed.");
                return;
            }

            prev = temp;
            temp = temp.next;
        } while (temp != head);

        System.out.println("Task not found.");
    }

    // View current and move to next
    public void viewCurrentTaskAndMove() {
        if (head == null) {
            System.out.println("No tasks available.");
            return;
        }

        if (current == null) {
            current = head;
        }

        System.out.println("Current Task:");
        printTask(current);
        current = current.next;
    }

    // Display all tasks
    public void displayTasks() {
        if (head == null) {
            System.out.println("No tasks to display.");
            return;
        }

        Task temp = head;
        System.out.println("All Tasks:");
        do {
            printTask(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks to search.");
            return;
        }

        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                printTask(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No tasks with priority " + priority + " found.");
        }
    }

    private void printTask(Task t) {
        System.out.println("ID: " + t.taskId + ", Name: " + t.name + ", Priority: " + t.priority + ", Due: " + t.dueDate);
    }
}

public class TaskScheduler {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TaskScheduler scheduler = new TaskScheduler();

        while (true) {
            System.out.println("\n--- Task Scheduler ---");
            System.out.println("1. Add Task at Beginning");
            System.out.println("2. Add Task at End");
            System.out.println("3. Add Task at Position");
            System.out.println("4. Remove Task by ID");
            System.out.println("5. View Current Task and Move to Next");
            System.out.println("6. Display All Tasks");
            System.out.println("7. Search Task by Priority");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            int id, prio, pos;
            String name, due;

            switch (ch) {
                case 1:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    prio = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    due = sc.nextLine();
                    scheduler.addAtBeginning(new Task(id, name, prio, due));
                    break;

                case 2:
                    System.out.print("Enter ID: ");
                    id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    prio = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    due = sc.nextLine();
                    scheduler.addAtEnd(new Task(id, name, prio, due));
                    break;

                case 3:
                    System.out.print("Enter Position: ");
                    pos = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter ID: ");
                    id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Priority: ");
                    prio = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Due Date: ");
                    due = sc.nextLine();
                    scheduler.addAtPosition(new Task(id, name, prio, due), pos);
                    break;

                case 4:
                    System.out.print("Enter Task ID to remove: ");
                    id = sc.nextInt();
                    scheduler.removeById(id);
                    break;

                case 5:
                    scheduler.viewCurrentTaskAndMove();
                    break;

                case 6:
                    scheduler.displayTasks();
                    break;

                case 7:
                    System.out.print("Enter Priority to search: ");
                    prio = sc.nextInt();
                    scheduler.searchByPriority(prio);
                    break;

                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
