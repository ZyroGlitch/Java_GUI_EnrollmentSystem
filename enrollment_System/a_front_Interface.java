package enrollment_System;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class a_front_Interface extends JFrame implements exit_Interface{

	static JPanel contentPane;
	
	//--LOGO
	static Image adminLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/ICONS/admin.png")).getImage().getScaledInstance(90,80,Image.SCALE_SMOOTH);
	static Image userLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/ICONS/student.png")).getImage().getScaledInstance(90,80,Image.SCALE_SMOOTH);
	static Image umLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/ICONS/university.png")).getImage().getScaledInstance(230,80,Image.SCALE_SMOOTH);
	static Image enrollNowLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/ICONS/enroll.png")).getImage().getScaledInstance(252,120,Image.SCALE_SMOOTH);
	static Image background = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/ICONS/image.jpg")).getImage().getScaledInstance(723,462,Image.SCALE_SMOOTH);

	static JLabel exit_Label;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					a_front_Interface frame = new a_front_Interface();
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
	public a_front_Interface() {
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 462);
		contentPane = new JPanel();
		contentPane.setForeground(Color.WHITE);
		contentPane.setBorder(null);
		contentPane.setBackground(Color.LIGHT_GRAY);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		exit_Label = new JLabel("X");
		exit_Interface.exitProgram(exit_Label);//--INHERITED INTERFACE NAME "exit_Interface"--//
		exit_Label.setForeground(new Color(0, 0, 0));
		exit_Label.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		exit_Label.setHorizontalAlignment(SwingConstants.CENTER);
		exit_Label.setBounds(703, 0, 20, 23);
		contentPane.add(exit_Label);
		
		JPanel umLogo_Panel = new JPanel();
		umLogo_Panel.setBorder(null);
		umLogo_Panel.setBackground(Color.WHITE);
		umLogo_Panel.setForeground(new Color(51, 204, 255));
		umLogo_Panel.setBounds(0, 0, 723, 462);
		contentPane.add(umLogo_Panel);
		umLogo_Panel.setLayout(null);
		
		JLabel university_Label = new JLabel("");
		university_Label.setHorizontalAlignment(SwingConstants.CENTER);
		university_Label.setBounds(0, 0, 723, 132);
		university_Label.setIcon(new ImageIcon(umLogo));
		umLogo_Panel.add(university_Label);
		
		JLabel whichAre_Label = new JLabel("Which one are you?");
		whichAre_Label.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		whichAre_Label.setHorizontalAlignment(SwingConstants.CENTER);
		whichAre_Label.setBounds(0, 147, 723, 40);
		umLogo_Panel.add(whichAre_Label);
		
		JLabel Admin_Label = new JLabel("Admin");
		Admin_Label.setFont(new Font("Arial", Font.BOLD, 16));
		Admin_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Admin_Label.setBounds(401, 330, 102, 14);
		umLogo_Panel.add(Admin_Label);
		
		JLabel newStudent_Label = new JLabel("Student");
		newStudent_Label.setHorizontalAlignment(SwingConstants.CENTER);
		newStudent_Label.setFont(new Font("Arial", Font.BOLD, 16));
		newStudent_Label.setBounds(213, 330, 102, 14);
		umLogo_Panel.add(newStudent_Label);
		
		JLabel enroll_Label = new JLabel("");
		enroll_Label.setForeground(new Color(255, 255, 255));
		enroll_Label.setBackground(new Color(255, 255, 255));
		enroll_Label.setHorizontalAlignment(SwingConstants.CENTER);
		enroll_Label.setBounds(239, 379, 244, 83);
		enroll_Label.setIcon(new ImageIcon(enrollNowLogo));
		umLogo_Panel.add(enroll_Label);
		
		JPanel admin_Panel = new JPanel();
		admin_Panel.setBounds(381, 198, 141, 121);
		umLogo_Panel.add(admin_Panel);
		admin_Panel.setBackground(new Color(204, 204, 153));
		admin_Panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		admin_Panel.setLayout(null);
		
		JLabel admin_Label = new JLabel("");
		admin_Label.setBounds(0, 0, 141, 121);
		admin_Panel.add(admin_Label);
		admin_Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				admin_Panel.setBackground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				admin_Panel.setBackground(new Color(204, 204, 153));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new c_adminFrame().setVisible(true);
	            dispose();           
	            
			}
		});
		admin_Label.setHorizontalAlignment(SwingConstants.CENTER);
		admin_Label.setIcon(new ImageIcon(adminLogo));
		
		JPanel student_Panel = new JPanel();
		student_Panel.setBounds(193, 198, 141, 121);
		umLogo_Panel.add(student_Panel);
		student_Panel.setBackground(new Color(204, 102, 51));
		student_Panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		student_Panel.setLayout(null);
		
		JLabel student_Label = new JLabel("");
		student_Label.setBounds(0, 0, 141, 121);
		student_Panel.add(student_Label);
		student_Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				student_Panel.setBackground(Color.BLACK);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				student_Panel.setBackground(new Color(204, 102, 51));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new b_Student_LogIn_Form_2().setVisible(true);
	            dispose();
			}
		});
		student_Label.setHorizontalAlignment(SwingConstants.CENTER);
		student_Label.setIcon(new ImageIcon(userLogo));
		
		JLabel background_label = new JLabel("");
		background_label.setBounds(0, 0, 723, 462);
		background_label.setIcon(new ImageIcon(background));
		umLogo_Panel.add(background_label);
		
		setLocationRelativeTo(null);
	}
}
