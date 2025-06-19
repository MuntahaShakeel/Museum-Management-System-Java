package my_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.io.File;

public class Connect {
    private static final String dbLoc = "jdbc:ucanaccess://Museum_Management_System.accdb";
    private Connection conn;
    private PreparedStatement prepState;
    private ResultSet rSet;

    public Connect() {
        if (!checkFileExists(dbLoc)) {
            System.out.println("Database file not found at: " + dbLoc);
            return;
        }

        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            conn = DriverManager.getConnection(dbLoc);
            System.out.println("Connection Established!");
        } catch (ClassNotFoundException e) {
            System.out.println("Ucanaccess driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Error while connecting to Database");
            e.printStackTrace();
        }
    }

    private boolean checkFileExists(String dbPath) {
        // Remove the "jdbc:ucanaccess://" prefix to get the actual file path
        String filePath = dbPath.substring("jdbc:ucanaccess://".length());
        File file = new File(filePath);
        return file.exists();
    }

    public Connection getConnection() {
        return conn;
    }

    public ResultSet runSelect(String query) {
        if (conn == null) {
            System.out.println("Database connection is null");
            return null;
        }

        try {
            prepState = conn.prepareStatement(query);
            rSet = prepState.executeQuery(query);
            return rSet;
        } catch (SQLException e) {
            System.out.println("Error while running query");
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void runDML(String query) {
        if (conn == null) {
            System.out.println("Database connection is null");
            return;
        }

        try {
            prepState = conn.prepareStatement(query);
            prepState.executeUpdate(query);
            System.out.println("Run successfully");
        } catch (SQLException e) {
            System.out.println("Error while running query");
            System.out.println(e.getMessage());
        }
    }
}
