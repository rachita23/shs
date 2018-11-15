package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Refer_Doc extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void Refer_Doc() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Refer_Doc frame = new Refer_Doc();
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
	public Refer_Doc() {
		setTitle("Refer To Doctor");
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setBounds(100, 100, 403, 137);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDoctorName = new JLabel("Doctor Name:");
		lblDoctorName.setBounds(10, 28, 69, 14);
		contentPane.add(lblDoctorName);
		
		textField = new JTextField();
		textField.setBounds(115, 25, 256, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnRefer = new JButton("Refer");
		btnRefer.setBounds(77, 70, 89, 23);
		contentPane.add(btnRefer);
	}

}
