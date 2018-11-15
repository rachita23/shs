package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class FullPatient extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void FullPatient() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FullPatient frame = new FullPatient();
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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"ID", "Name", "Profile"},
			},
			new String[] {
				"ID", "Name", "Profile"
			}
		));
		table.setBounds(10, 11, 414, 239);
		contentPane.add(table);		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 251, 414, -238);
		contentPane.add(scrollPane);
	}
}
