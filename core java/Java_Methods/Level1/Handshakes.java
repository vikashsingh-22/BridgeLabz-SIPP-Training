package Java_Methods.Level1;

import java.util.Scanner;

public class Handshakes {

    public static int calculateHandshakes(int numberOfStudents) {
        return (numberOfStudents * (numberOfStudents - 1)) / 2;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int students = sc.nextInt();
        System.out.println("Maximum number of handshakes: " + calculateHandshakes(students));

       

        
    }
}
