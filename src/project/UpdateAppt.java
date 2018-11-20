package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class UpdateAppt extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	Appt a;
	/**
	 * Launch the application.
	 */
	public static void UpdateApp(final Appt a) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateAppt frame = new UpdateAppt();
					frame.a = a;
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
	public UpdateAppt() {
		setTitle("Appointment");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 307, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMonday = new JLabel("Monday:");
		lblMonday.setBounds(10, 11, 70, 14);
		contentPane.add(lblMonday);
		
		JLabel lblTuesday = new JLabel("Tuesday:");
		lblTuesday.setBounds(10, 36, 70, 14);
		contentPane.add(lblTuesday);
		
		JLabel lblWednesday = new JLabel("Wednesday:");
		lblWednesday.setBounds(10, 61, 70, 14);
		contentPane.add(lblWednesday);
		
		JLabel lblThrusday = new JLabel("Thrusday:");
		lblThrusday.setBounds(10, 86, 70, 14);
		contentPane.add(lblThrusday);
		
		JLabel lblFriday = new JLabel("Friday:");
		lblFriday.setBounds(10, 111, 70, 14);
		contentPane.add(lblFriday);
		
		JLabel lblSaturday = new JLabel("Saturday:");
		lblSaturday.setBounds(10, 136, 70, 14);
		contentPane.add(lblSaturday);
		
		JLabel lblSunday = new JLabel("Sunday:");
		lblSunday.setBounds(10, 161, 70, 14);
		contentPane.add(lblSunday);
		
		textField = new JTextField();
		textField.setBounds(90, 8, 155, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(90, 33, 155, 20);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(90, 58, 155, 20);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(90, 83, 155, 20);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(90, 108, 155, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(90, 133, 155, 20);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(90, 158, 155, 20);
		contentPane.add(textField_6);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				a.apt = ";"+textField.getText()+";"+textField_1.getText()+";"+textField_2.getText()+
						";"+textField_3.getText()+";"+textField_4.getText()+";"+textField_5.getText()+";"+textField_6.getText();
				dispose();
			}
		});
		btnNewButton.setBounds(100, 213, 89, 23);
		contentPane.add(btnNewButton);
	}
}
