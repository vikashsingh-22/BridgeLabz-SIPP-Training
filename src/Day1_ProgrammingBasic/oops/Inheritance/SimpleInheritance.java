package oops.Inheritance;
class Vehicle{
	protected String brand="Ford";
	public void showBrand() {
		System.out.println(brand);
	}
}
class Car extends Vehicle  {
	public String model="Mustang";
	public void  showModel() {
		System.out.println(model);
	}
	public void sound() {
		System.out.println("Honk Honk!");
	}
}

public class SimpleInheritance {
	public static void main(String[] args) {
		Car obj=new Car();
		obj.showBrand();//Honk Honk!		
		obj.showModel();
		obj.sound();
//		Car obj1=new Vehicle();//Error
		Vehicle obj2=new Car();// parent ref=new child();
		obj2.showBrand();//Honk Honk!
	}
}
