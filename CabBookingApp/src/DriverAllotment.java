import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DriverAllotment {
	public static ResultSet rs;
		//Allocating Driver
		public static String driverAllocate(String from) {
			String vehiclenum = null;
			try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/cabbookingsql","root","swapnil69");   
					Statement stmt=con.createStatement(); 
					String que = "select max(rating),vehicleno from driver where presentloc='"+ from+"' and availablity='Yes';";
					rs = stmt.executeQuery(que); 
					while(rs.next())  
						vehiclenum = rs.getString("vehicleno");
					con.close();
				}
				catch(Exception e) {
						System.out.println(e);
				}
			return vehiclenum;
		}
		
		//checking no of drivers
		public static Boolean checkDriverCount(String from){  
			int count=0;
			try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/cabbookingsql","root","swapnil69");   
					Statement stmt=con.createStatement(); 
					String que = "select drivercount from city where name='"+from+"';";
					rs = stmt.executeQuery(que); 
					while(rs.next())
						count = rs.getInt("Drivercount");
					con.close();
				}
				catch(Exception e) {
						System.out.println(e);
				}
				if(count==0)
					return false;
				return true;
		}
		
		/*public static String WorstDriver(String from) {
			String vehicleno = null;
			try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/cabbookingsql","root","swapnil69");   
					Statement stmt=con.createStatement(); 
					String que = "select min(rating),vehicleno from driver where presentloc='"+ from+"' and availablity='Yes';";
					rs = stmt.executeQuery(que); 
					while(rs.next())
						vehicleno = rs.getString("vehicleno");
					con.close();
				}
				catch(Exception e) {
						System.out.println(e);
				}
			return vehicleno;
		}*/
		
		public static String maxDriverCity() {
			String city = null;
			try{  
					Class.forName("com.mysql.jdbc.Driver");  
					Connection con=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/cabbookingsql","root","swapnil69");   
					Statement stmt=con.createStatement(); 
					String que = "select max(drivercount),name from city;";
					rs = stmt.executeQuery(que); 
					while(rs.next())
						city = rs.getString("name");
					con.close();
				}
				catch(Exception e) {
						System.out.println(e);
				}
			return city;
		}
		
		public static void cancellation(String id) {
			String query = "update driver set availablity = 'Yes' where vehicleno = '"+ id + "';";
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
		
		public static void reallocateDrivers(String from,String to,String id) {
			SqlConnector.DBConnectupdate("update city set drivercount = drivercount-1 where name = '"+ from +"';");
			SqlConnector.DBConnectupdate("update city set drivercount = drivercount+1 where name = '"+ to +"';");
			SqlConnector.DBConnectupdate("update driver set presentloc='"+ to +"' where vehicleno = '"+ id +"';");
		}
		
		public static void decreaseCityDriverCount(String from) {
			SqlConnector.DBConnectupdate("update city set drivercount = drivercount-1 where name = '"+ from +"';");
		}
		
		public static void increaseCityDriverCount(String from) {
			SqlConnector.DBConnectupdate("update city set drivercount = drivercount+1 where name = '"+ from +"';");
		}
		
}
