package variables;

public class InstanceVariable {
	int x=10;
	int y;
	String name;
	boolean check;
	public static void main(String [] args) {
		InstanceVariable ob1=new InstanceVariable();
		System.out.println(ob1.x);
		ob1.x=20;//change globally
		System.out.println(ob1.x);
		ob1.m1();
		ob1.m2();
		
		ob1.defaultVal();

	}
	public void m1() {
		System.out.println(x);
	}
	public void m2() {
		x=12;//change inside this block
		System.out.println(x);
	}
	public void defaultVal() {
		System.out.println(y);//0
		System.out.println(name);//null
		System.out.println(check);//false
	}
}
