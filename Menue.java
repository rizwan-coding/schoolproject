
package aa;

import Details.Admission;
import Details.DeleteAdmission;
import Details.Update;
import Details.Veiw;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;
import Details.SearchAdmission;
import Details.ShowData;
import javax.swing.text.View;



public class Menue 
{
    Connection con;
    Scanner s1;
    PreparedStatement ps;
   int ch;
   
  
   
   public Menue (Scanner s1)
   {
       this.s1=s1;
       this.show_menu(s1);
   }
 public Menue (Connection con,Scanner s1,PreparedStatement ps)
 {
     this.s1=s1;
     this.con=con;
     this.ps=ps;
        System.out.println("Hello");
        show_menu(s1);
 }
 public void show_menu(Scanner s1)
 {
    System.out.println("\n---- School Information System ----");
            System.out.println("1. View School Information");
            System.out.println("2.Addmission form ");
            System.out.println("3. update information ");
            System.out.println("4. Delete record");
            System.out.println("5. serach student");
            System.out.println("6. Show Student Details ");
            
            System.out.println("7. Logout");
         

     System.out.print("SELECT YOUR CHOICE");
     ch=s1.nextInt();
     
     switch(ch)
     {
         case 1:
             new Veiw(con,s1,ps);
                break;
         case 2:
               new  Admission(con,s1,ps);
                break; 
         case 3:
              new Update(con,s1,ps);
                break;
         case 4:
                new DeleteAdmission(con,s1,ps);
                break; 
         
         case 5:
            new SearchAdmission(con, s1, ps);
                break; 
                
                case 6:
            new ShowData(con, s1, ps);
            
                break; 
         case 7:
              System.out.println("Logout");
                return;
        
              
         default:System.out.println("selct corrcet option");        
     }
 } 
}