package oops.abstraction;

abstract class Animal{
	public abstract void makeSound();
	public void eat() {
		System.out.println("Eating");
	}
}
class Cow extends Animal{
	public  void makeSound() {
		System.out.println("Moo");
	}
}
public class UsingInheritence {
	public static void main(String[] args) {
		Cow cow=new Cow();
		cow.makeSound();
		cow.eat();
	}

}
