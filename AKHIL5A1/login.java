package AKHIL5A1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import javax.swing.JSeparator;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class login {

	private JFrame frame;
	private JTextField tb1;
	private JPasswordField passwordField;
	private JPasswordField ps1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login window = new login();
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
	public login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 20));
		frame.getContentPane().setBackground(new Color(0, 0, 128));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 21));
		lblNewLabel.setBounds(173, 22, 72, 23);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(29, 63, 97, 23);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(47, 138, 19, -6);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PASSWORD");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_3.setBounds(29, 108, 97, 13);
		frame.getContentPane().add(lblNewLabel_3);
		
		tb1 = new JTextField();
		tb1.setBounds(149, 63, 96, 19);
		frame.getContentPane().add(tb1);
		tb1.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			//	JOptionPane.showMessageDialog(btnNewButton,"done");
				String un=tb1.getText();
				String ps=ps1.getText();
				
				if(un.isEmpty()||ps.isEmpty()) {
					JOptionPane.showMessageDialog(btnNewButton,"INVALID CREDENTIALS!!!");
				}
				else {
					String url = "jdbc:mysql://localhost:3306/test"; // table details
				    String username = "root"; // MySQL credentials
				    String password = "1234";
				    String query1 = "select * from tt1 where name=?;";
				    try {
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection(url, username, password);
						PreparedStatement ps1 = con.prepareStatement(query1);
						ps1.setString(1, un);
						ResultSet rs = ps1.executeQuery();
						if(rs.isBeforeFirst()) {
							rs.next();
							//System.out.print(rs.getString(2).getClass());
							if(rs.getString(2).equals(ps)) {
								JOptionPane.showMessageDialog(btnNewButton,"success!!!");
								content_page c = new content_page();
								c.setVisible(true);
								frame.setVisible(false);
							}
							else {
								JOptionPane.showMessageDialog(btnNewButton,"INCORRECT PASSWORD!!!");
							}
						    
						}
						else {
							JOptionPane.showMessageDialog(btnNewButton,"LOGIN FAILED!!!\n User doesn't exist.");
						}
				}
				    catch (ClassNotFoundException | SQLException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				    }
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(140, 179, 90, 23);
		frame.getContentPane().add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(47, 203, 19, -6);
		frame.getContentPane().add(passwordField);
		
		ps1 = new JPasswordField();
		ps1.setBounds(149, 107, 96, 19);
		frame.getContentPane().add(ps1);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisible(boolean b) 
	{
		// TODO Auto-generated method stub
		frame.setVisible(true);
		
	}
}
