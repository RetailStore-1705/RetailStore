import java.sql.*;
import javax.sql.StatementEvent;
import java.util.Scanner;
import java.lang.Exception;

public class DAO_Main {
    public static DAO_Factory daoFactory;
	public static void main(String[] args) {
		try{
			daoFactory = new DAO_Factory();

            while(true)
            {
                System.out.println("Welcome to our store!");
                System.out.println("Are you a 1)Customer or an 2)Employee (type the number):");
                Integer person = inputclass.in.nextInt();

                if(person == 1)
                {
                    customerInterface();
                }
                else if (person == 2)
                {
                    employeeInterface();
                }
                else
                {
                    System.out.println("Invalid input.");
                    continue;
                }


			    // System.out.println("Running usecase1");
			    // usecase_insert1();

			    // System.out.println("Running usecase2");
			    // usecase_insert2();
            }


		}catch(Exception e){
				//Handle errors for Class.forName
				e.printStackTrace();
		}
	}
	//end main

public static Integer generateTransactionID()
{
    int transID;
    String sql,check;
    Statement stmt = null;

    try
    {
        stmt = dbConnection.createStatement();
        sql = "select max(transactionID) from Transaction ";
        check = "select count(*) from Transaction";
		ResultSet rs = stmt.executeQuery(check);
        rs.next();
        int count = rs.getInt(1);
        if(count == 0)
        {
            transID = 100;
        }
        else
        {
            rs = stmt.executeQuery(sql);
            rs.next();
            int max = rs.getInt(1);
            transID = max+1;
        }

        return transID;
    }
    catch (SQLException ex) {
        // handle any errors
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }
}

public static Integer getNewCustomerID()
{
    int custID;
    String sql,check;
    Statement stmt = null;

    try
    {
        stmt = dbConnection.createStatement();
        sql = "select max(customerID) from Customer ";
        check = "select count(*) from Customer";
		ResultSet rs = stmt.executeQuery(check);
        rs.next();
        int count = rs.getInt(1);
        if(count == 0)
        {
            custID = 1;
        }
        else
        {
            rs = stmt.executeQuery(sql);
            rs.next();
            int max = rs.getInt(1);
            custID = max+1;
        }

        return custID;
    }
    catch (SQLException ex) {
        // handle any errors
        System.out.println("SQLException: " + ex.getMessage());
        System.out.println("SQLState: " + ex.getSQLState());
        System.out.println("VendorError: " + ex.getErrorCode());
    }
}


public static void customerInterface()
{
    
    try
    {
        CustPortalDAO_JDBC cpdj;
        getCustPortalDAO() 
        System.out.println("Have you been to this store before? (Yes or No)");
        String ans = inputclass.in.next();
        Integer custID;
        if(ans.equals("Yes") || ans.equals("yes"))
        {
            System.out.println("Please enter your Customer ID:");
            custID = inputclass.in.nextInt();
        }
        else if(ans.equals("No") || ans.equals("no"))
        {
            custID = getNewCustomerID();
        }
        daoFactory.activateConnection();
        CustomerPortalDAO cpd = daoFactory.getCustPortalDAO();
        cpd.getCustomer(custID);
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }
}

public static void employeeInterface()
{

}

    public static void usecase_insert1()
{

}

public static void usecase_insert2()
{
    
}

public static void usecase_insert3()
{
    
}

}

class inputclass
{
    static Scanner in = new Scanner(System.in);
}

