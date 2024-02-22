package test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class indbook {

	private JFrame frame;
	private JTextField name;
	private JTextField ph;
	tt t = new tt();
	int n = 0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					indbook window = new indbook();
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
	public indbook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 128));
		frame.getContentPane().setLayout(null);
		
		JLabel title = new JLabel("Ticket Booking");
		title.setForeground(new Color(255, 255, 255));
		title.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		title.setBounds(146, 0, 150, 45);
		frame.getContentPane().add(title);
		
		JLabel uname = new JLabel("Name");
		uname.setForeground(Color.WHITE);
		uname.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		uname.setBounds(46, 56, 67, 45);
		frame.getContentPane().add(uname);
		
		JLabel phone = new JLabel("phone");
		phone.setForeground(Color.WHITE);
		phone.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		phone.setBounds(46, 101, 67, 45);
		frame.getContentPane().add(phone);
		
		JLabel lblTickets = new JLabel("Tickets");
		lblTickets.setForeground(Color.WHITE);
		lblTickets.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblTickets.setBounds(46, 148, 67, 45);
		frame.getContentPane().add(lblTickets);
		
		name = new JTextField();
		name.setBounds(146, 71, 86, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		ph = new JTextField();
		ph.setBounds(146, 116, 86, 20);
		frame.getContentPane().add(ph);
		ph.setColumns(10);
		
		JComboBox ticks = new JComboBox();
		ticks.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4"}));
		ticks.setBounds(146, 162, 46, 22);
		frame.getContentPane().add(ticks);
		
		JButton next = new JButton("Continue");
		next.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				n = (int)Integer.valueOf((String)ticks.getSelectedItem());
				if(t.free.size()==0) {
					JOptionPane.showMessageDialog(next, " Tickets are not available!!!");
				}
				else if(t.free.size()<n) {
					JOptionPane.showMessageDialog(next, n+" Tickets are not available!!!");
				}
				else {
					t.k=n+1;
					t.name = name.getText();
					t.ph = ph.getText();
					
					t.frame.setVisible(true);
					frame.setVisible(false);
				}
				
			}
		});
		next.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		next.setBounds(146, 205, 121, 23);
		frame.getContentPane().add(next);
		
		JLabel lblNewLabel = new JLabel("Available Tickets : "+t.free.size());
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(213, 160, 159, 27);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
