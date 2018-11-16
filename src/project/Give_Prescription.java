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
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Give_Prescription extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	public ResultSet doc;

	/**
	 * Launch the application.
	 */
	public static void Give_Prescription(ResultSet doc) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Give_Prescription frame = new Give_Prescription();
					frame.doc = doc;
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
	public Give_Prescription() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 363, 259);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPatientName = new JLabel("Patient Name:");
		lblPatientName.setBounds(10, 22, 87, 14);
		contentPane.add(lblPatientName);
		
		JLabel lblMedicines = new JLabel("Medicines:");
		lblMedicines.setBounds(10, 56, 87, 14);
		contentPane.add(lblMedicines);
		
		JLabel lblTests = new JLabel("Tests:");
		lblTests.setBounds(10, 91, 87, 14);
		contentPane.add(lblTests);
		
		JLabel lblDisease = new JLabel("Disease:");
		lblDisease.setBounds(10, 126, 46, 14);
		contentPane.add(lblDisease);
		
		textField = new JTextField();
		textField.setBounds(130, 19, 187, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(130, 53, 187, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(130, 88, 187, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(130, 123, 187, 20);
		contentPane.add(textField_3);
		
		JButton btnPrescribe = new JButton("Prescribe");
		btnPrescribe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				try{
					String patname = textField.getText();
					String q = "Select id from paitient where name = '"+patname+"'";
					Connection con = Connection_DB.main();
					Statement s = con.createStatement();
					ResultSet r1 = s.executeQuery(q);
					int patid = r1.getInt("id");
					String q1 = "Update into History"+patid+" set prescription = '"+textField_1.getText()+"', tests = '"+textField_2.getText()+"', disease = '"+textField_3.getText()+"'";
					s.executeUpdate(q);
				}
				catch(Exception z){
					z.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Prescription Updated..!!");
				Doctor_Menu obj = new Doctor_Menu();
				obj.Doctor_Menu(doc);
			}
		});
		btnPrescribe.setBounds(110, 175, 89, 23);
		contentPane.add(btnPrescribe);
	}

}
