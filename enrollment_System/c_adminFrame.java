package enrollment_System;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.border.MatteBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPasswordField;
import java.sql.*;


public class c_adminFrame extends JFrame {

	private JPanel contentPane;

	private static JPanel main_Panel;
	private static JPanel admin_panel;
	private static JPanel resetPass_panel;
	private static JTextField userName_textField;
	private static JTextField usernameForgot_textfield;
	private static JTextField newPass_textfield;
	private static JLabel arrow_Label;
	private static JPanel arrow_panel;
	private static JLabel mainArrow_label;
	private static JPanel mainArrowPanel_panel;
	private static JLabel errorMessage_Label;
	private static JPasswordField password_passwordfield;
	private JLabel resetErrorMessage_label;

	private static Image adminLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/ICONS/userLogin.png")).getImage().getScaledInstance(203,152,Image.SCALE_SMOOTH);
	private static Image arrowLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/ICONS/back.png")).getImage().getScaledInstance(100,23,Image.SCALE_SMOOTH);
	
	
	public static int overall_Students;
	
	//---DATABASE CONNECTION---//
		Connection con, con1;
		PreparedStatement pst, pst1;
		ResultSet rs, rs1;
		
		//---DATABASE CONNECTION---//
		public void Connect(){
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://localhost/enrollment system","root","");
				con1 = DriverManager.getConnection("jdbc:mysql://localhost/enrollment system","root","");
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
					c_adminFrame frame = new c_adminFrame();
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

	public static void cardLayout(Component cardPanel) {
		main_Panel.removeAll();
		main_Panel.add(cardPanel); 
		main_Panel.repaint();
		main_Panel.revalidate();
	}

	
	public c_adminFrame() {
		
		Connect();
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 723, 462);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		main_Panel = new JPanel();
		main_Panel.setBounds(0, 0, 723, 462);
		contentPane.add(main_Panel);
		main_Panel.setLayout(new CardLayout(0, 0));

		admin_panel = new JPanel();
		admin_panel.setBackground(new Color(44, 62, 80));
		main_Panel.add(admin_panel, "name_2433484364900");
		admin_panel.setLayout(null);

		errorMessage_Label = new JLabel("");
		errorMessage_Label.setForeground(Color.WHITE);
		errorMessage_Label.setFont(new Font("Arial", Font.PLAIN, 14));
		errorMessage_Label.setHorizontalAlignment(SwingConstants.CENTER);
		errorMessage_Label.setBounds(204, 316, 317, 23);
		admin_panel.add(errorMessage_Label);

		JLabel shield_label = new JLabel("");
		shield_label.setHorizontalAlignment(SwingConstants.CENTER);
		shield_label.setBounds(261, 11, 203, 152);
		shield_label.setIcon(new ImageIcon(adminLogo));
		admin_panel.add(shield_label);

		userName_textField = new JTextField();
		userName_textField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				userName_textField.setText("");
			}
		});
		userName_textField.setForeground(Color.WHITE);
		userName_textField.setOpaque(false);
		userName_textField.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		userName_textField.setFont(new Font("Arial", Font.PLAIN, 16));
		userName_textField.setText("Username");
		userName_textField.setBounds(204, 196, 317, 29);
		admin_panel.add(userName_textField);
		userName_textField.setColumns(10);

		JLabel lblNewLabel = new JLabel("Forgot Password?");
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setForeground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setForeground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout(resetPass_panel);//--Method cardLayout--//
				userName_textField.setText("Username");
				password_passwordfield.setText("Password");
				password_passwordfield.setEchoChar((char)0);
				errorMessage_Label.setText("");

			}
		});
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(408, 291, 112, 14);
		admin_panel.add(lblNewLabel);

		JButton login_button = new JButton("Login");
		login_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				//--COMPARING THE DATABASE INFO AND USER DEFINE INFORMATION
	           String username = userName_textField.getText();
	           String password = String.valueOf(password_passwordfield.getPassword());
	           
	           
	           if(username.equals("") || password.equals("")) {
	               JOptionPane.showMessageDialog(null, "Login Failed");
	           } else {   
	           
	           try {
					
					pst = con.prepareStatement("SELECT * FROM `admin info` WHERE username = ? AND password = ?");
					
					 pst.setString(1, username);
		             pst.setString(2, password);	     
		             		       
		                rs = pst.executeQuery();
		               		                
		                if(rs.next()) {
		                    new e_Admin_Dashboard().setVisible(true);
		    	            dispose();
		    	            		    	       
		                   
		                } else {
		                    JOptionPane.showMessageDialog(null, "Incorrect Username or Password!");
		                }
		                

				} catch (SQLException e1) {
					e1.printStackTrace();
				}	        
	        	   
	        	   
			}
	          
			}
		});
		login_button.setBackground(Color.WHITE);
		login_button.setFont(new Font("Bell MT", Font.BOLD, 16));
		login_button.setBounds(314, 340, 97, 29);
		admin_panel.add(login_button);


		JLabel exit_lblNewLabel = new JLabel("X");
		exit_Interface.exitProgram(exit_lblNewLabel);//--INHERITED INTERFACE NAME "exit_Interface"--//


		exit_lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		exit_lblNewLabel.setForeground(Color.WHITE);
		exit_lblNewLabel.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		exit_lblNewLabel.setBounds(691, 0, 32, 29);
		admin_panel.add(exit_lblNewLabel);

		mainArrowPanel_panel = new JPanel();
		mainArrowPanel_panel.setBackground(new Color(44, 62, 80));
		mainArrowPanel_panel.setBounds(0, 0, 79, 29);
		admin_panel.add(mainArrowPanel_panel);
		mainArrowPanel_panel.setLayout(null);

		mainArrow_label = new JLabel("");
		mainArrow_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				mainArrowPanel_panel.setBackground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				mainArrowPanel_panel.setBackground(new Color(44, 62, 80));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new a_front_Interface().setVisible(true);
				dispose();
			}
		});
		mainArrow_label.setBounds(0, 0, 79, 29);
		mainArrowPanel_panel.add(mainArrow_label);
		mainArrow_label.setHorizontalAlignment(SwingConstants.CENTER);
		mainArrow_label.setIcon(new ImageIcon(arrowLogo));

		password_passwordfield = new JPasswordField("Password");
		password_passwordfield.setEchoChar((char)0);
		password_passwordfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(password_passwordfield.getText().equals("Password")) {
					password_passwordfield.setEchoChar('●');
					password_passwordfield.setText("");
				}else {
					password_passwordfield.selectAll();
				}
			}
		});
		password_passwordfield.setForeground(Color.WHITE);
		password_passwordfield.setOpaque(false);
		password_passwordfield.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		password_passwordfield.setFont(new Font("Arial", Font.PLAIN, 16));
		password_passwordfield.setBounds(204, 245, 317, 29);
		admin_panel.add(password_passwordfield);

		resetPass_panel = new JPanel();
		resetPass_panel.setBackground(new Color(44, 62, 80));
		main_Panel.add(resetPass_panel, "name_2452341645000");
		resetPass_panel.setLayout(null);

		JLabel shieldIcon_Label = new JLabel("");
		shieldIcon_Label.setHorizontalAlignment(SwingConstants.CENTER);
		shieldIcon_Label.setBounds(260, 0, 203, 152);
		shieldIcon_Label.setIcon(new ImageIcon(adminLogo));
		resetPass_panel.add(shieldIcon_Label);

		usernameForgot_textfield = new JTextField();
		usernameForgot_textfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				usernameForgot_textfield.setText("");
			}
		});
		usernameForgot_textfield.setText("Username");
		usernameForgot_textfield.setOpaque(false);
		usernameForgot_textfield.setForeground(Color.WHITE);
		usernameForgot_textfield.setFont(new Font("Arial", Font.PLAIN, 14));
		usernameForgot_textfield.setColumns(10);
		usernameForgot_textfield.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		usernameForgot_textfield.setBounds(203, 194, 317, 29);
		resetPass_panel.add(usernameForgot_textfield);

		newPass_textfield = new JTextField();
		newPass_textfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				newPass_textfield.setText("");
			}
		});
		newPass_textfield.setText("Reset Password");
		newPass_textfield.setOpaque(false);
		newPass_textfield.setForeground(Color.WHITE);
		newPass_textfield.setFont(new Font("Arial", Font.PLAIN, 14));
		newPass_textfield.setColumns(10);
		newPass_textfield.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.WHITE));
		newPass_textfield.setBounds(203, 252, 317, 29);
		resetPass_panel.add(newPass_textfield);

		JButton done_button = new JButton("Done");
		done_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//--UPDATING THE VALUE OF PASSWORD IN ADMIN INFO
				try {
					
					String username = usernameForgot_textfield.getText();
					String newPassword = newPass_textfield.getText();

					pst = con.prepareStatement("UPDATE `admin info` SET `password`= ? WHERE `username` = ?");

					pst.setString(1, newPassword);
					pst.setString(2, username);
					
					int k = pst.executeUpdate();
					if(k == 1){
						JOptionPane.showMessageDialog(null, "Record has been successfully updated!!");
						cardLayout(admin_panel);//--Method cardLayout--//
						
					}else {
	                    JOptionPane.showMessageDialog(null, "Incorrect Username!!");
	                }
									
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
			}

			
		});
		done_button.setFont(new Font("Bell MT", Font.BOLD, 16));
		done_button.setBackground(Color.WHITE);
		done_button.setBounds(313, 324, 97, 29);
		resetPass_panel.add(done_button);

		JLabel resExit_Label = new JLabel("X");
		exit_Interface.exitProgram(resExit_Label);//--INHERITED INTERFACE NAME "exit_Interface"--//
		resExit_Label.setHorizontalAlignment(SwingConstants.CENTER);
		resExit_Label.setForeground(Color.WHITE);
		resExit_Label.setFont(new Font("Segoe UI Black", Font.BOLD, 16));
		resExit_Label.setBounds(691, 0, 32, 29);
		resetPass_panel.add(resExit_Label);

		arrow_panel = new JPanel();
		arrow_panel.setBackground(new Color(44, 62, 80));
		arrow_panel.setBounds(0, 0, 79, 29);
		resetPass_panel.add(arrow_panel);
		arrow_panel.setLayout(null);

		arrow_Label = new JLabel("");
		arrow_Label.setBounds(0, 0, 79, 29);
		arrow_panel.add(arrow_Label);
		arrow_Label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				arrow_panel.setBackground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				arrow_panel.setBackground(new Color(44, 62, 80));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				cardLayout(admin_panel);//--Method cardLayout--//
				arrow_panel.setBackground(new Color(44, 62, 80));
				usernameForgot_textfield.setText("Username");
				newPass_textfield.setText("Reset Password");
				resetErrorMessage_label.setText("");
			}
		});
		arrow_Label.setHorizontalAlignment(SwingConstants.CENTER);
		arrow_Label.setIcon(new ImageIcon(arrowLogo));

		resetErrorMessage_label = new JLabel("");
		resetErrorMessage_label.setFont(new Font("Arial", Font.PLAIN, 14));
		resetErrorMessage_label.setHorizontalAlignment(SwingConstants.CENTER);
		resetErrorMessage_label.setBounds(203, 292, 317, 21);
		resetPass_panel.add(resetErrorMessage_label);

		setLocationRelativeTo(null);

	}
}
