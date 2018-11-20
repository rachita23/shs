package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
	public ResultSet doc;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void FullPatient(ResultSet doc) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FullPatient frame = new FullPatient();
					frame.doc=doc;
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
			},
			new String[] {
				"ID", "Name"
			}
		));
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 15, 414, 210);
		contentPane.add(scrollPane);
		DefaultTableModel md = (DefaultTableModel)table.getModel();
		try{
			
			String q = "Select pid from appt"+doc.getInt("id")+" where status = 'NO'";
			Connection con = Connection_DB.main();
			Statement s = con.createStatement();
			ResultSet r = s.executeQuery(q);
			while(r.next()){
				String q1 = "Select * from paitient where id ="+r.getInt("id");
				ResultSet rs = s.executeQuery(q1);
				md.addRow(new Object[]{Integer.toString(rs.getInt(1)),rs.getString(2)});
			}
			Connection_DB.close();
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
}
