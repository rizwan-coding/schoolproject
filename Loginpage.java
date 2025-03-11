
package aa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Loginpage
{
    String un,pass;
    Scanner s1;
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int no=1;
    static String coun_name;
    
    public Loginpage(Connection con,Scanner s1,PreparedStatement ps)
    {
        this.con=con;
        this.s1=s1;
        this.ps=ps;
        
         do
        {
        insert();
        no++;
        
        
        }while(no<=5);
      
    }
    public Loginpage(Scanner s1) 
    {
        
        this.s1 = s1;
        try
        {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/app","root", "root");
        
        }
        catch(Exception e)
        {
            System.out.println("Errorr "+e);
        }
        do
        {
        insert();
        no++;
        }while(no<=5);        
    }
    public void insert()
    {
        System.out.println("Enter user name");
        un=s1.next();
        System.out.println("Enter Password");
        pass=s1.next();
        validate();
    
    }
    public void validate()
    {
        try
        {
            ps=con.prepareStatement("select * from stdLogin where un=? and pass=?");
            ps.setString(1, un);
            ps.setString(2, pass);
            
            rs=ps.executeQuery();
            
            if(rs.next())
            {
                coun_name=un;
                Menue obj=new Menue (con,s1,ps);
            }
            else
            {
                System.out.println("\n rec not found");
            }
        }
        catch(Exception ee)
        {
            System.out.println("Errorr "+ee);
        }        
    }
}
