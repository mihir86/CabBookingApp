import java.awt.BorderLayout;
import java.awt.FlowLayout;

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

public class Registration extends JDialog {
	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_3;
	private JTextField textField_4;
	private JPasswordField passwordField;

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
		
			JLabel lblUsername = new JLabel("UserName");
			lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblUsername.setBounds(63, 102, 88, 20);
			contentPanel.add(lblUsername);
		
		
			textField = new JTextField();
			textField.setBounds(163, 100, 225, 22);
			contentPanel.add(textField);
			textField.setColumns(10);
		
		
			JLabel lblUserid = new JLabel("UserID");
			lblUserid.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblUserid.setBounds(87, 151, 49, 19);
			contentPanel.add(lblUserid);
		
		
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(163, 150, 225, 22);
			contentPanel.add(textField_1);
		
		
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPassword.setBounds(69, 205, 67, 20);
			contentPanel.add(lblPassword);
		
		
			JLabel lblEmailid = new JLabel("email-id");
			lblEmailid.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblEmailid.setBounds(77, 251, 59, 20);
			contentPanel.add(lblEmailid);
		
		
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(163, 251, 225, 22);
			contentPanel.add(textField_3);
		
		
			JLabel lblPhone = new JLabel("Phone");
			lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPhone.setBounds(92, 302, 44, 16);
			contentPanel.add(lblPhone);
		
		
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(163, 300, 225, 22);
			contentPanel.add(textField_4);
		
		
			passwordField = new JPasswordField();
			passwordField.setBounds(163, 200, 225, 22);
			contentPanel.add(passwordField);
		
		
			JLabel lblRegistration = new JLabel("Registration");
			lblRegistration.setFont(new Font("Tahoma", Font.PLAIN, 25));
			lblRegistration.setBounds(44, 31, 137, 31);
			contentPanel.add(lblRegistration);
		
		
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton RegisterButton = new JButton("Register");
				RegisterButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if(textField.getText().trim().isEmpty() || textField_1.getText().trim().isEmpty() || passwordField.getText().trim().isEmpty() || textField_3.getText().trim().isEmpty() || textField_4.getText().trim().isEmpty() || textField.getText().trim().isEmpty())
							JOptionPane.showMessageDialog(contentPanel, "Please fill all the fields");
						else
						{
							JOptionPane.showMessageDialog(contentPanel, "Registration Succesful");
							dispose();
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
