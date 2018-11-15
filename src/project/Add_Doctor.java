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
import java.awt.event.ActionEvent;

public class Add_Doctor extends JFrame {

	private JPanel contentPane;
	private JTextField txtAnu;
	private JTextField txtAnu_1;
	private JTextField textField_2;
	private JTextField txtAnugmailcom;
	private JTextField txtGhaziabad;
	private JTextField textField_5;
	private JTextField txtSenior;
	private JTextField textField_7;

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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		txtAnu = new JTextField();
		txtAnu.setBounds(81, 18, 181, 20);
		contentPane.add(txtAnu);
		txtAnu.setColumns(10);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(10, 105, 46, 14);
		contentPane.add(lblAge);
		
		txtAnu_1 = new JTextField();
		txtAnu_1.setBounds(81, 47, 181, 20);
		contentPane.add(txtAnu_1);
		txtAnu_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(81, 102, 181, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JRadioButton rdbtnM = new JRadioButton("M");
		rdbtnM.setBounds(75, 74, 33, 23);
		contentPane.add(rdbtnM);
		
		JRadioButton rdbtnF = new JRadioButton("F");
		rdbtnF.setBounds(128, 74, 39, 23);
		contentPane.add(rdbtnF);
		
		txtAnugmailcom = new JTextField();
		txtAnugmailcom.setBounds(81, 129, 181, 20);
		contentPane.add(txtAnugmailcom);
		txtAnugmailcom.setColumns(10);
		
		txtGhaziabad = new JTextField();
		txtGhaziabad.setBounds(81, 161, 181, 39);
		contentPane.add(txtGhaziabad);
		txtGhaziabad.setColumns(10);
		
		JButton btnSignup = new JButton("Add");
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		
		textField_5 = new JTextField();
		textField_5.setBounds(81, 220, 181, 20);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		txtSenior = new JTextField();
		txtSenior.setBounds(81, 249, 181, 20);
		contentPane.add(txtSenior);
		txtSenior.setColumns(10);
		
		textField_7 = new JTextField();
		textField_7.setBounds(81, 287, 181, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel lblApttime = new JLabel("ApptTime:");
		lblApttime.setBounds(10, 331, 59, 14);
		contentPane.add(lblApttime);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(81, 327, 89, 23);
		contentPane.add(btnUpdate);
	}
}
