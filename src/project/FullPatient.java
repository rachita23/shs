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
				{"ID", "Name"},
			},
			new String[] {
				"ID", "Name"
			}
		));
		DefaultTableModel md = (DefaultTableModel)table.getModel();
		
		try{
			String q = "Select id,name from paitient where referedby ='"+doc.getString("id")+"'";
			Connection con = Connection_DB.main();
			Statement s = con.createStatement();
			ResultSet r = s.executeQuery(q);
			while(r.next()){
				md.addRow(new Object[]{Integer.toString(r.getInt("id")),r.getString("name")});
			}
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
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
