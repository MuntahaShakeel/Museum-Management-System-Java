package my_package;

abstract class Visitor {
    private String name;
    private int id;
    private String dob;

    public Visitor() {
    }

    public Visitor(String name, int id, String dob) {
        this.name = name;
        this.id = id;
        this.dob = dob;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getDob() {
        return dob;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    // Abstract method
    public abstract void bookTour();
 public abstract void displayInfo();
    @Override
    public String toString() {
        return "Visitor information: " +"\n"+
                "name: " + name + '\'' +
                "Visitor id: " + id + '\'' +
                "Visitor's date of birth: " + dob + '\'' ;
    }
}
