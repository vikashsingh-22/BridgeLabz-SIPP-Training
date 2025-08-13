package oops.Encaptulation;

public class Encaptulation {
	String name="Anukalp";
	private int age;
	
	public int getAge() {//Getter
		return age;
	}
	
	public void setAge(int age) {//Setter
		this.age=age;
	}
	

	public static void main(String[] args) {
		Encaptulation obj=new Encaptulation();
		obj.setAge(20);
		System.out.println(obj.getAge());
	}

}
