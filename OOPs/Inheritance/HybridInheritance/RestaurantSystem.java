package Inheritance.HybridInheritance;

// Superclass
class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;

    }

    public void displayInfo() {
        System.out.println("Name: " + name + ", ID: " + id);
    }
}

// Interface
interface Worker {
    void performDuties();
}

// Subclass: Chef
class Chef extends Person implements Worker {
    private String specialty;

    public Chef(String name, int id, String specialty) {
        super(name, id);
        this.specialty = specialty;
    }

    @Override
    public void performDuties() {
        System.out.println("Role: Chef");
        displayInfo();
        System.out.println("Specialty: " + specialty);
        System.out.println("Duties: Prepares and cooks food.");
    }
}

// Subclass: Waiter
class Waiter extends Person implements Worker {
    private String shift;

    public Waiter(String name, int id, String shift) {
        super(name, id);
        this.shift = shift;
    }

    @Override
    public void performDuties() {
        System.out.println("Role: Waiter");
        displayInfo();
        System.out.println("Shift: " + shift);
        System.out.println("Duties: Serves food and assists customers.");
    }
}

// Main class
public class RestaurantSystem {
    public static void main(String[] args) {
        Chef chef = new Chef("Gordon Ramsay", 101, "Italian Cuisine");
        Waiter waiter = new Waiter("John Doe", 202, "Evening");

        chef.performDuties();
        System.out.println("-------------------------");
        waiter.performDuties();
    }
}
// This code demonstrates hybrid inheritance by combining a superclass (Person) with an interface (Worker).
// The Chef and Waiter classes inherit from Person and implement the Worker interface, showcasing both inheritance and polymorphism.
// The main method creates instances of Chef and Waiter, calling their performDuties methods to display their roles and responsibilities in a restaurant setting.
// This structure allows for easy extension in the future, such as adding more roles like Manager or Bartender, while maintaining a clear hierarchy and interface for worker duties.
// The use of an interface allows for flexibility in defining duties, which can be implemented differently by each subclass.
// This example illustrates the principles of hybrid inheritance effectively, showcasing how different types of relationships can