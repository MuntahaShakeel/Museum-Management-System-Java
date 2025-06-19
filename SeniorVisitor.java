package my_package;

public class SeniorVisitor extends Visitor {
    private int recordId;
    private int visitsCount;

    public SeniorVisitor(String name, int id, String dob, int recordId, int visitsCount) {
        super(name, id, dob);
        this.recordId = recordId;
        this.visitsCount = visitsCount;
    }

    public SeniorVisitor() {
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getVisitsCount() {
        return visitsCount;
    }

    public void setVisitsCount(int visitsCount) {
        this.visitsCount = visitsCount;
    }

    @Override
    public void bookTour() {
        System.out.println("Your information:");
        System.out.println(super.toString());
        System.out.println("Have a nice day!");
    }

    @Override
    public String toString() {
        return super.toString() + "SeniorVisitor\n" +
                "Record ID: " + recordId + "\n" +
                "Visits Count: " + visitsCount + "\n" +
                "You will be given a 20% discount on the ticket! Enjoy and have a nice day..";
    }
     @Override
    public void displayInfo() {
        System.out.println(super.toString() + "Visitor Type: Senior Visitor");
    }
}