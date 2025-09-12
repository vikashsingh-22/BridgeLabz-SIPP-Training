package ScenarioBased.DailyTask;


import java.util.LinkedList;
import java.util.Scanner;

public class DailyTaskPlanner {
    public static void main(String[] args) {
        LinkedList<Task> tasks = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter command (1: add meeting, 2: add workout, 3: add coding session, 4: execute all, 5: search by keyword): ");
        int command = scanner.nextInt();
        scanner.nextLine(); 

        switch (command) {
            case 1:
                System.out.println("Enter meeting title, description, location: ");
                tasks.add(new Meeting(scanner.nextLine(), scanner.nextLine(), scanner.nextLine()));
                System.out.println("Meeting added");
                break;
            case 2:
                System.out.println("Enter workout title, description, duration (minutes): ");
                tasks.add(new Workout(scanner.nextLine(), scanner.nextLine(), scanner.nextInt()));
                System.out.println("Workout added");
                break;
            case 3:
                System.out.println("Enter coding session title, description, programming language: ");
                tasks.add(new CodingSession(scanner.nextLine(), scanner.nextLine(), scanner.nextLine()));
                System.out.println("Coding session added");
                break;
            case 4:
                for (Task task : tasks) {
                    task.execute();
                }
                break;
            case 5:
                System.out.println("Enter keyword to search: ");
                String keyword = scanner.nextLine().toLowerCase();
                for (Task task : tasks) {
                    if (task.getTitle().toLowerCase().contains(keyword) || 
                        task.getDescription().toLowerCase().contains(keyword)) {
                        System.out.println("Found: " + task.getTitle() + " - " + task.getDescription());
                    }
                }
                break;
            default:
                System.out.println("Invalid command");
        }
        
    }
}