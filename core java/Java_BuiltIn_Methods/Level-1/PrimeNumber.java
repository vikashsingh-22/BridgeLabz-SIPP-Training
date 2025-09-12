import java.util.*;
public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        boolean c=find(n);
        if(c){
            System.out.print("It is a Prime Number");
        }
        else System.out.print("Not a Prime Number");
    }
    private static boolean find (int n) {
        for(int i=2;i<n/2;i++){
            if(n%i==0)return false;
        }
        return true;
    }
}
