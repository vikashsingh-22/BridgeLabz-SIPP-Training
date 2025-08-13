package variables;

public class LocalVariable {

	public static void main(String[] args) {
		int x=10;
		System.out.print(x);
		m1();
	}
	public static void m1() {
//		System.out.print(x);Error:x cannot be resolved to a variable
	}
}
