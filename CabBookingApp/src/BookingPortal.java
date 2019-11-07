import java.awt.EventQueue;

import javax.swing.JFrame;

public class BookingPortal {

	public JFrame frame;

	/**
	 * Launch the application.
	 */
	
	public BookingPortal(String id, String passwd){
		User u1;
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
