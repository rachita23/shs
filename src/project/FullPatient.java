package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class FullPatient extends JFrame {

	private JPanel contentPane;
	private JTable table;
	public int id;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void FullPatient(final int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FullPatient frame = new FullPatient();
					frame.id=id;
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
	public FullPatient() {
		setTitle("Assigned Patient ");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Name"},
			},
			new String[] {
				"ID", "Name"
			}
		));
		table.setBounds(10, 11, 414, 211);
		contentPane.add(table);		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 251, 414, -238);
		contentPane.add(scrollPane);
		
		textField = new JTextField();
		textField.setBounds(258, 232, 71, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("View Full");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(339, 232, 85, 31);
		contentPane.add(btnNewButton);
		
		JLabel lblEnter = new JLabel("Enter Patient ID");
		lblEnter.setBounds(169, 232, 79, 31);
		contentPane.add(lblEnter);
	}
}
