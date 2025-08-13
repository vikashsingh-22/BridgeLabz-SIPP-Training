package oops.Inheritance;

class Animal{
	String type="Pet";
	public void showType() {
		System.out.println(type);
	}
}
class Cow extends Animal{
	public void numberOfFeet() {
		System.out.println("Four");
	}
	public void hasHorn() {
		System.out.println("YES");
	}
	public void sound() {
		System.out.println("Moo");
	}
}
class Dog extends Animal{
	public void numberOfFeet() {
		System.out.println("Four");
	}
	public void hasHorn() {
		System.out.println("NO");
	}
	public void sound() {
		System.out.println("Bark");
	}
}
class Cat extends Animal{
	public void numberOfFeet() {
		System.out.println("Four");
	}
	public void hasHorn() {
		System.out.println("NO");
	}
	public void sound() {
		System.out.println("Meow");
	}
}

public class Hierarchical {
	public static void main(String[] args) {
		Cow cow=new Cow();
		Dog dog=new Dog();
		Cat cat=new Cat();
		
		cow.showType();
		cow.numberOfFeet();
		cow.hasHorn();
		cow.sound();
		
		dog.showType();
		dog.numberOfFeet();
		dog.hasHorn();
		dog.sound();
		
		cat.showType();
		cat.numberOfFeet();
		cat.hasHorn();
		cat.sound();
	}

}
