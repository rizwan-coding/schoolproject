package Details;

import java.sql.*;
import java.util.Scanner;

public class SearchAdmission {
    private Connection con;
    private Scanner s1;
    private PreparedStatement ps;

 // Constructor to initialize the class and immediately call the searchAdmission method
    public SearchAdmission(Connection con, Scanner s1 ,PreparedStatement ps) {
        this.con = con;
        this.s1 = s1;
        this.ps=ps;
        searchAdmission();
    }

   // Method to search for a student's admission details based on ID and Name  
    public void searchAdmission() {
        try {
               s1.nextLine();
            System.out.println("Enter the Student ID to search Details: ");
            String id = s1.nextLine(); 
                   System.out.println("Enter the  Name to search Details :");
            String  name = s1.nextLine(); 

            // SQL query to search for student details based on ID and Name
            String query = "SELECT * FROM addmissions WHERE id = ? AND student_name = ?";

           
            ps = con.prepareStatement(query);
            ps.setString(1, id);
            ps.setString(2, name); 

             // Check if a record exists in the result set
            ResultSet rs = ps.executeQuery();

          
            if (rs.next()) {
               // SQL query to search for student details based on ID and Name
               
                System.out.println("Student ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("student_name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Grade: " + rs.getString("grade"));
                System.out.println("Address: " + rs.getString("address"));
                System.out.println("Phone Number: " + rs.getString("phone_number"));
                System.out.println("Email: " + rs.getString("email"));
            } else {
                System.out.println("No record found with the provided Student ID or Name.");
            }

            rs.close(); 
        } catch (SQLException e) {
            System.out.println("Error searching admission: " + e.getMessage());
        }
    }
}
