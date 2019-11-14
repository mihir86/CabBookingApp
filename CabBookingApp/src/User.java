public class User {
	protected String userid,password;
	protected String emailid,name;
	protected long phone;
	protected int wallet;
	
	public User() {}
	
	public User(String name,String userid,String emailid,String password,long phone,int wallet) {
		this.name = name;
		this.userid = userid;
		this.emailid = emailid;
		this.password = password;
		this.phone = phone;
		this.wallet = wallet;
	}
	
	public void register() {
		SqlConnector.DBConnectupdate("insert into user values ("+
		"'"+ this.userid + "','" + this.name + "','" + this.password + "','" + this.emailid + "'," + this.wallet + ",'No'," + this.phone +");");
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
		int balance = SqlConnector.getBalance(id);
		User u = new User(nameofuser,id,emailid,passwd,phoneno,balance);
		return u;
	}
	
	public Boolean checkWallet(double distance) {
		double costOfTrip = distance * 20;
		if(wallet>=300 && (wallet-costOfTrip)>=0)
			return true;
		return false;
	}
	
	public void updateWallet(double distance) {
		double costOfTrip = distance * 20;
		wallet = wallet - (int)costOfTrip;
		SqlConnector.updateBalance(userid,wallet);
	}
	
	public void addMoney(int money) {
		wallet = wallet + money;
		SqlConnector.updateBalance(userid,wallet);
	}
	
	public static double distanceCal(int x1,int y1,int x2,int y2) {
		return Math.round(Math.sqrt((x2-x1)*(x2-x1)+(y2-y1)*(y2-y1)));
	}
	
	public static double costCal(double distance) {
		return Math.round(distance*20);
	}
	
	public static double timeCal(double distance) {
		return Math.round(distance*3000);
	}
	
}

