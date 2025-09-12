import java.util.*;
public class Palindrome {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String st=sc.nextLine();
        char[] ch=st.toCharArray();
        boolean b = check(ch);
        display(b);
    }

    private static boolean check(char[] ch){
        int a=ch.length/2;
        int b=ch.length-1;
        for(int i=0;i<a;i++){
            if(ch[i]!=ch[b])return false;
            else{
                b--;
            }
        }
        return true;
    }

    private static void display(boolean b){
        if(b)System.out.print("Its a Palindrome");
        else System.out.print("It's Not a palendrome");
    }
}
