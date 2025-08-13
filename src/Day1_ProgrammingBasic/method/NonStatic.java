package method;

public class NonStatic {

	public static void main(String[] args) {
//		m1();//Error:Cannot make a static reference to the non-static method m1() from the type NonStatic
		NonStatic obj=new NonStatic();
		obj.m1();
	}
	public void m1() {
		System.out.print("NonStatic Method");
	}

}
