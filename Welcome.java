package main;
import java.util.Scanner;
import aa.Loginpage;



 
public class Welcome {
    public static void main(String[] args)
    {
        Scanner  s1= new Scanner(System.in);
        Loginpage obj= new Loginpage(s1);
       obj.insert();
       obj.validate();
        
    }
            
    
}
