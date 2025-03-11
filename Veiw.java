package Details;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;
import java.sql.*;

public class Veiw {
    Connection con;
    Scanner s1;
    PreparedStatement ps;

     // Constructor to initialize the class and view school information
    public Veiw(Connection con,Scanner s1,PreparedStatement ps) {
        this.s1=s1;
        this.con=con;
        this.ps=ps;
        viewSchoolInfo();
        try {
             // Load MySQL JDBC Driver
             
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish connection with the database
            
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "root");
            System.out.println(" here is the our school data ");
        } catch (ClassNotFoundException e) {
            
             // Handle exception if the JDBC Driver is not found
            System.out.println("JDBC Driver not found: " + e.getMessage());
            
            
        } catch (SQLException e) 
        {
            // Handle exception if database connection fails
            System.out.println("Error: Could not establish a connection to the database. " + e.getMessage());
        }
    }

   // Method to fetch and display school information from the database
    public void viewSchoolInfo() {
        // SQL query to retrieve school information
        
        String query = "SELECT * FROM school_info";  
        try (Statement stmt = con.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            if (rs.next()) {
                  // Fetching values from the database
                String schoolName = rs.getString("school_name");
                String location = rs.getString("location");
                int establishedYear = rs.getInt("established_year");

                System.out.println("\n---- School Information ----");
                System.out.println("School Name: " + schoolName);
                System.out.println("Location: " + location);
                System.out.println("Established Year: " + establishedYear);
                System.out.println("----------------------------");
            } else {
     
                System.out.println("No school information found.");
            }
        } catch (SQLException e) {
            // Handle SQL exceptions and display error message
            System.out.println("Error fetching school information: " + e.getMessage());
        }
    }


}
