import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JProgressBar;

public class Trip {

	public JFrame frame;
	
	static Driver d1 = new Driver();
	static String newcity;
	static int time;
	static String uid;
	static String passwd;
	static double distance;
	static String vehicleid;
	
	public Trip(String vehicleno, String newLocation, int timer, String userid, String password,double dist){
		vehicleid = vehicleno;
		d1 = Driver.getDriver(vehicleno);
		newcity = newLocation;
		time = timer;
		uid = userid;
		passwd = password;
		distance = dist;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trip window = new Trip();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Trip() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 620, 399);
		frame.setDefaultCloseOperation(frame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(80, 95, 60, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Vehicle ID :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(49, 140, 91, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone No. :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(49, 175, 91, 26);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Rating :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(80, 214, 60, 26);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel dname = new JLabel("New label");
		dname.setBounds(185, 37, 202, 16);
		frame.getContentPane().add(dname);
		dname.setText(d1.name);
		
		JLabel dvehicle = new JLabel("New label");
		dvehicle.setBounds(185, 66, 202, 16);
		frame.getContentPane().add(dvehicle);
		dvehicle.setText(d1.vehicleNo);
		
		JLabel dphone = new JLabel("New label");
		dphone.setBounds(152, 181, 132, 16);
		frame.getContentPane().add(dphone);
		dphone.setText(Long.toString(d1.phone));
		
		JLabel drating = new JLabel("New label");
		drating.setBounds(152, 220, 132, 16);
		frame.getContentPane().add(drating);
		drating.setText(Double.toString(d1.rating));
		
		String ratingOptions[] = new String[5];
		for(int i=1;i<=5;i++) {
			ratingOptions[i-1] = Integer.toString(i);
		}
		
		JComboBox comboBox = new JComboBox(ratingOptions);
		comboBox.setBounds(266, 269, 106, 22);
		frame.getContentPane().add(comboBox);
		comboBox.setVisible(false);
		
		JLabel lblSelectRating = new JLabel("Please Select Driver Rating :");
		lblSelectRating.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblSelectRating.setBounds(49, 266, 199, 26);
		frame.getContentPane().add(lblSelectRating);
		lblSelectRating.setVisible(false);
		
		JLabel lblTripDetails = new JLabel("Trip Details");
		lblTripDetails.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblTripDetails.setBounds(64, 26, 132, 27);
		frame.getContentPane().add(lblTripDetails);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(100, 313, 397, 26);
		frame.getContentPane().add(progressBar);
		
		JButton btnOk = new JButton("OK");
		/*btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(progressBar.getValue() < 100)
					progressBar.setValue(progressBar.getValue()+5);
				else
					t.stop();
			}
		});*/
		btnOk.setVisible(false);
		btnOk.setBounds(417, 268, 80, 25);
		frame.getContentPane().add(btnOk);
				
		Timer t = new Timer(time,new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				//frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				lblSelectRating.setVisible(true);
				comboBox.setVisible(true);
				btnOk.setVisible(true);
				btnOk.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						d1 = Driver.getDriver(vehicleid);
	            	    int recentRating = Integer.parseInt((String)comboBox.getSelectedItem());
	            	    SqlConnector.DBConnectupdate("update city set drivercount = drivercount+1 where name = '"+ newcity +"';");
	            		SqlConnector.DBConnectupdateDriver("update driver set tripcount="+Integer.toString(d1.tripsCount+1)+",rating=" + Double.toString((recentRating + d1.rating*(d1.tripsCount))/(d1.tripsCount+1))+",availablity='Yes',presentloc='"+newcity+"' where vehicleno='"+d1.vehicleNo+"';" );
	            	    SqlConnector.updateAvailabilityY(d1.vehicleNo);
	            	    SqlConnector.updateRidingN(uid);
	            	    User u = User.getUser(uid, passwd);
	            	    u.updateWallet(distance);
	            	    JOptionPane.showMessageDialog(frame,"Thanks for Riding!\nHave a Nice Day!");
	            	    frame.dispose();
					}
				});
			}
			
		});
		t.start();
	}
}
