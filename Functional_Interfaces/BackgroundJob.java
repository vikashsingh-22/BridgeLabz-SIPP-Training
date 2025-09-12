package Functional_Interfaces;

public class BackgroundJob {
    public static void main(String[] args) {
        // Runnable task
        Runnable task = () -> {
            try {
                System.out.println("Background task started...");
                Thread.sleep(2000); 
                System.out.println(" Background task finished.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        // Execute asynchronously
        Thread thread = new Thread(task);
        thread.start();

        System.out.println("Main thread continues running...");
    }
}

