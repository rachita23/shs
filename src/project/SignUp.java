package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

public class SignUp extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void SignUp() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SignUp frame = new SignUp();
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
	public SignUp() {
		setTitle("SignUP");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 344, 365);
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
		
		textField = new JTextField();
		textField.setBounds(81, 18, 181, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(10, 105, 46, 14);
		contentPane.add(lblAge);
		
		textField_1 = new JTextField();
		textField_1.setBounds(81, 47, 181, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(81, 102, 181, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		ButtonGroup btn = new ButtonGroup();
		
		JRadioButton rdbtnM = new JRadioButton("M");
		rdbtnM.setBounds(75, 74, 33, 23);
		contentPane.add(rdbtnM);
		btn.add(rdbtnM);
		JRadioButton rdbtnF = new JRadioButton("F");
		rdbtnF.setBounds(150, 76, 39, 23);
		contentPane.add(rdbtnF);
		btn.add(rdbtnF);
		textField_3 = new JTextField();
		textField_3.setBounds(81, 129, 181, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(81, 161, 181, 39);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		JButton btnSignup = new JButton("SignUp");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				String pass = textField_1.getText();
				String age = textField_2.getText();
				String email = textField_3.getText();
				String address = textField_4.getText();
				String gender;
				int id ;//= 16;
				if(rdbtnF.isSelected()) {
					gender = "F";
				}
				else {
					gender = "M";
				}
				try{
					Connection con = Connection_DB.main();
					Statement s = con.createStatement();
					ResultSet rs = s.executeQuery("SELECT MAX(id) FROM paitient");  
					
					if (rs.next())
					{
						id = rs.getInt(1)+1;
					}
					else
					{
						id = 2018001;
					}
					String q = "Insert into paitient values('"+id+"','"+name+"','"+pass+"','"+address+"','"+email+"','"+gender+"','nil',0,0,0,'"+age+"')";
					s.executeUpdate(q);
					String create = "CREATE TABLE History"+id+"(visit_date varchar(20),"+"discharge_date varchar(20),"+"doctor varchar(50),"+"prescription varchar(100),"+"tests varchar(100),"+"disease varchar(20),"+"critical varchar(3))";
					s.executeUpdate(create);
					Login_Signin obj = new Login_Signin();
					obj.Login_Signin();
				}
				catch (Exception z){
					z.printStackTrace();
				}
				
			}
		});
		btnSignup.setBounds(90, 230, 89, 23);
		contentPane.add(btnSignup);
	}
}
