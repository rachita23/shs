package project;

import java.awt.EventQueue;

import javax.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;

public class Doctor_Menu extends JFrame {

	private JPanel contentPane;
	public ResultSet doc;
	Doctor d;

	/**
	 * Launch the application.
	 */
	public static void Doctor_Menu(ResultSet doc) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_Menu frame = new Doctor_Menu();
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
	public Doctor_Menu() {
		d = new Doctor();
		setTitle("DoctorMenu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 363, 292);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("View");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FullPatient obj = new FullPatient();
				obj.FullPatient(doc);
			}
		});
		btnNewButton.setBounds(220, 22, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Edit");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Doctor obj = new Add_Doctor();
				obj.Add_Doctor(d);
			}
		});
		btnNewButton_1.setBounds(220, 70, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Prescription");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Give_Prescription obj = new Give_Prescription();
				obj.Give_Prescription(doc);
			}
		});
		btnNewButton_2.setBounds(220, 122, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Refer");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Refer obj = new Refer();
				obj.Refer(doc);
			}
		});
		btnNewButton_3.setBounds(220, 170, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblToChangeThe = new JLabel("To Edit Profile");
		lblToChangeThe.setBounds(31, 67, 169, 28);
		contentPane.add(lblToChangeThe);
		
		JLabel lblToAddA = new JLabel("To View All Assigned Patients");
		lblToAddA.setBounds(31, 22, 174, 23);
		contentPane.add(lblToAddA);
		
		JLabel lblToViewAll = new JLabel("To Give Prescriptions");
		lblToViewAll.setBounds(31, 122, 151, 18);
		contentPane.add(lblToViewAll);
		
		JLabel lblToViewAll_1 = new JLabel("To Refer Patient to another Doctor");
		lblToViewAll_1.setBounds(31, 174, 169, 19);
		contentPane.add(lblToViewAll_1);
		
		JButton btnLogout = new JButton("LogOut");
		btnLogout.setBounds(132, 224, 85, 21);
		contentPane.add(btnLogout);
	}

}
