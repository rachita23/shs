package project;

import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;

public class Patient_Profile extends JFrame {

	private JPanel contentPane;
	public int id;
	/**
	 * Launch the application.
	 */
	public static void Patient_Profile(int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient_Profile frame = new Patient_Profile(id);
					frame.setVisible(true);
					frame.id = id;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create the frame.
	 */
	public Patient_Profile(int id) {
		setTitle("Profile");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 307, 425);
		contentPane = new JPanel();
		String name = "",gender=null,eid=null,address=null,loc=null,cr=null,doc=null;
		int age=0,rn=0;//,id=0;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String q = "select * from paitient where id ='"+id+"'";
		//JOptionPane.showMessageDialog(this, q);
		try{
			Connection con = Connection_DB.main();
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(q);
			while(rs.next()) {
				name = rs.getString("name");
				gender = rs.getString("gender");
				eid = rs.getString("email");
				address = rs.getString("address");
				cr = rs.getString("critical");
				doc = rs.getString("referedto");
				age = rs.getInt("age");
				rn = rs.getInt("roomno");
				id = rs.getInt("id");
			}
			JButton btnHistory = new JButton("History");
			btnHistory.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					History obj = new History();
					obj.History();
				}
			});
			btnHistory.setBounds(81, 352, 89, 23);
			contentPane.add(btnHistory);
			//JOptionPane.showMessageDialog(this, name+gender+eid+address+cr+doc+age+rn);
			
		}
		catch (Exception z) {
			z.printStackTrace();
		}
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(10, 55, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(10, 80, 46, 14);
		contentPane.add(lblGender);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setBounds(10, 134, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(10, 164, 46, 14);
		contentPane.add(lblAddress);
		
		JLabel lblAge = new JLabel("Age:");
		lblAge.setBounds(10, 105, 46, 14);
		contentPane.add(lblAge);
		
		JLabel lb1 = new JLabel("Anuparna Deb");
		lb1.setBounds(81, 55, 181, 14);
		contentPane.add(lb1);
		lb1.setText(name);
		
		JLabel lb4 = new JLabel("45");
		lb4.setBounds(81, 105, 181, 14);
		lb4.setText(Integer.toString(age));
		
		JLabel lb5 = new JLabel("anu@gmail.com");
		lb5.setBounds(81, 134, 181, 14);
		contentPane.add(lb5);
		lb5.setText(eid);
		
		JLabel lb6 = new JLabel("Ghaziabad");
		lb6.setBounds(81, 164, 181, 40);
		contentPane.add(lb6);
		lb6.setText(address);
		
		JLabel lb3 = new JLabel("Female");
		lb3.setBounds(81, 80, 181, 14);
		contentPane.add(lb3);
		lb3.setText(gender);
		
		
		
		JLabel lblLocation = new JLabel("Location:");
		lblLocation.setBounds(10, 224, 46, 14);
		contentPane.add(lblLocation);
		
		JLabel lblLocalopd = new JLabel("Local/OPD");
		lblLocalopd.setBounds(81, 224, 121, 14);
		contentPane.add(lblLocalopd);
		
		JLabel lblRoomNo = new JLabel("Room No.:");
		lblRoomNo.setBounds(10, 257, 61, 14);
		contentPane.add(lblRoomNo);
		
		JLabel label = new JLabel("23");
		label.setBounds(81, 257, 46, 14);
		contentPane.add(label);
		label.setText(Integer.toString(rn));
		
		JLabel lblStatus = new JLabel("Critical:");
		lblStatus.setBounds(10, 293, 46, 14);
		contentPane.add(lblStatus);
		
		JLabel lblCritical = new JLabel("Critical");
		lblCritical.setBounds(81, 293, 46, 14);
		contentPane.add(lblCritical);
		lblCritical.setText(cr);
		
		JLabel lblDoctor = new JLabel("Doctor:");
		lblDoctor.setBounds(10, 325, 46, 14);
		contentPane.add(lblDoctor);
		
		JLabel lblDoc = new JLabel("Rachita Nayyar");
		lblDoc.setBounds(81, 325, 181, 14);
		contentPane.add(lblDoc);
		lblDoc.setText(doc);
	}
}
