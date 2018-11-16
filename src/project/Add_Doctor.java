package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Add_Doctor extends JFrame {

	private JPanel contentPane;
	private JTextField txt1;
	private JTextField txt2;
	private JTextField txt3;
	private JTextField txt4;
	private JTextField txt5;
	private JTextField txt6;
	private JTextField txt7;
	private JTextField txt8;
	Appt a;
	/**
	 * Launch the application.
	 */
	public static void Add_Doctor() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Add_Doctor frame = new Add_Doctor();
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
	public Add_Doctor() {
		setTitle("Doctor");
		a = new Appt();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 307, 444);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(10, 21, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setBounds(10, 50, 59, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(10, 80, 46, 14);
		contentPane.add(lblGender);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 134, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 164, 46, 14);
		contentPane.add(lblAddress);
		
		txt1 = new JTextField();
		txt1.setBounds(81, 18, 181, 20);
		contentPane.add(txt1);
		txt1.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(10, 105, 46, 14);
		contentPane.add(lblAge);
		
		txt2 = new JTextField();
		txt2.setBounds(81, 47, 181, 20);
		contentPane.add(txt2);
		txt2.setColumns(10);
		
		txt3 = new JTextField();
		txt3.setBounds(81, 102, 181, 20);
		contentPane.add(txt3);
		txt3.setColumns(10);
		
		JRadioButton rdbtnM = new JRadioButton("M");
		rdbtnM.setBounds(75, 74, 33, 23);
		contentPane.add(rdbtnM);
		
		JRadioButton rdbtnF = new JRadioButton("F");
		rdbtnF.setBounds(128, 74, 39, 23);
		contentPane.add(rdbtnF);
		
		txt4 = new JTextField();
		txt4.setBounds(81, 129, 181, 20);
		contentPane.add(txt4);
		txt4.setColumns(10);
		
		txt5 = new JTextField();
		txt5.setBounds(81, 161, 181, 39);
		contentPane.add(txt5);
		txt5.setColumns(10);
		
		JButton btnSignup = new JButton("Add");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = txt1.getText();
				String pass = txt2.getText();
				String age = txt3.getText();
				String email = txt4.getText();
				String address = txt5.getText();
				String gender;
				if(rdbtnM.isSelected()) {
					gender = "M";
				}
				else {
					gender = "F";
				}
				String pos = txt7.getText();
				int dep = Integer.parseInt(txt6.getText());
				int room = Integer.parseInt(txt8.getText());
				int id = 20180000;
				try{
					Connection con = Connection_DB.main();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery("SELECT MAX(id) FROM doctor");  
					
					if (rs.next())
					{
						id = rs.getInt(1)+1;
					}
					else
					{
						id = 2018001;
					}
					
					String q = "Insert into doctor values("+ id +",'"+name+"','"+pass+"','"+address+"','"+email+"','"
							+gender+"','"+pos+"','"+a.apt+"',"+dep+","+room+",'"+age+"')";
					
					Statement s = con.createStatement();
					s.executeUpdate(q);
					
					Connection_DB.close();
				}
				catch (Exception z){
					z.printStackTrace();
				}
				
			}
		});
		btnSignup.setBounds(97, 377, 89, 23);
		contentPane.add(btnSignup);
		
		JLabel lblDepartment = new JLabel("DeptNo:");
		lblDepartment.setBounds(10, 223, 46, 14);
		contentPane.add(lblDepartment);
		
		JLabel lblTime = new JLabel("Postion:");
		lblTime.setBounds(10, 252, 46, 14);
		contentPane.add(lblTime);
		
		JLabel lblNewLabel_2 = new JLabel("Room No:");
		lblNewLabel_2.setBounds(10, 290, 59, 14);
		contentPane.add(lblNewLabel_2);
		
		txt6 = new JTextField();
		txt6.setBounds(81, 220, 181, 20);
		contentPane.add(txt6);
		txt6.setColumns(10);
		
		txt7 = new JTextField();
		txt7.setBounds(81, 249, 181, 20);
		contentPane.add(txt7);
		txt7.setColumns(10);
		
		txt8 = new JTextField();
		txt8.setBounds(81, 287, 181, 20);
		contentPane.add(txt8);
		txt8.setColumns(10);
		
		JLabel lblApttime = new JLabel("ApptTime:");
		lblApttime.setBounds(10, 331, 59, 14);
		contentPane.add(lblApttime);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdateAppt.UpdateApp(a);
			}
		});
		btnUpdate.setBounds(81, 327, 89, 23);
		contentPane.add(btnUpdate);
	}
}
