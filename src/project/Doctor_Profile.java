package project;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class Doctor_Profile extends JFrame {

	private JPanel contentPane;
	public int id;
	/**
	 * Launch the application.
	 */
	public static void Doctor_Profile(int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Doctor_Profile frame = new Doctor_Profile(id);
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
	public Doctor_Profile(int d) {
		setTitle("Profile");
		id = d;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 307, 458);
		contentPane = new JPanel();
		String name = null,gender=null,eid=null,address=null,at=null,pos=null;
		int age=0,rn=0,dept=0;//,id=0;
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		String q = "select * from doctor where id ="+id;
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
				at = rs.getString("appt_time");
				pos = rs.getString("position");
				age = rs.getInt("age");
				rn = rs.getInt("roomno");
				id = rs.getInt("id");
				dept = rs.getInt("dept");
			}
			Connection_DB.close();
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
		
		JLabel lb1 = new JLabel("Rachita Nayyar");
		lb1.setBounds(81, 55, 181, 14);
		contentPane.add(lb1);
		lb1.setText(name);
		
		JLabel lb4 = new JLabel("30");
		lb4.setBounds(81, 105, 181, 14);
		contentPane.add(lb4);
		lb4.setText(Integer.toString(age));
		
		JLabel lb5 = new JLabel("rachitanayyar@");
		lb5.setBounds(81, 134, 181, 14);
		contentPane.add(lb5);
		lb5.setText(eid);
		
		JLabel lb6 = new JLabel("Inderpuri");
		lb6.setBounds(81, 159, 181, 25);
		contentPane.add(lb6);
		lb6.setText(address);
		
		JLabel lb3 = new JLabel("Female");
		lb3.setBounds(81, 80, 181, 14);
		contentPane.add(lb3);
		lb3.setText(gender);
		
		JLabel lblPosition = new JLabel("Position:");
		lblPosition.setBounds(10, 205, 46, 14);
		contentPane.add(lblPosition);
		
		
		JLabel lblP = new JLabel("Neurologist");
		lblP.setBounds(81, 205, 156, 14);
		contentPane.add(lblP);
		lblP.setText(pos);
		
		JLabel lblAppttime = new JLabel("ApptTime:");
		lblAppttime.setBounds(10, 241, 59, 14);
		contentPane.add(lblAppttime);
		
		JLabel lblapt = new JLabel("Monday: 5:30-6:30");
		lblapt.setBounds(81, 241, 126, 14);
		contentPane.add(lblapt);
		lblapt.setText(at);
		
		JLabel lblDeptno = new JLabel("DeptNo:");
		lblDeptno.setBounds(10, 279, 46, 14);
		contentPane.add(lblDeptno);
		
		JLabel label_1 = new JLabel("1");
		label_1.setBounds(81, 279, 46, 14);
		contentPane.add(label_1);
		label_1.setText(Integer.toString(dept));
		
		JLabel lblRoomno = new JLabel("RoomNo:");
		lblRoomno.setBounds(10, 313, 46, 14);
		contentPane.add(lblRoomno);
		
		JLabel label_2 = new JLabel("4");
		label_2.setBounds(81, 313, 46, 14);
		contentPane.add(label_2);
		label_2.setText(Integer.toString(rn));
		
		JButton btnNewButton = new JButton("Book Appointment");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookAppt obj = new BookAppt();
				obj.BookAppt();
			}
		});
		btnNewButton.setBounds(81, 369, 126, 39);
		contentPane.add(btnNewButton);
	}
}
