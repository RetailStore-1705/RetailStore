import java.sql.*;

import javax.sql.StatementEvent;
public class CustPortalDAO_JDBC implements CustomerPortalDAO{

    Connection dbConnection;

    public CustPortalDAO_JDBC(Connection dbconn)
	{
        
		// JDBC driver name and database URL
 		//  Database credentials
		dbConnection = dbconn;
	}

    public void OrderItemsByPrice()
    {
        String sql;
        Statement stmt = null;

        try{
			stmt = dbConnection.createStatement();
			sql = "select productName, price, quantity from Inventory order by price";
			ResultSet rs = stmt.executeQuery(sql);
																																																																																																																																																																																			
			//STEP 5: Extract data from result set
			
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            System.out.println("Product Name"+" "+"Price"+" "+"Quantity");
            while (rs.next())
            {
                for (int i = 1; i <= columnsNumber; i++)
                {
                    if (i > 1)
                    {
                        System.out.print("  ");
                    }
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
                System.out.println("");
            }
            
            // while(rs.next()){
			// 	//Retrieve by column name
			// 	int rollno  = rs.getInt("rollno");
			// 	String name = rs.getString("name");
			// 	s.setRollno(rollno);
			// 	s.setName(name);
			// 	break;
			// 	// Add exception handling here if more than one row is returned
			// }
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
        
    }

    public void checkInventory()
    {
        String sql;
        Statement stmt = null;

        try{
			stmt = dbConnection.createStatement();
			sql = "select productName, price, quantity from Inventory";
			ResultSet rs = stmt.executeQuery(sql);

			ResultSetMetaData rsmd = rs.getMetaData();
            int columnsNumber = rsmd.getColumnCount();
            System.out.println("Product Name"+" "+"Price"+" "+"Quantity");
            while (rs.next())
            {
                for (int i = 1; i <= columnsNumber; i++)
                {
                    if (i > 1)
                    {
                        System.out.print("  ");
                    }
                    String columnValue = rs.getString(i);
                    System.out.print(columnValue + " " + rsmd.getColumnName(i));
                }
                System.out.println("");
            }
																																																																																																																																																																																			
			//STEP 5: Extract data from result set
			// while(rs.next()){
			// 	//Retrieve by column name
			// 	int rollno  = rs.getInt("rollno");
			// 	String name = rs.getString("name");
			// 	s.setRollno(rollno);
			// 	s.setName(name);
			// 	break;
			// 	// Add exception handling here if more than one row is returned
			// }
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		// Add exception handling when there is no matching record
    }

	public void buyItems(Customer cust,Integer transID, String productName, Integer quantity)
	{
		// decrease quantity in Inventory Table
		// delete the products in the product Table
		// add a row in the transaction table

		String sql;
        Statement stmt = null;

		 try{
			stmt = dbConnection.createStatement();
			// sql = "UPDATE inventory SET quantity = quantity - 1 WHERE quantity > 0;";
			// ResultSet rs = stmt.executeQuery(sql);

			for(int i=0; i<quantity;i++)
			{
				sql = "UPDATE inventory SET quantity = quantity - 1 WHERE quantity > 0;";
				ResultSet rs = stmt.executeQuery(sql);
				sql = "DELETE FROM product p, inventory i WHERE i.productName = " + productName + "p.productID = i.productID ;";
				ResultSet rs = stmt.executeQuery(sql);
				sql = "INSERT INTO Transaction (transactionNo, transactionID, customerID, productName, quantity)VALUES (transID," + transID + cust.getID() + productName + quantity.toString() + ");";
			}
			
																																																																																																																																																																																			
			//STEP 5: Extract data from result set
			// while(rs.next()){
			// 	//Retrieve by column name
			// 	int rollno  = rs.getInt("rollno");
			// 	String name = rs.getString("name");
			// 	s.setRollno(rollno);
			// 	s.setName(name);
			// 	break;
			// 	// Add exception handling here if more than one row is returned
			// }
		} catch (SQLException ex) {
		    // handle any errors
		    System.out.println("SQLException: " + ex.getMessage());
		    System.out.println("SQLState: " + ex.getSQLState());
		    System.out.println("VendorError: " + ex.getErrorCode());
		}
		

	}

    public void getCustomer(Integer custID)
    {

    }
    
}
