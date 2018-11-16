package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

public class FullPatient_Admin extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void FullPatient_Admin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FullPatient_Admin frame = new FullPatient_Admin();
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
	public FullPatient_Admin() {
		setTitle("Full view");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 514, 284);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Email", "Gender", "Address", "RoomNo", "Critical Status", "Doctor"
			}
		));
		
		DefaultTableModel md = (DefaultTableModel)table.getModel();
		try{
			Connection con = Connection_DB.main();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM paitient");  
			
			while (rs.next())
			{
				md.addRow(new Object[] {Integer.toString(rs.getInt(1)), rs.getString(2), rs.getString(5), rs.getString(6)
						, rs.getString(4),Integer.toString(rs.getInt(8)), rs.getString(7), Integer.toString(rs.getInt(9))});
			}
			
			Connection_DB.close();
		}
		catch (Exception z){
			z.printStackTrace();
		}
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(10, 11, 596, 241);
		contentPane.add(jsp);		
	}
}
