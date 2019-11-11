import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Trip {

	public JFrame frame;
	
	static Driver d1 = new Driver();
	static String to;
	static int time;
	static String uid;
	static String passwd;
	static double distance;
	
	public Trip(String vehicleno, String newLocation, int timer, String userid, String password,double dist){
		d1 = Driver.getDriver(vehicleno);
		to = newLocation;
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setBounds(82, 37, 91, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Vehicle ID :");
		lblNewLabel_1.setBounds(82, 66, 91, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Phone No. :");
		lblNewLabel_2.setBounds(82, 95, 91, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Rating :");
		lblNewLabel_3.setBounds(82, 124, 91, 16);
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
		dphone.setBounds(185, 95, 132, 16);
		frame.getContentPane().add(dphone);
		dphone.setText(Long.toString(d1.phone));
		
		JLabel drating = new JLabel("New label");
		drating.setBounds(185, 124, 132, 16);
		frame.getContentPane().add(drating);
		drating.setText(Double.toString(d1.rating));
		
		String ratingOptions[] = new String[5];
		for(int i=1;i<=5;i++) {
			ratingOptions[i-1] = Integer.toString(i);
		}
		
		JComboBox comboBox = new JComboBox(ratingOptions);
		comboBox.setBounds(185, 165, 106, 22);
		frame.getContentPane().add(comboBox);
		comboBox.setVisible(false);
		
		JLabel lblSelectRating = new JLabel("Select Driver's Rating :");
		lblSelectRating.setBounds(33, 168, 140, 16);
		frame.getContentPane().add(lblSelectRating);
		lblSelectRating.setVisible(false);
		
		JLabel lblThanksForRiding = new JLabel("THANKS FOR RIDING!");
		lblThanksForRiding.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblThanksForRiding.setBounds(118, 200, 186, 16);
		frame.getContentPane().add(lblThanksForRiding);
		lblThanksForRiding.setVisible(false);
		
		JLabel lblHaveANice = new JLabel("HAVE A NICE DAY!");
		lblHaveANice.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblHaveANice.setBounds(128, 224, 160, 16);
		frame.getContentPane().add(lblHaveANice);
		lblHaveANice.setVisible(false);
		
		JLabel lblTripDetails = new JLabel("TRIP DETAILS");
		lblTripDetails.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblTripDetails.setBounds(140, 13, 132, 16);
		frame.getContentPane().add(lblTripDetails);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnOk.setVisible(false);
		btnOk.setBounds(318, 164, 80, 25);
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
	            	    int recentRating = Integer.parseInt((String)comboBox.getSelectedItem());
	            	    d1.updateDriver(to, recentRating, d1);
	            	    SqlConnector.updateAvailabilityY(d1.vehicleNo);
	            	    SqlConnector.updateRidingN(uid);
	            	    User u = User.getUser(uid, passwd);
	            	    u.updateWallet(distance);
	            	    JFrame f; 
	            	    f=new JFrame();
	            	    JOptionPane.showMessageDialog(f,"Thanks for Riding!\nHave a Nice Day!");
	            	    frame.dispose();
					}
				});
			}
			
		});
		t.start();
		}

}
