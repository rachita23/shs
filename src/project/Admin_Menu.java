package project;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class Admin_Menu extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void Admin_Menu() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin_Menu frame = new Admin_Menu();
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
	public Admin_Menu() {
		setTitle("AdminMenu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 363, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add_Doctor obj = new Add_Doctor();
				obj.Add_Doctor();
			}
		});
		btnNewButton.setBounds(220, 22, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Change");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Change_Doc obj = new Change_Doc();
				obj.Change_Doc();
			}
		});
		btnNewButton_1.setBounds(220, 70, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FullDoc_Admin obj = new FullDoc_Admin();
				obj.FullDoc_Admin();
			}
		});
		btnNewButton_2.setBounds(220, 122, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("View");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FullPatient_Admin obj = new FullPatient_Admin();
				obj.FullPatient_Admin();
			}
		});
		btnNewButton_3.setBounds(220, 170, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Update");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update_DocProfile obj = new Update_DocProfile();
				obj.Update_DocProfile();
			}
		});
		btnNewButton_4.setBounds(220, 218, 89, 23);
		contentPane.add(btnNewButton_4);
		
		JLabel lblToChangeThe = new JLabel("To Change the Doctor Assigned");
		lblToChangeThe.setBounds(31, 67, 169, 28);
		contentPane.add(lblToChangeThe);
		
		JLabel lblToAddA = new JLabel("To Add a New Doctor");
		lblToAddA.setBounds(31, 22, 135, 23);
		contentPane.add(lblToAddA);
		
		JLabel lblToViewAll = new JLabel("To View All Doctors");
		lblToViewAll.setBounds(31, 122, 151, 18);
		contentPane.add(lblToViewAll);
		
		JLabel lblToViewAll_1 = new JLabel("To View All Patients");
		lblToViewAll_1.setBounds(31, 174, 135, 19);
		contentPane.add(lblToViewAll_1);
		
		JLabel lblToUpdateA = new JLabel("To Update a Doctor's Profile");
		lblToUpdateA.setBounds(31, 222, 135, 14);
		contentPane.add(lblToUpdateA);
	}

}
