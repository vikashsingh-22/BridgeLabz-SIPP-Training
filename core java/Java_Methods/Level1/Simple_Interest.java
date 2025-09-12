package Java_Methods.Level1;

import java.util.Scanner;

public class Simple_Interest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the principal amount:");
        int p=sc.nextInt();
        System.out.println("Enter the rate of interest:");
        int r=sc.nextInt();
        System.out.println("Enter the time period:");
        int t=sc.nextInt();
        System.out.println("The simple interest is:"+Simpleinterest(p, r, t));
    }
    public static double Simpleinterest(double p, double r, double t){
        return (p*r*t)/100;
    }
}
