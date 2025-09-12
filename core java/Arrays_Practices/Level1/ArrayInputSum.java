package Arrays_Practices.Level1;

import java.util.Scanner; 

public class ArrayInputSum {

    public static void main(String[] args) {
        
        double[] numbers = new double[10];
        double total = 0.0;
       
        int idx = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter numbers one by one.");
        System.out.println("Enter 0 or a negative number to stop.");

        while (true) {
            System.out.print("Enter number " + (idx + 1) + ": "); 
            double userInput = scanner.nextDouble();

            if (userInput < 0) {
                System.out.println("Stopping input as a negative number"+userInput+" was entered.");
                break; 
            }else if (userInput == 0) {
                System.out.println("Stopping input as 0 was entered.");
                break;

            }

            
            if (idx >= 10) {
                System.out.println("Maximum numbers reached");
                break; 
            }

            
            numbers[idx] = userInput;
            idx++; 
        }

        scanner.close();

        int numElementsEntered = idx;

        System.out.println("\nNumbers entered:");
        if (numElementsEntered == 0) {
            System.out.println("No valid numbers were entered.");
        } else {
            for (int i = 0; i < numElementsEntered; i++) {
                System.out.printf("%.2f ", numbers[i]); 
            }
            System.out.println(); 
        }

        for (int i = 0; i < numElementsEntered; i++) {
            total = total + numbers[i];
        }

        System.out.printf("Sum of all entered numbers: %.2f\n", total);
    }
}

