package enrollment_System;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Image;
import javax.swing.SwingConstants;
import java.awt.CardLayout;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;
import javax.swing.JComboBox;
import java.sql.*;
import javax.swing.JCheckBox;
import javax.swing.JButton;


public class b_Student_LogIn_Form_2 extends JFrame implements exit_Interface{

	public static JPanel contentPane;
	public static JTextField studentID_textField;
	public static JPasswordField passwordField;
	public static JLabel errorMessage_Label;

	//--LOGO
	static Image umlogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/ICONS/UM.png")).getImage().getScaledInstance(132, 92, Image.SCALE_SMOOTH);
	static Image eyeLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/ICONS/eye.jpg")).getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	static Image keyLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/ICONS/keys.png")).getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	static Image arrowLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/ICONS/back.png")).getImage().getScaledInstance(100, 23, Image.SCALE_SMOOTH);

	public static JTextField Username_textField;
	public static JTextField Password_textField;

	public static JPanel LoginMenu_panel;
	public static JPanel SignUpMenu_panel;
	public static JPanel information_Panel;
	public static JPanel LogIn_Panel;
	public static JPanel SignUp_Panel;
	public static JTextField firstName_textfield;
	public static JTextField lastName_textfield;
	public static JTextField age_textfield;
	public static JComboBox grade_comboBox;
	static JComboBox gender_comboBox;
	static JComboBox month_comboBox;
	static JComboBox day_comboBox;
	static JComboBox year_comboBox;
	static JLabel remainder_label;
	static JTextField downpayment_textfield;
	public static JLabel LogIn_lblNewLabel;

	static String firstName, surName, gender, age, gradeLevel, userName, passsword, month, date, year, date_enroll;
	static int k, downpayment = 0;
	
	//--TUITION INFO VARIABLES
	
	static int tuition;
	static int tuitionSender;
	
	//--LOGIN INFO VARIABLES
	static int studentID;
	static String id;
	static String studentPass;
	
	//---DATABASE CONNECTION---//
	Connection con, con1, con2, con3;
	PreparedStatement pst, pst1, pst2, pst3;
	ResultSet rs, rs1, rs3;
	private JPanel ResetPassword_panel;
	private JTextField studentID_label;
	private JTextField ResetPassword_label;
	
	//---DATABASE CONNECTION---//
	public void Connect(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/enrollment system","root","");
			con1 = DriverManager.getConnection("jdbc:mysql://localhost/enrollment system","root","");
			con2 = DriverManager.getConnection("jdbc:mysql://localhost/enrollment system","root","");
			con3 = DriverManager.getConnection("jdbc:mysql://localhost/enrollment system","root","");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					b_Student_LogIn_Form_2 frame = new b_Student_LogIn_Form_2();
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
	
	public b_Student_LogIn_Form_2() {
		
		Connect();	//---DATABASE CONNECTION METHOD---//

		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 462);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel dashboard_Panel = new JPanel();
		dashboard_Panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		dashboard_Panel.setBackground(new Color(0, 204, 204));
		dashboard_Panel.setBounds(22, 25, 191, 426);
		contentPane.add(dashboard_Panel);
		dashboard_Panel.setLayout(null);

		JLabel imageLogo_lblNewLabel = new JLabel("");
		imageLogo_lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		imageLogo_lblNewLabel.setIcon(new ImageIcon(umlogo));
		imageLogo_lblNewLabel.setBounds(0, 0, 191, 131);
		dashboard_Panel.add(imageLogo_lblNewLabel);

		// JPanel LoginMenu_panel = new JPanel();
		LoginMenu_panel = new JPanel();
		LoginMenu_panel.setBackground(new Color(0, 204, 204));
		LoginMenu_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		LoginMenu_panel.setBounds(0, 134, 191, 45);
		dashboard_Panel.add(LoginMenu_panel);
		LoginMenu_panel.setLayout(null);

		JLabel login_lblNewLabel = new JLabel("LOG IN");
		login_lblNewLabel.setBounds(0, 0, 191, 45);
		LoginMenu_panel.add(login_lblNewLabel);
		login_lblNewLabel.setForeground(Color.BLACK);

		login_lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				information_Panel.removeAll();
				information_Panel.add(LogIn_Panel);
				information_Panel.repaint();
				information_Panel.revalidate();

				Username_textField.setText("Create Username");
				Password_textField.setText("Create Password");

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				LoginMenu_panel.setBackground(Color.BLACK);
				login_lblNewLabel.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				LoginMenu_panel.setBackground(new Color(0, 204, 204));
				login_lblNewLabel.setForeground(Color.BLACK);
			}
		});
		login_lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		login_lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		// JPanel SignUpMenu_panel = new JPanel();
		SignUpMenu_panel = new JPanel();
		SignUpMenu_panel.setBackground(new Color(0, 204, 204));
		SignUpMenu_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		SignUpMenu_panel.setBounds(0, 178, 191, 45);
		dashboard_Panel.add(SignUpMenu_panel);
		SignUpMenu_panel.setLayout(null);

		JLabel register_lblNewLabel = new JLabel("REGISTER");
		register_lblNewLabel.setForeground(Color.BLACK);
		register_lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				information_Panel.removeAll();
				information_Panel.add(SignUp_Panel);
				information_Panel.repaint();
				information_Panel.revalidate();

				studentID_textField.setText("Student ID");
				passwordField.setEchoChar((char) 0);
				passwordField.setText("Password");
				downpayment_textfield.setText("0");

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				SignUpMenu_panel.setBackground(Color.BLACK);
				register_lblNewLabel.setForeground(Color.WHITE);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				SignUpMenu_panel.setBackground(new Color(0, 204, 204));
				register_lblNewLabel.setForeground(Color.BLACK);
			}
		});

		register_lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		register_lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 18));
		register_lblNewLabel.setBounds(0, 0, 191, 45);
		SignUpMenu_panel.add(register_lblNewLabel);

		// JPanel information_Panel = new JPanel();
		information_Panel = new JPanel();
		information_Panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		information_Panel.setBackground(new Color(96, 96, 96));
		information_Panel.setBounds(220, 25, 482, 426);
		contentPane.add(information_Panel);
		information_Panel.setLayout(new CardLayout(0, 0));

		// JPanel LogIn_Panel = new JPanel();
		LogIn_Panel = new JPanel();
		information_Panel.add(LogIn_Panel, "name_273010973145400");
		LogIn_Panel.setBackground(new Color(96, 96, 96));
		LogIn_Panel.setLayout(null);

		studentID_textField = new JTextField();
		studentID_textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				studentID_textField.setText("");
			}
		});
		studentID_textField.setText("Student ID");
		studentID_textField.setOpaque(false);
		studentID_textField.setBounds(109, 210, 265, 30);
		studentID_textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 255, 255)));
		studentID_textField.setFont(new Font("Arial Black", Font.BOLD, 14));
		studentID_textField.setForeground(Color.WHITE);
		LogIn_Panel.add(studentID_textField);
		studentID_textField.setColumns(10);

		passwordField = new JPasswordField();
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				passwordField.setEchoChar('●');
				passwordField.setText("");
			}
		});
		passwordField.setEchoChar((char) 0);
		passwordField.setText("Password");
		passwordField.setForeground(Color.WHITE);
		passwordField.setOpaque(false);
		passwordField.setBounds(109, 266, 265, 30);
		passwordField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.CYAN));
		passwordField.setFont(new Font("Arial Black", Font.BOLD, 14));
		LogIn_Panel.add(passwordField);

		JLabel schoolLogo_lblNewLabel = new JLabel("");
		schoolLogo_lblNewLabel.setBounds(99, 23, 132, 92);
		schoolLogo_lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		schoolLogo_lblNewLabel.setIcon(new ImageIcon(umlogo));
		LogIn_Panel.add(schoolLogo_lblNewLabel);

		JLabel macsat_lblNewLabel = new JLabel("UM");
		macsat_lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		macsat_lblNewLabel.setBounds(197, 23, 193, 92);
		macsat_lblNewLabel.setFont(new Font("Wide Latin", Font.BOLD, 36));
		macsat_lblNewLabel.setForeground(new Color(0, 255, 255));
		LogIn_Panel.add(macsat_lblNewLabel);

		JLabel mainCampus_lblNewLabel = new JLabel("Main Campus");
		mainCampus_lblNewLabel.setBounds(70, 114, 342, 30);
		mainCampus_lblNewLabel.setForeground(Color.CYAN);
		mainCampus_lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 20));
		mainCampus_lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LogIn_Panel.add(mainCampus_lblNewLabel);

		JPanel LogIn_panel = new JPanel();
		LogIn_panel.setBounds(156, 352, 171, 40);
		LogIn_panel.setBackground(new Color(0, 204, 0));
		LogIn_Panel.add(LogIn_panel);
		LogIn_panel.setLayout(null);

		//--JLabel LogIn_lblNewLabel = new JLabel("Log In")--//
		LogIn_lblNewLabel = new JLabel("Log In");
		LogIn_lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				//--Error exception for String input for downpayment jtextfield--//
				try {
					String id = studentID_textField.getText();
					studentID = Integer.parseInt(id);
					
				}catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,"Invalid input: " + e1.getMessage());
				}
				
			
				try {
					String studentPassword = passwordField.getText();
										
					pst = con.prepareStatement("SELECT * FROM `student info` WHERE `id` = ? AND `password` = ?");
					pst.setInt(1, studentID);
					pst.setString(2, studentPassword);
					
					rs = pst.executeQuery();
					
					if(rs.next()) {	    	            
						 String grade = rs.getString("yearlevel");
						
		    	            //--INITIALIZING THE VALUE OF THE NEXT FRAME BY USING THE VALUE INPUT IN STUDENT ID	   
		    	            d_Student_Dashboard studentDashboard = new d_Student_Dashboard();
		    	            d_Student_Dashboard.getYearLevel = grade;
		    	            d_Student_Dashboard.signUP_id = b_Student_LogIn_Form_2.studentID_textField.getText();	    	         
		    	            studentDashboard.setVisible(true);
		    				dispose();
					}
		               
				} catch (SQLException e1) {
					e1.printStackTrace();
				}

			}
		});
		LogIn_lblNewLabel.setBounds(0, 0, 171, 40);
		LogIn_lblNewLabel.setForeground(Color.BLACK);
		LogIn_lblNewLabel.setBackground(Color.WHITE);
		LogIn_lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		LogIn_lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		LogIn_panel.add(LogIn_lblNewLabel);

		JLabel keyIcon_Label = new JLabel("");
		keyIcon_Label.setHorizontalAlignment(SwingConstants.CENTER);
		keyIcon_Label.setBounds(10, 0, 48, 40);
		keyIcon_Label.setIcon(new ImageIcon(keyLogo));
		LogIn_panel.add(keyIcon_Label);

		JLabel forgot_label = new JLabel("Forgot Password?");
		forgot_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				forgot_label.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				forgot_label.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				information_Panel.removeAll();
				information_Panel.add(ResetPassword_panel);
				information_Panel.repaint();
				information_Panel.revalidate();
			}
		});
		forgot_label.setBounds(231, 307, 148, 14);
		forgot_label.setForeground(Color.BLACK);
		forgot_label.setHorizontalAlignment(SwingConstants.RIGHT);
		forgot_label.setFont(new Font("Arial Black", Font.BOLD, 12));
		LogIn_Panel.add(forgot_label);

		errorMessage_Label = new JLabel("");
		errorMessage_Label.setForeground(Color.WHITE);
		errorMessage_Label.setHorizontalAlignment(SwingConstants.CENTER);
		errorMessage_Label.setBounds(109, 337, 265, 14);
		LogIn_Panel.add(errorMessage_Label);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Invisible");
		chckbxNewCheckBox.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				  char echoChar = passwordField.getEchoChar();
			        if (echoChar == '\u2022') {
			            passwordField.setEchoChar((char) 0);
			        } else {
			            passwordField.setEchoChar('\u2022');
			        }
			}
		});
		chckbxNewCheckBox.setFont(new Font("Bell MT", Font.BOLD, 16));
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox.setBorder(null);
		chckbxNewCheckBox.setBackground(new Color(96, 96, 96));
		chckbxNewCheckBox.setForeground(Color.WHITE);
		chckbxNewCheckBox.setBounds(372, 271, 106, 23);
		LogIn_Panel.add(chckbxNewCheckBox);

		// JPanel SignUp_Panel = new JPanel();
		SignUp_Panel = new JPanel();
		SignUp_Panel.setBackground(new Color(96, 96, 96));
		information_Panel.add(SignUp_Panel, "name_273037285749499");

		Username_textField = new JTextField();
		Username_textField.setForeground(Color.WHITE);
		Username_textField.setOpaque(false);
		Username_textField.setBounds(243, 130, 226, 29);
		Username_textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Username_textField.setText("");
				
			}

		});
		SignUp_Panel.setLayout(null);
		Username_textField.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		Username_textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.CYAN));
		Username_textField.setText("Create Username");
		SignUp_Panel.add(Username_textField);
		Username_textField.setColumns(10);

		Password_textField = new JTextField();
		Password_textField.setForeground(Color.WHITE);
		Password_textField.setOpaque(false);
		Password_textField.setBounds(243, 174, 226, 29);
		Password_textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Password_textField.setText("");
				
			}

		});
		Password_textField.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		Password_textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.CYAN));
		Password_textField.setText("Create Password");
		Password_textField.setColumns(10);
		SignUp_Panel.add(Password_textField);

		JLabel imageIcon_lblNewLabel_1 = new JLabel("");
		imageIcon_lblNewLabel_1.setBounds(125, 21, 215, 99);
		imageIcon_lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		imageIcon_lblNewLabel_1.setIcon(new ImageIcon(umlogo));
		SignUp_Panel.add(imageIcon_lblNewLabel_1);

		JLabel signUp_lblNewLabel_1 = new JLabel("Sign Up");
		signUp_lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//--Error exception for String input for downpayment jtextfield--//
				try {
				downpayment = Integer.parseInt(downpayment_textfield.getText());
				
				}catch (NumberFormatException e1) {
					JOptionPane.showMessageDialog(null,"Invalid input: " + e1.getMessage());
				}
				
				
				if(firstName_textfield.getText().isEmpty() || firstName_textfield.getText().equals("First name")) {
					JOptionPane.showMessageDialog(null, "First name is required!!");

				}else if(lastName_textfield.getText().isEmpty() || lastName_textfield.getText().equals("Last name")) {
					JOptionPane.showMessageDialog(null, "Last name is required!!");
					
				}else if(gender_comboBox.getSelectedItem().toString().equals("Gender")) {
					JOptionPane.showMessageDialog(null, "Gender is required!!");

				}else if(age_textfield.getText().isEmpty() || age_textfield.getText().equals("Age")) {
					JOptionPane.showMessageDialog(null, "Age is required!!");

				}else if(grade_comboBox.getSelectedItem().toString().equals("Grade Level")) {
					JOptionPane.showMessageDialog(null, "Choose Grade 1-6 only!!");	
					
				}else if(Username_textField.getText().isEmpty() || Username_textField.getText().equals("Create Username")) {
					JOptionPane.showMessageDialog(null, "Username is required!!");
					
				}else if(Password_textField.getText().isEmpty() || Password_textField.getText().equals("Create Password")) {
					JOptionPane.showMessageDialog(null, "Password is required!!");
					
				}else if(month_comboBox.getSelectedItem().toString().equals("Month") || day_comboBox.getSelectedItem().toString().equals("Day") || year_comboBox.getSelectedItem().toString().equals("Year")) {
					JOptionPane.showMessageDialog(null, "Date Enrollment is required!!");
					
				}else if(downpayment_textfield.getText().isEmpty() || Password_textField.getText().equals("Downpayment")) {
					JOptionPane.showMessageDialog(null, "Downpayment is required!!");
					
				}else if(downpayment <= 1999) {
					
					JOptionPane.showMessageDialog(null, "Downpayment is not enough!!");
					
				}else {
					
				try {	
					
				firstName = firstName_textfield.getText();
				surName = lastName_textfield.getText();
				gender = gender_comboBox.getSelectedItem().toString();
				age = age_textfield.getText();
				gradeLevel = grade_comboBox.getSelectedItem().toString();
				userName = Username_textField.getText();
				passsword = Password_textField.getText();
				
				
				month = month_comboBox.getSelectedItem().toString();
				date = day_comboBox.getSelectedItem().toString();
				year = year_comboBox.getSelectedItem().toString();
				date_enroll = month + " " + date + ", "+ year;
				
				
				
				if(gradeLevel.equals("Grade 1") || gradeLevel.equals("Grade 2")) {
					tuition = 31753 - downpayment;
						
				}else if(gradeLevel.equals("Grade 3")) {
					tuition = 32382 - downpayment;
					
				}else if(gradeLevel.equals("Grade 4")) {
					tuition = 29787 - downpayment;
					
				}else if(gradeLevel.equals("Grade 5")) {
					tuition = 29881 - downpayment;
					
				}else if(gradeLevel.equals("Grade 6")) {
					tuition = 30322 - downpayment;
				}
																
					pst = con.prepareStatement("INSERT INTO `student info`(`firstname`, `lastname`, `gender`, `age`, `yearlevel`, `username`, `password`, `Date Enroll`,  `tuition`) VALUES (?,?,?,?,?,?,?,?,?)");
					pst.setString(1, firstName);
					pst.setString(2, surName);
					pst.setString(3, gender);
					pst.setString(4, age);
					pst.setString(5, gradeLevel);
					pst.setString(6, userName);
					pst.setString(7, passsword);
					pst.setString(8, date_enroll);
					pst.setInt(9, tuition);

					k = pst.executeUpdate();
					
					//----------------------------------------------------------------------------------------------
					String studentUsername = Username_textField.getText();
					pst1 = con1.prepareStatement("SELECT `id`, `password`, `tuition` FROM `student info` WHERE `username` = ?");
					pst1.setString(1, studentUsername);
					
					rs1 = pst1.executeQuery();
					
					//-----------------------------------------------------------------------------------------------
					
					
					if(k == 1 && rs1.next()) {
						JOptionPane.showMessageDialog(null, "Record added successfully!!");
						
						
						studentID = rs1.getInt("id");
			        	studentPass = rs1.getString("password");
			        	tuitionSender = rs1.getInt("tuition");
			        	 
			        	 id =  Integer. toString(studentID);
			        	 JOptionPane.showMessageDialog(null, "----YOUR UNIQUE LOG IN INFORMATION---- \n\n STUDENT ID: " + id + "\n PASSWORD: " + studentPass + "\n"
			        	 		+ "As a guide reference, you can take a picture or write it in your notes.");
			        	 
			        	
						firstName_textfield.setText("First name");
						lastName_textfield.setText("Last name");
						age_textfield.setText("Age");
						Username_textField.setText("Create Username");
						Password_textField.setText("Create Password");
						month_comboBox.setSelectedItem("Month");
						day_comboBox.setSelectedItem("Day");
						year_comboBox.setSelectedItem("Year");
						grade_comboBox.setSelectedItem("Grade Level");
						gender_comboBox.setSelectedItem("Gender");
						downpayment_textfield.setText("0");
						
						
						

					}else {
						JOptionPane.showMessageDialog(null, "Record failed to save!!");
					}
				
			         
				} catch (SQLException e1) {
					e1.printStackTrace();
				} 			

			}
				
			}
		}); 

		signUp_lblNewLabel_1.setBounds(159, 335, 147, 29);
		SignUp_Panel.add(signUp_lblNewLabel_1);
		signUp_lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.BOLD, 14));
		signUp_lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		JPanel signUp_panel = new JPanel();
		signUp_panel.setBounds(162, 335, 147, 29);
		signUp_panel.setBackground(Color.CYAN);
		SignUp_Panel.add(signUp_panel);
		signUp_panel.setLayout(null);

		firstName_textfield = new JTextField();
		firstName_textfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				firstName_textfield.setText("");
				
			}
		});
		firstName_textfield.setText("First name");
		firstName_textfield.setOpaque(false);
		firstName_textfield.setForeground(Color.WHITE);
		firstName_textfield.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		firstName_textfield.setColumns(10);
		firstName_textfield.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.CYAN));
		firstName_textfield.setBounds(10, 131, 215, 29);
		SignUp_Panel.add(firstName_textfield);

		lastName_textfield = new JTextField();
		lastName_textfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lastName_textfield.setText("");
				
			}
		});
		lastName_textfield.setText("Last name");
		lastName_textfield.setOpaque(false);
		lastName_textfield.setForeground(Color.WHITE);
		lastName_textfield.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		lastName_textfield.setColumns(10);
		lastName_textfield.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.CYAN));
		lastName_textfield.setBounds(10, 174, 215, 29);
		SignUp_Panel.add(lastName_textfield);

		age_textfield = new JTextField();
		age_textfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				age_textfield.setText("");
				
			}
		});
		age_textfield.setText("Age");
		age_textfield.setOpaque(false);
		age_textfield.setForeground(Color.WHITE);
		age_textfield.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		age_textfield.setColumns(10);
		age_textfield.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.CYAN));
		age_textfield.setBounds(10, 231, 86, 29);
		SignUp_Panel.add(age_textfield);

		String items[] = { "Grade Level", "Grade 1", "Grade 2", "Grade 3", "Grade 4", "Grade 5", "Grade 6" };
		grade_comboBox = new JComboBox(items);
		
		grade_comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		grade_comboBox.setBounds(10, 271, 117, 22);
		SignUp_Panel.add(grade_comboBox);
	
		downpayment_textfield = new JTextField();
		downpayment_textfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				downpayment_textfield.setText("");		
			}
		});
		downpayment_textfield.setHorizontalAlignment(SwingConstants.CENTER);
		downpayment_textfield.setText("Downpayment");
		downpayment_textfield.setOpaque(false);
		downpayment_textfield.setForeground(Color.WHITE);
		downpayment_textfield.setFont(new Font("Segoe UI Black", Font.BOLD, 13));
		downpayment_textfield.setColumns(10);
		downpayment_textfield.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.CYAN));
		downpayment_textfield.setBounds(245, 268, 226, 29);
		SignUp_Panel.add(downpayment_textfield);
		
		//--JLabel remainder_label = new JLabel("");--//
		remainder_label = new JLabel("Minimum Downpayment is P2000.");
		remainder_label.setForeground(Color.WHITE);
		remainder_label.setFont(new Font("Segoe UI", Font.BOLD, 11));
		remainder_label.setHorizontalAlignment(SwingConstants.CENTER);
		remainder_label.setBounds(245, 297, 226, 14);
		SignUp_Panel.add(remainder_label);
		
		String gender[] = {"Gender","Male","Female"};
		//--JComboBox gender_comboBox = new JComboBox(gender)--//
		gender_comboBox = new JComboBox(gender);
		gender_comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		gender_comboBox.setBounds(137, 271, 87, 22);
		SignUp_Panel.add(gender_comboBox);
		
		String month[] = {"Month","January","February","March","April","May","June","July","August","September","October","November","December"};
		//--JComboBox month_comboBox = new JComboBox(month)--//
		month_comboBox = new JComboBox(month);
		month_comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		month_comboBox.setBounds(106, 234, 118, 22);
		SignUp_Panel.add(month_comboBox);
		
		String day[] = {"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
		//--JComboBox day_comboBox = new JComboBox(day)--//
		day_comboBox = new JComboBox(day);
		day_comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		day_comboBox.setBounds(242, 234, 97, 22);
		SignUp_Panel.add(day_comboBox);
		
		String year[] = {"Year","2023","2022","2021","2020","2019","2018","2017","2016","2015","2014","2013","2012","2011","2010","2009","2008","2007","2006","2005","2004","2003","2002","2001","2000"};
		//--JComboBox year_comboBox = new JComboBox(year)--//
		year_comboBox = new JComboBox(year);
		year_comboBox.setFont(new Font("Arial", Font.PLAIN, 16));
		year_comboBox.setBounds(346, 234, 123, 22);
		SignUp_Panel.add(year_comboBox);
		
		JLabel remainder_label_1 = new JLabel("Date of Enrollment");
		remainder_label_1.setHorizontalAlignment(SwingConstants.CENTER);
		remainder_label_1.setForeground(Color.WHITE);
		remainder_label_1.setFont(new Font("Segoe UI", Font.BOLD, 12));
		remainder_label_1.setBounds(116, 214, 362, 14);
		SignUp_Panel.add(remainder_label_1);
		
		ResetPassword_panel = new JPanel();
		ResetPassword_panel.setBackground(new Color(96, 96, 96));
		information_Panel.add(ResetPassword_panel, "name_1008303396717600");
		ResetPassword_panel.setLayout(null);
		
		studentID_label = new JTextField();
		studentID_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				studentID_label.setText("");
			}
		});
		studentID_label.setText("Student ID");
		studentID_label.setOpaque(false);
		studentID_label.setForeground(Color.WHITE);
		studentID_label.setFont(new Font("Arial", Font.PLAIN, 14));
		studentID_label.setColumns(10);
		studentID_label.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		studentID_label.setBounds(88, 158, 317, 29);
		ResetPassword_panel.add(studentID_label);
		
		ResetPassword_label = new JTextField();
		ResetPassword_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ResetPassword_label.setText("");
			}
		});
		ResetPassword_label.setText("Reset Password");
		ResetPassword_label.setOpaque(false);
		ResetPassword_label.setForeground(Color.WHITE);
		ResetPassword_label.setFont(new Font("Arial", Font.PLAIN, 14));
		ResetPassword_label.setColumns(10);
		ResetPassword_label.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		ResetPassword_label.setBounds(88, 211, 317, 29);
		ResetPassword_panel.add(ResetPassword_label);
		
		JLabel resetLogo_label = new JLabel("");
		resetLogo_label.setHorizontalAlignment(SwingConstants.CENTER);
		resetLogo_label.setBounds(170, 24, 152, 102);
		resetLogo_label.setIcon(new ImageIcon(umlogo));
		ResetPassword_panel.add(resetLogo_label);
		
		JButton done_button = new JButton("DONE");
		done_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//--UPDATING THE VALUE OF PASSWORD IN ADMIN INFO
				try {
					
					String id = studentID_label.getText();
					int student_id = Integer.parseInt(id);
					String newPassword = ResetPassword_label.getText();

					pst = con.prepareStatement("UPDATE `student info` SET `password`= ? WHERE `id` = ?");

					pst.setString(1, newPassword);
					pst.setInt(2, student_id);
					
					int k = pst.executeUpdate();
					if(k == 1){
						JOptionPane.showMessageDialog(null, "Password has been successfully updated!!");
						studentID_label.setText("Username");
						ResetPassword_label.setText("Reset Password");
						
						information_Panel.removeAll();
						information_Panel.add(LogIn_Panel);
						information_Panel.repaint();
						information_Panel.revalidate();
						
					}else {
	                    JOptionPane.showMessageDialog(null, "Incorrect Username!!");
	                }
									
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				
			}
		});
		done_button.setFont(new Font("Times New Roman", Font.BOLD, 18));
		done_button.setBounds(202, 275, 89, 23);
		ResetPassword_panel.add(done_button);

		JLabel exit_lblNewLabel = new JLabel("X");
		exit_Interface.exitProgram(exit_lblNewLabel);//--INHERITED INTERFACE NAME "exit_Interface"--//
		exit_lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		exit_lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		exit_lblNewLabel.setForeground(Color.WHITE);
		exit_lblNewLabel.setBounds(690, 0, 43, 23);
		contentPane.add(exit_lblNewLabel);

		JPanel back_Panel = new JPanel();
		back_Panel.setBackground(Color.CYAN);
		back_Panel.setBounds(0, 0, 66, 23);
		contentPane.add(back_Panel);
		back_Panel.setLayout(null);

		JLabel arrow_Label = new JLabel("");
		arrow_Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				back_Panel.setBackground(Color.DARK_GRAY);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				back_Panel.setBackground(Color.CYAN);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new a_front_Interface().setVisible(true);
				dispose();
			}
		});
		arrow_Label.setHorizontalAlignment(SwingConstants.CENTER);
		arrow_Label.setBounds(0, 0, 66, 23);
		arrow_Label.setIcon(new ImageIcon(arrowLogo));
		back_Panel.add(arrow_Label);

		setLocationRelativeTo(null);
		
	
		
	}
}
