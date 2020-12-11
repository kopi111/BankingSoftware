package comBankingApp.AOOPProject;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.lang.ProcessHandle.Info;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.TimeZone;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class updateDashBoard {

	private JFrame frmDashboardadmin;
	private JPanel pnlBackground_1;
	private JLabel lblUser;
	private JLabel lblPosition;
	private JLabel lblProfileIcon;
	private JLabel lblMessageIcon;
	private JPanel panel_1;
	private JLabel lblHomeIcon;
	private JLabel lblNewLabel_4;
	private JTextField txtAccountNummber;
	private JLabel lblFirstNamme;
	private JLabel lblLastName;
	private JLabel lblAge;
	private JLabel lblEmail;
	private JLabel lblTelephone;
	private JLabel lblDateOfBirth;
	private JLabel lblStreetName;
	private JLabel lblCommunity;
	private JLabel lblParish;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtAge;
	private JTextField txtEmail;
	private JTextField txtDob;
	private JTextField txtTelephone;
	private JTextField txtStreetName;
	private JTextField txtCommunity;
	private JTextField txtParish;
	DefaultTableModel model;
	private JTable table2;
	private JScrollPane scrollPane;
	private JButton txtRest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					updateDashBoard window = new updateDashBoard();
					window.frmDashboardadmin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public updateDashBoard() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDashboardadmin = new JFrame();
		frmDashboardadmin.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				SimpleDateFormat dateTimeInGMT = new SimpleDateFormat("MMM dd, yyyy hh:mm a");
				dateTimeInGMT.setTimeZone(TimeZone.getTimeZone("EST"));
				
				
			//	lblCurentDateTime.setText(dateTimeInGMT.format(new Date()));
			}
		});
		frmDashboardadmin.setTitle("Administrator's Dashboard");
		frmDashboardadmin.setUndecorated(true);
		frmDashboardadmin.setBounds(100, 100, 1200, 850);
		frmDashboardadmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDashboardadmin.setBackground(new Color(0,0,0,0));
		frmDashboardadmin.getContentPane().setLayout(null);
		frmDashboardadmin.setLocationRelativeTo(null);
		
		Image accountIcon= new ImageIcon(this.getClass().getResource("/Account Icon 2.png")).getImage();
		Image mailIcon = new ImageIcon(this.getClass().getResource("/Notification Icon 2.png")).getImage();
		Image exitIcon = new ImageIcon(this.getClass().getResource("/Exit Icon.png")).getImage();
		Image welcomeIcon = new ImageIcon(this.getClass().getResource("/Personal Icon 5.png")).getImage();
		Image failedTransIcon= new ImageIcon(this.getClass().getResource("/report.png")).getImage();
		Image succTransIcon= new ImageIcon(this.getClass().getResource("/check.png")).getImage();
		Image logo = new ImageIcon(this.getClass().getResource("/outkastlogo1.png")).getImage();
		Image homeicon = new ImageIcon(this.getClass().getResource("/Home Icon.png")).getImage();
		Image logouticon = new ImageIcon(this.getClass().getResource("/Logout Icon.png")).getImage();
		Image settingsicon = new ImageIcon(this.getClass().getResource("/Settins Icon.png")).getImage();
		Image userIcon = new ImageIcon(this.getClass().getResource("/group.png")).getImage();
		Image messageAdminIcon = new ImageIcon(this.getClass().getResource("/Message Icon (2).png")).getImage();
		
		
		JPanel pnlTotalUsers = new JPanel();
		
		JPanel pnlActiveUsers = new JPanel();
		
		JPanel pnlTotalTasks = new JPanel();
		
		JPanel pnlBackground = new JPanel();
		pnlBackground_1 = new RoundedCorners(20);
		pnlBackground_1.setBounds(10, -3, 1180, 828);
		frmDashboardadmin.getContentPane().add(pnlBackground_1);
		pnlBackground_1.setLayout(null);
		Image AllUsersIcon= new ImageIcon(this.getClass().getResource("/group.png")).getImage();
		Image todayusers= new ImageIcon(this.getClass().getResource("/paper-note.png")).getImage();
		Image activeusersIcon= new ImageIcon(this.getClass().getResource("/online-learning.png")).getImage();
		Image allusersIcon= new ImageIcon(this.getClass().getResource("/group.png")).getImage();
		Image messageIcon= new ImageIcon(this.getClass().getResource("/chat (1).png")).getImage();
		
		
		JPanel pnlWelcome = new JPanel();
		
		lblUser = new JLabel("Username");
		lblUser.setFont(new Font("Rockwell Condensed", Font.PLAIN, 18));
		lblUser.setBounds(1003, 11, 78, 14);
		pnlBackground_1.add(lblUser);
		
		lblPosition = new JLabel("Position");
		lblPosition.setFont(new Font("Rockwell Condensed", Font.PLAIN, 18));
		lblPosition.setBounds(1003, 28, 78, 14);
		pnlBackground_1.add(lblPosition);
		
		lblProfileIcon = new JLabel("");
		lblProfileIcon.setIcon(new ImageIcon(accountIcon));
		lblProfileIcon.setBounds(962, 0, 42, 53);
		pnlBackground_1.add(lblProfileIcon);
		
		lblMessageIcon = new JLabel("");
		lblMessageIcon.setIcon(new ImageIcon(mailIcon));
		lblMessageIcon.setBounds(915, 11, 29, 31);
		pnlBackground_1.add(lblMessageIcon);
		
		JButton btnMinimize = new JButton("----");
		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frmDashboardadmin.setState(JFrame.ICONIFIED);
			}
		});
		btnMinimize.setOpaque(false);
		btnMinimize.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMinimize.setContentAreaFilled(false);
		btnMinimize.setBorderPainted(false);
		btnMinimize.setBounds(1123, 5, 48, 23);
		pnlBackground_1.add(btnMinimize);
		
		panel_1 = new JPanel();
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(293, 32, 449, 142);
		pnlBackground_1.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(logo));
		
		txtAccountNummber = new JTextField();
		txtAccountNummber.setBounds(915, 135, 163, 39);
		pnlBackground_1.add(txtAccountNummber);
		txtAccountNummber.setColumns(10);
		
		JLabel lblAccountNumber = new JLabel("Enter Account Number");
		lblAccountNumber.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		lblAccountNumber.setBounds(915, 90, 169, 34);
		pnlBackground_1.add(lblAccountNumber);
		
		lblFirstNamme = new JLabel("First Name");
		lblFirstNamme.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		lblFirstNamme.setBounds(177, 197, 169, 34);
		pnlBackground_1.add(lblFirstNamme);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		lblLastName.setBounds(389, 197, 169, 34);
		pnlBackground_1.add(lblLastName);
		
		lblAge = new JLabel("Age");
		lblAge.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		lblAge.setBounds(568, 197, 169, 34);
		pnlBackground_1.add(lblAge);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		lblEmail.setBounds(745, 197, 169, 34);
		pnlBackground_1.add(lblEmail);
		
		lblTelephone = new JLabel(" Telephone");
		lblTelephone.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		lblTelephone.setBounds(201, 299, 169, 34);
		pnlBackground_1.add(lblTelephone);
		
		lblDateOfBirth = new JLabel(" Date Of Birth");
		lblDateOfBirth.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		lblDateOfBirth.setBounds(970, 197, 169, 34);
		pnlBackground_1.add(lblDateOfBirth);
		
		lblStreetName = new JLabel("Street Name");
		lblStreetName.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		lblStreetName.setBounds(463, 299, 169, 34);
		pnlBackground_1.add(lblStreetName);
		
		lblCommunity = new JLabel("Community");
		lblCommunity.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		lblCommunity.setBounds(727, 299, 169, 34);
		pnlBackground_1.add(lblCommunity);
		
		lblParish = new JLabel("Parish");
		lblParish.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		lblParish.setBounds(1032, 299, 169, 34);
		pnlBackground_1.add(lblParish);
		
		txtFirstName = new JTextField();
		txtFirstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char C= evt.getKeyChar();
				
				if(!Character.isLetter(C)||C==KeyEvent.VK_SPACE||C==KeyEvent.VK_DELETE) {
					evt.consume();
				}
			}
			
		});
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(143, 242, 163, 39);
		pnlBackground_1.add(txtFirstName);
		
		txtLastName = new JTextField();
		txtLastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char C= evt.getKeyChar();
				
				if(!Character.isLetter(C)||C==KeyEvent.VK_SPACE||C==KeyEvent.VK_DELETE) {
					evt.consume();
				}
			}
			
		});
		txtLastName.setColumns(10);
		txtLastName.setBounds(344, 242, 163, 39);
		pnlBackground_1.add(txtLastName);
		
		txtAge = new JTextField();
		txtAge.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char C= evt.getKeyChar();
				
				if(!Character.isDigit(C)||C==KeyEvent.VK_SPACE||C==KeyEvent.VK_DELETE) {
					evt.consume();
				}
			}
			
		});
		txtAge.setColumns(10);
		txtAge.setBounds(553, 242, 68, 39);
		pnlBackground_1.add(txtAge);
		
		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char C= evt.getKeyChar();
				
				if(C==KeyEvent.VK_SPACE||C==KeyEvent.VK_DELETE) {
					evt.consume();
				}
			}
		});
		txtEmail.setColumns(10);
		txtEmail.setBounds(671, 242, 214, 39);
		pnlBackground_1.add(txtEmail);
		
		txtDob = new JTextField();
		txtDob.setColumns(10);
		txtDob.setBounds(941, 242, 163, 39);
		pnlBackground_1.add(txtDob);
		
		txtTelephone = new JTextField();
		txtTelephone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char C= evt.getKeyChar();
				
				if(!Character.isDigit(C)||C==KeyEvent.VK_SPACE||C==KeyEvent.VK_DELETE) {
					evt.consume();
				}
			}
		});
		txtTelephone.setColumns(10);
		txtTelephone.setBounds(126, 344, 214, 39);
		pnlBackground_1.add(txtTelephone);
		
		txtStreetName = new JTextField();
		txtStreetName.setColumns(10);
		txtStreetName.setBounds(407, 344, 214, 39);
		pnlBackground_1.add(txtStreetName);
		
		txtCommunity = new JTextField();
		txtCommunity.setColumns(10);
		txtCommunity.setBounds(671, 344, 214, 39);
		pnlBackground_1.add(txtCommunity);
		
		txtParish = new JTextField();
		txtParish.setColumns(10);
		txtParish.setBounds(945, 344, 214, 39);
		pnlBackground_1.add(txtParish);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				int accountNumber;
			    accountNumber=  (Integer.parseInt(txtAccountNummber.getText())); 
			    customerMethods customerMet = new customerMethods();
			    customerInformation customer1 = new customerInformation();
			    customerInformation customer = new customerInformation();
			    customer1 = customerMet.generateCustomerInfo(accountNumber);
			    
			DefaultTableModel model = (DefaultTableModel)table2.getModel();
			Object[] row = new Object[9];
			
			System.out.println("btton");
				
				row[0]= customer1.getFirstName();
				row[1]= customer1.getLastName();
				row[2]= customer1.getAge();
				row[3]= customer1.getEmail();
				row[4]= customer1.getDob();
				
				row[5]= customer1.getTelephone();
				row[6]= customer1.getAddress().getstreetName();
				row[7]= customer1.getAddress().getCommunity();
				row[8]= customer1.getAddress().getParish();
				txtEmail.setText(customer1.getEmail());
				txtDob.setText(customer1.getDob());
				txtFirstName.setText(customer1.getFirstName()); 
				txtLastName.setText(customer1.getLastName()); 	
				String age = Integer.toString(customer1.getAge());
				txtAge.setText(age); 
				String tele = Integer.toString(customer1.getTelephone());
				txtTelephone.setText(tele); 
				txtStreetName.setText(customer1.getAddress().getstreetName()); 
				txtCommunity.setText(customer1.getAddress().getCommunity()); 
				txtParish.setText(customer1.getAddress().getParish()); 
				
			model.addRow(row);
			}
		});
		btnSearch.setBounds(1088, 128, 65, 53);
		pnlBackground_1.add(btnSearch);
		
		JLabel lblMessage = new JLabel("");
		lblMessage.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblMessage.setBounds(389, 11, 462, 39);
		pnlBackground_1.add(lblMessage);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				ApplicationContext beanFactory = new ClassPathXmlApplicationContext("SpringFrameWork.xml");
		    	 customerMethods methods= (customerMethods)  beanFactory.getBean("cm");
		    	 customerInformation info =(customerInformation) beanFactory.getBean("ci");
		    	 customerAddress address=(customerAddress) beanFactory.getBean("ca");
		    	 BasicConfigurator.configure();
				
		    	info.setAccountNumber(Integer.parseInt(txtAccountNummber.getText()));
				info.setFirstName(txtFirstName.getText());
			
				info.setLastName(txtLastName.getText());
				
				info.setAge(Integer.parseInt(txtAge.getText()));
			
				info.setEmail(txtEmail.getText());
				info.setTelephone(Integer.parseInt(txtTelephone.getText()));
				info.setDob(txtDob.getText());
				address.setCommunity(txtCommunity.getText());
				address.setParish(txtParish.getText());
				address.setstreetName(txtStreetName.getText());
				address.setCommunity(txtCommunity.getText());
				
				info.setAddress(address);
				boolean test = methods.updateCustomerInfo2(info);
				if (test == true) {
					int input = JOptionPane.showConfirmDialog(null, 
			                   "Update Successfull!!!", "", JOptionPane.DEFAULT_OPTION);
			           	
				}
				
				else  {
					
					int input = JOptionPane.showConfirmDialog(null, 
			                   "Update Failed!!!","", JOptionPane.DEFAULT_OPTION);
			           		
				}
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnUpdate.setBounds(522, 397, 110, 39);
		pnlBackground_1.add(btnUpdate);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(126, 463, 1044, 231);
		pnlBackground_1.add(scrollPane);
		
		table2 = new JTable();
		table2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		scrollPane.setViewportView(table2);
		
		
		table2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"First Name", "Last Name", "Age", "Email", "Date of Birth", "Telephone", "Street Naame", "Community", "Parish"
			}
		));
		
		JPanel panel = new JPanel();
		panel.setBounds(4, 0, 112, 803);
		pnlBackground_1.add(panel);
		panel.setBackground(new Color(65, 105, 225));
		panel.setLayout(null);
		
		lblHomeIcon = new JLabel("");
		lblHomeIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				DashboardAdmin da= new DashboardAdmin();
			
				da.setVisible(true);
				frmDashboardadmin.dispose();
			}
		});
		lblHomeIcon.setBounds(34, 46, 24, 25);
		panel.add(lblHomeIcon);
		lblHomeIcon.setIcon(new ImageIcon(homeicon));
		
		JButton btnNewButton = new JButton("HOME");
		btnNewButton.setForeground(Color.magenta);
		btnNewButton.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setAlignmentY(0.0f);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBounds(10, 79, 112, 23);
		panel.add(btnNewButton);
		
		txtRest = new JButton("Reset");
		txtRest.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				customerMethods  cm = new customerMethods ();
				int accountNumber = Integer.parseInt(txtAccountNummber.getText());
				
				int num = cm.resetCustomer(accountNumber);
				if (num == 0) {
					int input = JOptionPane.showConfirmDialog(null, 
			                   "Reset Successfull!!!", "", JOptionPane.DEFAULT_OPTION);
				}
				else {
					int input = JOptionPane.showConfirmDialog(null, 
			                   "Reset Failed!!!", "", JOptionPane.DEFAULT_OPTION);
				}
			}
		});
		txtRest.setBounds(574, 741, 148, 39);
		pnlBackground_1.add(txtRest);
		
		model= new DefaultTableModel();
		Object[] colum= {"First Name","Last Name", "Age","Date of Birth", "Email", "Telephone","street Name","Parish","Community"};
		Object[]  row = new Object[0];
		model.setColumnIdentifiers(colum);
		
		

		
		
		
		
		
		
		
		
	}

	public void setVisible(boolean b) {
		frmDashboardadmin.setVisible(true);
		
	}
}
