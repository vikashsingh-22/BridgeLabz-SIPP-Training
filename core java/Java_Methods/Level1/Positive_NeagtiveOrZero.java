package Java_Methods.Level1;

import java.util.Scanner;

public class Positive_NeagtiveOrZero {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number to check");
        int n=sc.nextInt();
        System.out.println(positiveNegativeOrZero(n));
    }
    public static int positiveNegativeOrZero(int n){
        if(n>0){
            return 1;
        }else if(n<0){
            return -1;
        }else{
            return 0;
        }
    }
}
