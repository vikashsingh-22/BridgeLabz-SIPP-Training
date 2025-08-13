package oops.polymorphism;
class Animal{
	public void makeSound() {
		System.out.print("Generic Sound");
	}
}
class Cow extends Animal{
	@Override
	public void makeSound() {
		System.out.println("Moo");
	}
}
public class Runtime {
	public static void main(String[] args) {
		Animal cow=new Cow();
		cow.makeSound();
	}

}
