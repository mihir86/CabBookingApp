import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;

public class Login {
	private JFrame frame;
	private JPasswordField passwrd;
	private JTextField uid;

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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblUsername = new JLabel("Password");
		lblUsername.setBounds(68, 107, 99, 37);
		frame.getContentPane().add(lblUsername);
		
		JLabel label = new JLabel("Userid");
		label.setBounds(68, 57, 99, 37);
		frame.getContentPane().add(label);
		
		passwrd = new JPasswordField();
		passwrd.setBounds(154, 114, 214, 22);
		frame.getContentPane().add(passwrd);
		
		uid = new JTextField();
		uid.setBounds(154, 64, 214, 22);
		frame.getContentPane().add(uid);
		uid.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userid = uid.getText();
				String password = String.valueOf(passwrd.getPassword());
				if(User.checkCredentials(userid, password)) {
					//
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
					JFrame f; 
            	    f=new JFrame();
            	    JOptionPane.showMessageDialog(f,"Invalid Userid or Password");
				}
			}
		});
		btnLogin.setBounds(168, 157, 97, 25);
		frame.getContentPane().add(btnLogin);
		
		JButton btnNewUser = new JButton("New User?");
		btnNewUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
        			public void run() {
        				try {
        					Registration window = new Registration();
        					window.frame.setVisible(true);
        				} catch (Exception e) {
        					e.printStackTrace();
        				}
        			}
        		});

			}
		});
		btnNewUser.setBounds(168, 196, 97, 25);
		frame.getContentPane().add(btnNewUser);
		
		JLabel lblWelcomeToUber = DefaultComponentFactory.getInstance().createTitle("WELCOME TO UBER");
		lblWelcomeToUber.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblWelcomeToUber.setBounds(139, 13, 219, 53);
		frame.getContentPane().add(lblWelcomeToUber);
	}
}
