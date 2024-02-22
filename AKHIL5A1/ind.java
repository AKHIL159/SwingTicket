package AKHIL5A1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ind {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ind window = new ind();
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
	public ind() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 128));
		frame.getContentPane().setLayout(null);
		
		JButton login = new JButton("Login");
		login.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
			 login l = new login();
			 l.setVisible(true);
			}
		});
		login.setBounds(165, 78, 89, 29);
		frame.getContentPane().add(login);
		
		JButton register = new JButton("Register");
		register.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		register.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				
			 Registration r = new Registration();
			 r.setVisible(true);
			}
		});
		register.setBounds(150, 135, 127, 29);
		frame.getContentPane().add(register);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}

}
