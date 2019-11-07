
public class Driver {
	String name,vehicleNo,presentLocation;
	int tripsCount;
	double rating;
	long phone;
	Boolean availablity = true;
	
	public Driver(String name,double rating,int tripsCount,String vehicleNo,String presentLocation,long phone){
		this.name = name;
		this.rating= rating;
		this.tripsCount = tripsCount;
		this.vehicleNo = vehicleNo;
		this.presentLocation = presentLocation;
		this.phone = phone;
	}
	
	public void ChangeRating (int recentUserRating) {
		availablity = true;
		tripsCount = tripsCount+1;
		rating = (recentUserRating + rating)/(tripsCount);
	}
	
	public void UpdateLocation(String newLocation) {
		presentLocation = newLocation;
	}
	
	
	
}
