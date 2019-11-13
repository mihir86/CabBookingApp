import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;

public class Login {
	private JFrame frame;
	private JPasswordField passwrd;
	private JTextField uid;
	private JLabel hyperlink;
	private Registration registrationPage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 774, 533);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Password");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(208, 256, 99, 37);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblUserid = new JLabel("UserID");
		lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUserid.setBounds(229, 206, 60, 37);
		frame.getContentPane().add(lblUserid);
		
		passwrd = new JPasswordField();
		passwrd.setBounds(318, 264, 214, 22);
		frame.getContentPane().add(passwrd);
		
		uid = new JTextField();
		uid.setBounds(318, 214, 214, 22);
		frame.getContentPane().add(uid);
		uid.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userid = uid.getText();
				String password = String.valueOf(passwrd.getPassword());
				if(User.checkCredentials(userid, password)) {
					new BookingPortal(userid,password);
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
				else {
            	    JOptionPane.showMessageDialog(frame,"Invalid Userid or Password");
				}
			}
		});
		btnLogin.setBounds(309, 348, 97, 25);
		frame.getContentPane().add(btnLogin);
		
		
		hyperlink = new JLabel("New User? Register here");
		hyperlink.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hyperlink.setBounds(273, 396, 189, 32);
		frame.getContentPane().add(hyperlink);
		
		hyperlink.setForeground(Color.BLUE.darker());
	    hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));
		
	  
	    registrationPage = new Registration();
	    hyperlink.addMouseListener(new MouseAdapter() {
	 
	            @Override
	            public void mouseClicked(MouseEvent e) {
	                registrationPage.setVisible(true);
	            }
	 
	            @Override
	            public void mouseExited(MouseEvent e) {
	                hyperlink.setText("New User? Register here");
	            }
	 
	            @Override
	            public void mouseEntered(MouseEvent e) {
	                hyperlink.setText("<html><a href=''>" + "New User? Register here" + "</a></html>");
	            }
	    });
		
		JLabel lblWelcomeToUber = DefaultComponentFactory.getInstance().createTitle("Welcome to MARS Cabs");
		lblWelcomeToUber.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblWelcomeToUber.setBounds(190, 46, 389, 53);
		frame.getContentPane().add(lblWelcomeToUber);
		
		JLabel label_1 = new JLabel("Sign In");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label_1.setBounds(322, 134, 68, 25);
		frame.getContentPane().add(label_1);
	}
}
