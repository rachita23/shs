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

public class Patient_Menu extends JFrame {
	public int id;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void Patient_Menu(int a) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient_Menu frame = new Patient_Menu(a);
					frame.setVisible(true);
					frame.id = a;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Patient_Menu(int a) {
		setTitle("Patient Menu");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 363, 206);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Profile");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Patient_Profile obj = new Patient_Profile(1);
				obj.Patient_Profile(id);
			}
		});
		btnNewButton.setBounds(220, 22, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Book");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAppt obj = new BookAppt();
				obj.BookAppt();
			}
		});
		btnNewButton_1.setBounds(220, 70, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Search");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_Doc obj = new Search_Doc();
				obj.Search_Doc();
			}
		});
		btnNewButton_2.setBounds(220, 122, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JLabel lblToChangeThe = new JLabel("To Book an Appointment");
		lblToChangeThe.setBounds(31, 67, 169, 28);
		contentPane.add(lblToChangeThe);
		
		JLabel lblToAddA = new JLabel("To view Profile");
		lblToAddA.setBounds(31, 22, 135, 23);
		contentPane.add(lblToAddA);
		
		JLabel lblToViewAll = new JLabel("To Search for a Doctor");
		lblToViewAll.setBounds(31, 122, 151, 18);
		contentPane.add(lblToViewAll);
	}

}
