package project;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class GetDocID extends JFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetDocID frame = new GetDocID();
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
	public GetDocID() {
		setTitle("Doctor ID");
		setBounds(100, 100, 202, 147);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lb = new JLabel("Enter ID: ");
		lb.setBounds(10, 11, 54, 14);
		getContentPane().add(lb);
		
		textField = new JTextField();
		textField.setBounds(74, 8, 107, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btn = new JButton("Enter");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Doctor d = new Doctor();
				try{
					int id = Integer.parseInt(textField.getText());
					Connection con = Connection_DB.main();
					String q = "Select * from doctor "+
								"where id = "+id ;
					Statement s = con.createStatement();
					ResultSet rs = s.executeQuery(q);
					if (rs.next())
					{
						d.setId(rs.getInt(1));
						d.setName(rs.getString(2));
						d.setAddress(rs.getString(4));
						d.setEmail(rs.getString(5));
						d.setGender(rs.getString(6));
						d.setPosition(rs.getString(7));
						d.setAppt(rs.getString(8));
						d.setDeptid(rs.getInt(9));
						d.setRoomno(rs.getInt(10));
						d.setAge(rs.getInt(11));
						Add_Doctor.Add_Doctor(d);
						dispose();
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Doctor ID..!!", "alert", JOptionPane.ERROR_MESSAGE);
					}					
					Connection_DB.close();
				}
				catch (Exception z){
					z.printStackTrace();
				}
			}
		});
		btn.setBounds(48, 62, 89, 23);
		getContentPane().add(btn);

	}
}
