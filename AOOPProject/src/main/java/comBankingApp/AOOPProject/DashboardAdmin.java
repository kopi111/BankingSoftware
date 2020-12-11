package comBankingApp.AOOPProject;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFormattedTextField;
import java.awt.SystemColor;
import javax.swing.JScrollPane;

public class DashboardAdmin {

	private JFrame frmDashboardadmin;
	private JPanel pnlBackground_1;
	private JPanel pnlTotalUsers_1;
	private JPanel pnlActiveUsers_1;
	private JPanel pnlTotalTasks_1;
	private JLabel lblPosition;
	private JLabel lblProfileIcon;
	private JLabel lblMessageIcon;
	private JLabel lblWelcomeIcon;
	private JLabel lblTransactions;
	private JPanel panel_1;
	private JTable tblRecentTransactions;
	private JLabel lblNewLabel_1;
	private JPanel pnlWelcome_1;
	private JLabel lblActiveUsers;
	private JLabel lblTodaysUsers;
	private JLabel lblMessages;
	private JLabel lblAllUsers;
	private JLabel lblHomeIcon;
	private JLabel lblLogOutIcon;
	private JLabel lblSettingsIcon;
	private JLabel lblAdminMessages;
	private JButton btnAccounts;
	private JButton btnNewButton_2;
	private JButton btnNewButton_4;
	private JLabel lblNewLabel_4;
	private JTextField txtAccountNumber;
	private JTextField txtWithdraw;
	private JTextField txtDeposite;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardAdmin window = new DashboardAdmin();
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
	public DashboardAdmin() {
		initialize();
		
	}
	
	workerClass adminWorker = new workerClass();
	public DashboardAdmin(workerClass workclass) {
		initialize();
	
		adminWorker= workclass;
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	JLabel lblUsername = new JLabel();
	JLabel lblId = new JLabel();
	private JTextField textDeleteAccountNumber;
	private JTextField txtAccount;
	private JButton btnSearch;
	private JScrollPane scrollPane;
	
	private void initialize() {
		frmDashboardadmin = new JFrame();
		frmDashboardadmin.addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent e) {
				SimpleDateFormat dateTimeInGMT = new SimpleDateFormat("MMM dd, yyyy hh:mm a");
				lblUsername.setText(adminWorker.getLastName());
				
				
			int convert = (int) adminWorker.getWorkerIdNumbere(); 	
			String str1 = Integer.toString(convert);		 				
			lblId.setText(str1);
			
			
			
				dateTimeInGMT.setTimeZone(TimeZone.getTimeZone("EST"));
				
			//	lblCurentDateTime.setText(dateTimeInGMT.format(new Date()));
			}
		});
		JPanel panTrans = new JPanel();
		panTrans.setVisible(false);
		JPanel searchPannel = new JPanel();
		searchPannel.setVisible(false);
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
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(65, 105, 225));
		panel.setBounds(10, 22, 112, 803);
		frmDashboardadmin.getContentPane().add(panel);
		panel.setLayout(null);
		
		lblHomeIcon = new JLabel("");
		lblHomeIcon.setBounds(19, 55, 24, 25);
		panel.add(lblHomeIcon);
		Image homeicon = new ImageIcon(this.getClass().getResource("/Home Icon.png")).getImage();
		lblHomeIcon.setIcon(new ImageIcon(homeicon));
		
		lblLogOutIcon = new JLabel("");
		lblLogOutIcon.setBounds(46, 343, 24, 31);
		panel.add(lblLogOutIcon);
		Image logouticon = new ImageIcon(this.getClass().getResource("/Logout Icon.png")).getImage();
		lblLogOutIcon.setIcon(new ImageIcon( logouticon ));
		Image settingsicon = new ImageIcon(this.getClass().getResource("/Settins Icon.png")).getImage();
		
		JLabel lblUserIcon = new JLabel("");
		lblUserIcon.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
		
				
				
				
			}
		});
		lblUserIcon.setBounds(19, 147, 24, 31);
		panel.add(lblUserIcon);
		Image userIcon = new ImageIcon(this.getClass().getResource("/group.png")).getImage();
		lblUserIcon.setIcon(new ImageIcon( userIcon ));
		
		lblAdminMessages = new JLabel("");
		lblAdminMessages.setBounds(19, 245, 24, 31);
		panel.add(lblAdminMessages);
		Image messageAdminIcon = new ImageIcon(this.getClass().getResource("/Message Icon (2).png")).getImage();
		lblAdminMessages.setIcon(new ImageIcon( messageAdminIcon ));
		
		JButton btnNewButton = new JButton("HOME");
		btnNewButton.setForeground(Color.magenta);
		btnNewButton.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setAlignmentY(0.0f);
		btnNewButton.setOpaque(false);
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton.setBounds(0, 82, 112, 23);
		panel.add(btnNewButton);
		
		btnAccounts = new JButton("USERS");
		btnAccounts.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnAccounts.setForeground(Color.magenta);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnAccounts.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				FrmWorker worker = new FrmWorker();
				worker.setVisible(true);
			}
		});
		btnAccounts.setOpaque(false);
		btnAccounts.setHorizontalAlignment(SwingConstants.LEFT);
		btnAccounts.setForeground(Color.WHITE);
		btnAccounts.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		btnAccounts.setContentAreaFilled(false);
		btnAccounts.setBorderPainted(false);
		btnAccounts.setAlignmentY(0.0f);
		btnAccounts.setBounds(0, 173, 112, 23);
		panel.add(btnAccounts);
		
		btnNewButton_2 = new JButton("MESSAGES");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_2.setForeground(Color.magenta);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_2.setForeground(Color.white);
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				frmAdminMessages messages = new frmAdminMessages();
				messages.setVisible(true);
			}
		});
		btnNewButton_2.setOpaque(false);
		btnNewButton_2.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		btnNewButton_2.setContentAreaFilled(false);
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setAlignmentY(0.0f);
		btnNewButton_2.setBounds(0, 273, 129, 23);
		panel.add(btnNewButton_2);
		
		btnNewButton_4 = new JButton("SIGN OUT");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_4.setForeground(Color.magenta);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_4.setForeground(Color.white);
			}
		});
		btnNewButton_4.setOpaque(false);
		btnNewButton_4.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		btnNewButton_4.setContentAreaFilled(false);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setAlignmentY(0.0f);
		btnNewButton_4.setBounds(0, 385, 129, 23);
		panel.add(btnNewButton_4);
		
		
		JPanel pnlTotalUsers = new JPanel();
		
		JPanel pnlActiveUsers = new JPanel();
		
		JPanel pnlTotalTasks = new JPanel();
		
		JPanel pnlBackground = new JPanel();
		pnlBackground_1 = new RoundedCorners(20);
		pnlBackground_1.setBounds(10, 11, 1180, 828);
		frmDashboardadmin.getContentPane().add(pnlBackground_1);
		pnlBackground_1.setLayout(null);
		
		lblWelcomeIcon = new JLabel("");
		lblWelcomeIcon.setIcon(new ImageIcon(welcomeIcon));
		lblWelcomeIcon.setBounds(806, 56, 179, 216);
		pnlBackground_1.add(lblWelcomeIcon);
		pnlTotalUsers_1 = new RoundedCorners(40, Color.white);
		pnlTotalUsers_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				createAccount crea = new createAccount();
				crea.setVisiable(true);
			}
		});
		pnlTotalUsers_1.setBounds(158, 334, 220, 96);
		pnlBackground_1.add(pnlTotalUsers_1);
		pnlTotalUsers_1.setBackground(Color.WHITE);
		pnlTotalUsers_1.setLayout(null);
		
		lblAllUsers = new JLabel("Create Account");
		lblAllUsers.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		lblAllUsers.setBounds(43, 28, 130, 45);
		pnlTotalUsers_1.add(lblAllUsers);
		pnlActiveUsers_1 = new RoundedCorners(40, Color.white);
		pnlActiveUsers_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				updateDashBoard  udash= new updateDashBoard();
				udash.setVisible(true);
			}
		});
		Image AllUsersIcon= new ImageIcon(this.getClass().getResource("/group.png")).getImage();
		lblAllUsers.setIcon(new ImageIcon(AllUsersIcon));
	
		pnlActiveUsers_1.setBounds(415, 334, 214, 96);
		pnlBackground_1.add(pnlActiveUsers_1);
		pnlActiveUsers_1.setBackground(Color.WHITE);
		pnlActiveUsers_1.setLayout(null);
		
		lblActiveUsers = new JLabel("Update Account");
		lblActiveUsers.setBounds(34, 26, 146, 45);
		lblActiveUsers.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		pnlActiveUsers_1.add(lblActiveUsers);
		pnlTotalTasks_1 = new RoundedCorners(40, Color.white);
		JButton btnDeposite = new JButton("Deposite");
		JLabel lblDeposite = new JLabel("Deposite");
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.addMouseListener(new MouseAdapter() {
			@Override
			
			
			
			public void mouseClicked(MouseEvent e) {
				int callFunction = 2;
				
				 ApplicationContext beanFactory = new ClassPathXmlApplicationContext("SpringFrameWork.xml");
				 
		    	 BasicConfigurator.configure();				

		    	 accountInformation acc = (accountInformation) beanFactory.getBean("aci");
		    	 accountInformation acc2 = (accountInformation) beanFactory.getBean("aci");
			
				
		    	 
				
				
				 if (txtAccountNumber.getText().isEmpty()){
					 txtAccountNumber.setBackground(Color.red);
			            int input = JOptionPane.showConfirmDialog(null, 
				        "Account NUMBER cant be empty", "", JOptionPane.DEFAULT_OPTION);
			            callFunction=callFunction-1;
			           
			            
			        }
			      
			        
			        if (txtWithdraw.getText().isEmpty()){
			        	
			        	txtWithdraw.setBackground(Color.red);
			        	txtDeposite.setBackground(Color.red);
				           int input = JOptionPane.showConfirmDialog(null, 
				                   "Cant do two transaction at once", "", JOptionPane.DEFAULT_OPTION);
				           		callFunction=callFunction-1;
			        	
			        }
			        
			        customerMethods cmt = new customerMethods();
			        
			        acc.setAccountNumber(Integer.parseInt(txtAccountNumber.getText()));
			        acc.setTran(Integer.parseInt(txtWithdraw.getText()));
			        
			        acc2=cmt.withdram(acc);
			        
			        int message = acc2.getAccountNumber();
			        System.out.println(acc2.getAccountNumber());
			        if(message == 2) {
			        	
			        	 int input = JOptionPane.showConfirmDialog(null, 
				                   "Error in tranactiom", "", JOptionPane.DEFAULT_OPTION);
			        	
			        }
			        
			        else {
			        	 int input = JOptionPane.showConfirmDialog(null, 
				                   "Transaction was Successful ", "", JOptionPane.DEFAULT_OPTION);
			        }
			        
			}
		});
		JLabel lblWithdraw = new JLabel("Withdraw");
		pnlTotalTasks_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				
				panTrans.setVisible(true);
				
	if (txtWithdraw.isVisible()== true) {
					
					txtWithdraw.setVisible(false);
					lblWithdraw.setVisible(false);
					btnWithdraw.setVisible(false);
					txtDeposite.setVisible(true);
					lblDeposite.setVisible(true);
					btnDeposite.setVisible(true);
					//lblTransaction.setText("Withdraw"); 
				}
				else if (txtWithdraw.isVisible()== false) {
					txtWithdraw.setVisible(true);
					lblWithdraw.setVisible(true);
					btnWithdraw.setVisible(true);
					txtDeposite.setVisible(false);
					lblDeposite.setVisible(false);
					btnDeposite.setVisible(false);
				//	lblTransaction.setText("Deposite"); 
					
				}
				
			
			/*	if (panTrans.isVisible()== true) {
					
					
					txtDeposite.setVisible(false);
					btnDeposite.setVisible(false);
					lblDeposite.setVisible(false);
					txtWithdraw.setVisible(true);
					btnWithdraw.setVisible(true);
					lblWithdraw.setVisible(true);
					
					
				}
				  if(panTrans.isVisible()== false) {
					panTrans.setVisible(true);
					txtWithdraw.setVisible(false);
					btnWithdraw.setVisible(false);
					lblWithdraw.setVisible(false);
					txtDeposite.setVisible(true);
					btnDeposite.setVisible(true);
					lblDeposite.setVisible(true);
					
				}
				  if(lblWithdraw.isVisible()==false) {
					  panTrans.setVisible(true);
						txtWithdraw.setVisible(false);
						btnWithdraw.setVisible(false);
						lblWithdraw.setVisible(false);
						txtDeposite.setVisible(true);
						btnDeposite.setVisible(true);
						lblDeposite.setVisible(true);
					  
				  }
				
				*/
					
				
				
				
			}
		});
		pnlTotalTasks_1.setBounds(663, 334, 214, 96);
		pnlBackground_1.add(pnlTotalTasks_1);
		pnlTotalTasks_1.setBackground(Color.WHITE);
		pnlTotalTasks_1.setLayout(null);
		
		lblTodaysUsers = new JLabel("Transaction");
		lblTodaysUsers.setBounds(38, 28, 154, 45);
		lblTodaysUsers.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		pnlTotalTasks_1.add(lblTodaysUsers);
		Image todayusers= new ImageIcon(this.getClass().getResource("/paper-note.png")).getImage();
		lblTodaysUsers.setIcon(new ImageIcon(todayusers));
		Image activeusersIcon= new ImageIcon(this.getClass().getResource("/online-learning.png")).getImage();
		lblActiveUsers.setIcon(new ImageIcon(activeusersIcon));
		Image allusersIcon= new ImageIcon(this.getClass().getResource("/group.png")).getImage();
		
		RoundedCorners pnlTotalTasks_1_1 = new RoundedCorners(40, Color.WHITE);
		pnlTotalTasks_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(searchPannel.isVisible()==true) {
					
					
					searchPannel.setVisible(false);
				
				}
				
					else if(searchPannel.isVisible()==false) {
					
					
					searchPannel.setVisible(true);
				}
					
				
			}
		});
		pnlTotalTasks_1_1.setBounds(912, 334, 214, 96);
		pnlBackground_1.add(pnlTotalTasks_1_1);
		pnlTotalTasks_1_1.setLayout(null);
		
		lblMessages = new JLabel("Search ");
		lblMessages.setBounds(51, 28, 123, 45);
		lblMessages.setFont(new Font("Rockwell Condensed", Font.PLAIN, 19));
		pnlTotalTasks_1_1.add(lblMessages);
		Image messageIcon= new ImageIcon(this.getClass().getResource("/chat (1).png")).getImage();
		lblMessages.setIcon(new ImageIcon(messageIcon));
		
		
		JPanel pnlWelcome = new JPanel();
		pnlWelcome_1 = new RoundedCorners(40, new Color(65, 105, 225));
		pnlWelcome_1.setBounds(158, 120, 968, 141);
		pnlBackground_1.add(pnlWelcome_1);
		pnlWelcome_1.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome,");
		lblWelcome.setBounds(248, 27, 161, 56);
		lblWelcome.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 27));
		pnlWelcome_1.add(lblWelcome);
		
		
		lblUsername.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 25));
		lblUsername.setBounds(419, 32, 179, 48);
		pnlWelcome_1.add(lblUsername);
		
		JLabel lblNewLabel_2 = new JLabel("Check  Notifications");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(272, 94, 267, 62);
		pnlWelcome_1.add(lblNewLabel_2);
		
		lblPosition = new JLabel("Bamk Teller");
		lblPosition.setFont(new Font("Rockwell Condensed", Font.PLAIN, 18));
		lblPosition.setBounds(1016, 11, 78, 25);
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
		
		
		
		lblId.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		lblId.setBounds(158, 280, 89, 31);
		pnlBackground_1.add(lblId);
		
		panel_1 = new JPanel();
		RoundedCorners panel_1 = new RoundedCorners(40, Color.WHITE);
		panel_1.setBounds(508, 591, 618, 226);
		pnlBackground_1.add(panel_1);
		panel_1.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 32, 598, 283);
		panel_1.add(scrollPane);
		
		tblRecentTransactions = new JTable();
		scrollPane.setViewportView(tblRecentTransactions);
		tblRecentTransactions.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblRecentTransactions.setGridColor(new Color(211, 211, 211));
		tblRecentTransactions.setSelectionBackground(new Color(255, 0, 255));
		tblRecentTransactions.setShowVerticalLines(false);
		tblRecentTransactions.setRowMargin(20);
		tblRecentTransactions.setRowHeight(60);
		tblRecentTransactions.setModel(new DefaultTableModel(
			new Object[][] {
				{"Sept 3", "Bank Withdraw", "$500.00"},
			},
			new String[] {
				"Date", "Type", "idk"
			}
		) {
			Class[] columnTypes = new Class[] {
				String.class, String.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		
		tblRecentTransactions.setModel(new DefaultTableModel(
				
				new Object[][] {
					
					
				},
				new String[] {
						 "Withdraw", "Deposite", "Date","Time","Deposite"
					}
				
			
				));
		
		lblNewLabel_1 = new JLabel("Recent Transactions");
		lblNewLabel_1.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
		lblNewLabel_1.setBounds(21, 11, 193, 24);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(116, 0, 234, 79);
		pnlBackground_1.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(logo));
		
		//JPanel panTrans = new JPanel();
		panTrans.setBounds(116, 460, 382, 345);
		pnlBackground_1.add(panTrans);
		panTrans.setLayout(null);
		
		txtAccountNumber = new JTextField();
		txtAccountNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char C = evt.getKeyChar(); //Allows input of only Numbers and periods in the textfield
				
				if(!Character.isDigit(C)||C==KeyEvent.VK_SPACE||C==KeyEvent.VK_DELETE||C==KeyEvent.VK_BACK_SPACE) {
					evt.consume();
					
					
				}
			}
			
				
			
		});
		txtAccountNumber.setBounds(35, 94, 140, 41);
		panTrans.add(txtAccountNumber);
		txtAccountNumber.setColumns(10);
		
		lblTransactions = new JLabel("TRANSACTIONS");
		lblTransactions.setBounds(58, 1, 220, 31);
		panTrans.add(lblTransactions);
		lblTransactions.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		
		txtWithdraw = new JTextField();
		txtWithdraw.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char c = evt.getKeyChar(); //Allows input of only Numbers and periods in the textfield
			    if ((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_PERIOD)) {
			        String s = txtWithdraw.getText();
			        int dot = s.indexOf(".");
			        if(dot != -1 && c == KeyEvent.VK_PERIOD) {
			            evt.consume();
			        } else if(dot != -1 && c != KeyEvent.VK_BACK_SPACE){
			            String afterDecimal = s.substring(dot + 1);
			            if (afterDecimal.length() > 2) {
			                evt.consume();
			            }
			        }
			    }
			}
			
		});
		
		txtWithdraw.setColumns(10);
		txtWithdraw.setBounds(35, 188, 140, 41);
		panTrans.add(txtWithdraw);
		
		txtDeposite = new JTextField();
		txtDeposite.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char c = evt.getKeyChar(); //Allows input of only Numbers and periods in the textfield
			    if ((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_PERIOD)) {
			        String s = txtDeposite.getText();
			        int dot = s.indexOf(".");
			        if(dot != -1 && c == KeyEvent.VK_PERIOD) {
			            evt.consume();
			        } else if(dot != -1 && c != KeyEvent.VK_BACK_SPACE){
			            String afterDecimal = s.substring(dot + 1);
			            if (afterDecimal.length() > 2) {
			                evt.consume();
			            }
			        }
			    }
			}
			
		});
	
		txtDeposite.setColumns(10);
		txtDeposite.setBounds(35, 282, 150, 41);
		panTrans.add(txtDeposite);
		
		JLabel lblAccountNumber = new JLabel("Account Number");
		lblAccountNumber.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		lblAccountNumber.setBounds(10, 60, 220, 31);
		panTrans.add(lblAccountNumber);
		
		
		lblWithdraw.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		lblWithdraw.setBounds(45, 146, 220, 31);
		panTrans.add(lblWithdraw);
		
		
		lblDeposite.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		lblDeposite.setBounds(45, 240, 220, 31);
		panTrans.add(lblDeposite);
		
		
		btnDeposite.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int callFunction =2;
				 ApplicationContext beanFactory = new ClassPathXmlApplicationContext("SpringFrameWork.xml");
				
				 accountInformation acc = (accountInformation) beanFactory.getBean("aci");
				 accountInformation acc2 = (accountInformation) beanFactory.getBean("aci");
		    	 
		    	 BasicConfigurator.configure();	
				
				
				 if (txtAccountNumber.getText().isEmpty()){
					 txtAccountNumber.setBackground(Color.red);
			            int input = JOptionPane.showConfirmDialog(null, 
				        "Account NUMBER cant be empty", "", JOptionPane.DEFAULT_OPTION);
			            callFunction=callFunction-1;
			           
			            
			        }
			      
			        
			        if (txtDeposite.getText().isEmpty()){
			        	
			        	txtWithdraw.setBackground(Color.red);
			        	txtDeposite.setBackground(Color.red);
				           int input = JOptionPane.showConfirmDialog(null, 
				                   "Cant do two transaction at once", "", JOptionPane.DEFAULT_OPTION);
				           		callFunction=callFunction-1;
			        	
			        }
			        System.out.println(txtAccountNumber.getText());
			        
			        System.out.println(txtDeposite.getText());
			        customerMethods cmt = new customerMethods();
			        
			        acc.setAccountNumber(Integer.parseInt(txtAccountNumber.getText()));
			        acc.setTran(Integer.parseInt(txtDeposite.getText()));
			        acc2= null;
			        acc2=cmt.deposite(acc);
			        
			        System.out.println(acc2.getAccountNumber());
			        int message = acc2.getAccountNumber();
			        
			        if(message == 1) {
			        	
			        	 int input = JOptionPane.showConfirmDialog(null, 
				                   "Error in tranactiom", "", JOptionPane.DEFAULT_OPTION);
			        	
			        }
			        
			        
			        if(message==2) {
			        	int input = JOptionPane.showConfirmDialog(null, 
				                   "Error in tranactiom", "", JOptionPane.DEFAULT_OPTION);
			        }
			        
			        else {
			        	 int input = JOptionPane.showConfirmDialog(null, 
				                   "Transaction was Successful ", "", JOptionPane.DEFAULT_OPTION);
			        }
			        
			}
		});
		btnDeposite.setBounds(218, 273, 140, 50);
		panTrans.add(btnDeposite);
		
		
		btnWithdraw.setBounds(218, 183, 140, 50);
		panTrans.add(btnWithdraw);
		JPanel paneltextDeleteAccountNumber = new JPanel();
		RoundedCorners pnlTotalUsers_1_1 = new RoundedCorners(40, Color.WHITE);
		pnlTotalUsers_1_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (paneltextDeleteAccountNumber.isVisible()) {
					
					paneltextDeleteAccountNumber.setVisible(false);
					
				} 
				else {
					
					paneltextDeleteAccountNumber.setVisible(true);
				}
				
			}
		});
		pnlTotalUsers_1_1.setLayout(null);
		pnlTotalUsers_1_1.setBounds(571, 460, 220, 96);
		pnlBackground_1.add(pnlTotalUsers_1_1);
		
		JLabel lblDeleteAccount = new JLabel("Delete Account");
		lblDeleteAccount.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		lblDeleteAccount.setBounds(52, 51, 130, 45);
		pnlTotalUsers_1_1.add(lblDeleteAccount);
		lblSettingsIcon = new JLabel("");
		lblSettingsIcon.setBounds(89, 22, 33, 31);
		pnlTotalUsers_1_1.add(lblSettingsIcon);
		lblSettingsIcon.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 11));
		lblSettingsIcon.setIcon(new ImageIcon( settingsicon ));
		
		
		paneltextDeleteAccountNumber.setVisible(false);
		paneltextDeleteAccountNumber.setBounds(823, 445, 303, 130);
		pnlBackground_1.add(paneltextDeleteAccountNumber);
		paneltextDeleteAccountNumber.setLayout(null);
		
		textDeleteAccountNumber = new JTextField();
		textDeleteAccountNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char C= evt.getKeyChar();
				
				if(!Character.isDigit(C)) {
					evt.consume();
				}
				
			}
		});
		textDeleteAccountNumber.setBounds(42, 63, 107, 38);
		paneltextDeleteAccountNumber.add(textDeleteAccountNumber);
		textDeleteAccountNumber.setColumns(10);
		
		JLabel lbltextDeleteAccountNumber = new JLabel(" Account #");
		lbltextDeleteAccountNumber.setBounds(54, 7, 130, 45);
		paneltextDeleteAccountNumber.add(lbltextDeleteAccountNumber);
		lbltextDeleteAccountNumber.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		
		JButton btnDeleteAccountNumber = new JButton("Delete");
		btnDeleteAccountNumber.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ApplicationContext beanFactory = new ClassPathXmlApplicationContext("SpringFrameWork.xml");
				
		    	 BasicConfigurator.configure();	
		    	 
		    	try {
				 customerMethods customerMet= (customerMethods)  beanFactory.getBean("cm");
				 int accountNumber = (Integer.parseInt(textDeleteAccountNumber.getText()));
				 int num1;
				 num1 = customerMet.deleteCustomer(accountNumber);
				 
				 if(num1==1) {
					 
			           int input = JOptionPane.showConfirmDialog(null, 
			                   "Account holder was delete", "", JOptionPane.DEFAULT_OPTION);
				 }
				 
		    	}catch(Exception ex) {
		    		
		    		int input = JOptionPane.showConfirmDialog(null, 
			                   "Account holder was not deleted ", "", JOptionPane.DEFAULT_OPTION);
		    	}
				 
			}
		});
		btnDeleteAccountNumber.setBounds(192, 59, 78, 42);
		paneltextDeleteAccountNumber.add(btnDeleteAccountNumber);
		btnDeleteAccountNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		
		searchPannel.setBounds(823, 272, 303, 51);
		pnlBackground_1.add(searchPannel);
		searchPannel.setLayout(null);
		
		txtAccount = new JTextField();
		txtAccount.setBounds(10, 0, 126, 40);
		searchPannel.add(txtAccount);
		txtAccount.setColumns(10);
		
		
		
		btnSearch = new JButton("Search");
		btnSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int accountNumber = (Integer.parseInt(txtAccount.getText()));
				
				ApplicationContext beanFactory = new ClassPathXmlApplicationContext("SpringFrameWork.xml");
				
		    	
		    	 
		    	 BasicConfigurator.configure();	

		    	 customerMethods customerMet= (customerMethods)  beanFactory.getBean("cm");
			   
			    transactionInformation trans= new transactionInformation();
			
			    List<transactionInformation> transList= null;
			    
			    transList = customerMet.getTransaction(accountNumber);
			    
			DefaultTableModel model = (DefaultTableModel)tblRecentTransactions.getModel();
			Object[] row = new Object[5];
			System.out.println("size of array "+transList.size());
			 for(int i =0; i< transList.size();i++)
		        {
				
				
				
				row[0]= transList.get(i).getWithdraw();
				row[1]= transList.get(i).getDeposite();
				row[2]= transList.get(i).getDate();
				row[3]= transList.get(i).getTime();
				row[4]=transList.get(i).getBalance();
		        }
			 
			 model.addRow(row);
			}
				
				
			
		});
		btnSearch.setBounds(198, 1, 95, 40);
		searchPannel.add(btnSearch);
	}

	public void setVisible(boolean b) {
		
		frmDashboardadmin.setVisible(true);
	}
}
