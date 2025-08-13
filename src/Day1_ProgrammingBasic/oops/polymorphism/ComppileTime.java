package oops.polymorphism;
interface Animals{
	public void makeSound();
}
class Horse implements Animals{
	public void makeSound() {
		System.out.println("neigh");
	}
}
class Lion implements Animals{
	public void makeSound() {
		System.out.println("Roar");
	}
}
public class ComppileTime {
	public static void main(String[] args) {
		Animals horse=new Horse();
		Animals lion=new Lion();
		horse.makeSound();
		lion.makeSound();
	}

}
