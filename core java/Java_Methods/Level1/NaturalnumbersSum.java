package Java_Methods.Level1;

import java.util.Scanner;

public class NaturalnumbersSum {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of terms");
        int n=sc.nextInt();
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=i;
        }
        System.out.println("Sum of first "+n+" natural numbers is "+sumOfNaturalNumbers(n));

    }
    public static int sumOfNaturalNumbers(int n){
        return n*(n+1)/2;
    }
}
