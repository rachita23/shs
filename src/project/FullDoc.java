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
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FullDoc extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void FullDoc() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FullDoc frame = new FullDoc();
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
	public FullDoc() {
		setTitle("Full view");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 596, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Name", "Position", "Department"
			}
		));
		DefaultTableModel md = (DefaultTableModel)table.getModel();
		try{
			Connection con = Connection_DB.main();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM doctor");  
			
			while (rs.next())
			{
				md.addRow(new Object[] {rs.getString(2), rs.getString(7), Integer.toString(rs.getInt(9))});
			}
			
			Connection_DB.close();
		}
		catch (Exception z){
			z.printStackTrace();
		}
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(10, 11, 562, 284);
		contentPane.add(jsp);				
		
		JButton btnNewButton = new JButton("Back to Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Search_Doc obj = new Search_Doc();
				obj.Search_Doc();
			}
		});
		btnNewButton.setBounds(219, 305, 130, 31);
		contentPane.add(btnNewButton);
	}
}
