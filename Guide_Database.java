package my_package;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Guide_Database {
    private String name;
    private int id;
    private String language;
    private Connect c;

    public Guide_Database(String name, int id, String language) {
        this.name = name;
        this.id = id;
        this.language = language;
        this.c = new Connect();
    }

    public void insertGuide() {
        String query = "INSERT INTO guide (name, id, language) VALUES (?, ?, ?)";
        try {
            Connection conn = c.getConnection();
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, this.name);
                ps.setInt(2, this.id);
                ps.setString(3, this.language);
                ps.executeUpdate();
                System.out.println("Guide added successfully");
            } else {
                System.out.println("Connection to database failed.");
            }
        } catch (SQLException e) {
            System.out.println("Error while inserting guide");
            System.out.println(e.getMessage());
        }
    }

    public ResultSet fetchGuides() {
        String query = "SELECT * FROM guide";
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
            System.out.println("Error while fetching guides");
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void displayGuides() {
        ResultSet rs = fetchGuides();
        if (rs == null) {
            System.out.println("No data found in the Guide table or failed to fetch data.");
            return;
        }

        try {
            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String language = rs.getString("language");
                System.out.println("ID: " + id + ", Name: " + name + ", Language: " + language);
            }
            if (!hasData) {
                System.out.println("The Guide table is empty.");
            }
        } catch (SQLException e) {
            System.out.println("Error while displaying guides");
            System.out.println(e.getMessage());
        }
    }

    public void deleteGuideById(int guideId) {
        String query = "DELETE FROM guide WHERE id = ?";
        try {
            Connection conn = c.getConnection();
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, guideId);
                int affectedRows = ps.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Guide with ID " + guideId +"deleted successfully.");
                    shiftGuidesUp();
                } else {
                    System.out.println("Guide with ID " + guideId + " not found.");
                }
            } else {
                System.out.println("Connection to database failed.");
            }
        } catch (SQLException e) {
            System.out.println("Error while deleting guide");
            System.out.println(e.getMessage());
        }
    }

    private void shiftGuidesUp() {
        String query = "UPDATE guide SET id = id - 1 WHERE id > ?";
        try {
            Connection conn = c.getConnection();
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, id);
                ps.executeUpdate();
                System.out.println("Guides shifted up successfully.");
            } else {
                System.out.println("Connection to database failed.");
            }
        } catch (SQLException e) {
            System.out.println("Error while shifting guides");
            System.out.println(e.getMessage());
        }
    }

    public void updateGuide(int guideId, String newName, int newId, String newLanguage) {
        String query = "UPDATE guide SET name = ?, id = ?, language = ? WHERE id = ?";
        try {
            Connection conn = c.getConnection();
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, newName);
                ps.setInt(2, newId);
                ps.setString(3, newLanguage);
                ps.setInt(4, guideId);
                int affectedRows = ps.executeUpdate();
                if (affectedRows > 0) {
                    System.out.println("Guide updated successfully.");
                } else {
                    System.out.println("Guide with ID " + guideId + " not found.");
                }
            } else {
                System.out.println("Connection to database failed.");
            }
        } catch (SQLException e) {
            System.out.println("Error while updating guide");
            System.out.println(e.getMessage());
        }
    }

    // Add the search function
    public ResultSet searchGuideById(int guideId) {
        String query = "SELECT * FROM guide WHERE id = ?";
        try {
            Connection conn = c.getConnection();
            if (conn != null) {
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setInt(1, guideId);
                return ps.executeQuery();
            } else {
                System.out.println("Connection to database failed.");
                return null;
            }
        } catch (SQLException e) {
            System.out.println("Error while searching for guide");
            System.out.println(e.getMessage());
            return null;
        }
    }
}
