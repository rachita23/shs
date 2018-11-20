package project;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class BookAppt_Smart extends JFrame {

	private JPanel contentPane;
	public int id;

	/**
	 * Launch the application.
	 */
	public static void BookAppt_Smart(int id) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BookAppt_Smart frame = new BookAppt_Smart();
					frame.id = id;
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
	public BookAppt_Smart() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		
		setContentPane(contentPane);
	}

}
