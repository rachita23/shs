package project;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class GetDocID extends JFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		btn.setBounds(48, 62, 89, 23);
		getContentPane().add(btn);

	}
}
