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
import java.awt.event.ActionEvent;
import java.mysql.*;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	public int a;
	/**
	 * Launch the application.
	 */
	public static void New_Login(int a) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.a = a;
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
	public Login() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 274, 140);
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
		textField.setBounds(86, 8, 165, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(86, 33, 165, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String username = textField.getText();
				String pass = textField_1.getText();
				if(a==0) {
					if(username == "admin" && pass == "admin")
					{
						Admin_Menu obj = new Admin_Menu();
						obj.Admin_Menu();
					}
				}
				else {
					String q = "Select password from doctor where name = '" + username + "'";
					try{
						Connection con = Connection_DB.main();
						Statement s = con.createStatement();
						Result r = s.executeStatement(q);
						while(r.next()){
							String res = r.getString("password");
							if(pass == res){
								Doctor_Menu obj = new Doctor_Menu();
								obj.Doctor_Menu();
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
			}
		});
		btnNewButton.setBounds(86, 67, 89, 23);
		contentPane.add(btnNewButton);
	}
}
