
package Details;

import java.sql.*;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Update {
     private Connection con;
    private Scanner s1;
    private PreparedStatement ps;
  
  
    // Constructor to initialize the class and call the updateAdmission method
    public Update(Connection con, Scanner s1, PreparedStatement ps) {
        this.s1 = s1;
        this.con = con;
        this.ps = ps;
      
        updateAdmission();
    }
      
        
  
        // Method to update an existing student's admission details
     public void updateAdmission() {
        try {
            System.out.println("Enter student's ID to update:");
            int Id = s1.nextInt();
            s1.nextLine(); 

    System.out.println("Enter new student's name ");
    String student_name = s1.nextLine();

    System.out.println("Enter new student's age ");
    String age = s1.nextLine();

    System.out.println("Enter new student's grade ");
    String grade = s1.nextLine();

    System.out.println("Enter new student's address ");
    String address = s1.nextLine();
 System.out.println("Enter new student's phone number");
       String phoneNumber = s1.nextLine();

      System.out.println("Enter new student's email :");
       String email = s1.nextLine();

   // Building the dynamic SQL UPDATE query based on provided values 
   
        StringBuilder queryBuilder = new StringBuilder("UPDATE addmissions SET ");
        boolean isFirst = true;
          // Append fields to update only if values are provided
          
            if (!student_name.isEmpty()) {
                queryBuilder.append("student_name = ? ");
                isFirst = false;
            }
            if (!age.isEmpty()) {
                if (!isFirst) queryBuilder.append(", ");
                queryBuilder.append("age = ? ");
                isFirst = false;
            }
            if (!grade.isEmpty()) {
                if (!isFirst) queryBuilder.append(", ");
                queryBuilder.append("grade = ? ");
                isFirst = false;
            }
            if (!address.isEmpty()) {
                if (!isFirst) queryBuilder.append(", ");
                queryBuilder.append("address = ? ");
                isFirst = false;
            }
            if (!phoneNumber.isEmpty()) {
                if (!isFirst) queryBuilder.append(", ");
                queryBuilder.append("phone_number = ? ");
                isFirst = false;
            }
            if (!email.isEmpty()) {
                if (!isFirst) queryBuilder.append(", ");
                queryBuilder.append("email = ? ");
            }
            
            // Adding the WHERE condition to update only the record with the given ID

            queryBuilder.append("WHERE id = ?");
            
            ps = con.prepareStatement(queryBuilder.toString());

            int index = 1;
                // Set parameters for the prepared statement dynamically
             
            if (!student_name.isEmpty()) {
                ps.setString(index++, student_name);
            }
            if (!age.isEmpty()) {
                ps.setString(index++, age);
            }
            if (!grade.isEmpty()) {
                ps.setString(index++, grade);
            }
            if (!address.isEmpty()) {
                ps.setString(index++, address);
            }
            if (!phoneNumber.isEmpty()) {
                ps.setString(index++, phoneNumber);
            }
            if (!email.isEmpty()) {
                ps.setString(index++, email);
            }
             // Set the Student ID in the WHERE clause
            ps.setInt(index, Id); 
            
              // Execute the update operation
              
            int result = ps.executeUpdate();
            
            if (result > 0) {
                System.out.println("Admission updated successfully!");
            } else {
                System.out.println("Error updating admission.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating admission: " + e.getMessage());
        }
    }
}   
     

