package oops.Inheritance;

class Vehicles{
	protected String brand="Mahindra";
	public void showBrand() {
		System.out.println(brand);
	}
}
class Carr extends Vehicles{
	public void numberOfWheel() {
		System.out.println("Four");
	}
}
class ElectricCar extends Carr{
	public String model="XUV400 EV";
	public void showModel() {
		System.out.println(model);
	}
	public void price() {
		System.out.println("₹15.49");
	}
	public void batteryPower() {
		System.out.println("39.4kWh");
	}
	public void range() {
		System.out.println("375km and 456km");
	}
}
public class MultilevelInheritance {

	public static void main(String[] args) {
		ElectricCar ev=new ElectricCar();
		ev.showBrand();
		ev.numberOfWheel();
		ev.showModel();
		ev.price();
		ev.batteryPower();
		ev.range();
	}

}
