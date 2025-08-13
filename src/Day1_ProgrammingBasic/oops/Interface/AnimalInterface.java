package oops.Interface;

interface Animal{
	public void makeSound();
}
class Horse implements Animal{
	public void makeSound() {
		System.out.println("neigh");
	}
}
class Lion implements Animal{
	public void makeSound() {
		System.out.println("Roar");
	}
}
public class AnimalInterface {
	public static void main(String[] args) {
		Animal horse=new Horse();
		Animal lion=new Lion();
		horse.makeSound();
		lion.makeSound();
	}

}

