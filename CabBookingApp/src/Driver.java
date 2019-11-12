
public class Driver {
	String name,vehicleNo,presentLocation,availablity;
	int tripsCount;
	double rating;
	long phone;
	
	public Driver() {}
	
	public Driver(String name,double rating,int tripsCount,String vehicleNo,String presentLocation,long phone,String availability){
		this.name = name;
		this.rating= rating;
		this.tripsCount = tripsCount;
		this.vehicleNo = vehicleNo;
		this.presentLocation = presentLocation;
		this.phone = phone;
		this.availablity = availability;
	}
	
	public static Driver getDriver(String vehicleno) {
		String nameofdriver = SqlConnector.getDrivername(vehicleno);
		String availability = SqlConnector.getAvailability(vehicleno);
		String presentLocation = SqlConnector.getPresentLocation(vehicleno);
		long phoneno = SqlConnector.getDriverphone(vehicleno);
		double rating = SqlConnector.getRating(vehicleno);
		int tripcount = SqlConnector.getTrips(vehicleno);
		Driver d = new Driver(nameofdriver,rating,tripcount,vehicleno,presentLocation,phoneno,availability);
		return d;
	}
}
