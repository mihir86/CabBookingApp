import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Login {

	private JFrame frame;

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
		lblUsername.setBounds(68, 139, 99, 37);
		frame.getContentPane().add(lblUsername);
		
		JLabel label = new JLabel("Usernam");
		label.setBounds(68, 95, 99, 37);
		frame.getContentPane().add(label);
	}
}