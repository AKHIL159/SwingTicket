package test;

import java.awt.EventQueue;
import java.util.*;

import java.sql.*;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;
import javax.swing.SwingUtilities;
import javax.swing.JProgressBar;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class tt {
	int c=0,k=4;
	String name = "";
	String ph = "";
	int price = (k)*100;
	
	ArrayList<JToggleButton> close = new ArrayList();
	ArrayList<JToggleButton> free = new ArrayList();
	List<JToggleButton> temp = new ArrayList<JToggleButton>();
	
	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					tt window = new tt();
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
	public tt() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 9));
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setLayout(null);
		JToggleButton A1 = new JToggleButton("A1");
		JToggleButton A2 = new JToggleButton("A2");
		JToggleButton B1 = new JToggleButton("B1");
		JToggleButton C1 = new JToggleButton("C1");
		JToggleButton D1 = new JToggleButton("D1");
		JToggleButton E1 = new JToggleButton("E1");
		JToggleButton C2 = new JToggleButton("C2");
		JToggleButton D2 = new JToggleButton("D2");
		JToggleButton E2 = new JToggleButton("E2");
		JToggleButton E4 = new JToggleButton("E4");
		JToggleButton D4 = new JToggleButton("D4");
		JToggleButton C4 = new JToggleButton("C4");
		JToggleButton B4 = new JToggleButton("B4");
		JToggleButton A4 = new JToggleButton("A4");
		JToggleButton E3 = new JToggleButton("E3");
		JToggleButton D3 = new JToggleButton("D3");
		JToggleButton C3 = new JToggleButton("C3");
		JToggleButton B3 = new JToggleButton("B3");
		JToggleButton A3 = new JToggleButton("A3");
		JToggleButton B2 = new JToggleButton("B2");
		
		HashMap<String,JToggleButton> btns = new HashMap<String,JToggleButton>();
		btns.put("A1",A1);
		btns.put("A2",A2);
		btns.put("B1",B1);
		btns.put("C1",C1);
		btns.put("D1",D1);
		btns.put("E1",E1);
		btns.put("C2",C2);
		btns.put("D2",D2);
		btns.put("E2",E2);
		btns.put("E4",E4);
		btns.put("D4",D4);
		btns.put("C4",C4);
		btns.put("B4",B4);
		btns.put("A4",A4);
		btns.put("E3",E3);
		btns.put("D3",D3);
		btns.put("C3",C3);
		btns.put("B3",B3);
		btns.put("A3",A3);
		btns.put("B2",B2);
		
		
//		List<JToggleButton> close = Arrays.asList(C1,C2,C3,C4,D1,D2,D3,D4,E1,E2,E3,E4);
//		List<JToggleButton> free = Arrays.asList(A1,A2,A3,A4,B1,B2,B3,B4);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
			
//			String query = "update ticket set state = ? where id = ?";
			
			String q1 = "select * from ticket";
			//String q2 = "select * from ticket where state = 0";
			
			Statement s1 = con.createStatement();
			ResultSet r = s1.executeQuery(q1);
			
			while(r.next()) {
				if(r.getInt("state")==1) {
					close.add(btns.get(r.getString("id")));
				}
				else {
					free.add(btns.get(r.getString("id")));
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
				
					
		JLabel head = new JLabel("Select Tickets");
		head.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 22));
		head.setForeground(new Color(255, 255, 255));
		head.setBounds(145, 11, 131, 26);
		frame.getContentPane().add(head);
		
		
		A1.setForeground(new Color(255, 255, 255));
		A1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==k-1 && !A1.isSelected()) {
					temp.remove(A1);
					c--;
				}
				else if(close.contains(A1) || c==k-1) {
					A1.setSelected(false);
				}
				else if(A1.isSelected()){
					//System.out.print(A1.isSelected());
					temp.add(A1);
					c++;
				}
				else if (!A1.isSelected()){
					//System.out.print(A1.isSelected());
					temp.remove(A1);
					c--;
				}
			}
		});
		A1.setBackground(new Color(64, 0, 0));
		A1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		A1.setBounds(44, 44, 45, 26);
		frame.getContentPane().add(A1);
		
		
		A2.setForeground(new Color(255, 255, 255));
		A2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==k-1 && !A2.isSelected()) {
					temp.remove(A2);
					c--;
				}
				else if(close.contains(A2) || c==k-1) {
					A2.setSelected(false);
				}
				else if(A2.isSelected()){
					temp.add(A2);
					c++;
				}
				else {
					temp.remove(A2);
					c--;
				}
			}
		});
		A2.setBackground(new Color(64, 0, 0));
		A2.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		A2.setBounds(99, 44, 45, 26);
		frame.getContentPane().add(A2);
		
		
		B1.setForeground(new Color(255, 255, 255));
		B1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==k-1 && !B1.isSelected()) {
					temp.remove(B1);
					c--;
				}
				else if(close.contains(B1) || c==k-1) {
					B1.setSelected(false);
				}
				else if(B1.isSelected()){
					c++;
					temp.add(B1);
				}
				else {
					c--;
					temp.remove(B1);
				}
			}
		});
		B1.setBackground(new Color(64, 0, 0));
		B1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		B1.setBounds(44, 81, 45, 26);
		frame.getContentPane().add(B1);
		
		
		C1.setForeground(new Color(255, 255, 255));
		C1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==k-1 && !C1.isSelected()) {
					c--;temp.remove(C1);
				}
				else if(close.contains(C1) || c==k-1) {
					C1.setSelected(false);
				}
				else if(C1.isSelected()){
					c++;temp.add(C1);
				}
				else {
					c--;
					temp.remove(C1);
				}
			}
		});
		C1.setBackground(new Color(64, 0, 0));
		C1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		C1.setBounds(44, 118, 45, 26);
		frame.getContentPane().add(C1);
		
		
		D1.setForeground(new Color(255, 255, 255));
		D1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==k-1 && !D1.isSelected()) {
					temp.remove(D1);
					c--;
				}
				else if(close.contains(D1) || c==k-1) {
					D1.setSelected(false);
				}
				else if(D1.isSelected()){
					temp.add(D1);
					c++;
				}
				else {
					temp.remove(D1);
					c--;
				}
			}
		});
		D1.setBackground(new Color(64, 0, 0));
		D1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		D1.setBounds(44, 155, 45, 26);
		frame.getContentPane().add(D1);
		
		
		E1.setForeground(new Color(255, 255, 255));
		E1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==k-1 && !E1.isSelected()) {
					temp.remove(E1);
					c--;
				}
				else if(close.contains(E1) || c==k-1) {
					E1.setSelected(false);
				}
				else if(E1.isSelected()){
					c++;
					temp.add(E1);
				}
				else {
					temp.remove(E1);
					c--;
				}
			}
		});
		E1.setBackground(new Color(64, 0, 0));
		E1.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		E1.setBounds(44, 192, 45, 26);
		frame.getContentPane().add(E1);
		
		
		B2.setForeground(new Color(255, 255, 255));
		B2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==k-1 && !B2.isSelected()) {
					temp.remove(B2);
					c--;
				}
				else if(close.contains(B2) || c==k-1) {
					B2.setSelected(false);
				}
				else if(B2.isSelected()){
					c++;
					temp.add(B2);
				}
				else {
					temp.remove(B2);
					c--;
				}
			}
		});
		B2.setBackground(new Color(64, 0, 0));
		B2.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		B2.setBounds(99, 82, 45, 26);
		frame.getContentPane().add(B2);
		
		
		C2.setForeground(new Color(255, 255, 255));
		C2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==k-1 && !C2.isSelected()) {
					c--;temp.remove(C2);
				}
				else if(close.contains(C2) || c==k-1) {
					C2.setSelected(false);
				}
				else if(C2.isSelected()){
					c++;temp.add(C2);
				}
				else {
					c--;temp.remove(A2);
				}
			}
		});
		C2.setBackground(new Color(64, 0, 0));
		C2.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		C2.setBounds(99, 119, 45, 26);
		frame.getContentPane().add(C2);
		
		
		D2.setForeground(new Color(255, 255, 255));
		D2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==k-1 && !D2.isSelected()) {
					c--;temp.remove(D2);
				}
				else if(close.contains(D2) || c==k-1) {
					D2.setSelected(false);
				}
				else if(D2.isSelected()){
					c++;temp.add(D2);
				}
				else {
					c--;temp.remove(D2);
				}
			}
		});
		D2.setBackground(new Color(64, 0, 0));
		D2.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		D2.setBounds(99, 156, 45, 26);
		frame.getContentPane().add(D2);
		
		
		E2.setForeground(new Color(255, 255, 255));
		E2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==k-1 && !E2.isSelected()) {
					c--;temp.remove(E2);
				}
				else if(close.contains(E2) || c==k-1) {
					E2.setSelected(false);
				}
				else if(E2.isSelected()){
					c++;temp.add(E2);
				}
				else {
					c--;temp.remove(E2);
				}
			}
		});
		E2.setBackground(new Color(64, 0, 0));
		E2.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		E2.setBounds(99, 193, 45, 26);
		frame.getContentPane().add(E2);
		
		
		A3.setForeground(new Color(255, 255, 255));
		A3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==k-1 && !A3.isSelected()) {
					c--;temp.remove(A3);
				}
				else if(close.contains(A3) || c==k-1) {
					A3.setSelected(false);
				}
				else if(A3.isSelected()){
					c++;temp.add(A3);
				}
				else {
					c--;temp.remove(A3);
				}
			}
		});
		A3.setBackground(new Color(64, 0, 0));
		A3.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		A3.setBounds(249, 45, 45, 26);
		frame.getContentPane().add(A3);
		
		
		B3.setForeground(new Color(255, 255, 255));
		B3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==k-1 && !B3.isSelected()) {
					c--;temp.remove(B3);
				}
				else if(close.contains(B3) || c==k-1) {
					B3.setSelected(false);
				}
				else if(B3.isSelected()){
					c++;temp.add(B3);
				}
				else {
					c--;temp.remove(B3);
				}
			}
		});
		B3.setBackground(new Color(64, 0, 0));
		B3.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		B3.setBounds(249, 82, 45, 26);
		frame.getContentPane().add(B3);
		
		
		C3.setForeground(new Color(255, 255, 255));
		C3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==k-1 && !C3.isSelected()) {
					c--;temp.remove(C3);
				}
				else if(close.contains(C3) || c==k-1) {
					C3.setSelected(false);
				}
				else if(C3.isSelected()){
					c++;temp.add(C3);
				}
				else {
					c--;temp.remove(C3);
				}
			}
		});
		C3.setBackground(new Color(64, 0, 0));
		C3.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		C3.setBounds(249, 119, 45, 26);
		frame.getContentPane().add(C3);
		
		
		D3.setForeground(new Color(255, 255, 255));
		D3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==k-1 && !D3.isSelected()) {
					c--;temp.remove(D3);
				}
				else if(close.contains(D3) || c==k-1) {
					D3.setSelected(false);
				}
				else if(D3.isSelected()){
					temp.add(D3);
					c++;
				}
				else {
					temp.remove(D3);
					c--;
				}
			}
		});
		D3.setBackground(new Color(64, 0, 0));
		D3.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		D3.setBounds(249, 156, 45, 26);
		frame.getContentPane().add(D3);
		
		
		E3.setForeground(new Color(255, 255, 255));
		E3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==k-1 && !E3.isSelected()) {
					c--;temp.remove(E3);
				}
				else if(close.contains(E3) || c==k-1) {
					E3.setSelected(false);
				}
				else if(E3.isSelected()){
					c++;temp.add(E3);
				}
				else {
					c--;temp.remove(E3);
				}
			}
		});
		E3.setBackground(new Color(64, 0, 0));
		E3.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		E3.setBounds(249, 193, 45, 26);
		frame.getContentPane().add(E3);
		
		
		A4.setForeground(new Color(255, 255, 255));
		A4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==k-1 && !A4.isSelected()) {
					c--;temp.remove(A4);
				}
				else if(close.contains(A4) || c==k-1) {
					A4.setSelected(false);
				}
				else if(A4.isSelected()){
					c++;temp.add(A4);
				}
				else {
					c--;temp.remove(A4);
				}
			}
		});
		A4.setBackground(new Color(64, 0, 0));
		A4.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		A4.setBounds(304, 44, 45, 26);
		frame.getContentPane().add(A4);
		
		
		B4.setForeground(new Color(255, 255, 255));
		B4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==k-1 && !B4.isSelected()) {
					c--;temp.remove(B4);
				}
				else if(close.contains(B4) || c==k-1) {
					B4.setSelected(false);
				}
				else if(B4.isSelected()){
					c++;temp.add(B4);
				}
				else {
					c--;temp.remove(B4);
				}
			}
		});
		B4.setBackground(new Color(64, 0, 0));
		B4.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		B4.setBounds(304, 82, 45, 26);
		frame.getContentPane().add(B4);
		
		
		C4.setForeground(new Color(255, 255, 255));
		C4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==k-1 && !C4.isSelected()) {
					c--;temp.remove(C4);
				}
				else if(close.contains(C4) || c==k-1) {
					C4.setSelected(false);
				}
				else if(C4.isSelected()){
					c++;temp.add(C4);
				}
				else {
					c--;temp.remove(C4);
				}
			}
		});
		C4.setBackground(new Color(64, 0, 0));
		C4.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		C4.setBounds(304, 119, 45, 26);
		frame.getContentPane().add(C4);
		
		
		D4.setForeground(new Color(255, 255, 255));
		D4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==k-1 && !D4.isSelected()) {
					c--;temp.remove(D4);
				}
				else if(close.contains(D4) || c==k-1) {
					D4.setSelected(false);
				}
				else if(D4.isSelected()){
					c++;temp.add(D4);
				}
				else {
					c--;temp.remove(D4);
				}
			}
		});
		D4.setBackground(new Color(64, 0, 0));
		D4.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		D4.setBounds(304, 156, 45, 26);
		frame.getContentPane().add(D4);
		
		
//		E4.addActionListener(new ActionListener(){
//			public void actionPerformed(ActionEvent e) {
//				if(close.contains(E4)) {
//					E4.setBackground(Color.RED);
//				}
//				else {
//					//count++;
//				}
//			}
//		});
		E4.setForeground(new Color(255, 255, 255));
		E4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(c==k-1 && !E4.isSelected()) {
					c--;temp.remove(E4);
				}
				else if(close.contains(E4) || c==k-1) {
					E4.setSelected(false);
				}
				else if(E4.isSelected()){
					c++;temp.add(E4);
				}
				else {
					c--;temp.remove(E4);
				}
			}
		});
		E4.setBackground(new Color(64, 0, 0));
		E4.setFont(new Font("Segoe UI", Font.PLAIN, 9));
		E4.setBounds(304, 193, 45, 26);
		frame.getContentPane().add(E4);
		
		JButton cbtn = new JButton("CONFIRM");
		cbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
					String q2 = "update ticket set state = 1 where id = ?";
					PreparedStatement ps = con.prepareStatement(q2);
					for(JToggleButton x: temp) {
						ps.setString(1, x.getLabel());
						ps.executeUpdate();
						free.remove(x);
						close.add(x);
					
					}
					
				}catch(Exception e1) {
						e1.printStackTrace();
					}
				finally {
					for(JToggleButton t: free) {
						//t.setSelected(true);
						t.setBackground(Color.GREEN);
					}
					for(JToggleButton t: close) {
						//t.setSelected(true);
						t.setBackground(Color.RED);
					}
					String bticks = "";
					
					try {
						for(JToggleButton x:temp) {
							bticks+=x.getLabel()+" ";
						}
						Class.forName("com.mysql.cj.jdbc.Driver");
						Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "1234");
						indbook i = new indbook();
						PreparedStatement ps1 = con.prepareStatement("insert into udata values(?,?,?,?,?)");
						ps1.setString(1,name);
						ps1.setString(2, ph);
						ps1.setInt(3,k-1);
						ps1.setString(4, bticks);
						ps1.setInt(5, (k-1)*100);
						
						ps1.executeUpdate();
						
						
						JOptionPane.showMessageDialog(cbtn, "Tickets Booked!\nname: "+name+"\nphone: "+ph+
								"\nprice: "+c*100+"\ntickets: "+bticks);
					}
					catch(Exception qw){
						qw.printStackTrace();
					}
					
					
					frame.setVisible(false);
					//SwingUtilities.updateComponentTreeUI(frame);
				}
			}
		});
		cbtn.setFont(new Font("Times New Roman", Font.BOLD, 10));
		cbtn.setBounds(154, 227, 89, 23);
		frame.getContentPane().add(cbtn);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		for(JToggleButton t: free) {
			//t.setSelected(true);
			t.setBackground(Color.GREEN);
		}
		for(JToggleButton t: close) {
			//t.setSelected(true);
			t.setBackground(Color.RED);
		}
//		if(A1.getBackground()==Color.GREEN) {
//			A1.setBackground(Color.ORANGE);
//		}
		//List<JToggleButton> temp = Arrays.asList(A1,A2,A3,A4,B1,B2,B3,B4,C1,C2,C3,C4,D1,D2,D3,D4,E1,E2,E3,E4);
//		ArrayList<JToggleButton> a = new ArrayList();
//		a.addAll(temp);
		
		
	}
}
