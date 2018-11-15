package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class BookAppt extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void BookAppt() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAppt frame = new BookAppt();
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
	public BookAppt() {
		setTitle("Book");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 181, 194);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(10, 11, 145, 14);
		contentPane.add(lblName);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(10, 46, 98, 20);
		contentPane.add(comboBox);
		
		JLabel lblTime = new JLabel("Time");
		lblTime.setBounds(10, 77, 98, 14);
		contentPane.add(lblTime);
		
		JButton btnBook = new JButton("Book");
		btnBook.setBounds(10, 116, 80, 20);
		contentPane.add(btnBook);
	}
}
