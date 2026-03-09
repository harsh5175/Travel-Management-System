import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Conn {
    public Connection c;
    public Statement s;

    public Conn() {
        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection to the 'tms' database
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/tms", "root", "Suraj15@05");

            // Create Statement object for executing SQL queries
            s = c.createStatement();

            System.out.println("✅ Database Connected Successfully!");

        } catch (Exception e) {
            System.err.println("❌ Database Connection Failed:");
            e.printStackTrace();
        }
    }

    // Optional main method to test the connection
    public static void main(String[] args) {
        new Conn();
    }
}
