package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Refer_Dept extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	
	public ResultSet pat;
	public ResultSet doc;

	/**
	 * Launch the application.
	 */
	public static void Refer_Dept(ResultSet pat,ResultSet doc) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Refer_Dept frame = new Refer_Dept();
					frame.setVisible(true);
					frame.pat = pat;
					frame.doc = doc;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Refer_Dept() {
		setTitle("Refer To Department");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 403, 173);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoctorName = new JLabel("Department Name:");
		lblDoctorName.setBounds(10, 28, 95, 14);
		contentPane.add(lblDoctorName);
		
		textField = new JTextField();
		textField.setBounds(115, 25, 256, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnRefer = new JButton("Refer");
		btnRefer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				docname = textField.getText();
				try{
					String q = "Select id from doctor where name = '"+docname+"'";
					Connection con = Connection_DB.main();
					Statement s = con.createStatement();
					ResultSet r1 = s.executeQuery(q);
					String q2 = "Update into paitient set referedto = "+r1.getInt("id")+", referedby = "+doc.getInt("id");
					s.executeUpdate(q2);
				}
				catch(Exception e){
					e.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "Referral Updated..!!");
				Doctor_Menu obj = new Doctor_Menu();
				obj.Doctor_Menu(doc);
			}
		});
		btnRefer.setBounds(79, 100, 89, 23);
		contentPane.add(btnRefer);
		
		JLabel lblDoctorName_1 = new JLabel("Doctor Name:");
		lblDoctorName_1.setBounds(10, 64, 95, 14);
		contentPane.add(lblDoctorName_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(115, 56, 256, 20);
		contentPane.add(textField_1);
	}

}
