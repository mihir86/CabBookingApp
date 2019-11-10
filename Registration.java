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
		{
			JLabel lblUsername = new JLabel("UserName");
			lblUsername.setBounds(63, 102, 71, 16);
			contentPanel.add(lblUsername);
		}
		{
			textField = new JTextField();
			textField.setBounds(163, 99, 167, 22);
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblUserid = new JLabel("UserID");
			lblUserid.setBounds(63, 141, 59, 16);
			contentPanel.add(lblUserid);
		}
		{
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(163, 138, 167, 22);
			contentPanel.add(textField_1);
		}
		{
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setBounds(63, 188, 59, 16);
			contentPanel.add(lblPassword);
		}
		{
			JLabel lblEmailid = new JLabel("email-id");
			lblEmailid.setBounds(63, 238, 59, 16);
			contentPanel.add(lblEmailid);
		}
		{
			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(163, 235, 167, 22);
			contentPanel.add(textField_3);
		}
		{
			JLabel lblPhone = new JLabel("Phone");
			lblPhone.setBounds(63, 289, 59, 16);
			contentPanel.add(lblPhone);
		}
		{
			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(163, 286, 167, 22);
			contentPanel.add(textField_4);
		}
		{
			passwordField = new JPasswordField();
			passwordField.setBounds(163, 185, 167, 22);
			contentPanel.add(passwordField);
		}
		{
			JLabel lblRegistration = new JLabel("Registration");
			lblRegistration.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblRegistration.setBounds(63, 39, 112, 22);
			contentPanel.add(lblRegistration);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton RegisterButton = new JButton("Register");
				RegisterButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						JOptionPane.showMessageDialog(RegisterButton, "Registration Succesful");
					}
				});
				RegisterButton.setActionCommand("OK");
				buttonPane.add(RegisterButton);
				getRootPane().setDefaultButton(RegisterButton);
			}
			{
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
	}

}
