import java.sql.*;
public class SqlConnector {
	public static ResultSet rs;
	//For User table
	public static void DBConnectupdate(String query){  
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/cabbookingsql","root","swapnil69");    
			Statement stmt=con.createStatement();  
			stmt.executeUpdate(query);   
			con.close();  
		}
		catch(Exception e) {
			System.out.println(e);
		}  
	} 

	public static String[] DBConnectgetname()
	{
		String arr[]=new String[50];
		int i=0;
		try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/cabbookingsql","root","swapnil69");   
				Statement stmt=con.createStatement(); 
				String que = "select userid from User;";
				rs = stmt.executeQuery(que); 
				while(rs.next())  
					arr[i++]=rs.getString("userid");
				con.close();
			}
			catch(Exception e) {
					System.out.println(e);
			}  
		return arr;
	} 

	public static String[] DBConnectgetpassword()
	{
		String arr[]=new String[50];
		int i=0;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/cabbookingsql","root","swapnil69");  
			Statement stmt=con.createStatement(); 
			String que = "select password from User;";
			rs = stmt.executeQuery(que); 
			while(rs.next())  
				arr[i++]=rs.getString("password");
			con.close();
			}
		catch(Exception e){
			System.out.println(e);
		}  
		return arr;
	}
	
	public static String getName(String id)
	{
		String name = null;
		try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/cabbookingsql","root","swapnil69");   
				Statement stmt=con.createStatement(); 
				String que = "select name from User where userid = '"+ id + "';";
				rs = stmt.executeQuery(que);
				while(rs.next())
				name=rs.getString("name");
				con.close();
			}
			catch(Exception e) {
					System.out.println(e);
			}
		return name;
	}
	
	public static String getEmailid(String id)
	{
		String email = null;
		try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/cabbookingsql","root","swapnil69");   
				Statement stmt=con.createStatement(); 
				String que = "select email from User where userid = '"+ id + "';";
				rs = stmt.executeQuery(que);
				while(rs.next())
				email = rs.getString("email");
				con.close();
			}
			catch(Exception e) {
					System.out.println(e);
			}
		return email;
	}
	
	public static long getPhoneno(String id)
	{
		long phoneno = 0;
		try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/cabbookingsql","root","swapnil69");   
				Statement stmt=con.createStatement(); 
				String que = "select phone from User where userid = '"+ id + "';";
				rs = stmt.executeQuery(que);
				while(rs.next())
				phoneno =rs.getLong("phone");
				con.close();
			}
			catch(Exception e) {
					System.out.println(e);
			}
		return phoneno;
	}
	
	public static double getBalance(String id)
	{
		double wallet = 0;
		try{  
				Class.forName("com.mysql.jdbc.Driver");  
				Connection con=DriverManager.getConnection(  
				"jdbc:mysql://localhost:3306/cabbookingsql","root","swapnil69");   
				Statement stmt=con.createStatement(); 
				String que = "select wallet from User where userid = '"+ id + "';";
				rs = stmt.executeQuery(que);
				while(rs.next())
				wallet = rs.getDouble("wallet");
				con.close();
			}
			catch(Exception e) {
					System.out.println(e);
			}
		return wallet;
	}
	
}
