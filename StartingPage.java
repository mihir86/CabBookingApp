import java.awt.EventQueue;
import java.awt.*;
import javax.swing.*;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.awt.event.*;

import javax.swing.JTextField;

public class StartingPage {

	private JFrame frame;
	private JTextField textField;
	private JLabel hyperlink;
	private Registration registrationPage;
	private JButton btnLogin;
	private JPasswordField passwordField;
	private Booking bookingPage;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StartingPage window = new StartingPage();
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
	public StartingPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 774, 534);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToMars = new JLabel("Welcome to MARS Cabs");
		lblWelcomeToMars.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblWelcomeToMars.setBounds(194, 52, 364, 43);
		frame.getContentPane().add(lblWelcomeToMars);
		
		JLabel lblSignIn = new JLabel("Sign In");
		lblSignIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSignIn.setBounds(324, 142, 68, 25);
		frame.getContentPane().add(lblSignIn);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblUsername.setBounds(211, 212, 78, 25);
		frame.getContentPane().add(lblUsername);
		
		textField = new JTextField();
		textField.setBounds(301, 214, 168, 22);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPassword.setBounds(211, 273, 78, 25);
		frame.getContentPane().add(lblPassword);
		
		hyperlink = new JLabel("New User? Register here");
		hyperlink.setFont(new Font("Tahoma", Font.PLAIN, 16));
		hyperlink.setBounds(264, 403, 189, 32);
		frame.getContentPane().add(hyperlink);
		
		hyperlink.setForeground(Color.BLUE.darker());
	    hyperlink.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    
	    bookingPage = new Booking();
	    btnLogin = new JButton("Login");
	    btnLogin.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		bookingPage.setVisible(true);
	            frame.dispose();//to close the current jframe
	    	}
	    });
	    btnLogin.setBounds(301, 355, 97, 25);
	    frame.getContentPane().add(btnLogin);
	    
	    passwordField = new JPasswordField();
	    passwordField.setBounds(301, 275, 168, 22);
	    frame.getContentPane().add(passwordField);
	    
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
	}
}
