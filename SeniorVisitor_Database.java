package my_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class SeniorVisitor_Database {
    private String name;
    private int id;
    private String dateOfBirth;
    private Connect c;

    public SeniorVisitor_Database(String name, int id, String dateOfBirth) {
        this.name = name;
        this.id = id;
        this.dateOfBirth = dateOfBirth;
        this.c = new Connect();
    }

    

    public void insertVisitor() {
        String query = "INSERT INTO SeniorVisitor (Name, ID, [Date of Birth]) VALUES (?, ?, ?)";
        try {
            Connection conn = c.getConnection();
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, this.name);
                ps.setInt(2, this.id);
                ps.setString(3, dateOfBirth); // Format date before inserting
                ps.executeUpdate();
                System.out.println("Visitor added successfully");
            } else {
                System.out.println("Connection to database failed.");
            }
        } catch (SQLException e) {
            System.out.println("Error while inserting visitor");
            System.out.println(e.getMessage());
        }
    }

    public ResultSet fetchVisitors() {
        String query = "SELECT * FROM SeniorVisitor";
        try {
            Connection conn = c.getConnection();
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(query);
                return ps.executeQuery();
            } else {
                System.out.println("Connection to database failed.");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error while fetching visitors");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void displayVisitors() {
        ResultSet rs = fetchVisitors();
        if (rs == null) {
            System.out.println("No data found in the SeniorVisitor table or failed to fetch data.");
            return;
        }

        try {
            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                int id = rs.getInt("ID");
                String name = rs.getString("Name");
                String dateOfBirth = rs.getString("Date of Birth");
                System.out.println("ID: " + id + ", Name: " + name + ", Date of Birth: " + dateOfBirth);
            }
            if (!hasData) {
                System.out.println("The SeniorVisitor table is empty.");
            }
        } catch (SQLException e) {
            System.out.println("Error while displaying visitors");
            System.out.println(e.getMessage());
        }
    }

    public void deleteVisitorById(int visitorId) {
        String query = "DELETE FROM SeniorVisitor WHERE ID = ?";
        try {
            Connection conn = c.getConnection();
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, visitorId);
                int affectedRows = ps.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Visitor with ID " + visitorId + " deleted successfully.");
                    shiftVisitorsUp();
                } else {
                    System.out.println("Visitor with ID " + visitorId + " not found.");
                }
            } else {
                System.out.println("Connection to database failed.");
            }
        } catch (SQLException e) {
            System.out.println("Error while deleting visitor");
            System.out.println(e.getMessage());
        }
    }

    private void shiftVisitorsUp() {
        String query = "UPDATE SeniorVisitor SET ID = ID - 1 WHERE ID > ?";
        try {
            Connection conn = c.getConnection();
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, id);
                ps.executeUpdate();
                System.out.println("Visitors shifted up successfully.");
            } else {
                System.out.println("Connection to database failed.");
            }
        } catch (SQLException e) {
            System.out.println("Error while shifting visitors");
            System.out.println(e.getMessage());
        }
    }

    public void updateVisitor(int visitorId, String newName, int newId, String newDateOfBirth) {
        String query = "UPDATE SeniorVisitor SET Name = ?, ID = ?, [Date of Birth] = ? WHERE ID = ?";
        try {
            Connection conn = c.getConnection();
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, newName);
                ps.setInt(2, newId);
                ps.setString(3,newDateOfBirth); // Format date before updating
                ps.setInt(4, visitorId);
                int affectedRows = ps.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Visitor updated successfully.");
                } else {
                    System.out.println("Visitor with ID " + visitorId + " not found.");
                }
            } else {
                System.out.println("Connection to database failed.");
            }
        } catch (SQLException e) {
            System.out.println("Error while updating visitor");
            System.out.println(e.getMessage());
        }
    }

    // Add the search function
    public ResultSet searchVisitorById(int visitorId) {
        String query = "SELECT * FROM SeniorVisitor WHERE ID = ?";
        try {
            Connection conn = c.getConnection();
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, visitorId);
                return ps.executeQuery();
            } else {
                System.out.println("Connection to database failed.");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error while searching for visitor");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
