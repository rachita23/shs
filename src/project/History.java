package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class History extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ResultSet r;
	/**
	 * Launch the application.
	 */
	public static void History(ResultSet r) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					History frame = new History();
					frame.setVisible(true);
					frame.r = r;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public History() {
		setTitle("History");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 513, 285);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"Visit_Date", "Discharge_Date", "Doctor", "Prescription", "Tests", "Disease", "Status", "RoomNo."},
			},
			new String[] {
				"Visit_Date", "Dischare_Date", "Doctor", "Prescription", "Tests", "Disease", "Status", "RoomNo."
			}
		));
		table.getColumnModel().getColumn(1).setPreferredWidth(88);
		table.getColumnModel().getColumn(1).setMinWidth(30);
		table.setBounds(10, 11, 594, 249);
		contentPane.add(table);
	}

}
