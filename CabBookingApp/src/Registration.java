import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import java.awt.Font;
import java.awt.Image;

public class Registration extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField name;
	private JTextField userid;
	private JTextField emailid;
	private JTextField phoneno;
	private JPasswordField passwordField;
	String uname,uid,email,password;
	long phone;
	User u = new User();
	int flag = 1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Registration dialog = new Registration();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Registration() {
		setBounds(100, 100, 573, 429);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
			JLabel lblUsername = new JLabel("Name");
			lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblUsername.setBounds(87, 100, 49, 20);
			contentPanel.add(lblUsername);
		
		
			name = new JTextField();
			name.setBounds(163, 100, 225, 22);
			contentPanel.add(name);
			name.setColumns(10);
		
		
			JLabel lblUserid = new JLabel("UserID");
			lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblUserid.setBounds(87, 151, 49, 19);
			contentPanel.add(lblUserid);
		
		
			userid = new JTextField();
			userid.setColumns(10);
			userid.setBounds(163, 150, 225, 22);
			contentPanel.add(userid);
		
		
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPassword.setBounds(69, 205, 67, 20);
			contentPanel.add(lblPassword);
		
		
			JLabel lblEmailid = new JLabel("email-id");
			lblEmailid.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblEmailid.setBounds(77, 251, 59, 20);
			contentPanel.add(lblEmailid);
		
		
			emailid = new JTextField();
			emailid.setColumns(10);
			emailid.setBounds(163, 251, 225, 22);
			contentPanel.add(emailid);
		
		
			JLabel lblPhone = new JLabel("Phone");
			lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPhone.setBounds(92, 302, 44, 16);
			contentPanel.add(lblPhone);
		
		
			phoneno = new JTextField();
			phoneno.setColumns(10);
			phoneno.setBounds(163, 300, 225, 22);
			contentPanel.add(phoneno);
		
		
			passwordField = new JPasswordField();
			passwordField.setBounds(163, 200, 225, 22);
			contentPanel.add(passwordField);
		
		
			JLabel lblRegistration = new JLabel("Registration");
			lblRegistration.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblRegistration.setBounds(44, 31, 137, 31);
			contentPanel.add(lblRegistration);
			
			JLabel label = new JLabel("");
			label.setBounds(193, 30, 32, 32);
			contentPanel.add(label);
			Image reg = new ImageIcon(this.getClass().getResource("/reg.png")).getImage();
			label.setIcon(new ImageIcon(reg));
		
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton RegisterButton = new JButton("Register");
				RegisterButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(name.getText().trim().isEmpty() || userid.getText().trim().isEmpty() || String.valueOf(passwordField.getPassword()).trim().isEmpty() || emailid.getText().trim().isEmpty() || phoneno.getText().trim().isEmpty()) {
							JOptionPane.showMessageDialog(contentPanel, "Please fill all the fields");
							flag=0;
						}
						else
							flag=1;
						if(flag==1) {
							uname = name.getText();
							password = String.valueOf(passwordField.getPassword());
							uid = userid.getText();
							email = emailid.getText();
							String regex = "[7-9]{1}[0-9]{9}";
							String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+ 
		                            "[a-zA-Z0-9_+&*-]+)*@" + 
		                            "(?:[a-zA-Z0-9-]+\\.)+[a-z" + 
		                            "A-Z]{2,7}$"; 
							if(!phoneno.getText().matches(regex) || !email.matches(emailRegex))
								JOptionPane.showMessageDialog(contentPanel, "Please enter valid credentials!");
							else if(!User.uniqueid(uid)) {
								phone = Long.parseLong(phoneno.getText());
								JOptionPane.showMessageDialog(contentPanel, "Userid is already in use!");
							}
								else
							{
								phone = Long.parseLong(phoneno.getText());
								u.userid = uid;
								u.password = password;
								u.wallet = 0;
								u.name = uname;
								u.emailid = email;
								u.phone = phone;
								u.register();
								JOptionPane.showMessageDialog(contentPanel, "Registration Successful");
								dispose();
							}
						}
						
					}
				});
				RegisterButton.setActionCommand("OK");
				buttonPane.add(RegisterButton);
				getRootPane().setDefaultButton(RegisterButton);
			}
			
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			
		
	}

}
