package enrollment_System;

import java.awt.EventQueue;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JComboBox;

public class d_Student_Dashboard extends JFrame implements exit_Interface{

	private static JPanel contentPane;
	
	static Image menLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/Student_Dashboard_Icon/man.png")).getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
	static Image womenLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/Student_Dashboard_Icon/women.png")).getImage().getScaledInstance(150, 100, Image.SCALE_SMOOTH);
	static Image dashboardLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/Student_Dashboard_Icon/dashboard.png")).getImage().getScaledInstance(35, 30, Image.SCALE_SMOOTH);
	static Image umlogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/ICONS/UM.png")).getImage().getScaledInstance(60, 45, Image.SCALE_SMOOTH);
	static Image userLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/Student_Dashboard_Icon/user.png")).getImage().getScaledInstance(35, 25, Image.SCALE_SMOOTH);
	static Image creditcardLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/Student_Dashboard_Icon/credit.png")).getImage().getScaledInstance(30, 26, Image.SCALE_SMOOTH);
	static Image arrowLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/ICONS/back.png")).getImage().getScaledInstance(100, 23, Image.SCALE_SMOOTH);
	static Image subjectLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/Student_Dashboard_Icon/books.png")).getImage().getScaledInstance(50, 32, Image.SCALE_SMOOTH);

	
	public static JTextField examsPaid_textfield;
	public static JTextField perExam_textfield;
	public static JTextField totalAssessment_Jtextfield;
	public static JTextField currentBalance_textfield;
	
	static JPanel dashboard_cardPanel;
	static JPanel card_panel;
	static JPanel vision_cardPanel;
	static JPanel coreValues_cardPanel;
	static JPanel userAccount_panel;
	static JPanel payment_panel;
	public static JTextField id_textfield;
	public static JTextField amount_textfield;
	static JComboBox item_comboBox;
	static JPanel grade123_panel;
	static JLabel firstname_Label;
	static JLabel gender_Label;
	static JLabel gradelevel_Label;
	static JLabel username_Label;
	static JLabel lastname_Label;
	static JLabel age_Label;
	static JLabel date_Label;
	static JLabel password_Label;
	static JPanel grade456_panel;
	
	public static String signUP_id;
	static int id;
	static int tuitionReciever;
	static String tuition;
	static int stud_ID;
	
	//--ATTRIBUTES HOLDING THE VALUE IN THE ACCOUNT
	public static String firstname, lastname, age, gender, yearLevel, username, password, date_Enroll;
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	public static String getYearLevel;
	 
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					d_Student_Dashboard frame = new d_Student_Dashboard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void Connect(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/enrollment system","root","");
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Create the frame.
	 */
	public d_Student_Dashboard() {
		 
		Connect();
				
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel dashboard_panel = new JPanel();
		dashboard_panel.setBorder(null);
		dashboard_panel.setBounds(0, 0, 164, 462);
		dashboard_panel.setBackground(new Color(96, 125, 139));
		contentPane.add(dashboard_panel);
		dashboard_panel.setLayout(null);
		
		JLabel student_label = new JLabel("");
		student_label.setHorizontalAlignment(SwingConstants.CENTER);
		student_label.setBounds(0, 0, 164, 123);
		student_label.setIcon(new ImageIcon(menLogo));
		dashboard_panel.add(student_label);
		
		JPanel menuDash_panel = new JPanel();
		menuDash_panel.setBounds(0, 123, 164, 48);
		menuDash_panel.setBackground(new Color(96, 125, 139));
		dashboard_panel.add(menuDash_panel);
		menuDash_panel.setLayout(null);
		
		String vision = "Vision, Mission and \n Values";
		JLabel dashboard_label = new JLabel("Dashboard");
		dashboard_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuDash_panel.setBackground(Color.MAGENTA);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuDash_panel.setBackground(new Color(96, 125, 139));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				card_panel.removeAll();
				card_panel.add(dashboard_cardPanel);
				card_panel.repaint();
				card_panel.revalidate();
				
				id_textfield.setText("");
				amount_textfield.setText("");
				item_comboBox.setSelectedItem("Select...");

				//--SET THE VALUE OF TOTAL ASSESSMENT
				switch(getYearLevel) {
				case "Grade 1":
					totalAssessment_Jtextfield.setText("31753");
					break;
				case "Grade 2":
					totalAssessment_Jtextfield.setText("31753");
				case "Grade 3":
					totalAssessment_Jtextfield.setText("32382");
					break;
				case "Grade 4":
					totalAssessment_Jtextfield.setText("29787");
					break;
				case "Grade 5":
					totalAssessment_Jtextfield.setText("29881");
					break;
				case "Grade 6":
					totalAssessment_Jtextfield.setText("30322");
					break;
					default:
						JOptionPane.showMessageDialog(null, "Your getYearLevel is invalid");
				}
				
				
				try {
					stud_ID = Integer.parseInt(signUP_id);
					
					pst = con.prepareStatement("SELECT `tuition` FROM `student info` WHERE `id` = ?");
					pst.setInt(1, stud_ID);
					rs = pst.executeQuery();
										
					if(rs.next() == true) {
						tuitionReciever = rs.getInt("tuition");
						tuition = Integer.toString(tuitionReciever);
						currentBalance_textfield.setText(tuition);
					
					}else {
						JOptionPane.showMessageDialog(null, "Value can't transfer");
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		dashboard_label.setForeground(Color.WHITE);
		dashboard_label.setHorizontalAlignment(SwingConstants.CENTER);
		dashboard_label.setFont(new Font("Segoe UI", Font.BOLD, 16));
		dashboard_label.setBounds(0, 0, 164, 48);
		menuDash_panel.add(dashboard_label);
		
		JLabel dashboard_Icon_label = new JLabel("");
		dashboard_Icon_label.setHorizontalAlignment(SwingConstants.CENTER);
		dashboard_Icon_label.setBounds(10, 11, 26, 26);
		dashboard_Icon_label.setIcon(new ImageIcon(dashboardLogo));
		menuDash_panel.add(dashboard_Icon_label);
		
		JPanel visionMission_panel = new JPanel();
		visionMission_panel.setBounds(0, 170, 164, 48);
		visionMission_panel.setBackground(new Color(96, 125, 139));
		dashboard_panel.add(visionMission_panel);
		visionMission_panel.setLayout(null);
		
		JLabel visionMission_label = new JLabel("Vision Mission");
		visionMission_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				visionMission_panel.setBackground(Color.MAGENTA);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				visionMission_panel.setBackground(new Color(96, 125, 139));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				card_panel.removeAll();
				card_panel.add(vision_cardPanel);
				card_panel.repaint();
				card_panel.revalidate();
				
				id_textfield.setText("");
				amount_textfield.setText("");
				item_comboBox.setSelectedItem("Select...");

			}
		});
		visionMission_label.setForeground(Color.WHITE);
		visionMission_label.setFont(new Font("Segoe UI", Font.BOLD, 12));
		visionMission_label.setHorizontalAlignment(SwingConstants.CENTER);
		visionMission_label.setBounds(0, 0, 164, 48);
		visionMission_panel.add(visionMission_label);
		
		JLabel visionIcon_label = new JLabel("");
		visionIcon_label.setHorizontalAlignment(SwingConstants.CENTER);
		visionIcon_label.setBounds(10, 11, 26, 26);
		visionIcon_label.setIcon(new ImageIcon(dashboardLogo));
		visionMission_panel.add(visionIcon_label);
		
		JPanel coreValues_panel = new JPanel();
		coreValues_panel.setLayout(null);
		coreValues_panel.setBackground(new Color(96, 125, 139));
		coreValues_panel.setBounds(0, 217, 164, 48);
		dashboard_panel.add(coreValues_panel);
		
		JLabel coreValues_label = new JLabel("Core Values");
		coreValues_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				coreValues_panel.setBackground(Color.MAGENTA);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				coreValues_panel.setBackground(new Color(96, 125, 139));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				card_panel.removeAll();
				card_panel.add(coreValues_cardPanel);
				card_panel.repaint();
				card_panel.revalidate();
				
				id_textfield.setText("");
				amount_textfield.setText("");
				item_comboBox.setSelectedItem("Select...");
				
			}
		});
		coreValues_label.setHorizontalAlignment(SwingConstants.CENTER);
		coreValues_label.setForeground(Color.WHITE);
		coreValues_label.setFont(new Font("Segoe UI", Font.BOLD, 15));
		coreValues_label.setBounds(0, 0, 164, 48);
		coreValues_panel.add(coreValues_label);
		
		JLabel coreValuesIcon_label = new JLabel("");
		coreValuesIcon_label.setHorizontalAlignment(SwingConstants.CENTER);
		coreValuesIcon_label.setBounds(10, 11, 26, 26);
		coreValuesIcon_label.setIcon(new ImageIcon(dashboardLogo));
		coreValues_panel.add(coreValuesIcon_label);
		
		JPanel onlinePayment_panel = new JPanel();
		onlinePayment_panel.setLayout(null);
		onlinePayment_panel.setBackground(new Color(96, 125, 139));
		onlinePayment_panel.setBounds(0, 315, 164, 48);
		dashboard_panel.add(onlinePayment_panel);
		
		JLabel onlinepayment_label = new JLabel("Online Payment");
		onlinepayment_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				onlinePayment_panel.setBackground(Color.MAGENTA);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				onlinePayment_panel.setBackground(new Color(96, 125, 139));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				card_panel.removeAll();
				card_panel.add(payment_panel);
				card_panel.repaint();
				card_panel.revalidate();
			}
		});
		onlinepayment_label.setHorizontalAlignment(SwingConstants.CENTER);
		onlinepayment_label.setForeground(Color.WHITE);
		onlinepayment_label.setFont(new Font("Segoe UI", Font.BOLD, 14));
		onlinepayment_label.setBounds(0, 0, 206, 48);
		onlinePayment_panel.add(onlinepayment_label);
		
		JLabel creditIcon_label = new JLabel("");
		creditIcon_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				onlinePayment_panel.setBackground(Color.MAGENTA);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				onlinePayment_panel.setBackground(new Color(96, 125, 139));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				card_panel.removeAll();
				card_panel.add(payment_panel);
				card_panel.repaint();
				card_panel.revalidate();
			}
		});
		creditIcon_label.setHorizontalAlignment(SwingConstants.CENTER);
		creditIcon_label.setBounds(0, 0, 51, 48);
		creditIcon_label.setIcon(new ImageIcon(creditcardLogo));
		onlinePayment_panel.add(creditIcon_label);
		
		JPanel back_Panel = new JPanel();
		back_Panel.setLayout(null);
		back_Panel.setBackground(Color.CYAN);
		back_Panel.setBounds(0, 439, 66, 23);
		dashboard_panel.add(back_Panel);
		
		JLabel arrow_Label = new JLabel("");
		arrow_Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				back_Panel.setBackground(Color.MAGENTA);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				back_Panel.setBackground(Color.CYAN);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new b_Student_LogIn_Form_2().setVisible(true);
	            dispose();
			}
		});
		arrow_Label.setHorizontalAlignment(SwingConstants.CENTER);
		arrow_Label.setBounds(0, 0, 66, 23);
		arrow_Label.setIcon(new ImageIcon(arrowLogo));
		back_Panel.add(arrow_Label);
		
		JPanel subjects_panel = new JPanel();
		subjects_panel.setLayout(null);
		subjects_panel.setBackground(new Color(96, 125, 139));
		subjects_panel.setBounds(1, 267, 164, 48);
		dashboard_panel.add(subjects_panel);
		
		JLabel subject_label = new JLabel("Subjects");
		subject_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				subjects_panel.setBackground(Color.MAGENTA);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				subjects_panel.setBackground(new Color(96, 125, 139));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				id_textfield.setText("");
				amount_textfield.setText("");
				item_comboBox.setSelectedItem("Select...");
				
								
				if(getYearLevel.equals("Grade 1") || getYearLevel.equals("Grade 2") || getYearLevel.equals("Grade 3")) {
					card_panel.removeAll();
					card_panel.add(grade123_panel);
					card_panel.repaint();
					card_panel.revalidate();
					
				}else {
					card_panel.removeAll();
					card_panel.add(grade456_panel);
					card_panel.repaint();
					card_panel.revalidate();
				}
			}
		});
		subject_label.setHorizontalAlignment(SwingConstants.CENTER);
		subject_label.setForeground(Color.WHITE);
		subject_label.setFont(new Font("Segoe UI", Font.BOLD, 15));
		subject_label.setBounds(2, 0, 162, 48);
		subjects_panel.add(subject_label);
		
		JLabel subjectIcon_label = new JLabel("");
		subjectIcon_label.setHorizontalAlignment(SwingConstants.CENTER);
		subjectIcon_label.setBounds(0, 0, 54, 48);
		subjectIcon_label.setIcon(new ImageIcon(subjectLogo));
		subjects_panel.add(subjectIcon_label);
		
		JPanel titleBar_panel = new JPanel();
		titleBar_panel.setBorder(null);
		titleBar_panel.setBounds(163, 0, 560, 53);
		titleBar_panel.setBackground(Color.WHITE);
		contentPane.add(titleBar_panel);
		titleBar_panel.setLayout(null);
		
		JButton exit_button = new JButton("X");
		exit_button.setForeground(Color.WHITE);
		exit_button.setBackground(Color.DARK_GRAY);
		exit_Interface.exitWithForeGround(exit_button);//--INHERITED INTERFACE NAME "exit_Interface"--//
		exit_button.setBorder(null);
		exit_button.setFont(new Font("Segoe UI", Font.BOLD, 16));
		exit_button.setBounds(517, 1, 42, 23);
		titleBar_panel.add(exit_button);
		
		JLabel um_logo = new JLabel("");
		um_logo.setHorizontalAlignment(SwingConstants.CENTER);
		um_logo.setBounds(0, 0, 80, 53);
		um_logo.setIcon(new ImageIcon(umlogo));
		titleBar_panel.add(um_logo);
		
		JTextPane umPortal_textpane = new JTextPane();
		umPortal_textpane.setEditable(false);
		umPortal_textpane.setFont(new Font("Segoe UI", Font.BOLD, 16));
		umPortal_textpane.setText("UM \r\nSTUDENT PORTAL");
		umPortal_textpane.setBounds(83, 0, 152, 53);
		titleBar_panel.add(umPortal_textpane);
		
		JPanel account_Panel = new JPanel();
		account_Panel.setBorder(null);
		account_Panel.setBackground(Color.WHITE);
		account_Panel.setBounds(387, 11, 128, 31);
		titleBar_panel.add(account_Panel);
		account_Panel.setLayout(null);
		
		JLabel account_label = new JLabel("ACCOUNT");
		account_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				account_Panel.setBackground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				account_Panel.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				card_panel.removeAll();
				card_panel.add(userAccount_panel);
				card_panel.repaint();
				card_panel.revalidate();
				
				id_textfield.setText("");
				amount_textfield.setText("");
				item_comboBox.setSelectedItem("Select...");
				
				
			try {
				id = Integer.parseInt(signUP_id);
					
				pst = con.prepareStatement("SELECT * FROM `student info` WHERE id = ?");
				pst.setInt(1, id);
				rs = pst.executeQuery();

				if(rs.next() == true){
						firstname = rs.getString("firstname");
						lastname = rs.getString("lastname");
						gender = rs.getString("gender");
						age = rs.getString("age");
						yearLevel = rs.getString("yearlevel");
						username = rs.getString("username");
						password = rs.getString("password");
						date_Enroll = rs.getString("Date Enroll");
						
						
						//--ALL COMPONENTS OF ACCOUNT INFO PANEL
						firstname_Label.setText(firstname);
						lastname_Label.setText(lastname);
						gender_Label.setText(gender);
						age_Label.setText(age);
						gradelevel_Label.setText(yearLevel);
						username_Label.setText(username);
						password_Label.setText(password);;
						date_Label.setText(date_Enroll);;
					
					}else {
						JOptionPane.showMessageDialog(null, "No Record Found!!");
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});
		account_label.setHorizontalAlignment(SwingConstants.CENTER);
		account_label.setFont(new Font("Segoe UI", Font.BOLD, 11));
		account_label.setBounds(0, 0, 128, 31);
		account_Panel.add(account_label);
		
		JLabel userIcon_logo = new JLabel("");
		userIcon_logo.setHorizontalAlignment(SwingConstants.CENTER);
		userIcon_logo.setBounds(0, 0, 35, 31);
		userIcon_logo.setIcon(new ImageIcon(userLogo));
		account_Panel.add(userIcon_logo);
		
		//--JPanel card_panel = new JPanel();--//
		card_panel = new JPanel();
		card_panel.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.DARK_GRAY));
		card_panel.setBounds(163, 53, 560, 409);
		card_panel.setBackground(Color.WHITE);
		contentPane.add(card_panel);
		card_panel.setLayout(new CardLayout(0, 0));
		
		//--JPanel dashboard_cardPanel = new JPanel();--//
		dashboard_cardPanel = new JPanel();
		dashboard_cardPanel.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.DARK_GRAY));
		dashboard_cardPanel.setBackground(Color.WHITE);
		card_panel.add(dashboard_cardPanel, "name_227090344176700");
		dashboard_cardPanel.setLayout(null);
		
		JPanel examPaid_panel = new JPanel();
		examPaid_panel.setBackground(Color.LIGHT_GRAY);
		examPaid_panel.setBorder(null);
		examPaid_panel.setBounds(10, 18, 242, 95);
		dashboard_cardPanel.add(examPaid_panel);
		examPaid_panel.setLayout(null);
		
		examsPaid_textfield = new JTextField("");
		examsPaid_textfield.setEditable(false);
		examsPaid_textfield.setForeground(Color.WHITE);
		examsPaid_textfield.setFont(new Font("Segoe UI", Font.BOLD, 20));
		examsPaid_textfield.setBorder(null);
		examsPaid_textfield.setBounds(0, 0, 242, 63);
		examPaid_panel.add(examsPaid_textfield);
		examsPaid_textfield.setHorizontalAlignment(SwingConstants.CENTER);
		examsPaid_textfield.setBackground(new Color(144, 164, 174));
		examsPaid_textfield.setColumns(10);
		
		JLabel examPaid_label = new JLabel("Exams Paid");
		examPaid_label.setFont(new Font("Segoe UI", Font.BOLD, 13));
		examPaid_label.setHorizontalAlignment(SwingConstants.CENTER);
		examPaid_label.setBounds(0, 62, 242, 30);
		examPaid_panel.add(examPaid_label);
		
		JPanel perExam_panel = new JPanel();
		perExam_panel.setLayout(null);
		perExam_panel.setBorder(null);
		perExam_panel.setBackground(Color.LIGHT_GRAY);
		perExam_panel.setBounds(308, 18, 242, 95);
		dashboard_cardPanel.add(perExam_panel);
		
		perExam_textfield = new JTextField();
		perExam_textfield.setText("2000");
		perExam_textfield.setEditable(false);
		perExam_textfield.setHorizontalAlignment(SwingConstants.CENTER);
		perExam_textfield.setForeground(Color.WHITE);
		perExam_textfield.setFont(new Font("Segoe UI", Font.BOLD, 20));
		perExam_textfield.setColumns(10);
		perExam_textfield.setBorder(null);
		perExam_textfield.setBackground(new Color(144, 164, 174));
		perExam_textfield.setBounds(0, 0, 242, 63);
		perExam_panel.add(perExam_textfield);
		
		JLabel perExam_label = new JLabel("Per Exam");
		perExam_label.setHorizontalAlignment(SwingConstants.CENTER);
		perExam_label.setFont(new Font("Segoe UI", Font.BOLD, 13));
		perExam_label.setBounds(0, 62, 242, 30);
		perExam_panel.add(perExam_label);
		
		JPanel totalPayment_panel = new JPanel();
		totalPayment_panel.setLayout(null);
		totalPayment_panel.setBorder(null);
		totalPayment_panel.setBackground(Color.LIGHT_GRAY);
		totalPayment_panel.setBounds(9, 143, 242, 95);
		dashboard_cardPanel.add(totalPayment_panel);
		
		
		totalAssessment_Jtextfield = new JTextField();
		totalAssessment_Jtextfield.setEditable(false);
		totalAssessment_Jtextfield.setHorizontalAlignment(SwingConstants.CENTER);
		totalAssessment_Jtextfield.setForeground(Color.WHITE);
		totalAssessment_Jtextfield.setFont(new Font("Segoe UI", Font.BOLD, 20));
		totalAssessment_Jtextfield.setColumns(10);
		totalAssessment_Jtextfield.setBorder(null);
		totalAssessment_Jtextfield.setBackground(new Color(144, 164, 174));
		totalAssessment_Jtextfield.setBounds(1, 0, 242, 63);
		totalPayment_panel.add(totalAssessment_Jtextfield);
		
		JLabel totalAssessment_label = new JLabel("Total Assessment");
		totalAssessment_label.setHorizontalAlignment(SwingConstants.CENTER);
		totalAssessment_label.setFont(new Font("Segoe UI", Font.BOLD, 13));
		totalAssessment_label.setBounds(1, 62, 242, 30);
		totalPayment_panel.add(totalAssessment_label);
		
		JPanel currentBalance_panel = new JPanel();
		currentBalance_panel.setLayout(null);
		currentBalance_panel.setBorder(null);
		currentBalance_panel.setBackground(Color.LIGHT_GRAY);
		currentBalance_panel.setBounds(308, 143, 242, 95);
		dashboard_cardPanel.add(currentBalance_panel);
		
		currentBalance_textfield = new JTextField();
		currentBalance_textfield.setEditable(false);
		currentBalance_textfield.setHorizontalAlignment(SwingConstants.CENTER);
		currentBalance_textfield.setForeground(Color.WHITE);
		currentBalance_textfield.setFont(new Font("Segoe UI", Font.BOLD, 20));
		currentBalance_textfield.setColumns(10);
		currentBalance_textfield.setBorder(null);
		currentBalance_textfield.setBackground(new Color(144, 164, 174));
		currentBalance_textfield.setBounds(1, 0, 242, 63);
		currentBalance_panel.add(currentBalance_textfield);
		
		JLabel currentBalance_label = new JLabel("Current Balance");
		currentBalance_label.setHorizontalAlignment(SwingConstants.CENTER);
		currentBalance_label.setFont(new Font("Segoe UI", Font.BOLD, 13));
		currentBalance_label.setBounds(1, 62, 242, 30);
		currentBalance_panel.add(currentBalance_label);
		
		//--JPanel vision_cardPanel = new JPanel();--//
		vision_cardPanel = new JPanel();
		vision_cardPanel.setBackground(Color.WHITE);
		vision_cardPanel.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.DARK_GRAY));
		card_panel.add(vision_cardPanel, "name_227107692789300");
		vision_cardPanel.setLayout(null);
		
		JLabel vision_label = new JLabel("Vision");
		vision_label.setForeground(new Color(0, 102, 0));
		vision_label.setHorizontalAlignment(SwingConstants.CENTER);
		vision_label.setFont(new Font("Segoe UI", Font.BOLD, 20));
		vision_label.setBounds(194, 35, 173, 33);
		vision_cardPanel.add(vision_label);
		
		JTextPane vision_jtextpane = new JTextPane();
		vision_jtextpane.setBackground(Color.WHITE);
		vision_jtextpane.setFont(new Font("Segoe UI", Font.BOLD, 14));
		vision_jtextpane.setText("By 2022, a globally recognized institution providing quality, affordable and open education.");
		vision_jtextpane.setBounds(10, 79, 540, 46);
		vision_cardPanel.add(vision_jtextpane);
		
		JLabel mission_label = new JLabel("Mission");
		mission_label.setForeground(new Color(0, 102, 0));
		mission_label.setHorizontalAlignment(SwingConstants.CENTER);
		mission_label.setFont(new Font("Segoe UI", Font.BOLD, 20));
		mission_label.setBounds(194, 164, 173, 33);
		vision_cardPanel.add(mission_label);
		
		JTextPane mission_jtextpane = new JTextPane();
		mission_jtextpane.setText("To provide a dynamic and supportive academic environment through the highest standard of instruction, research and extension in a non-sectarian institution committed to democratizing access to education.");
		mission_jtextpane.setFont(new Font("Segoe UI", Font.BOLD, 14));
		mission_jtextpane.setBackground(Color.WHITE);
		mission_jtextpane.setBounds(10, 208, 540, 82);
		vision_cardPanel.add(mission_jtextpane);
		
		//--JPanel coreValues_cardPanel = new JPanel();--//
		coreValues_cardPanel = new JPanel();
		coreValues_cardPanel.setBackground(Color.WHITE);
		coreValues_cardPanel.setBorder(new MatteBorder(1, 0, 0, 0, (Color) Color.DARK_GRAY));
		card_panel.add(coreValues_cardPanel, "name_227111004853500");
		coreValues_cardPanel.setLayout(null);
		
		JLabel teamwork_label = new JLabel("Teamwork");
		teamwork_label.setForeground(new Color(0, 102, 0));
		teamwork_label.setFont(new Font("Segoe UI", Font.BOLD, 16));
		teamwork_label.setBounds(9, 312, 185, 25);
		coreValues_cardPanel.add(teamwork_label);
		
		JLabel excellence_label = new JLabel("Excellence");
		excellence_label.setForeground(new Color(0, 102, 0));
		excellence_label.setFont(new Font("Segoe UI", Font.BOLD, 16));
		excellence_label.setBounds(10, 11, 163, 25);
		coreValues_cardPanel.add(excellence_label);
		
		JTextArea excellence_jtextpane = new JTextArea();
		excellence_jtextpane.setWrapStyleWord(true);
		excellence_jtextpane.setLineWrap(true);
		excellence_jtextpane.setEditable(false);
		excellence_jtextpane.setText("We are committed to world-class customer service and quality as we excel for the mutual success of our stakeholders. We ensure that our product and services are on par with the global standards to ensure its responsiveness and impact on our stakeholders and the community and country in general.");
		excellence_jtextpane.setFont(new Font("Segoe UI", Font.BOLD, 13));
		excellence_jtextpane.setBounds(10, 33, 540, 82);
		coreValues_cardPanel.add(excellence_jtextpane);
		
		JLabel honesty_label = new JLabel("Honesty and Integrity");
		honesty_label.setForeground(new Color(0, 102, 0));
		honesty_label.setFont(new Font("Segoe UI", Font.BOLD, 16));
		honesty_label.setBounds(10, 122, 185, 25);
		coreValues_cardPanel.add(honesty_label);
		
		JTextArea honesty_jtextpane = new JTextArea();
		honesty_jtextpane.setWrapStyleWord(true);
		honesty_jtextpane.setText("Our organization establishes utmost trust and ensures transparency in dealing with our stakeholders. We practice accountability in all our undertakings especially those that involve our stakeholders. Professionalism is at the core of our thrusts as an academic institution.");
		honesty_jtextpane.setLineWrap(true);
		honesty_jtextpane.setFont(new Font("Segoe UI", Font.BOLD, 13));
		honesty_jtextpane.setEditable(false);
		honesty_jtextpane.setBounds(10, 143, 540, 82);
		coreValues_cardPanel.add(honesty_jtextpane);
		
		JLabel innovation_label = new JLabel("Innovation");
		innovation_label.setForeground(new Color(0, 102, 0));
		innovation_label.setFont(new Font("Segoe UI", Font.BOLD, 16));
		innovation_label.setBounds(10, 225, 185, 25);
		coreValues_cardPanel.add(innovation_label);
		
		JTextArea innovation_jtextpane = new JTextArea();
		innovation_jtextpane.setWrapStyleWord(true);
		innovation_jtextpane.setText("We always think outside the box to be of prime service to our stakeholders. We do this by continuously introducing new programs as value addedd benefits to our clients.");
		innovation_jtextpane.setLineWrap(true);
		innovation_jtextpane.setFont(new Font("Segoe UI", Font.BOLD, 13));
		innovation_jtextpane.setEditable(false);
		innovation_jtextpane.setBounds(10, 249, 540, 58);
		coreValues_cardPanel.add(innovation_jtextpane);
		
		JTextArea teamwork_jtextpane = new JTextArea();
		teamwork_jtextpane.setLineWrap(true);
		teamwork_jtextpane.setWrapStyleWord(true);
		teamwork_jtextpane.setText("We believe in the concept that \"the whole is greater than the sum of its parts.\" We value the collective effort of every stakeholder through synergy, cooperation, collaboration, and 'esprit de corps' as it is integral to the success of the institution.");
		teamwork_jtextpane.setFont(new Font("Segoe UI", Font.BOLD, 13));
		teamwork_jtextpane.setEditable(false);
		teamwork_jtextpane.setBounds(9, 336, 540, 65);
		coreValues_cardPanel.add(teamwork_jtextpane);
		
		//--JPanel userAccount_panel = new JPanel()--//
		userAccount_panel = new JPanel();
		userAccount_panel.setBackground(Color.WHITE);
		card_panel.add(userAccount_panel, "name_228220339308500");
		userAccount_panel.setLayout(null);
		
		JLabel personal_label = new JLabel("Personal Details");
		personal_label.setFont(new Font("Times New Roman", Font.BOLD, 24));
		personal_label.setBounds(10, 11, 312, 64);
		userAccount_panel.add(personal_label);
		
		JLabel firstname_label = new JLabel("First Name: ");
		firstname_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		firstname_label.setBounds(10, 86, 92, 25);
		userAccount_panel.add(firstname_label);
		
		//--JLabel firstname_Label = new JLabel("First Name: ")--//
		firstname_Label = new JLabel("");
		firstname_Label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		firstname_Label.setBounds(112, 86, 92, 25);
		userAccount_panel.add(firstname_Label);
		
		JLabel lastname_label = new JLabel("Last Name: ");
		lastname_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lastname_label.setBounds(295, 86, 92, 25);
		userAccount_panel.add(lastname_label);
		
		//--JLabel lastname_Label = new JLabel("Last Name: ")--//
		lastname_Label = new JLabel("");
		lastname_Label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lastname_Label.setBounds(397, 86, 92, 25);
		userAccount_panel.add(lastname_Label);
		
		JLabel gender_label = new JLabel("Gender:");
		gender_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		gender_label.setBounds(10, 122, 92, 25);
		userAccount_panel.add(gender_label);
		
		//--JLabel gender_Label = new JLabel("Gender:")--//
		gender_Label = new JLabel("");
		gender_Label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		gender_Label.setBounds(112, 122, 92, 25);
		userAccount_panel.add(gender_Label);
		
		JLabel age_label = new JLabel("Age:");
		age_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		age_label.setBounds(295, 122, 92, 25);
		userAccount_panel.add(age_label);
		
		//--JLabel age_Label = new JLabel("Gender:")--//
		age_Label = new JLabel("");
		age_Label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		age_Label.setBounds(397, 122, 92, 25);
		userAccount_panel.add(age_Label);
		
		JLabel gradelevel_label = new JLabel("Grade Level:");
		gradelevel_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		gradelevel_label.setBounds(10, 158, 92, 25);
		userAccount_panel.add(gradelevel_label);
		
		//--JLabel gradelevel_Label = new JLabel("Username:")--//
		gradelevel_Label = new JLabel("");
		gradelevel_Label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		gradelevel_Label.setBounds(112, 158, 92, 25);
		userAccount_panel.add(gradelevel_Label);
		
		JLabel date_label = new JLabel("Date Enroll:");
		date_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		date_label.setBounds(295, 158, 92, 25);
		userAccount_panel.add(date_label);
		
		//--JLabel date_Label = new JLabel("Password:")--//
		date_Label = new JLabel("");
		date_Label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		date_Label.setBounds(397, 158, 153, 25);
		userAccount_panel.add(date_Label);
		
		JLabel username_label = new JLabel("Username:");
		username_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		username_label.setBounds(10, 194, 92, 25);
		userAccount_panel.add(username_label);
		
		//--JLabel username_Label = new JLabel("Password:")--//
		username_Label = new JLabel("");
		username_Label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		username_Label.setBounds(112, 194, 92, 25);
		userAccount_panel.add(username_Label);
		
		JLabel password_label = new JLabel("Password:");
		password_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		password_label.setBounds(295, 194, 92, 25);
		userAccount_panel.add(password_label);
		
		//--JLabel password_Label = new JLabel("Password:")--//
		password_Label = new JLabel("");
		password_Label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		password_Label.setBounds(397, 194, 92, 25);
		userAccount_panel.add(password_Label);
		
		//--JPanel payment_panel = new JPanel()--//
		payment_panel = new JPanel();
		payment_panel.setBackground(Color.WHITE);
		card_panel.add(payment_panel, "name_582507759269900");
		payment_panel.setLayout(null);
		
		JLabel online_label = new JLabel("Online Payment");
		online_label.setFont(new Font("Times New Roman", Font.BOLD, 26));
		online_label.setHorizontalAlignment(SwingConstants.CENTER);
		online_label.setBounds(152, 11, 232, 40);
		payment_panel.add(online_label);
		
		JLabel online_label_1 = new JLabel("Main Campus");
		online_label_1.setForeground(Color.RED);
		online_label_1.setHorizontalAlignment(SwingConstants.CENTER);
		online_label_1.setFont(new Font("Times New Roman", Font.BOLD, 22));
		online_label_1.setBounds(152, 49, 232, 40);
		payment_panel.add(online_label_1);
		
		JPanel paymentMode_panel = new JPanel();
		paymentMode_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		paymentMode_panel.setBounds(31, 103, 475, 275);
		payment_panel.add(paymentMode_panel);
		paymentMode_panel.setLayout(null);
		
		JLabel studentsID_label = new JLabel("Students ID:");
		studentsID_label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		studentsID_label.setBounds(10, 11, 139, 29);
		paymentMode_panel.add(studentsID_label);
		
		id_textfield = new JTextField();
		id_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		id_textfield.setBounds(10, 40, 455, 29);
		paymentMode_panel.add(id_textfield);
		id_textfield.setColumns(10);
		
		JLabel purpose_label = new JLabel("Purpose:");
		purpose_label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		purpose_label.setBounds(10, 80, 139, 29);
		paymentMode_panel.add(purpose_label);
		
		String items[] = {"Select...","Tuition Fee"};
		//--JComboBox item_comboBox = new JComboBox(items)--//
		item_comboBox = new JComboBox(items);
		item_comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		item_comboBox.setBounds(10, 105, 455, 29);
		paymentMode_panel.add(item_comboBox);
		
		JLabel studentsID_label_1 = new JLabel("Amount:");
		studentsID_label_1.setFont(new Font("Times New Roman", Font.BOLD, 18));
		studentsID_label_1.setBounds(10, 145, 139, 29);
		paymentMode_panel.add(studentsID_label_1);
		
		amount_textfield = new JTextField();
		amount_textfield.setFont(new Font("Tahoma", Font.PLAIN, 15));
		amount_textfield.setColumns(10);
		amount_textfield.setBounds(10, 174, 455, 29);
		paymentMode_panel.add(amount_textfield);
		
		JButton pay_button = new JButton("PAY");
		pay_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				/*--AFTER SUCCESSFULLY PAYING TUITION THE CURRENT BALANCE JTEXTFIELD 
									WILL AUTOMATICALLY UPDATED BASED ON DATABASE VALUE*/
				
				examsPaid_textfield.setText(amount_textfield.getText());
				int amountPay = Integer.parseInt(amount_textfield.getText());
				try {
					pst = con.prepareStatement("SELECT * FROM `student info` WHERE `id` = ?");
					pst.setInt(1,stud_ID);
					
					rs = pst.executeQuery();
					
					if(rs.next() == true) {
						int databaseValue = rs.getInt("tuition") - amountPay;
						
						pst = con.prepareStatement("UPDATE `student info` SET `tuition` = ? WHERE `id` = ?");
						pst.setInt(1, databaseValue);
						pst.setInt(2,stud_ID);
						
						int k = pst.executeUpdate();
						
						if(k == 1){
							JOptionPane.showMessageDialog(null, "Tuition has been successfully updated!!");
							String current = Integer.toString(databaseValue);
							currentBalance_textfield.setText(current);
							
							id_textfield.setText("");
							item_comboBox.setSelectedItem("Select...");
							amount_textfield.setText("");
							
							card_panel.removeAll();
							card_panel.add(dashboard_cardPanel);
							card_panel.repaint();
							card_panel.revalidate();
						}
					}
					
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		pay_button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		pay_button.setBounds(193, 214, 89, 23);
		paymentMode_panel.add(pay_button);
		
		//--JPanel grade123_panel = new JPanel()--//
		grade123_panel = new JPanel();
		grade123_panel.setBackground(Color.WHITE);
		card_panel.add(grade123_panel, "name_667300355492100");
		grade123_panel.setLayout(null);
		
		JLabel grade1_label = new JLabel("Subjects");
		grade1_label.setFont(new Font("Times New Roman", Font.BOLD, 22));
		grade1_label.setHorizontalAlignment(SwingConstants.CENTER);
		grade1_label.setBounds(10, 11, 540, 36);
		grade123_panel.add(grade1_label);
		
		JLabel Araling_Panlipunan_label = new JLabel("Araling Panlipunan");
		Araling_Panlipunan_label.setHorizontalAlignment(SwingConstants.CENTER);
		Araling_Panlipunan_label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Araling_Panlipunan_label.setBounds(92, 77, 196, 36);
		grade123_panel.add(Araling_Panlipunan_label);
		
		JLabel Arts_label = new JLabel("Arts");
		Arts_label.setHorizontalAlignment(SwingConstants.CENTER);
		Arts_label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Arts_label.setBounds(92, 124, 196, 36);
		grade123_panel.add(Arts_label);
		
		JLabel English_Label = new JLabel("English");
		English_Label.setHorizontalAlignment(SwingConstants.CENTER);
		English_Label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		English_Label.setBounds(92, 171, 196, 36);
		grade123_panel.add(English_Label);
		
		JLabel Filipino_Label = new JLabel("Filipino");
		Filipino_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Filipino_Label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Filipino_Label.setBounds(92, 218, 196, 36);
		grade123_panel.add(Filipino_Label);
		
		JLabel Health_label = new JLabel("Health");
		Health_label.setHorizontalAlignment(SwingConstants.CENTER);
		Health_label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Health_label.setBounds(92, 265, 196, 36);
		grade123_panel.add(Health_label);
		
		JLabel Math_Label = new JLabel("Math");
		Math_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Math_Label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Math_Label.setBounds(298, 77, 196, 36);
		grade123_panel.add(Math_Label);
		
		JLabel motherTongue_Label = new JLabel("Mother Tongue");
		motherTongue_Label.setHorizontalAlignment(SwingConstants.CENTER);
		motherTongue_Label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		motherTongue_Label.setBounds(298, 124, 196, 36);
		grade123_panel.add(motherTongue_Label);
		
		JLabel Music_Label = new JLabel("Music");
		Music_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Music_Label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Music_Label.setBounds(298, 171, 196, 36);
		grade123_panel.add(Music_Label);
		
		JLabel PE_Label = new JLabel("Physical Education");
		PE_Label.setHorizontalAlignment(SwingConstants.CENTER);
		PE_Label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		PE_Label.setBounds(298, 218, 196, 36);
		grade123_panel.add(PE_Label);
		
		JLabel Science_Label = new JLabel("Science");
		Science_Label.setHorizontalAlignment(SwingConstants.CENTER);
		Science_Label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Science_Label.setBounds(298, 265, 196, 36);
		grade123_panel.add(Science_Label);
		
		JLabel esp_label = new JLabel("Edukasyon sa Pagpapakatao (ESP)");
		esp_label.setHorizontalAlignment(SwingConstants.CENTER);
		esp_label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		esp_label.setBounds(54, 312, 272, 36);
		grade123_panel.add(esp_label);
		
		//--JPanel grade456_panel = new JPanel()--//
		grade456_panel = new JPanel();
		grade456_panel.setLayout(null);
		grade456_panel.setBackground(Color.WHITE);
		card_panel.add(grade456_panel, "name_668746146853100");
		
		JLabel grade4Title_label = new JLabel("Subjects");
		grade4Title_label.setHorizontalAlignment(SwingConstants.CENTER);
		grade4Title_label.setFont(new Font("Times New Roman", Font.BOLD, 22));
		grade4Title_label.setBounds(10, 11, 540, 36);
		grade456_panel.add(grade4Title_label);
		
		JLabel aralingPanlipunan_label = new JLabel("Araling Panlipunan");
		aralingPanlipunan_label.setHorizontalAlignment(SwingConstants.CENTER);
		aralingPanlipunan_label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		aralingPanlipunan_label.setBounds(92, 77, 196, 36);
		grade456_panel.add(aralingPanlipunan_label);
		
		JLabel arts_label = new JLabel("Arts");
		arts_label.setHorizontalAlignment(SwingConstants.CENTER);
		arts_label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		arts_label.setBounds(92, 124, 196, 36);
		grade456_panel.add(arts_label);
		
		JLabel english_label = new JLabel("English");
		english_label.setHorizontalAlignment(SwingConstants.CENTER);
		english_label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		english_label.setBounds(92, 171, 196, 36);
		grade456_panel.add(english_label);
		
		JLabel filipino_label = new JLabel("Filipino");
		filipino_label.setHorizontalAlignment(SwingConstants.CENTER);
		filipino_label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		filipino_label.setBounds(92, 218, 196, 36);
		grade456_panel.add(filipino_label);
		
		JLabel health_label = new JLabel("Health");
		health_label.setHorizontalAlignment(SwingConstants.CENTER);
		health_label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		health_label.setBounds(92, 265, 196, 36);
		grade456_panel.add(health_label);
		
		JLabel math_label = new JLabel("Math");
		math_label.setHorizontalAlignment(SwingConstants.CENTER);
		math_label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		math_label.setBounds(298, 77, 196, 36);
		grade456_panel.add(math_label);
		
		JLabel EPP_TLE_label = new JLabel("EPP/TLE");
		EPP_TLE_label.setHorizontalAlignment(SwingConstants.CENTER);
		EPP_TLE_label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		EPP_TLE_label.setBounds(298, 124, 196, 36);
		grade456_panel.add(EPP_TLE_label);
		
		JLabel music_label = new JLabel("Music");
		music_label.setHorizontalAlignment(SwingConstants.CENTER);
		music_label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		music_label.setBounds(298, 171, 196, 36);
		grade456_panel.add(music_label);
		
		JLabel PE_label = new JLabel("Physical Education");
		PE_label.setHorizontalAlignment(SwingConstants.CENTER);
		PE_label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		PE_label.setBounds(298, 218, 196, 36);
		grade456_panel.add(PE_label);
		
		JLabel Science_label = new JLabel("Science");
		Science_label.setHorizontalAlignment(SwingConstants.CENTER);
		Science_label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		Science_label.setBounds(298, 265, 196, 36);
		grade456_panel.add(Science_label);
		
		JLabel ESP_label = new JLabel("Edukasyon sa Pagpapakatao (ESP)");
		ESP_label.setHorizontalAlignment(SwingConstants.CENTER);
		ESP_label.setFont(new Font("Times New Roman", Font.BOLD, 18));
		ESP_label.setBounds(54, 312, 272, 36);
		grade456_panel.add(ESP_label);
		
		setLocationRelativeTo(null);
	}
}
