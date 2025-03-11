package Details;

import java.sql.*;
import java.util.Scanner;

public class ShowData {
    private Connection con;
    private Scanner s1;
    private PreparedStatement ps;

     // Constructor to initialize the class and call the ShowData method
    public ShowData(Connection con, Scanner s1, PreparedStatement ps) {
        this.con = con;
        this.s1 = s1;
        this.ps = ps;
        ShowData();
    }
// Method to retrieve and display all admission records from the database
    public void ShowData() {
        try {
            // SQL query to select all records from the admissions table
            String query = "SELECT * FROM addmissions";

            
            ps = con.prepareStatement(query);

            // Execute the query and store the result set
            ResultSet rs = ps.executeQuery();
            
              // Boolean flag to check if any records exist
            boolean foundRecord = false;

         // Loop through the result set and print each student's details
            while (rs.next()) {
                foundRecord = true;
              
                System.out.println("Student ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("student_name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Grade: " + rs.getString("grade"));
                System.out.println("Address: " + rs.getString("address"));
                System.out.println("Phone Number: " + rs.getString("phone_number"));
                System.out.println("Email: " + rs.getString("email"));
                System.out.println("-----------------------------------------");
            }

            if (!foundRecord) {
                System.out.println("No records found in the admissions table.");
            }

           
            rs.close();
        } catch (SQLException e) {
      // Handle any SQL exceptions and print the error message
            System.out.println("Error searching admission: " + e.getMessage());
        } 
    }
}