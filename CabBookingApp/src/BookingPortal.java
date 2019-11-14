import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;

public class BookingPortal {
	public JFrame frame;
	
	static User u1 = new User();
	String from,to;
	int x1,y1,x2,y2;
	double distance;
	int time;
	static Driver d = new Driver();

	/**
	 * Launch the application.
	 */
	
	public BookingPortal(String id, String passwd){
		u1 = User.getUser(id, passwd);
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookingPortal window = new BookingPortal();
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
	public BookingPortal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 887, 525);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ImageIcon logo = new ImageIcon("C:\\Users\\Mihir Bansal\\Desktop\\project images\\logo6.jpg");
		frame.setIconImage(logo.getImage());
		frame.setTitle("MARS Cabs");
		
		String s[]= SqlConnector.DBConnectgetcity();
		
		JComboBox comboBox = new JComboBox(s);
		comboBox.setBounds(184, 111, 242, 22);
		frame.getContentPane().add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox(s);
		comboBox_1.setBounds(184, 171, 242, 22);
		frame.getContentPane().add(comboBox_1);
		
		JButton btnSearchForCabs = new JButton("Search for Cabs");
		
		JButton btnConfirmBooking = new JButton("Confirm Booking");
		
		btnConfirmBooking.setVisible(false);
		btnConfirmBooking.setBounds(80, 440, 135, 25);
		frame.getContentPane().add(btnConfirmBooking);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel.setVisible(false);
		lblNewLabel.setBounds(236, 339, 148, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_1.setVisible(false);
		lblNewLabel_1.setBounds(236, 368, 148, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblNewLabel_2.setVisible(false);
		lblNewLabel_2.setBounds(236, 397, 148, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblPickup = new JLabel("Pickup :");
		lblPickup.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPickup.setBounds(94, 112, 78, 21);
		frame.getContentPane().add(lblPickup);
		
		JLabel lblDestination = new JLabel("Destination :");
		lblDestination.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDestination.setBounds(57, 172, 124, 16);
		frame.getContentPane().add(lblDestination);
		
		JLabel lblDistance = new JLabel("Distance:");
		lblDistance.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblDistance.setVisible(false);
		lblDistance.setBounds(167, 339, 78, 16);
		frame.getContentPane().add(lblDistance);
		
		JLabel lblEstimatedTime = new JLabel("Estimated Time:");
		lblEstimatedTime.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblEstimatedTime.setVisible(false);
		lblEstimatedTime.setBounds(123, 368, 122, 16);
		frame.getContentPane().add(lblEstimatedTime);
		
		JLabel lblEstimatedFare = new JLabel("Estimated Fare:");
		lblEstimatedFare.setFont(new Font("Dialog", Font.PLAIN, 15));
		lblEstimatedFare.setVisible(false);
		lblEstimatedFare.setBounds(123, 397, 122, 16);
		frame.getContentPane().add(lblEstimatedFare);
		
		
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setVisible(false);
		btnCancel.setBounds(257, 440, 97, 25);
		frame.getContentPane().add(btnCancel);
		
		btnSearchForCabs.setBounds(68, 226, 148, 25);
		frame.getContentPane().add(btnSearchForCabs);
		
		JButton btnMyWallet = new JButton("My Wallet");
		btnMyWallet.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserWallet(u1.userid,u1.password);
				EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					UserWallet window = new UserWallet();
        					window.frame.setVisible(true);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			}
        		});
			}
		});
		btnMyWallet.setBounds(249, 226, 153, 25);
		frame.getContentPane().add(btnMyWallet);
		
		JLabel lblBookARide = new JLabel("Book a Ride");
		lblBookARide.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblBookARide.setBounds(27, 30, 142, 34);
		frame.getContentPane().add(lblBookARide);
		
		JLabel label = new JLabel("");
		label.setBounds(155, 287, 37, 39);
		frame.getContentPane().add(label);
		Image tripimg = new ImageIcon(this.getClass().getResource("/trip.png")).getImage();
		label.setIcon(new ImageIcon(tripimg));
		
		JLabel label_1 = new JLabel("Trip Details");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		label_1.setBounds(27, 297, 159, 27);
		frame.getContentPane().add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(180, 32, 32, 32);
		frame.getContentPane().add(label_2);
		Image ride = new ImageIcon(this.getClass().getResource("/ride.png")).getImage();
		label_2.setIcon(new ImageIcon(ride));
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(458, 13, 384, 452);
		frame.getContentPane().add(label_3);
		Image map = new ImageIcon(this.getClass().getResource("/mapfinal2.jpg")).getImage();
		label_3.setIcon(new ImageIcon(map));
		
		btnSearchForCabs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				from = (String) comboBox.getSelectedItem();
				to = (String) comboBox_1.getSelectedItem();
				int x1 = SqlConnector.getX(from);
				int y1 = SqlConnector.getY(from);
				int x2 = SqlConnector.getX(to);
				int y2 = SqlConnector.getY(to);
				distance = User.distanceCal(x1, y1, x2, y2);
				u1 = User.getUser(u1.userid, u1.password);
				if(to.equals(from)) {
            	    JOptionPane.showMessageDialog(frame,"Please Enter 2 different locations!");
				}
				else if(!DriverAllotment.checkDriverCount(from)) {
            	    JOptionPane.showMessageDialog(frame,"No cabs available at the moment!");
            	    String location = DriverAllotment.maxDriverCity();
            	    String BestDriver = DriverAllotment.driverAllocate(location);
            	    DriverAllotment.reallocateDrivers(location, from, BestDriver);
				}
				else if(DriverAllotment.checkDriverCount(from)){
					d.vehicleNo = DriverAllotment.driverAllocate(from);
					DriverAllotment.decreaseCityDriverCount(from);
					SqlConnector.updateAvailabilityN(d.vehicleNo);
					
					btnConfirmBooking.setVisible(true);
					btnCancel.setVisible(true);
					lblNewLabel.setText(Double.toString(distance) + " Km");
					lblNewLabel.setVisible(true);
					lblDistance.setVisible(true);
					lblNewLabel_1.setText(Double.toString(User.timeCal(distance)/1000) + " min");
					lblNewLabel_1.setVisible(true);
					lblEstimatedTime.setVisible(true);
					lblNewLabel_2.setText("Rs. "+ Double.toString(User.costCal(distance)));
					lblNewLabel_2.setVisible(true);
					lblEstimatedFare.setVisible(true);
					btnSearchForCabs.setVisible(false);
				}
			}
		});
		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SqlConnector.updateAvailabilityY(d.vehicleNo);
				DriverAllotment.increaseCityDriverCount(from);
				
				lblNewLabel.setVisible(false);
				lblDistance.setVisible(false);
				lblNewLabel_1.setVisible(false);
				lblEstimatedTime.setVisible(false);
				lblNewLabel_2.setVisible(false);
				lblEstimatedFare.setVisible(false);
				btnConfirmBooking.setVisible(false);
				btnSearchForCabs.setVisible(true);
				btnCancel.setVisible(false);
			}
		});
		
		btnConfirmBooking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				u1 = User.getUser(u1.userid, u1.password);
				time = (int) User.timeCal(distance);
				
				if(SqlConnector.IsRiding(u1.userid)) {
            	    JOptionPane.showMessageDialog(frame,"You are already on a ride!");
				}
				else if(!u1.checkWallet(distance)) {
            	    JOptionPane.showMessageDialog(frame,"Insufficient Wallet Balance!\nPlease add money to the wallet");
				}
				
				else {
					JOptionPane.showMessageDialog(frame, "Booking Confirmed\nEnjoy ur Ride!");
					SqlConnector.updateRidingY(u1.userid);
					btnConfirmBooking.setVisible(false);
					btnCancel.setVisible(false);
					btnSearchForCabs.setVisible(false);
					btnMyWallet.setVisible(false);
					
					new Trip(d.vehicleNo,to,time,u1.userid,u1.password,distance);
					
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
					Timer t = new Timer(time,new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							btnSearchForCabs.setVisible(true);
							btnMyWallet.setVisible(true);
							lblNewLabel.setVisible(false);
							lblDistance.setVisible(false);
							lblNewLabel_1.setVisible(false);
							lblEstimatedTime.setVisible(false);
							lblNewLabel_2.setVisible(false);
							lblEstimatedFare.setVisible(false);
							
						}
						
					});
					t.start();
				}
			}
		});
	}
}
