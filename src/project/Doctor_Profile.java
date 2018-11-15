package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Doctor_Profile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void Doctor_Profile() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_Profile frame = new Doctor_Profile();
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
	public Doctor_Profile() {
		setTitle("Profile");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 307, 458);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(10, 55, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(10, 80, 46, 14);
		contentPane.add(lblGender);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 134, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 164, 46, 14);
		contentPane.add(lblAddress);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(10, 105, 46, 14);
		contentPane.add(lblAge);
		
		JLabel lb1 = new JLabel("Rachita Nayyar");
		lb1.setBounds(81, 55, 181, 14);
		contentPane.add(lb1);
		
		JLabel lb4 = new JLabel("30");
		lb4.setBounds(81, 105, 181, 14);
		contentPane.add(lb4);
		
		JLabel lb5 = new JLabel("rachitanayyar@");
		lb5.setBounds(81, 134, 181, 14);
		contentPane.add(lb5);
		
		JLabel lb6 = new JLabel("Inderpuri");
		lb6.setBounds(81, 159, 181, 25);
		contentPane.add(lb6);
		
		JLabel lb3 = new JLabel("Female");
		lb3.setBounds(81, 80, 181, 14);
		contentPane.add(lb3);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(10, 205, 46, 14);
		contentPane.add(lblPosition);
		
		JLabel lblNeurologist = new JLabel("Neurologist");
		lblNeurologist.setBounds(81, 205, 156, 14);
		contentPane.add(lblNeurologist);
		
		JLabel lblAppttime = new JLabel("ApptTime:");
		lblAppttime.setBounds(10, 241, 59, 14);
		contentPane.add(lblAppttime);
		
		JLabel lblMonday = new JLabel("Monday: 5:30-6:30");
		lblMonday.setBounds(81, 241, 126, 14);
		contentPane.add(lblMonday);
		
		JLabel lblDeptno = new JLabel("DeptNo:");
		lblDeptno.setBounds(10, 279, 46, 14);
		contentPane.add(lblDeptno);
		
		JLabel label_1 = new JLabel("1");
		label_1.setBounds(81, 279, 46, 14);
		contentPane.add(label_1);
		
		JLabel lblRoomno = new JLabel("RoomNo:");
		lblRoomno.setBounds(10, 313, 46, 14);
		contentPane.add(lblRoomno);
		
		JLabel label_2 = new JLabel("4");
		label_2.setBounds(81, 313, 46, 14);
		contentPane.add(label_2);
		
		JButton btnNewButton = new JButton("Book Appointment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAppt obj = new BookAppt();
				obj.BookAppt();
			}
		});
		btnNewButton.setBounds(81, 369, 126, 39);
		contentPane.add(btnNewButton);
	}
}
