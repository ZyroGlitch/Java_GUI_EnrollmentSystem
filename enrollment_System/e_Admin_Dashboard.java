package enrollment_System;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;
import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;

public class e_Admin_Dashboard extends JFrame {

	private JPanel contentPane;

	static Image userLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/Admin_Icons/teamwork.png")).getImage().getScaledInstance(150, 105, Image.SCALE_SMOOTH);
	static Image umlogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/ICONS/UM.png")).getImage().getScaledInstance(80, 50, Image.SCALE_SMOOTH);
	static Image grade1 = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/Admin_Icons/angel.png")).getImage().getScaledInstance(77, 68, Image.SCALE_SMOOTH);
	static Image grade2 = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/Admin_Icons/Andrew.png")).getImage().getScaledInstance(77, 68, Image.SCALE_SMOOTH);
	static Image grade3 = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/Admin_Icons/Brook.png")).getImage().getScaledInstance(77, 68, Image.SCALE_SMOOTH);
	static Image grade4 = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/Admin_Icons/Michelle.png")).getImage().getScaledInstance(77, 68, Image.SCALE_SMOOTH);
	static Image grade5 = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/Admin_Icons/Sakura.png")).getImage().getScaledInstance(77, 68, Image.SCALE_SMOOTH);
	static Image grade6 = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/Admin_Icons/scientist.png")).getImage().getScaledInstance(77, 68, Image.SCALE_SMOOTH);
	static Image students = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/Admin_Icons/students.png")).getImage().getScaledInstance(77, 67, Image.SCALE_SMOOTH);
	static Image arrowLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/ICONS/back.png")).getImage().getScaledInstance(100, 23, Image.SCALE_SMOOTH);
	static Image updateLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/Admin_Icons/update.png")).getImage().getScaledInstance(59, 39, Image.SCALE_SMOOTH);
	static Image deleteLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/Admin_Icons/delete.png")).getImage().getScaledInstance(67, 39, Image.SCALE_SMOOTH);
	static Image csvLogo = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/Admin_Icons/csv.png")).getImage().getScaledInstance(55, 39, Image.SCALE_SMOOTH);
	static Image create = new ImageIcon(b_Student_LogIn_Form_2.class.getResource("/Admin_Icons/create.png")).getImage().getScaledInstance(55, 39, Image.SCALE_SMOOTH);

	private JTextField firstname_textfield;
	private JTextField lastname_textfield;
	private JTextField username_textfield;
	private JTextField password_textfield;
	private JTextField age_textfield;
	private JTable content_table;
	static JPanel student_panel;
	static JPanel card_panel;
	static JPanel Dashboard_panel;
	static JLabel menu_label;
	static JLabel population_label;
	static JLabel grade1Population_label;
	static JLabel grade2Population_label;
	static JLabel grade3Population_label;
	static JLabel grade4Population_label;
	static JLabel grade5Population_label;
	static JLabel grade6Population_label;
	static JComboBox id_comboBox = new JComboBox();
	static JComboBox gender_comboBox;
	static JComboBox gradeLevel_comboBox;
	
	static c_adminFrame firstFrame;

	//---DATABASE CONNECTION---//
			Connection con, con1, con2, con3, con4, con5, con6;
			PreparedStatement pst, pst1, pst2, pst3, pst4, pst5, pst6;
			ResultSet rs, rs1, rs2, rs3, rs4, rs5, rs6;
			
			//---DATABASE CONNECTION---//
			public void Connect(){
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con = DriverManager.getConnection("jdbc:mysql://localhost/enrollment system","root","");
					con1 = DriverManager.getConnection("jdbc:mysql://localhost/enrollment system","root","");
					con2 = DriverManager.getConnection("jdbc:mysql://localhost/enrollment system","root","");
					con3 = DriverManager.getConnection("jdbc:mysql://localhost/enrollment system","root","");
					con4 = DriverManager.getConnection("jdbc:mysql://localhost/enrollment system","root","");
					con5 = DriverManager.getConnection("jdbc:mysql://localhost/enrollment system","root","");
					con6 = DriverManager.getConnection("jdbc:mysql://localhost/enrollment system","root","");
					
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			
			public void LoadProductNo(){
				try {
					pst = con.prepareStatement("SELECT `id` FROM `student info`");
					rs = pst.executeQuery();
					id_comboBox.removeAllItems();

					while(rs.next()){
						id_comboBox.addItem(rs.getString(1));
					}

				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
	
			
			public void responsiveTable() {

				
				
				try {

					int q;
					
					pst = con.prepareStatement("SELECT * FROM `student info`");
					rs = pst.executeQuery();
					ResultSetMetaData table = rs.getMetaData();
					q = table.getColumnCount();
					
					DefaultTableModel df = (DefaultTableModel)content_table.getModel();
					df.setRowCount(0);
					
					while(rs.next()) {
						Vector v2 = new Vector();
						
						for(int a = 1; a <= q; a++) {
							v2.add(rs.getString("id"));
							v2.add(rs.getString("firstname"));
							v2.add(rs.getString("lastname"));
							v2.add(rs.getString("gender"));
							v2.add(rs.getString("age"));
							v2.add(rs.getString("yearlevel"));
							v2.add(rs.getString("username"));
							v2.add(rs.getString("password"));
							v2.add(rs.getString("Date Enroll"));
						}
						df.addRow(v2);
					}
					

				}catch(SQLException e) {
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
					e_Admin_Dashboard frame = new e_Admin_Dashboard();									    
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
	public e_Admin_Dashboard() {
		
		Connect();
		LoadProductNo();
		
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel user_panel = new JPanel();
		user_panel.setBackground(new Color(127, 140, 141));
		user_panel.setBounds(0, 0, 261, 117);
		contentPane.add(user_panel);
		user_panel.setLayout(null);
		
		JLabel userLogo_label = new JLabel("");
		userLogo_label.setHorizontalAlignment(SwingConstants.CENTER);
		userLogo_label.setBounds(0, 0, 261, 117);
		userLogo_label.setIcon(new ImageIcon(userLogo));
		user_panel.add(userLogo_label);
		
		JPanel dashboard_panel = new JPanel();
		dashboard_panel.setBackground(new Color(236, 240, 241));
		dashboard_panel.setBounds(0, 116, 261, 484);
		contentPane.add(dashboard_panel);
		dashboard_panel.setLayout(null);
		
		JPanel menuDash_panel = new JPanel();
		menuDash_panel.setBounds(0, 0, 261, 55);
		menuDash_panel.setBackground(new Color(236, 240, 241));
		dashboard_panel.add(menuDash_panel);
		menuDash_panel.setLayout(null);
		
		JLabel dashboard_label = new JLabel("Dashboard");
		dashboard_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				menuDash_panel.setBackground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				menuDash_panel.setBackground(new Color(236, 240, 241));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				card_panel.removeAll();
				card_panel.add(Dashboard_panel);
				card_panel.repaint();
				card_panel.revalidate();	
				
				menu_label.setText("Dashboard");
				
				 try {
					 
					 String yearlevel[] = {"Grade 1", "Grade 2", "Grade 3", "Grade 4", "Grade 5", "Grade 6"};
		        	   
		        	  	 pst = con.prepareStatement("SELECT COUNT(id) FROM `student info`");
		        	  	 
		        	  	 pst1 = con1.prepareStatement("SELECT COUNT(id) FROM `student info` WHERE yearlevel = ?");
		        	  	 pst2 = con2.prepareStatement("SELECT COUNT(id) FROM `student info` WHERE yearlevel = ?");
		        	  	pst3 = con3.prepareStatement("SELECT COUNT(id) FROM `student info` WHERE yearlevel = ?");
		        	  	pst4 = con4.prepareStatement("SELECT COUNT(id) FROM `student info` WHERE yearlevel = ?");
		        	  	pst5 = con5.prepareStatement("SELECT COUNT(id) FROM `student info` WHERE yearlevel = ?");
		        	  	pst6 = con6.prepareStatement("SELECT COUNT(id) FROM `student info` WHERE yearlevel = ?");
						
		        	  	 pst1.setString(1, yearlevel[0]);
		        	  	 pst2.setString(1, yearlevel[1]);
		        	  	 pst3.setString(1, yearlevel[2]);
		        	  	 pst4.setString(1, yearlevel[3]);
		        	  	 pst5.setString(1, yearlevel[4]);
		        	  	 pst6.setString(1, yearlevel[5]);
		        	  	 
		        	  	 
		        	      rs = pst.executeQuery();
		        	      rs1 = pst1.executeQuery();
		        	      rs2 = pst2.executeQuery();
		        	      rs3 = pst3.executeQuery();
		        	      rs4 = pst4.executeQuery();
		        	      rs5 = pst5.executeQuery();
		        	      rs6 = pst6.executeQuery();

		        	      // Extract the count value from the result set
		        	      int count[] = new int[7];
		        	      
		        	     
		        	      if (rs.next() && rs1.next() && rs2.next() && rs3.next() && rs4.next() && rs5.next() && rs6.next()) {
		        	    	  count[0] = rs.getInt(1);
		        	    	  count[1] = rs1.getInt(1);
		        	    	  count[2] = rs2.getInt(1);
		        	    	  count[3] = rs3.getInt(1);
		        	    	  count[4] = rs4.getInt(1);
		        	    	  count[5] = rs5.getInt(1);
		        	    	  count[6] = rs6.getInt(1);
		        	    	  
		        	    	  String population = Integer.toString(count[0]);
		        	    	  population_label.setText(population);
		        	    	  
		        	    	  String grade_1 = Integer.toString(count[1]);
		        	    	  grade1Population_label.setText(grade_1);
		        	    	  
		        	    	  String grade_2 = Integer.toString(count[2]);
		        	    	  grade2Population_label.setText(grade_2);
		        	    	  
		        	    	  String grade_3 = Integer.toString(count[3]);
		        	    	  grade3Population_label.setText(grade_3);
		        	    	  
		        	    	  String grade_4 = Integer.toString(count[4]);
		        	    	  grade4Population_label.setText(grade_4);
		        	    	  
		        	    	  String grade_5 = Integer.toString(count[5]);
		        	    	  grade5Population_label.setText(grade_5);
		        	    	  
		        	    	  String grade_6 = Integer.toString(count[6]);
		        	    	  grade6Population_label.setText(grade_6);
		        	    	 
		        	    	  //--CLEAR ALL DATA IN PREVIOUS PANEL
		        	    	  	firstname_textfield.setText("");
								lastname_textfield.setText("");
								gender_comboBox.setSelectedItem("Gender");
								age_textfield.setText("");
								gradeLevel_comboBox.setSelectedItem("Grade Level");
								username_textfield.setText("");
								password_textfield.setText("");
								
								//-- METHOD FOR RESPONSIVE TABLE
								responsiveTable();
		        	      }
  	     
		        	   } catch (SQLException e1) {
		        		   JOptionPane.showMessageDialog(null, "Invalid count!");
							e1.printStackTrace();
						} 
			
			}
		});
		dashboard_label.setFont(new Font("Segoe UI", Font.BOLD, 16));
		dashboard_label.setHorizontalAlignment(SwingConstants.CENTER);
		dashboard_label.setBounds(0, 0, 261, 55);
		menuDash_panel.add(dashboard_label);
		
		
		JPanel students_panel = new JPanel();
		students_panel.setBounds(0, 55, 261, 55);
		students_panel.setBackground(new Color(236, 240, 241));
		dashboard_panel.add(students_panel);
		students_panel.setLayout(null);
		
		JLabel student_label = new JLabel("Students");
		student_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				students_panel.setBackground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				students_panel.setBackground(new Color(236, 240, 241));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				card_panel.removeAll();
				card_panel.add(student_panel);
				card_panel.repaint();
				card_panel.revalidate();	
				
				menu_label.setText("Students");
				
				//-- METHOD FOR RESPONSIVE TABLE
				responsiveTable();
			}
		});
		student_label.setHorizontalAlignment(SwingConstants.CENTER);
		student_label.setFont(new Font("Segoe UI", Font.BOLD, 16));
		student_label.setBounds(0, 0, 261, 55);
		students_panel.add(student_label);
		
		JPanel back_Panel = new JPanel();
		back_Panel.setLayout(null);
		back_Panel.setBackground(Color.CYAN);
		back_Panel.setBounds(0, 461, 66, 23);
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
				new c_adminFrame().setVisible(true);
				dispose();
			}
		});
		arrow_Label.setHorizontalAlignment(SwingConstants.CENTER);
		arrow_Label.setBounds(0, 0, 66, 23);
		arrow_Label.setIcon(new ImageIcon(arrowLogo));
		back_Panel.add(arrow_Label);
		
		JPanel upperTab_panel = new JPanel();
		upperTab_panel.setBackground(new Color(0, 230, 118));
		upperTab_panel.setBounds(258, 0, 642, 74);
		contentPane.add(upperTab_panel);
		upperTab_panel.setLayout(null);
		
		JLabel umLogo_label = new JLabel("");
		umLogo_label.setHorizontalAlignment(SwingConstants.CENTER);
		umLogo_label.setBounds(10, 0, 99, 74);
		umLogo_label.setIcon(new ImageIcon(umlogo));
		upperTab_panel.add(umLogo_label);
		
		JLabel umText_label = new JLabel("University of Mindanao Main Campus");
		umText_label.setFont(new Font("Times New Roman", Font.BOLD, 22));
		umText_label.setBounds(109, 0, 406, 74);
		upperTab_panel.add(umText_label);
		
		JButton exit_Button = new JButton("X");
		exit_Interface.exitAdmin(exit_Button);//--INHERITED INTERFACE NAME "exit_Interface"--//
		
		exit_Button.setForeground(Color.BLACK);
		exit_Button.setFont(new Font("Segoe UI", Font.BOLD, 18));
		exit_Button.setBorder(null);
		exit_Button.setBackground(Color.LIGHT_GRAY);
		exit_Button.setBounds(600, 0, 42, 23);
		upperTab_panel.add(exit_Button);
		
		JPanel middleTab_panel = new JPanel();
		middleTab_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		middleTab_panel.setBackground(Color.DARK_GRAY);
		middleTab_panel.setBounds(258, 73, 655, 44);
		contentPane.add(middleTab_panel);
		middleTab_panel.setLayout(null);
		
		menu_label = new JLabel("Dashboard");
		menu_label.setForeground(Color.WHITE);
		menu_label.setBackground(Color.WHITE);
		menu_label.setFont(new Font("Times New Roman", Font.BOLD, 24));
		menu_label.setHorizontalAlignment(SwingConstants.CENTER);
		menu_label.setBounds(0, 0, 655, 44);
		middleTab_panel.add(menu_label);
		
		//--JPanel card_panel = new JPanel()--//
		card_panel = new JPanel();
		card_panel.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		card_panel.setBackground(Color.WHITE);
		card_panel.setBounds(258, 116, 642, 484);
		contentPane.add(card_panel);
		card_panel.setLayout(new CardLayout(0, 0));
		
		//--JPanel Dashboard_panel = new JPanel()--//
		Dashboard_panel = new JPanel();
		Dashboard_panel.setBackground(Color.WHITE);
		card_panel.add(Dashboard_panel, "name_403492972161100");
		Dashboard_panel.setLayout(null);
		
		JPanel total_panel = new JPanel();
		total_panel.setBounds(169, 11, 293, 94);
		total_panel.setBackground(new Color(0, 150, 136));
		Dashboard_panel.add(total_panel);
		total_panel.setLayout(null);
		
		JLabel totalIcon_label = new JLabel("");
		totalIcon_label.setHorizontalAlignment(SwingConstants.CENTER);
		totalIcon_label.setBounds(0, 0, 87, 67);
		totalIcon_label.setIcon(new ImageIcon(students));
		total_panel.add(totalIcon_label);
		
		JPanel subTotal_panel = new JPanel();
		subTotal_panel.setLayout(null);
		subTotal_panel.setBackground(Color.GRAY);
		subTotal_panel.setBounds(0, 66, 293, 31);
		total_panel.add(subTotal_panel);
		
		JLabel subTotal_label = new JLabel("OVERALL POPULATION");
		subTotal_label.setHorizontalAlignment(SwingConstants.CENTER);
		subTotal_label.setForeground(Color.WHITE);
		subTotal_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		subTotal_label.setBounds(0, 0, 293, 31);
		subTotal_panel.add(subTotal_label);
		
		//--JLabel population_label = new JLabel("")--//
		population_label = new JLabel("");
		population_label.setFont(new Font("Times New Roman", Font.BOLD, 32));
		population_label.setHorizontalAlignment(SwingConstants.CENTER);
		population_label.setBounds(0, 0, 293, 67);
		total_panel.add(population_label);
		
		JPanel grade1_panel = new JPanel();
		grade1_panel.setBounds(10, 127, 293, 99);
		grade1_panel.setBackground(new Color(0, 150, 136));
		Dashboard_panel.add(grade1_panel);
		grade1_panel.setLayout(null);
		
		JPanel subGrade1_panel = new JPanel();
		subGrade1_panel.setBackground(Color.GRAY);
		subGrade1_panel.setBounds(0, 68, 293, 31);
		grade1_panel.add(subGrade1_panel);
		subGrade1_panel.setLayout(null);
		
		JLabel grade1_label = new JLabel("GRADE 1");
		grade1_label.setForeground(Color.WHITE);
		grade1_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		grade1_label.setHorizontalAlignment(SwingConstants.CENTER);
		grade1_label.setBounds(0, 0, 293, 31);
		subGrade1_panel.add(grade1_label);
		
		JLabel grade1Icon_label = new JLabel("");
		grade1Icon_label.setHorizontalAlignment(SwingConstants.CENTER);
		grade1Icon_label.setBounds(0, 0, 77, 68);
		grade1Icon_label.setIcon(new ImageIcon(grade1));
		grade1_panel.add(grade1Icon_label);
		
		//--JLabel grade1Population_label = new JLabel("")--//
		grade1Population_label = new JLabel("");
		grade1Population_label.setHorizontalAlignment(SwingConstants.CENTER);
		grade1Population_label.setFont(new Font("Times New Roman", Font.BOLD, 32));
		grade1Population_label.setBounds(0, 1, 293, 67);
		grade1_panel.add(grade1Population_label);
		
		JPanel grade2_panel = new JPanel();
		grade2_panel.setBounds(335, 127, 293, 99);
		grade2_panel.setBackground(new Color(0, 150, 136));
		Dashboard_panel.add(grade2_panel);
		grade2_panel.setLayout(null);
		
		JPanel subGrade2_panel = new JPanel();
		subGrade2_panel.setBackground(Color.GRAY);
		subGrade2_panel.setBounds(0, 68, 293, 31);
		grade2_panel.add(subGrade2_panel);
		subGrade2_panel.setLayout(null);
		
		JLabel grade2_label = new JLabel("GRADE 2");
		grade2_label.setHorizontalAlignment(SwingConstants.CENTER);
		grade2_label.setForeground(Color.WHITE);
		grade2_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		grade2_label.setBounds(0, 0, 293, 31);
		subGrade2_panel.add(grade2_label);
		
		JLabel grade2Icon_label = new JLabel("");
		grade2Icon_label.setHorizontalAlignment(SwingConstants.CENTER);
		grade2Icon_label.setBounds(0, 0, 77, 68);
		grade2Icon_label.setIcon(new ImageIcon(grade2));
		grade2_panel.add(grade2Icon_label);
		
		//--JLabel grade2Population_label = new JLabel("")--//
		grade2Population_label = new JLabel("");
		grade2Population_label.setHorizontalAlignment(SwingConstants.CENTER);
		grade2Population_label.setFont(new Font("Times New Roman", Font.BOLD, 32));
		grade2Population_label.setBounds(0, 0, 293, 67);
		grade2_panel.add(grade2Population_label);
		
		JPanel grade3_panel = new JPanel();
		grade3_panel.setBounds(10, 250, 293, 99);
		grade3_panel.setBackground(new Color(0, 150, 136));
		Dashboard_panel.add(grade3_panel);
		grade3_panel.setLayout(null);
		
		JPanel subGrade_panel = new JPanel();
		subGrade_panel.setBackground(Color.GRAY);
		subGrade_panel.setBounds(0, 68, 293, 31);
		grade3_panel.add(subGrade_panel);
		subGrade_panel.setLayout(null);
		
		JLabel grade3_label = new JLabel("GRADE 3");
		grade3_label.setHorizontalAlignment(SwingConstants.CENTER);
		grade3_label.setForeground(Color.WHITE);
		grade3_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		grade3_label.setBounds(0, 0, 293, 31);
		subGrade_panel.add(grade3_label);
		
		JLabel grade3Icon_label = new JLabel("");
		grade3Icon_label.setHorizontalAlignment(SwingConstants.CENTER);
		grade3Icon_label.setBounds(0, 0, 77, 68);
		grade3Icon_label.setIcon(new ImageIcon(grade3));
		grade3_panel.add(grade3Icon_label);
		
		//--JLabel grade3Population_label = new JLabel("")--//
		grade3Population_label = new JLabel("");
		grade3Population_label.setHorizontalAlignment(SwingConstants.CENTER);
		grade3Population_label.setFont(new Font("Times New Roman", Font.BOLD, 32));
		grade3Population_label.setBounds(0, 0, 293, 67);
		grade3_panel.add(grade3Population_label);
		
		JPanel grade4_panel = new JPanel();
		grade4_panel.setBounds(335, 250, 293, 99);
		grade4_panel.setBackground(new Color(0, 150, 136));
		Dashboard_panel.add(grade4_panel);
		grade4_panel.setLayout(null);
		
		JPanel subGrade4_panel = new JPanel();
		subGrade4_panel.setBackground(Color.GRAY);
		subGrade4_panel.setBounds(0, 68, 293, 31);
		grade4_panel.add(subGrade4_panel);
		subGrade4_panel.setLayout(null);
		
		JLabel grade4_label = new JLabel("GRADE 4");
		grade4_label.setHorizontalAlignment(SwingConstants.CENTER);
		grade4_label.setForeground(Color.WHITE);
		grade4_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		grade4_label.setBounds(0, 0, 293, 31);
		subGrade4_panel.add(grade4_label);
		
		JLabel grade4Icon_label = new JLabel("");
		grade4Icon_label.setHorizontalAlignment(SwingConstants.CENTER);
		grade4Icon_label.setBounds(0, 0, 77, 68);
		grade4Icon_label.setIcon(new ImageIcon(grade4));
		grade4_panel.add(grade4Icon_label);
		
		//--JLabel grade4Population_label = new JLabel("")--//
		grade4Population_label = new JLabel("");
		grade4Population_label.setHorizontalAlignment(SwingConstants.CENTER);
		grade4Population_label.setFont(new Font("Times New Roman", Font.BOLD, 32));
		grade4Population_label.setBounds(0, 1, 293, 67);
		grade4_panel.add(grade4Population_label);
		
		JPanel grade5_panel = new JPanel();
		grade5_panel.setBounds(10, 370, 293, 99);
		grade5_panel.setBackground(new Color(0, 150, 136));
		Dashboard_panel.add(grade5_panel);
		grade5_panel.setLayout(null);
		
		JPanel subGrade5_panel = new JPanel();
		subGrade5_panel.setBackground(Color.GRAY);
		subGrade5_panel.setBounds(0, 68, 293, 31);
		grade5_panel.add(subGrade5_panel);
		subGrade5_panel.setLayout(null);
		
		JLabel grade5_label = new JLabel("GRADE 5");
		grade5_label.setHorizontalAlignment(SwingConstants.CENTER);
		grade5_label.setForeground(Color.WHITE);
		grade5_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		grade5_label.setBounds(0, 0, 293, 31);
		subGrade5_panel.add(grade5_label);
		
		JLabel grade5Icon_label = new JLabel("");
		grade5Icon_label.setHorizontalAlignment(SwingConstants.CENTER);
		grade5Icon_label.setBounds(0, 0, 77, 68);
		grade5Icon_label.setIcon(new ImageIcon(grade5));
		grade5_panel.add(grade5Icon_label);
		
		//--JLabel grade5Population_label = new JLabel("")--//
		grade5Population_label = new JLabel("");
		grade5Population_label.setHorizontalAlignment(SwingConstants.CENTER);
		grade5Population_label.setFont(new Font("Times New Roman", Font.BOLD, 32));
		grade5Population_label.setBounds(0, 0, 293, 67);
		grade5_panel.add(grade5Population_label);
		
		JPanel grade6_panel = new JPanel();
		grade6_panel.setBounds(335, 370, 293, 99);
		grade6_panel.setBackground(new Color(0, 150, 136));
		Dashboard_panel.add(grade6_panel);
		grade6_panel.setLayout(null);
		
		JPanel subGrade6_panel = new JPanel();
		subGrade6_panel.setBackground(Color.GRAY);
		subGrade6_panel.setBounds(0, 68, 293, 31);
		grade6_panel.add(subGrade6_panel);
		subGrade6_panel.setLayout(null);
		
		JLabel grade6_label = new JLabel("GRADE 6");
		grade6_label.setHorizontalAlignment(SwingConstants.CENTER);
		grade6_label.setForeground(Color.WHITE);
		grade6_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		grade6_label.setBounds(0, 0, 293, 31);
		subGrade6_panel.add(grade6_label);
		
		JLabel grade6Icon_panel = new JLabel("");
		grade6Icon_panel.setHorizontalAlignment(SwingConstants.CENTER);
		grade6Icon_panel.setBounds(0, 0, 77, 68);
		grade6Icon_panel.setIcon(new ImageIcon(grade6));
		grade6_panel.add(grade6Icon_panel);
		
		//--JLabel grade6Population_label = new JLabel("")--//
		grade6Population_label = new JLabel("");
		grade6Population_label.setHorizontalAlignment(SwingConstants.CENTER);
		grade6Population_label.setFont(new Font("Times New Roman", Font.BOLD, 32));
		grade6Population_label.setBounds(0, 1, 293, 67);
		grade6_panel.add(grade6Population_label);
		
		//--JPanel student_panel = new JPanel()--//
		student_panel = new JPanel();
		card_panel.add(student_panel, "name_517772670656600");
		student_panel.setLayout(null);
		
		//--JComboBox id_comboBox = new JComboBox()--//
		
		id_comboBox.setBackground(Color.WHITE);
		id_comboBox.setFont(new Font("Times New Roman", Font.BOLD, 16));
		id_comboBox.setBounds(115, 181, 185, 30);
		student_panel.add(id_comboBox);
		
		firstname_textfield = new JTextField();
		firstname_textfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				firstname_textfield.setText("");
			}
		});
		firstname_textfield.setFont(new Font("Arial Black", Font.PLAIN, 12));
		firstname_textfield.setColumns(10);
		firstname_textfield.setBounds(9, 24, 186, 30);
		student_panel.add(firstname_textfield);
		
		JLabel firstName_label = new JLabel("Firstname");
		firstName_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		firstName_label.setBounds(9, 10, 93, 14);
		student_panel.add(firstName_label);
		
		JLabel lastname_label = new JLabel("Lastname");
		lastname_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		lastname_label.setBounds(10, 64, 93, 14);
		student_panel.add(lastname_label);
		
		lastname_textfield = new JTextField();
		lastname_textfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lastname_textfield.setText("");
			}
		});
		lastname_textfield.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lastname_textfield.setColumns(10);
		lastname_textfield.setBounds(9, 79, 186, 30);
		student_panel.add(lastname_textfield);
		
		String gender[] = {"Gender","Male","Female"};
		//--JComboBox gender_comboBox = new JComboBox(gender)--//
		gender_comboBox = new JComboBox(gender);
		gender_comboBox.setFont(new Font("Times New Roman", Font.BOLD, 13));
		gender_comboBox.setBounds(532, 79, 78, 30);
		student_panel.add(gender_comboBox);
		
		JLabel gender_label = new JLabel("Gender");
		gender_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		gender_label.setBounds(539, 64, 93, 14);
		student_panel.add(gender_label);
		
		String gradeLevel[] = {"Grade Level","Grade 1","Grade 2","Grade 3","Grade 4","Grade 5","Grade 6"};
		//--JComboBox gradeLevel_comboBox = new JComboBox(gradeLevel)--//
		gradeLevel_comboBox = new JComboBox(gradeLevel);
		gradeLevel_comboBox.setFont(new Font("Times New Roman", Font.BOLD, 13));
		gradeLevel_comboBox.setBounds(416, 79, 96, 30);
		student_panel.add(gradeLevel_comboBox);
		
		JLabel gradeLevel_label = new JLabel("Grade Level");
		gradeLevel_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		gradeLevel_label.setBounds(415, 64, 93, 14);
		student_panel.add(gradeLevel_label);
		
		username_textfield = new JTextField();
		username_textfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				username_textfield.setText("");
			}
		});
		username_textfield.setFont(new Font("Arial Black", Font.PLAIN, 12));
		username_textfield.setColumns(10);
		username_textfield.setBounds(210, 24, 186, 30);
		student_panel.add(username_textfield);
		
		JLabel username_label = new JLabel("Username");
		username_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		username_label.setBounds(217, 10, 93, 14);
		student_panel.add(username_label);
		
		password_textfield = new JTextField();
		password_textfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				password_textfield.setText("");
			}
		});
		password_textfield.setFont(new Font("Arial Black", Font.PLAIN, 12));
		password_textfield.setColumns(10);
		password_textfield.setBounds(210, 79, 186, 30);
		student_panel.add(password_textfield);
		
		JLabel password_label = new JLabel("Password");
		password_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		password_label.setBounds(211, 64, 93, 14);
		student_panel.add(password_label);
		
		age_textfield = new JTextField();
		age_textfield.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				age_textfield.setText("");
			}
		});
		age_textfield.setFont(new Font("Arial Black", Font.PLAIN, 12));
		age_textfield.setColumns(10);
		age_textfield.setBounds(410, 24, 200, 30);
		student_panel.add(age_textfield);
		
		JLabel age_label = new JLabel("Age");
		age_label.setFont(new Font("Times New Roman", Font.BOLD, 16));
		age_label.setBounds(411, 10, 93, 14);
		student_panel.add(age_label);
		
		JButton display_button = new JButton("SEARCH");
		display_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				try {
					String id = id_comboBox.getSelectedItem().toString();
					pst = con.prepareStatement("SELECT * FROM `student info` WHERE id = ?");
					pst.setString(1, id);
					rs = pst.executeQuery();

					if(rs.next() == true){
						firstname_textfield.setText(rs.getString(2));
						lastname_textfield.setText(rs.getString(3));
						gender_comboBox.setSelectedItem(rs.getString(4));
						age_textfield.setText(rs.getString(5));
						gradeLevel_comboBox.setSelectedItem(rs.getString(6));
						username_textfield.setText(rs.getString(7));
						password_textfield.setText(rs.getString(8));
						
						//-- METHOD FOR RESPONSIVE TABLE
						responsiveTable();
						
					}else {
						JOptionPane.showMessageDialog(null, "No Record Found!!");
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		display_button.setFont(new Font("Times New Roman", Font.BOLD, 10));
		display_button.setBounds(327, 178, 185, 33);
		student_panel.add(display_button);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 218, 622, 262);
		student_panel.add(scrollPane);
		
		content_table = new JTable();
		scrollPane.setViewportView(content_table);
		content_table.setModel(new DefaultTableModel(
			new Object[][] {
				
			},
			new String[] {"id", "firstname", "lastname", "gender", "age", "yearlevel", "username", "password", "Date Enroll"}
		));
		content_table.getColumnModel().getColumn(0).setPreferredWidth(45);
		content_table.getColumnModel().getColumn(4).setPreferredWidth(34);
		
		JPanel update_panel = new JPanel();
		update_panel.setBackground(Color.WHITE);
		update_panel.setBounds(8, 127, 186, 39);
		student_panel.add(update_panel);
		update_panel.setLayout(null);
		
		JLabel update_label = new JLabel("Update");
		update_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				update_panel.setBackground(Color.CYAN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				update_panel.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//--UPDATING VALUE OF DATABASE
				try {
					String firstname = firstname_textfield.getText();
					String lastname = lastname_textfield.getText();
					String gender = gender_comboBox.getSelectedItem().toString();
					String age = age_textfield.getText();
					String yearlevel = gradeLevel_comboBox.getSelectedItem().toString();
					String username = username_textfield.getText();
					String password = password_textfield.getText();
					String id = id_comboBox.getSelectedItem().toString();				
					pst = con.prepareStatement("UPDATE `student info` SET `firstname` = ?,`lastname` = ?,`gender` = ?,`age` = ?,`yearlevel` = ?,`username` = ?,`password` = ? WHERE id = ?");

					pst.setString(1, firstname);
					pst.setString(2, lastname);
					pst.setString(3, gender);
					pst.setString(4, age);
					pst.setString(5, yearlevel);
					pst.setString(6, username);
					pst.setString(7, password);
					pst.setString(8, id);

					int k = pst.executeUpdate();
					
					if(k == 1){
						JOptionPane.showMessageDialog(null, "Record has been successfully updated!!");
						firstname_textfield.setText("");
						lastname_textfield.setText("");
						gender_comboBox.setSelectedItem("Gender");
						age_textfield.setText("");
						gradeLevel_comboBox.setSelectedItem("Grade Level");
						username_textfield.setText("");
						password_textfield.setText("");
						//REQUEST FOCUS after the user update his info, the typeClick will automatically appear on the Textf_productName.
						firstname_textfield.requestFocus();
						LoadProductNo();
					
						//-- METHOD FOR RESPONSIVE TABLE
						responsiveTable();
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		update_label.setHorizontalAlignment(SwingConstants.LEFT);
		update_label.setFont(new Font("Times New Roman", Font.BOLD, 26));
		update_label.setBounds(1, 0, 186, 37);
		update_panel.add(update_label);
		
		JLabel updateIcon_label = new JLabel("");
		updateIcon_label.setHorizontalAlignment(SwingConstants.CENTER);
		updateIcon_label.setBounds(127, 0, 59, 39);
		updateIcon_label.setIcon(new ImageIcon(updateLogo));
		update_panel.add(updateIcon_label);
		
		JPanel delete_panel = new JPanel();
		delete_panel.setBackground(Color.WHITE);
		delete_panel.setBounds(210, 127, 194, 39);
		student_panel.add(delete_panel);
		delete_panel.setLayout(null);
		
		JLabel delete_label = new JLabel("Delete");
		delete_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				delete_panel.setBackground(Color.RED);
				delete_label.setForeground(Color.WHITE);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				delete_panel.setBackground(Color.WHITE);
				delete_label.setForeground(Color.BLACK);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//--DELETING A DATA IN THE DATABASE
				try {

					String id = id_comboBox.getSelectedItem().toString();
					pst = con.prepareStatement("DELETE FROM `student info` WHERE id = ?");
					pst.setString(1, id);

					int k = pst.executeUpdate();

					if(k == 1){
						JOptionPane.showMessageDialog(null, "Record has been successfully deleted!!");
						firstname_textfield.setText("");
						lastname_textfield.setText("");
						gender_comboBox.setSelectedItem("Gender");
						age_textfield.setText("");
						gradeLevel_comboBox.setSelectedItem("Grade Level");
						username_textfield.setText("");
						password_textfield.setText("");
						//REQUEST FOCUS after the user update his info, the typeClick will automatically appear on the Textf_productName.
						firstname_textfield.requestFocus();
						LoadProductNo();
						
						//-- METHOD FOR RESPONSIVE TABLE
						responsiveTable();

					}else {
						JOptionPane.showMessageDialog(null, "Record failed to delete!!");
					}

				} catch (SQLException e1) {
					e1.printStackTrace();
				}
				
				
				
				
			}
		});
		delete_label.setHorizontalAlignment(SwingConstants.LEFT);
		delete_label.setFont(new Font("Times New Roman", Font.BOLD, 26));
		delete_label.setBounds(0, 0, 194, 39);
		delete_panel.add(delete_label);
		
		JLabel deleteIcon_label = new JLabel("");
		deleteIcon_label.setBounds(127, 0, 67, 39);
		deleteIcon_label.setIcon(new ImageIcon(deleteLogo));
		delete_panel.add(deleteIcon_label);
		
		JPanel csv_panel = new JPanel();
		csv_panel.setLayout(null);
		csv_panel.setBackground(Color.WHITE);
		csv_panel.setBounds(418, 127, 194, 39);
		student_panel.add(csv_panel);
		
		JLabel csv_label = new JLabel("Export CSV");
		csv_label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				csv_panel.setBackground(Color.GREEN);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				csv_panel.setBackground(Color.WHITE);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				
				//--EXPORT THE DATA OF OUR DATABASE INTO CSV FILE TYPE
				try {
					
					String filename = "D:\\\\ExportedFileJava.csv";
					
					FileWriter write = new FileWriter(filename);
					pst = con.prepareStatement("SELECT * FROM `student info`");
					rs = pst.executeQuery();
					
					while(rs.next()) {
						write.append(rs.getString(1));
						write.append(",");
						write.append(rs.getString(2));
						write.append(",");
						write.append(rs.getString(3));
						write.append(",");
						write.append(rs.getString(4));
						write.append(",");
						write.append(rs.getString(5));
						write.append(",");
						write.append(rs.getString(6));
						write.append(",");
						write.append(rs.getString(7));
						write.append(",");
						write.append(rs.getString(8));
						write.append(",");
						write.append(rs.getString(9));
						write.append(",");
						write.append(rs.getString(10));
						write.append("\n");
					}
					JOptionPane.showMessageDialog(null, "CSV file exported successfully!!");
					write.flush();
					write.close();
					
					//-- METHOD FOR RESPONSIVE TABLE
					responsiveTable();
					
				} catch (IOException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}				
				
			}
		});
		csv_label.setHorizontalAlignment(SwingConstants.LEFT);
		csv_label.setFont(new Font("Times New Roman", Font.BOLD, 24));
		csv_label.setBounds(0, -1, 194, 39);
		csv_panel.add(csv_label);
		
		JLabel csvIcon_label = new JLabel("");
		csvIcon_label.setBounds(127, 0, 67, 39);
		csvIcon_label.setIcon(new ImageIcon(csvLogo));
		csv_panel.add(csvIcon_label);
		
		setLocationRelativeTo(null);
	}
}
