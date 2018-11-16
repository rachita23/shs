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

public class FullDoc_Admin extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void FullDoc_Admin() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FullDoc_Admin frame = new FullDoc_Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public FullDoc_Admin() {
		setTitle("Full view");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 632, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"ID", "Name", "Email", "Gender", "Address", "DeptNo", "Position", "RoomNo", "ApptTime"
			}
		));
		
		DefaultTableModel md = (DefaultTableModel)table.getModel();
		try{
			Connection con = Connection_DB.main();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM doctor");  
			
			while (rs.next())
			{
				md.addRow(new Object[] {Integer.toString(rs.getInt(1)), rs.getString(2), rs.getString(5), rs.getString(6)
						, rs.getString(4),Integer.toString(rs.getInt(9)), rs.getString(7), Integer.toString(rs.getInt(10)),
						rs.getString(8)});
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
