package my_package;

public class RegularVisitor extends Visitor {

    public RegularVisitor(String name, int id, String dob) {
        super(name, id, dob);
    }

    public RegularVisitor() {
    }

    @Override
    public void bookTour() {
        System.out.println("Your information:");
        System.out.println(super.toString());
        System.out.println("Have a nice day!");
    }

    @Override
    public String toString() {
        return super.toString() + "RegularVisitor ";
    }
 @Override
    public void displayInfo() {
        System.out.println(super.toString() + "Visitor Type: Senior Visitor");
    }
}