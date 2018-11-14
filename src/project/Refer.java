package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Refer extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Refer frame = new Refer();
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
	public Refer() {
		setTitle("Refer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 142);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPatientName = new JLabel("Patient Name:");
		lblPatientName.setBounds(10, 26, 100, 14);
		contentPane.add(lblPatientName);
		
		textField = new JTextField();
		textField.setBounds(132, 23, 207, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnReferToAnother = new JButton("Refer to Another Doctor");
		btnReferToAnother.setBounds(21, 70, 184, 23);
		contentPane.add(btnReferToAnother);
		
		JButton btnReferToAnother_1 = new JButton("Refer to Another Department");
		btnReferToAnother_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnReferToAnother_1.setBounds(213, 70, 184, 23);
		contentPane.add(btnReferToAnother_1);
	}

}
