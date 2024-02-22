package AKHIL5A1;

import java.awt.EventQueue;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;

public class imgtest {

	private JFrame frame;
	private JTextField uname;
	private JTextField fname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					imgtest window = new imgtest();
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
	public imgtest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Your Name");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(82, 91, 104, 45);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Friend's Name");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(82, 133, 104, 45);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("FRIENDSHIP CALC");
		lblNewLabel_1_2.setForeground(Color.WHITE);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		lblNewLabel_1_2.setBounds(103, 24, 233, 45);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		uname = new JTextField();
		uname.setBounds(196, 104, 129, 20);
		frame.getContentPane().add(uname);
		uname.setColumns(10);
		
		fname = new JTextField();
		fname.setColumns(10);
		fname.setBounds(196, 146, 129, 20);
		frame.getContentPane().add(fname);
		
		JButton check = new JButton("CHECK");
		check.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		check.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			 Random r = new Random();
			 int res = r.nextInt(1,100);
			 JOptionPane.showMessageDialog(check,"Your Friendship : "+res);
			}
		});;
		check.setBackground(new Color(192, 192, 192));
		check.setForeground(new Color(0, 0, 0));
		check.setBounds(158, 198, 104, 23);
		frame.getContentPane().add(check);
		
		JLabel lblNewLabel = new JLabel("SUBMIT");
		lblNewLabel.setBounds(0, 0, 434, 261);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\admim\\Downloads\\img1 (1).png"));
		frame.getContentPane().add(lblNewLabel);
	}
}
