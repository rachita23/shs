package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Refer_Dept extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Refer_Dept frame = new Refer_Dept();
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
	public Refer_Dept() {
		setTitle("Refer To Department");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
