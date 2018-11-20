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
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class Search extends JFrame {

	private JPanel contentPane;
	private JTextField sr;
	private JTable table;
	private JTable table_1;
	private int a;
	private JButton btnView;
	private JTextField textField_1;
	/**
	 * Launch the application.
	 */
	public static void Search(int a) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Search frame = new Search();
					frame.setVisible(true);
					frame.a = a;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Search() {
		setTitle("Search");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		sr = new JTextField();
		sr.setBounds(10, 24, 328, 20);
		contentPane.add(sr);
		sr.setColumns(10);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String search = sr.getText();
				DefaultTableModel md = (DefaultTableModel)table.getModel();
				try{
					Connection con = Connection_DB.main();
					Statement stmt = con.createStatement();
					ResultSet rs;
					if(a==0) {
						rs = stmt.executeQuery("select * from doctor where name = '"+search+"'");
					}
					else {
						rs = stmt.executeQuery("select * from doctor where position = '"+search+"'");
					}
					
					table = new JTable();
					table.setModel(new DefaultTableModel(
						new Object[][] {
							{"Name", "Position", "Department"},
						},
						new String[] {
							"Name", "Position", "Department"
						}
					));
					md = (DefaultTableModel)table.getModel();
					
					try{
						
						while(rs.next()){
							String s = "Select name from department where id = "+Integer.toString(rs.getInt("dept"));
							ResultSet r = stmt.executeQuery(s);
							md.addRow(new Object[]{rs.getString("name"),rs.getString("position"),r.getString("name")});
						}
					}
					catch(Exception e1){
						e1.printStackTrace();
					}
					
					
					table.setBounds(10, 68, 328, 169);
					contentPane.add(table);		
					
					//Connection_DB.close();
				}
				catch (Exception z){
					z.printStackTrace();
				}
				JScrollPane jsp = new JScrollPane(table);
				jsp.setBounds(10, 11, 562, 284);
				contentPane.add(jsp);	
				
			}
		});
		btnNewButton.setBounds(356, 23, 68, 23);
		contentPane.add(btnNewButton);
		
		
		
		btnView = new JButton("View");
		btnView.setBounds(341, 256, 85, 21);
		contentPane.add(btnView);
		
		JLabel lblEnterDoctorsnameTo = new JLabel("Enter Doctor's name to view full profile");
		lblEnterDoctorsnameTo.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEnterDoctorsnameTo.setBounds(0, 251, 226, 28);
		contentPane.add(lblEnterDoctorsnameTo);
		
		textField_1 = new JTextField();
		textField_1.setBounds(235, 258, 96, 19);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
	}
}
