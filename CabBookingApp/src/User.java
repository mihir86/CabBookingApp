public class User {
	String name,userid,emailid,password;
	long phone;
	double wallet;
	
	public User() {}
	
	public User(String name,String userid,String emailid,String password,long phone,double wallet) {
		this.name = name;
		this.userid = userid;
		this.emailid = emailid;
		this.password = password;
		this.phone = phone;
		this.wallet = wallet;
	}
	
	public void register() {
		SqlConnector.DBConnectupdate("insert into user values ("+
		"'"+ this.userid + "','" + this.name + "','" + this.password + "'," + this.phone + ",'" + this.emailid + "'," + this.wallet +");");
	}
	
	public static Boolean uniqueid (String id) {
		try {
		String arr[]=SqlConnector.DBConnectgetname();
		int i=0;
		int n = arr.length;
        for(i=0;i<n;i++) {
        	if(arr[i] != null)
        if(arr[i].equals(id))
        	return false;
        }
		}
		catch(Exception e1)
		{
			System.out.println("Exception");
		}
		return true;
	}
	
	public static Boolean checkCredentials(String id,String passwd) {
		try {
			String arr[]=SqlConnector.DBConnectgetname();
			int i=0;
			String pass[]=SqlConnector.DBConnectgetpassword();
			int n= arr.length;
            for(i=0;i<n;i++) {
            	if(arr[i] != null) {
            		if(arr[i].equals(id) && pass[i].equals(passwd))
            			return true;
            }
            }
		}
		catch(Exception e1)
		{
			System.out.println("Exception");
		}
		return false;
		}
	
	public static User getUser(String id,String passwd) {
		String nameofuser = SqlConnector.getName(id);
		String emailid = SqlConnector.getEmailid(id);
		long phoneno = SqlConnector.getPhoneno(id);
		double balance = SqlConnector.getBalance(id);
		User u = new User(nameofuser,id,emailid,passwd,phoneno,balance);
		return u;
	}
	
	public Boolean checkWallet(double distance) {
		double costOfTrip = distance * 5;
		if(wallet>=300 && (wallet-costOfTrip)>=0)
			return true;
		return false;
	}
	
	public void updateWallet(double distance) {
		double costOfTrip = distance * 5;
		wallet = wallet - costOfTrip;
		SqlConnector.UpdateBalance(userid,wallet);
	}
	
	public void addMoney(double money) {
		wallet = wallet + money;
		SqlConnector.UpdateBalance(userid,wallet);
	}
	
}

