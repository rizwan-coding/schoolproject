package Details;

import java.sql.*;
import java.util.Scanner;

public class DeleteAdmission {
    private Connection con;
    private Scanner s1;
    private PreparedStatement ps;

    
     // Constructor to initialize variables and call the deleteAdmission method
    public DeleteAdmission(Connection con, Scanner s1, PreparedStatement ps) {
        this.s1 = s1;
        this.con = con;
        this.ps = ps;
       
        deleteAdmission(); // Call method to delete an admission record
    }

     // Method to delete an admission record from the database
    public void deleteAdmission() {
        try {
           s1.nextLine();
            System.out.println("Enter the Student ID to delete admission record:");
            String sId = s1.nextLine();

              // SQL query to delete the admission record where ID matches
            String query = "DELETE FROM addmissions WHERE id = ?";
            
            ps = con.prepareStatement(query);
            ps.setString(1,sId);
            
             // Execute the delete operation and store the result
             
            int result = ps.executeUpdate(); 

            if (result > 0) {
                System.out.println("Admission record deleted successfully!");
            } else {
                System.out.println("No record found with ");
            }
        } catch (SQLException e) {
            System.out.println("Error deleting admission: " + e.getMessage());
        }
    }
}
