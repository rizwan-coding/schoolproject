package Details;

import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Admission {
    private Connection con;
    private Scanner s1;
    private PreparedStatement ps;

    // Constructor to initialize the class variables and call the addAdmission method
  
    public Admission(Connection con, Scanner s1, PreparedStatement ps) {
        this.s1 = s1;
        this.con = con;
        this.ps = ps;
     
        addAdmission(); // Call the method to add admission details
    }

  
  
   // Method to take input from the user and insert admission details into the database
    public void addAdmission() {
        try {
              s1.nextLine();
            System.out.println("Enter student's name:");
            String student_name =s1.nextLine(); 
           
          
            
            System.out.println("Enter student's age:");
            String age = s1.nextLine(); 
            
            System.out.println("Enter student's grade:");
            String grade = s1.nextLine(); 
            
            System.out.println("Enter student's address:");
            String address = s1.nextLine(); 

            System.out.println("Enter student's phone number:");
            String phoneNumber = s1.nextLine(); 

            System.out.println("Enter student's email:");
            String email = s1.nextLine(); 
            
            
           // SQL query to insert admission details into the database
           String query = "INSERT INTO addmissions (student_name,age, grade, address, phone_number, email) VALUES (?, ?, ?, ?, ?, ?)";
           
            ps = con.prepareStatement(query);

            
            ps.setString(1, student_name);  
            ps.setString(2, age);  
            ps.setString(3, grade);  
            ps.setString(4, address);  
            ps.setString(5, phoneNumber); 
            ps.setString(6, email);  
            
             // Execute the update query and store the result
            int result = ps.executeUpdate(); 

            if (result > 0) {
                System.out.println("Admission added successfully!");
            } else {
                System.out.println("Error adding admission.");
            }
        } catch (SQLException e) {
            System.out.println("Error adding admission: " + e.getMessage());
        }
    }


  

}