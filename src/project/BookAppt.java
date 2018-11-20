package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

public class BookAppt extends JFrame {

	private JPanel contentPane;
	public int did;
	public int pid;
	/**
	 * Launch the application.
	 */
	public static void BookAppt(int did, int pid) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAppt frame = new BookAppt();
					frame.did = did;
					frame.pid = pid;
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public BookAppt() {
		setTitle("Book");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 181, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		try {
			String q = "Select appt_time from doctor where id = "+did;
			Connection con = Connection_DB.main();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(q);
			String a = rs.getString(("appt_time"));
			String ap [];
			ap = a.split(";");
			for (int i=0; i<ap.length; i++) {
				if(ap[i]!=null) {
					if(i==0) {
						comboBox.addItem(new String("Monday "+ap[i]));
					}
					else if(i==1) {
						comboBox.addItem(new String("Tuesday "+ap[i]));
					}
					else if(i==2) {
						comboBox.addItem(new String("Wednesday "+ap[i]));
					}
					else if(i==3) {
						comboBox.addItem(new String("Thursday "+ap[i]));
					}
					else if(i==4) {
						comboBox.addItem(new String("Friday "+ap[i]));
					}
					else if(i==5) {
						comboBox.addItem(new String("Saturday "+ap[i]));
					}
					else if(i==6) {
						comboBox.addItem(new String("Sunday "+ap[i]));
					}
				}
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		comboBox.setBounds(10, 46, 98, 20);
		contentPane.add(comboBox);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(10, 77, 98, 14);
		contentPane.add(lblTime);
		
		JButton btnBook = new JButton("Book");
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				String day=null;
				if(((String)comboBox.getSelectedItem()).equals("Monday %")) {
					day = "Monday";
				}
				else if(((String)comboBox.getSelectedItem()).equals("Tuesday %")) {
					day = "Tuesday";
				}
				else if(((String)comboBox.getSelectedItem()).equals("Wednesday %")) {
					day = "Wednesday";
				}
				else if(((String)comboBox.getSelectedItem()).equals("Thursday %")) {
					day = "Thursday";
				}
				else if(((String)comboBox.getSelectedItem()).equals("Friday %")) {
					day = "Friday";
				}
				else if(((String)comboBox.getSelectedItem()).equals("Saturday %")) {
					day = "Saturday";
				}
				else {
					day = "Sunday";
				}
				Connection con = Connection_DB.main();
				Statement stmt = con.createStatement();
				String q1 = "Select max(s_no) from history"+pid;
				ResultSet r = stmt.executeQuery(q1);
				int a = r.getInt("s_no") + 1;
				String q = "Update history"+pid+" set s_no ="+a+", visit_date = '"+day+"' , discharge_date = 'null', doctor ="+did;
				ResultSet rs = stmt.executeQuery(q);
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}});
		btnBook.setBounds(10, 116, 80, 20);
		contentPane.add(btnBook);
		
	}
}
