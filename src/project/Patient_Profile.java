package project;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Patient_Profile extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void Patient_Profile() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient_Profile frame = new Patient_Profile();
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
	public Patient_Profile() {
		setTitle("Profile");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 307, 425);
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
		
		JLabel lb1 = new JLabel("Anuparna Deb");
		lb1.setBounds(81, 55, 181, 14);
		contentPane.add(lb1);
		
		JLabel lb4 = new JLabel("45");
		lb4.setBounds(81, 105, 181, 14);
		contentPane.add(lb4);
		
		JLabel lb5 = new JLabel("anu@gmail.com");
		lb5.setBounds(81, 134, 181, 14);
		contentPane.add(lb5);
		
		JLabel lb6 = new JLabel("Ghaziabad");
		lb6.setBounds(81, 164, 181, 40);
		contentPane.add(lb6);
		
		JLabel lb3 = new JLabel("Female");
		lb3.setBounds(81, 80, 181, 14);
		contentPane.add(lb3);
		
		JButton btnHistory = new JButton("History");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				History obj = new History();
				obj.History();
			}
		});
		btnHistory.setBounds(81, 352, 89, 23);
		contentPane.add(btnHistory);
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(10, 224, 46, 14);
		contentPane.add(lblLocation);
		
		JLabel lblLocalopd = new JLabel("Local/OPD");
		lblLocalopd.setBounds(81, 224, 121, 14);
		contentPane.add(lblLocalopd);
		
		JLabel lblRoomNo = new JLabel("Room No.:");
		lblRoomNo.setBounds(10, 257, 61, 14);
		contentPane.add(lblRoomNo);
		
		JLabel label = new JLabel("23");
		label.setBounds(81, 257, 46, 14);
		contentPane.add(label);
		
		JLabel lblStatus = new JLabel("Status:");
		lblStatus.setBounds(10, 293, 46, 14);
		contentPane.add(lblStatus);
		
		JLabel lblCritical = new JLabel("Critical");
		lblCritical.setBounds(81, 293, 46, 14);
		contentPane.add(lblCritical);
		
		JLabel lblDoctor = new JLabel("Doctor:");
		lblDoctor.setBounds(10, 325, 46, 14);
		contentPane.add(lblDoctor);
		
		JLabel lblRachitaNayyar = new JLabel("Rachita Nayyar");
		lblRachitaNayyar.setBounds(81, 325, 181, 14);
		contentPane.add(lblRachitaNayyar);
	}
}
