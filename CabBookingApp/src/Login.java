import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.Font;
import java.awt.Image;

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
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		ImageIcon logo = new ImageIcon("C:\\Users\\Mihir Bansal\\Desktop\\project images\\logo6.jpg");
		frame.setIconImage(logo.getImage());
		frame.setTitle("MARS Cabs");
		
		JLabel lblUsername = new JLabel("Password");
		lblUsername.setForeground(Color.BLACK);
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUsername.setBounds(220, 255, 99, 37);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblUserid = new JLabel("UserID");
		lblUserid.setForeground(Color.BLACK);
		lblUserid.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblUserid.setBounds(241, 205, 60, 37);
		frame.getContentPane().add(lblUserid);
		
		passwrd = new JPasswordField();
		passwrd.setBounds(330, 263, 214, 22);
		frame.getContentPane().add(passwrd);
		
		uid = new JTextField();
		uid.setBounds(330, 213, 214, 22);
		frame.getContentPane().add(uid);
		uid.setColumns(10);
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String userid = uid.getText();
				String password = String.valueOf(passwrd.getPassword());
				if(userid.trim().isEmpty() || password.trim().isEmpty())
					JOptionPane.showMessageDialog(frame, "Please fill all the fields");
				else if(User.checkCredentials(userid, password)) {
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
		btnLogin.setBounds(306, 334, 97, 25);
		frame.getContentPane().add(btnLogin);
		
		
		hyperlink = new JLabel("New User? Register here");
		hyperlink.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hyperlink.setBounds(268, 430, 195, 32);
		frame.getContentPane().add(hyperlink);
		
		hyperlink.setForeground(Color.BLUE);
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
		lblWelcomeToUber.setForeground(Color.BLACK);
		lblWelcomeToUber.setFont(new Font("Tahoma", Font.BOLD, 36));
		lblWelcomeToUber.setBounds(165, 46, 439, 59);
		frame.getContentPane().add(lblWelcomeToUber);
		
		JLabel label_1 = new JLabel("Sign In");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 24));
		label_1.setBounds(321, 132, 74, 37);
		frame.getContentPane().add(label_1);
		
		JLabel label = new JLabel("");
		label.setBounds(165, 205, 43, 37);
		frame.getContentPane().add(label);
		Image img1 = new ImageIcon(this.getClass().getResource("/user.png")).getImage();
		label.setIcon(new ImageIcon(img1));
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(165, 255, 43, 37);
		frame.getContentPane().add(label_2);
		Image img2 = new ImageIcon(this.getClass().getResource("/password2.png")).getImage();
		label_2.setIcon(new ImageIcon(img2));
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(12, 13, 127, 116);
		frame.getContentPane().add(label_3);
		Image img3 = new ImageIcon(this.getClass().getResource("/logo6.jpg")).getImage();
		label_3.setIcon(new ImageIcon(img3));
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(0, 0, 756, 486);
		frame.getContentPane().add(label_4);
		Image bg = new ImageIcon(this.getClass().getResource("/bground2.jpg")).getImage();
		label_4.setIcon(new ImageIcon(bg));
	}
}
