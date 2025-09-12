package LinkedList;

import java.util.Scanner;

class Process {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;
    int waitingTime;
    int turnaroundTime;
    Process next;

    public Process(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
        this.next = null;
    }
}

public class RoundRobinScheduler {
    private Process head = null;
    private Process tail = null;
    private int timeQuantum;

    public RoundRobinScheduler(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }

    // Add process at end
    public void addProcess(int pid, int burstTime, int priority) {
        Process newProcess = new Process(pid, burstTime, priority);
        if (head == null) {
            head = tail = newProcess;
            newProcess.next = head;
        } else {
            tail.next = newProcess;
            tail = newProcess;
            tail.next = head;
        }
        System.out.println("Process P" + pid + " added.");
    }

    // Remove a process by Process ID
    private void removeProcess(Process target) {
        if (head == null || target == null) return;

        if (head == target && head == tail) {
            head = tail = null;
        } else if (head == target) {
            tail.next = head.next;
            head = head.next;
        } else {
            Process temp = head;
            while (temp.next != target && temp.next != head) {
                temp = temp.next;
            }

            temp.next = target.next;
            if (target == tail) tail = temp;
        }
    }

    // Simulate round robin scheduling
    public void simulateScheduling() {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int currentTime = 0;
        int totalWaitingTime = 0;
        int totalTurnaroundTime = 0;
        int processCount = getProcessCount();

        Process current = head;

        System.out.println("\n--- Starting Round Robin Scheduling ---");

        while (head != null) {
            System.out.println("\nCurrent Process: P" + current.pid);
            int timeUsed = Math.min(timeQuantum, current.remainingTime);
            currentTime += timeUsed;
            current.remainingTime -= timeUsed;

            if (current.remainingTime == 0) {
                current.turnaroundTime = currentTime;
                current.waitingTime = current.turnaroundTime - current.burstTime;
                totalWaitingTime += current.waitingTime;
                totalTurnaroundTime += current.turnaroundTime;

                System.out.println("Process P" + current.pid + " completed.");
                Process toRemove = current;
                current = current.next;
                removeProcess(toRemove);
            } else {
                current = current.next;
            }

            displayProcesses();
        }

        System.out.println("\n--- Scheduling Complete ---");
        System.out.printf("Average Waiting Time: %.2f\n", (double) totalWaitingTime / processCount);
        System.out.printf("Average Turnaround Time: %.2f\n", (double) totalTurnaroundTime / processCount);
    }

    // Display process queue
    public void displayProcesses() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return;
        }

        System.out.println("Processes in Queue:");
        Process temp = head;
        do {
            System.out.print("P" + temp.pid + "(Rem: " + temp.remainingTime + ") -> ");
            temp = temp.next;
        } while (temp != head);
        System.out.println("(back to P" + head.pid + ")");
    }

    // Count processes
    public int getProcessCount() {
        if (head == null) return 0;
        int count = 0;
        Process temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);
        return count;
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter time quantum: ");
        int quantum = sc.nextInt();

        RoundRobinScheduler scheduler = new RoundRobinScheduler(quantum);

        while (true) {
            System.out.println("\n--- Round Robin Menu ---");
            System.out.println("1. Add Process");
            System.out.println("2. Display Processes");
            System.out.println("3. Start Scheduling");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            int pid, burst, priority;

            switch (choice) {
                case 1:
                    System.out.print("Enter Process ID: ");
                    pid = sc.nextInt();
                    System.out.print("Enter Burst Time: ");
                    burst = sc.nextInt();
                    System.out.print("Enter Priority: ");
                    priority = sc.nextInt();
                    scheduler.addProcess(pid, burst, priority);
                    break;

                case 2:
                    scheduler.displayProcesses();
                    break;

                case 3:
                    scheduler.simulateScheduling();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
