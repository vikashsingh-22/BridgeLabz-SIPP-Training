package method;

public class NonStaticChild {

	public static void main(String[] args) {
//		m1();//Error:The method m1() is undefined for the type NonStaticChild
		NonStatic obj=new NonStatic();
		obj.m1();
		
//		NonStaticChild obj1=new NonStaticChild();
//		obj1.m1();/Error:The method m1() is undefined for the type NonStaticChild
		
	}

}
