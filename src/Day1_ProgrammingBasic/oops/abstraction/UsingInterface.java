package oops.abstraction;

interface Animals{
	public void makeSound();
}
class Horse implements Animals{
	public void makeSound() {
		System.out.println("neigh");
	}
}

public class UsingInterface {
	public static void main(String[] args) {
		Animals horse=new Horse();
		horse.makeSound();
	}

}

