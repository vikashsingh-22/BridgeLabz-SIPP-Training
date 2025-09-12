import java.util.*;
public class Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        find(n);     
    }
    private static void find(int n){
        int a=0;
        int b=1;
        System.out.print(a+" "+b+" ");
        for(int i=0;i<n;i++){
            int c=a+b;
            a=b;
            b=c;
            System.out.print(c+" ");
        }
    }
}
