import java.util.Scanner;

public class CountdownFor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter countdown start: ");
        int counter = sc.nextInt();

        for (int i = counter; i >= 1; i--) {
            System.out.println(i);
        }

        System.out.println("Lift off!");
    }
}
