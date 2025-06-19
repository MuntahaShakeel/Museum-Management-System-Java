package my_package;
import java.util.ArrayList;
import java.util.Scanner;

public class MuseumManagementSystem {
    private ArrayList<RegularVisitor> regularVisitors = new ArrayList<>();
    private ArrayList<SeniorVisitor> seniorVisitors = new ArrayList<>();
    private ArrayList<Visitor> allVisitors = new ArrayList<>();
    private ArrayList<Guide> guides = new ArrayList<>();
    private Scanner scanner;

    public MuseumManagementSystem() {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        MuseumManagementSystem museumSystem = new MuseumManagementSystem();
        museumSystem.runMenu();
    }

    private void runMenu() {
        int choice;
        do {
            System.out.println("\n1. Add Regular Visitor");
            System.out.println("2. Add Senior Visitor");
            System.out.println("3. Delete Visitor");
            System.out.println("4. Search Visitor");
            System.out.println("5. Add Guide");
            System.out.println("6. Delete Guide");
            System.out.println("7. Search Guide");
            System.out.println("8. Display All Visitors");
            System.out.println("9. Display Regular Visitors");
            System.out.println("10. Display Senior Visitors");
            System.out.println("11. Issue ticket");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addRegularVisitor();
                    break;
                case 2:
                    addSeniorVisitor();
                    break;
                case 3:
                    deleteVisitor();
                    break;
                case 4:
                    searchVisitor();
                    break;
                case 5:
                    addGuide();
                    break;
                case 6:
                    deleteGuide();
                    break;
                case 7:
                    searchGuide();
                    break;
                case 8:
                    displayAllVisitors();
                    break;
                case 9:
                    displayRegularVisitors();
                    break;
                case 10:
                    displaySeniorVisitors();
                    break;
                case 11:
                    issueTicket();
                    break;
                case 12:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 12);
        scanner.close();
    }

    private void addRegularVisitor() {
        System.out.println("Enter visitor name:");
        String name = scanner.nextLine();
        System.out.println("Enter visitor ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Enter visitor dob:");
        String dob = scanner.nextLine();

        RegularVisitor visitor = new RegularVisitor(name, id, dob);
        regularVisitors.add(visitor);
        allVisitors.add(visitor); // Add to allVisitors ArrayList
        System.out.println("Regular Visitor added successfully.");
    }

    private void addSeniorVisitor() {
        System.out.println("Enter visitor name:");
        String name = scanner.nextLine();
        System.out.println("Enter visitor ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Enter visitor dob:");
        String dob = scanner.nextLine();
        System.out.println("Enter visitor record ID:");
        int recordId = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Enter visitor visits count:");
        int visitsCount = scanner.nextInt();
        scanner.nextLine();
        SeniorVisitor visitor = new SeniorVisitor(name, id, dob, recordId, visitsCount);
        seniorVisitors.add(visitor);
        allVisitors.add(visitor); 
        System.out.println("Senior Visitor added successfully.");
    }

    private void deleteVisitor() {
        System.out.println("Enter visitor ID to delete:");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Visitor visitor = findVisitorByID(id);
        if (visitor != null) {
            if (visitor instanceof RegularVisitor) {
                regularVisitors.remove(visitor);
            } else if (visitor instanceof SeniorVisitor) {
                seniorVisitors.remove(visitor);
            }
            allVisitors.remove(visitor); // Remove from allVisitors ArrayList
            System.out.println("Visitor deleted successfully.");
        } else {
            System.out.println("Visitor not found.");
        }
    }

    private void searchVisitor() {
        System.out.println("Enter visitor ID to search:");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Visitor visitor = findVisitorByID(id);
        if (visitor != null) {
            System.out.println("Visitor found:");
            System.out.println(visitor);
        } else {
            System.out.println("Visitor not found.");
        }
    }

    private Visitor findVisitorByID(int id) {
        for (RegularVisitor visitor : regularVisitors) {
            if (visitor.getId() == id) {
                return visitor;
            }
        }
        for (SeniorVisitor visitor : seniorVisitors) {
            if (visitor.getId() == id) {
                return visitor;
            }
        }
        return null;
    }

    private void addGuide() {
        System.out.println("Enter guide name:");
        String name = scanner.nextLine();
        System.out.println("Enter guide ID:");
        int id = scanner.nextInt();
        scanner.nextLine(); 
        System.out.println("Enter guide language:");
        String language = scanner.nextLine();

        Guide guide = new Guide(name, id, language);
        guides.add(guide);
        System.out.println("Guide added successfully.");
    }

    private void deleteGuide() {
        System.out.println("Enter guide ID to delete:");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Guide guide = findGuideByID(id);
        if (guide != null) {
            guides.remove(guide);
            System.out.println("Guide deleted successfully.");
        } else {
            System.out.println("Guide not found.");
        }
    }

    private void searchGuide() {
        System.out.println("Enter guide ID to search:");
        int id = scanner.nextInt();
        scanner.nextLine(); 

        Guide guide = findGuideByID(id);
        if (guide != null) {
            System.out.println("Guide found:");
            System.out.println(guide);
        } else {
            System.out.println("Guide not found.");
        }
    }

    private Guide findGuideByID(int id) {
        for (Guide guide : guides) {
            if (guide.getId() == id) {
                return guide;
            }
        }
        return null;
    }

    private void displayAllVisitors() {
        System.out.println("\nDisplaying All Visitors:");
        for (Visitor visitor : allVisitors) {
            System.out.println(visitor);
        }
    }

    private void displayRegularVisitors() {
        System.out.println("\nDisplaying Regular Visitors:");
        for (RegularVisitor visitor : regularVisitors) {
            System.out.println(visitor);
        }
    }

    private void displaySeniorVisitors() {
        System.out.println("\nDisplaying Senior Visitors:");
        for (SeniorVisitor visitor : seniorVisitors) {
            System.out.println(visitor);
        }
    }
    private void issueTicket() {
    System.out.println("\n1. Regular Visitor");
    System.out.println("2. Senior Visitor");
    System.out.print("Enter visitor type (1 or 2): ");
    int visitorTypeChoice = scanner.nextInt();
    scanner.nextLine(); 

    System.out.print("Enter visitor ID: ");
    int visitorID = scanner.nextInt();
    scanner.nextLine(); 

    Visitor visitor = findVisitorByID(visitorID);
    if (visitor == null) {
        System.out.println("Visitor not found. Please register first!");
        return; 
    }

    int ticketPrice;
    if (visitorTypeChoice == 1) {
        System.out.println("Regular Visitor selected.");
        ticketPrice = 100; 
    } else if (visitorTypeChoice == 2) {
        System.out.println("Senior Visitor selected.");
        System.out.println("You will be given a discount.");
        ticketPrice = 80; 
    } else {
        System.out.println("Invalid visitor type.");
        return; 
    }

    // This is where the ticketTypeChoice variable should be declared and used
    System.out.println("\n1. One Time Ticket");
    System.out.println("2. Multi Time Ticket");
    System.out.print("Enter ticket type (1 or 2): ");
    int ticketTypeChoice = scanner.nextInt();
    scanner.nextLine(); 

    if (ticketTypeChoice == 1) {
        System.out.println("Issuing One Time Ticket...");
        OneTimeTicket ticket = new OneTimeTicket("Today", ticketPrice);
        System.out.println("Your ticket has been issued.");
        System.out.println("You can take your ticket from the counter now.");
        System.out.println("Ticket details: " + ticket);
        visitor.displayInfo(); // Display visitor info after issuing ticket
    } else if (ticketTypeChoice == 2) {
        System.out.println("Issuing Multi Time Ticket...");
        System.out.println("\n1. Weekly");
        System.out.println("2. Monthly");
        System.out.print("Enter ticket duration (1 or 2): ");
        int durationChoice = scanner.nextInt();
        scanner.nextLine(); 

        TicketType ticketType = (durationChoice == 1) ? TicketType.MULTI_TIME_WEEKLY : TicketType.MULTI_TIME_MONTHLY;
        MultiTimeTicket ticket = new MultiTimeTicket("Today", ticketPrice, ticketType);
        System.out.println("Your ticket has been issued.");
        System.out.println("You can take your ticket from the counter now.");
        System.out.println("Ticket details: " + ticket);
        visitor.displayInfo(); // Display visitor info after issuing ticket
    } else {
        System.out.println("Invalid ticket type.");
    }
}
}