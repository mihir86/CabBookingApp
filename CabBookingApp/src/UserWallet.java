import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Image;

public class UserWallet {

	public JFrame frame;
	
	static User u1 = new User();
	public UserWallet(String id, String passwd){
		u1 = User.getUser(id, passwd);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the application.
	 */
	public UserWallet() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 515, 336);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setText(Integer.toString(u1.wallet));
		lblNewLabel.setBounds(248, 129, 128, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Wallet Balance :");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(108, 123, 128, 25);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Select Amount :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(108, 161, 128, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnAddMoney = new JButton("Add Money");
		btnAddMoney.setBounds(186, 226, 97, 25);
		frame.getContentPane().add(btnAddMoney);
		
		String moneyOptions[] = new String[50];
		for(int i=1;i<=50;i++) {
			moneyOptions[i-1] = Integer.toString(i*100);
		}
		
		JComboBox money = new JComboBox(moneyOptions);
		money.setBounds(248, 166, 128, 22);
		frame.getContentPane().add(money);
		
		JLabel lblMyWallet = new JLabel("My Wallet");
		lblMyWallet.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblMyWallet.setBounds(45, 25, 112, 40);
		frame.getContentPane().add(lblMyWallet);
		
		JLabel label = new JLabel("");
		label.setBounds(169, 13, 71, 65);
		frame.getContentPane().add(label);
		btnAddMoney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				int addmoney = Integer.parseInt((String)money.getSelectedItem());
				if (JOptionPane.showConfirmDialog(null, "Are you sure?", "", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
				    // yes option
					u1.addMoney(addmoney);
					lblNewLabel.setText(Integer.toString(u1.wallet));
				} 
				else {
				    // no option
				}
			}
		});
		Image img = new ImageIcon(this.getClass().getResource("/wallet.png")).getImage();
		label.setIcon(new ImageIcon(img));
	}
}
