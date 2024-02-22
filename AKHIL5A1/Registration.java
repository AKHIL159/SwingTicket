package AKHIL5A1;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollBar;
import javax.swing.JSlider;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Registration {

	private JFrame frame;
	private JTextField uname;
	private JTextField upass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
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
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 128));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTRATION");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel.setBounds(115, 10, 191, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("NAME");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setBounds(87, 66, 90, 13);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_2.setBounds(87, 110, 90, 13);
		frame.getContentPane().add(lblNewLabel_2);
		
		uname = new JTextField();
		uname.setBounds(187, 62, 106, 21);
		frame.getContentPane().add(uname);
		uname.setColumns(10);
		
		JButton btnNewButton = new JButton("SUBMIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				String un=uname.getText();
				String up=upass.getText();
				if (un.length()<5 || up.length()<5) {
					JOptionPane.showMessageDialog(btnNewButton,"REGISTRATION FAILED!!!\n Requirements not met.");
				}
				else {
				//String ps=tb1.getText();
               // JOptionPane.showMessageDialog(btnNewButton,"HELLO"+ nm+"REGISTRATION done");
				String url = "jdbc:mysql://localhost:3306/test"; // table details
			    String username = "root"; // MySQL credentials
			    String password = "1234";
			    String query1 = "select * from tt1 where name=?;";
			    String query2 = "insert into tt1 values(?,?);"; // query to be run
			    try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, username, password);
					PreparedStatement ps1 = con.prepareStatement(query1);
					ps1.setString(1, un);
					ResultSet rs = ps1.executeQuery();
					if(!rs.next()) {
						PreparedStatement ps2 = con.prepareStatement(query2);
					    ps2.setString(1, un);
					    ps2.setString(2, up);
					    ps2.executeUpdate();
					    JOptionPane.showMessageDialog(btnNewButton,"REGISTRATION done");
					}
					else {
						JOptionPane.showMessageDialog(btnNewButton,"REGISTRATION FAILED!!!\n User already exists.");
					}
					
				    
				    //ResultSet rs= st.executeQuery(query); // Execute query
				    //ps.executeUpdate();
				    
//				    while(rs.next()) {
//				    	String name= rs.getString("name"); // Retrieve name from db
//					    System.out.println(name);
//				    }
			    } catch (ClassNotFoundException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} // Driver name
			
				
			    
				
				
				
				 ind i=new ind();
				 i.setVisible(true);
				 frame.setVisible(false);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBounds(148, 164, 85, 21);
		frame.getContentPane().add(btnNewButton);
		
		upass = new JTextField();
		upass.setColumns(10);
		upass.setBounds(187, 108, 106, 21);
		frame.getContentPane().add(upass);
		
		JLabel lblNewLabel_3 = new JLabel("min. 5 chars");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setBounds(303, 66, 73, 17);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("min. 5 chars");
		lblNewLabel_3_1.setForeground(Color.WHITE);
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		lblNewLabel_3_1.setBounds(303, 110, 73, 17);
		frame.getContentPane().add(lblNewLabel_3_1);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void setVisible(boolean b) {
		// TODO Auto-generated method stub
		frame.setVisible(true);
	}
}

