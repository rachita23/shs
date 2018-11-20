package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Change_Doc extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void Change_Doc() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Change_Doc frame = new Change_Doc();
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
	public Change_Doc() {
		setTitle("ChangeDoc");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 307, 287);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPatientID = new JLabel("Patient ID:");
		lblPatientID.setBounds(26, 50, 120, 14);
		contentPane.add(lblPatientID);
		
		JLabel lblReferTo = new JLabel("Refer To:");
		lblReferTo.setBounds(28, 98, 46, 14);
		contentPane.add(lblReferTo);
		
		JLabel lblReferredBy = new JLabel("Referred By:");
		lblReferredBy.setBounds(26, 144, 84, 14);
		contentPane.add(lblReferredBy);
		
		JButton btnChange = new JButton("Change");
		btnChange.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try{
					Connection con = Connection_DB.main();
					Statement stmt = con.createStatement();
					int id = Integer.parseInt(textField.getText());
					ResultSet rs = stmt.executeQuery("SELECT id FROM paitient WHERE id = "+ id);  
					if (rs.next())
					{
						String q = " update paitient "
								+ "set referedto = ? , referedby = ? "
						        + "where id = ?";
						PreparedStatement ps = con.prepareStatement(q);
						if (textField_1.getText().equals(""))
							ps.setNull(1, java.sql.Types.INTEGER);
						else
							ps.setInt(1, Integer.parseInt(textField_1.getText()));
						
						if (textField_2.getText().equals(""))
							ps.setNull(2, java.sql.Types.INTEGER);
						else
							ps.setInt(2, Integer.parseInt(textField_2.getText()));	
						
						ps.setInt(3, id);
						ps.executeUpdate();
						ps.close();
						Connection_DB.close();
						dispose();
						
					}
					else
					{
						JOptionPane.showMessageDialog(null, "Invalid Paitient ID..!!", "alert", JOptionPane.ERROR_MESSAGE);
						Connection_DB.close();
					}
					
				}
				catch (Exception z){
					z.printStackTrace();
				}
			}
		});
		btnChange.setBounds(80, 205, 89, 23);
		contentPane.add(btnChange);
		
		textField = new JTextField();
		textField.setBounds(128, 47, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(128, 95, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(128, 141, 86, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
	}

}
