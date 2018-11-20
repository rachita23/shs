package project;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Update_DocProfile extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void Update_DocProfile() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Update_DocProfile frame = new Update_DocProfile();
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
	public Update_DocProfile() {
		setTitle("Search By Name");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 322);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 24, 328, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btn = new JButton("Enter");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = textField.getText();
				DefaultTableModel md = (DefaultTableModel)table.getModel();
				
				try{
					
					Connection con = Connection_DB.main();
					String q = "select doc.id, doc.name, doc.position, dep.id, dep.name from doctor doc, department dep "+
								"where doc.dept = dep.id and doc.name like '"+name+"%' " ;
					Statement s = con.createStatement();
					ResultSet rs = s.executeQuery(q);
					while(rs.next())
					{
						md.addRow(new Object[] {Integer.toString(rs.getInt(1)),rs.getString(2), rs.getString(3), Integer.toString(rs.getInt(4)), rs.getString(5)});		
					}					
					Connection_DB.close();
				}
				catch (Exception z){
					z.printStackTrace();
				}
				
				
				
			}
		});
		btn.setBounds(356, 23, 68, 23);
		contentPane.add(btn);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id","Name", "Position", "Department No.", "Department Name"
			}
		));
		
		JScrollPane jsp = new JScrollPane(table);
		jsp.setBounds(10, 55, 414, 190);
		contentPane.add(jsp);
		
		JButton btn1 = new JButton("Next");
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetDocID.main();
			}
		});
		btn1.setBounds(345, 256, 79, 23);
		contentPane.add(btn1);
	}
}
