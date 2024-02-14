package studentproject;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
class studentdata
{
    String Name;
    String Class;
    String Division;
    int Password;
    void features()
    {
        System.out.println("1.Add Student:");
        System.out.println("2.Update Student:");
        System.out.println("3.See Details Of Student:");
        System.out.println("4.Delete Student:");
    }
    void NameSetter(String name1,String class1,String division1,int password1)
    {
        this.Name=name1;
        this.Class=class1;
        this.Division=division1;
        this.Password=password1;
    }
}
class Studentproject
{
    static String URL="jdbc:mysql://localhost/studentproject";
    static String username="root";
    static String userpassword="";
    public static void main(String[] args)
    {
        studentdata sd=new studentdata();
        Scanner enter=new Scanner(System.in);
        System.out.println("This Is The Student Database Programme:");
        System.out.println();
        sd.features();
        System.out.println();
        System.out.print("Choose Your Utility By Number:\t");
        int choose=enter.nextInt();
        switch(choose)
        {
            case 1:
                System.out.println();
                System.out.println("-------------------------");
                System.out.println("You Are Adding Your Data:");
                System.out.println("-------------------------");
                System.out.println();
                String Name=null,Class=null,Division=null;
                int Password1,Password;
                System.out.print("Add Your Name:\t");
                Name=enter.next();
                System.out.print("Add Your Class:\t");
                Class=enter.next();
                System.out.print("Add Your Division:\t");
                Division=enter.next();
                System.out.println();
                System.out.print("Set 4 Digit Password For Security:\t");
                Password1=enter.nextInt();
                System.out.print("Confirm Password:\t");
                Password=enter.nextInt();
                if(Password1==Password)
                {
                sd.NameSetter(Name,Class,Division,Password);
                try(Connection connect=DriverManager.getConnection(URL,username,userpassword);
                Statement state=connect.createStatement())
                {
                    state.executeUpdate("INSERT INTO studentdata(Name,Class,Division,Pass) value('"+sd.Name+"','"+sd.Class+"','"+sd.Division+"','"+sd.Password+"')");
                    System.out.println();
                    System.out.println("Your Details Is Successfully Saved");
                }
            catch(SQLException e)
            {
                System.out.println(e.getMessage());
            }
                }
                else
                {
                    System.out.println();
                    System.out.println("Their Is A Password Problem Maybe\nThey Both Are Not Equal Start The Process Again::");
                }
            break;
            case 2: 
                System.out.println();
                System.out.println("------------------------------");
                System.out.println("You Are Updating Your Details:");
                System.out.println("------------------------------");
                System.out.println();
                System.out.println("What You Want To Update:");
                System.out.println();
                System.out.println("1.Name");
                System.out.println("2.Class");
                System.out.println("3.Division");
                System.out.println();
                System.out.print("Enter Your Utility By Feature Numbers:\t");
                int utility=enter.nextInt();
                if(utility==1)
                {
                    System.out.println();
                    System.out.print("Enter Old Name:\t");
                    String OldName=enter.next();
                    System.out.print("Enter New Name:\t");
                    String NewName=enter.next();
                    System.out.println();
                    System.out.print("Enter A Password For Identification:");
                    String Pass=enter.next();
                    String serverpassword;
                    try(Connection connect=DriverManager.getConnection(URL,username,userpassword);Statement state=connect.createStatement())
                    {
                        PreparedStatement ps=connect.prepareStatement("SELECT Pass From studentdata WHERE Pass=?");
                        ps.setString(1,Pass);
                        ResultSet set=ps.executeQuery();
                        while(set.next())
                        {
                         serverpassword=set.getString("Pass");
                        if(Pass.equals(serverpassword))
                        {
                        state.executeUpdate("UPDATE studentdata SET Name='"+NewName+"' WHERE Name='"+OldName+"'");
                        System.out.println();
                        System.out.println("Your Name Is Successfully Updated:");
                        }
                        else if(Pass!=serverpassword)
                        {
                            System.out.println("There Is A Password Problem:");
                        }
                        }
                    }
                    catch(SQLException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
                else if(utility==2)
                {
                    System.out.println();
                    System.out.print("Enter Old Class:\t");
                    String OldClass=enter.next();
                    System.out.print("Enter New Class:\t");
                    String NewClass=enter.next();
                    System.out.println();
                    System.out.print("Enter Password For Identification:\t");
                    String Pass=enter.next();
                    String serverpassword;
                    try(Connection connect=DriverManager.getConnection(URL,username,userpassword);Statement state=connect.createStatement())
                    {
                         PreparedStatement ps=connect.prepareStatement("SELECT Pass From studentdata WHERE Pass=?");
                         ps.setString(1,Pass);
                         ResultSet set=ps.executeQuery();
                         while(set.next())
                         {
                          serverpassword=set.getString("Pass");
                         if(Pass.equals(serverpassword))
                         {
                         state.executeUpdate("UPDATE studentdata SET Class='"+NewClass+"' WHERE Class='"+OldClass+"'");
                         System.out.println();
                         System.out.println("Your Name Is Successfully Updated:");
                         }
                         else if(Pass!=serverpassword)
                         {
                             System.out.println("There Is A Password Problem Try Again:");
                         }
                         }
                    }
                    catch(SQLException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
                else if(utility==3)
                {
                    System.out.println();
                    System.out.print("Enter Old Division:\t");
                    String OldDivision=enter.next();
                    System.out.print("Enter New Division:\t");
                    String NewDivision=enter.next();
                    System.out.println();
                    System.out.print("Enter Password For Identification:\t");
                    String Pass=enter.next();
                    String serverpassword;
                    try(Connection connect=DriverManager.getConnection(URL,username,userpassword);Statement state=connect.createStatement())
                    {
                        PreparedStatement ps=connect.prepareStatement("SELECT Pass From studentdata WHERE Pass=?");
                         ps.setString(1,Pass);
                         ResultSet set=ps.executeQuery();
                         while(set.next())
                         {
                          serverpassword=set.getString("Pass");
                         if(Pass.equals(serverpassword))
                         {
                            state.executeUpdate("UPDATE studentdata SET Division='"+NewDivision+"' WHERE Division='"+OldDivision+"'");
                            System.out.println();
                            System.out.println("Your Name Is Successfully Updated:");
                         }
                         else if(Pass!=serverpassword)
                         {
                          System.out.println("There Is A Password Problem Try Again:");   
                         }
                         }
                    }
                    catch(SQLException e)
                    {
                        System.out.println(e.getMessage());
                    }
                }
            break;
            case 3:
            {
                try(Connection connect=DriverManager.getConnection(URL,username,userpassword);
                        Statement state=connect.createStatement())
                {
                    System.out.println();
                    System.out.println("-------------------------");
                    System.out.println("You Are Seeing Your Data:");
                    System.out.println("-------------------------");
                    System.out.println();
                    System.out.print("To See Your Details Enter 4 Digit Password:\t");
                    int password=enter.nextInt();
                    ResultSet set;
                    set= state.executeQuery("SELECT * FROM studentdata WHERE Pass='"+password+"'");
                    while(set.next())
                    {
                       System.out.println();
                       System.out.println("Name Is "+set.getString("Name"));
                       System.out.println("Class Is "+set.getString("Class"));
                       System.out.println("Division Is "+set.getString("Division"));
                       System.out.println();
                   }
                }
                catch(SQLException e)
                {
                    System.out.println(e.getMessage());
                }   
            }
            break;
            case 4:
            {
               System.out.println();
               System.out.println("---------------------------");
               System.out.println("You Are Deleting Your Data:");
               System.out.println("---------------------------");
               System.out.println();
               System.out.println("You Really Want To Delete Your Delete:");
               System.out.println();
               System.out.println("1.Yes:");
               System.out.println("2.No:");
               System.out.println();
               System.out.print("Enter Your Confirmation By Number:\t");
               int choice=enter.nextInt();
               if(choice==1)
               {
                   try(Connection connect=DriverManager.getConnection(URL,username,userpassword);Statement state=connect.createStatement())
                   {
                       System.out.println();
                       System.out.print("Enter Your Password To Delete Details:\t");
                       int password=enter.nextInt();
                       state.executeUpdate("DELETE FROM studentdata WHERE Pass='"+password+"'");
                       System.out.println();
                       System.out.println("Your Data Is Successfully Deleted:");
                   }
                   catch(SQLException e)
                   {
                       System.out.println(e.getMessage());
                   }
               }
               else if(choice==2)
               {
                   System.out.println("Ok No Problem:");
               }
            }
            break;
            default:
                System.out.println("There Is Some Problem:");
                break;
        }
    }
}