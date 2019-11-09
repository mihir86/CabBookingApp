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
	
	public static void updateRidingY(String id) {
		String query = "update User set riding = 'Yes' where userid = '"+ id + "';";
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
	
	public static void updateRidingN(String id) {
		String query = "update User set riding = 'No' where userid = '"+ id + "';";
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
	
	public static void updateAvailabilityN(String id) {
		String query = "update driver set availablity = 'No' where vehicleno = '"+ id + "';";
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
	
	public static Boolean IsRiding(String id) {
		String check = null;
		try{  
			Class.forName("com.mysql.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/cabbookingsql","root","swapnil69");   
			Statement stmt=con.createStatement(); 
			String que = "select riding from User where userid = '"+ id + "';";
			rs = stmt.executeQuery(que);
			while(rs.next())
			check = rs.getString("riding");
			con.close();
		}
		catch(Exception e) {
				System.out.println(e);
		}
		if(check.equals("Yes"))
			return true;
		return false;
	}
	
	public static void updateBalance(String id,double wallet) {
		String query = "update User set wallet = " + wallet + " where userid = '"+ id + "';";
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
	
		//For Driver table
		public static void DBConnectupdateDriver(String query){  
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
		public static String getDrivername(String id)
		{
			String name = null;
			try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/cabbookingsql","root","swapnil69");   
					Statement stmt=con.createStatement(); 
					String que = "select name from Driver where vehicleno = '"+ id + "';";
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
		
		public static String getPresentLocation(String id)
		{
			String location = null;
			try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/cabbookingsql","root","swapnil69");   
					Statement stmt=con.createStatement(); 
					String que = "select email from driver where vehicleno = '"+ id + "';";
					rs = stmt.executeQuery(que);
					while(rs.next())
					location = rs.getString("presentloc");
					con.close();
				}
				catch(Exception e) {
						System.out.println(e);
				}
			return location;
		}
		
		public static String getAvailability(String id)
		{
			String availability = null;
			try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/cabbookingsql","root","swapnil69");   
					Statement stmt=con.createStatement(); 
					String que = "select availablity from driver where vehicleno = '"+ id + "';";
					rs = stmt.executeQuery(que);
					while(rs.next())
					availability = rs.getString("availablity");
					con.close();
				}
				catch(Exception e) {
						System.out.println(e);
				}
			return availability;
		}
		
		public static long getDriverphone(String id)
		{
			long phoneno = 0;
			try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/cabbookingsql","root","swapnil69");   
					Statement stmt=con.createStatement(); 
					String que = "select phone from driver where vehicleno = '"+ id + "';";
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
		
		public static double getRating(String id)
		{
			double rating = 0;
			try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/cabbookingsql","root","swapnil69");   
					Statement stmt=con.createStatement(); 
					String que = "select rating from driver where vehicleno = '"+ id + "';";
					rs = stmt.executeQuery(que);
					while(rs.next())
					rating = rs.getDouble("rating");
					con.close();
				}
				catch(Exception e) {
						System.out.println(e);
				}
			return rating;
		}
		
		public static int getTrips(String id)
		{
			int trips = 0;
			try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/cabbookingsql","root","swapnil69");   
					Statement stmt=con.createStatement(); 
					String que = "select tripcount from driver where vehicleno = '"+ id + "';";
					rs = stmt.executeQuery(que);
					while(rs.next())
					trips = rs.getInt("tripcount");
					con.close();
				}
				catch(Exception e) {
						System.out.println(e);
				}
			return trips;
		}
		
		public static int getX(String city)
		{
			int x = 0;
			try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/cabbookingsql","root","swapnil69");   
					Statement stmt=con.createStatement(); 
					String que = "select X from city where name = '"+ city + "';";
					rs = stmt.executeQuery(que);
					while(rs.next())
					x = rs.getInt("X");
					con.close();
				}
				catch(Exception e) {
						System.out.println(e);
				}
			return x;
		}
		
		public static int getY(String city)
		{
			int y = 0;
			try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/cabbookingsql","root","swapnil69");   
					Statement stmt=con.createStatement(); 
					String que = "select Y from city where name = '"+ city + "';";
					rs = stmt.executeQuery(que);
					while(rs.next())
					y = rs.getInt("Y");
					con.close();
				}
				catch(Exception e) {
						System.out.println(e);
				}
			return y;
		}
	
}
