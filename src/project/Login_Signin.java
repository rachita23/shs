package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Login_Signin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void Login_Signin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login_Signin frame = new Login_Signin();
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
	public Login_Signin() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 316, 142);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("UserName:");
		lblName.setBounds(10, 11, 57, 14);
		contentPane.add(lblName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(10, 36, 57, 14);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(86, 8, 188, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 33, 188, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String pass = textField_1.getText();
				String q = "Select password,id from paitient where name = '"+ username +"'";
				try{
					Connection con = Connection_DB.main();
					Statement s = con.createStatement();
					ResultSet r = s.executeQuery(q);
					while(r.next()){
						String res = r.getString("password");
						if(pass.equals(res)){
							int a = r.getInt("id");
							Patient_Menu obj = new Patient_Menu();
							obj.Patient_Menu(a);
						}
						else{
							JOptionPane.showMessageDialog(null, "Invalid Username or Password..!!", "alert", JOptionPane.ERROR_MESSAGE);
						}
					}
				}
				catch (Exception z){
					z.printStackTrace();
				}
				
			}
		});
		btnNewButton.setBounds(86, 67, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnSignUp = new JButton("Sign Up");
		btnSignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SignUp obj = new SignUp();
				obj.SignUp();
				
			}
		});
		btnSignUp.setBounds(185, 67, 89, 23);
		contentPane.add(btnSignUp);
	}
}
