import java.util.Scanner;

public class PowerCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter base: ");
        double base = sc.nextDouble();
        System.out.print("Enter exponent: ");
        double exp = sc.nextDouble();
        double result = Math.pow(base, exp);
        System.out.println(base + " raised to " + exp + " = " + result);
        sc.close();
    }
}