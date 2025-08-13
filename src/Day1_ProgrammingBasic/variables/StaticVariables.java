package variables;

public class StaticVariables {
	static int x=10;
	static String name="vikash";
	static int y;
	static String name2;
	static boolean check;
	public static void main(String[] args) {
		System.out.println(x);
		m1();
		System.out.println(name);
		m2();
		
		defaultVal();
	}
	public static void m1() {
		System.out.println(x);
		x=12;
		System.out.println(x);
	}
	public static void m2() {
		System.out.println(name);
		name="Anu";
		System.out.println(name);
	}
	public static void defaultVal() {
		System.out.println(y);
		System.out.println(name2);
		System.out.println(check);

	}
}
