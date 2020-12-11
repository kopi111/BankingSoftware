package comBankingApp.AOOPProject;

import java.util.*;
import javax.swing.JOptionPane;

import java.awt.EventQueue;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DashboardUser {
	
	 customerInformation  customerInfo = new customerInformation();
	 int currentAccountNumber ;	 
	 
	private JLabel lblCurrentDate;

	private JFrame frmDashboarduser;
	private JTable tblTransactions;
	private JPanel pnlUserBackground;
	private JPanel pnlPayCredit_1;
	private JPanel pnlFundTransfer_1;
	private JPanel pnlPayBills_1;
	private JPanel pnlRecentTransactions_1;
	private JPanel pnlContactInfo_1;
	private JPanel pnlCards_1;
	DefaultTableModel model;
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DashboardUser window = new DashboardUser();
					window.frmDashboarduser.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	
	
	public void todaydate() {
		Calendar calendar= new GregorianCalendar();
		
		int day  = calendar.get(Calendar.DAY_OF_MONTH);
		int gmonth = calendar.get(Calendar.MONTH);
		int year= calendar.get(Calendar.YEAR);
		
		int realmonth= gmonth + 1;
		
		//lblCurrentDate.setText("Date: "+day+"/"+realmonth+"/"+year);
			}
		
	customerInformation customer = new customerInformation();
	private JTextField txtAccountNumber;
	private JTextField txtTransferAmount;
	
	public DashboardUser() {
		initialize();
		todaydate();
		
	}
	
	
	public DashboardUser(customerInformation  Customer) {
		
		initialize();
		todaydate();
		this.customer = Customer;
		currentAccountNumber = Customer.getAccountNumber();
		
	}
	
	

	
	private void initialize() {
		frmDashboarduser = new JFrame();
		JLabel lblUser = new JLabel();
		JLabel lblAccountBalance = new JLabel();
		JLabel lblSavingAccAmount = new JLabel();
		JLabel lblLoanAccAmount = new JLabel();
		
	//	lblAccountBalance
		frmDashboarduser.addWindowListener(new WindowAdapter() {
			@Override
			//change name og label
			public void windowOpened(WindowEvent e) {
				SimpleDateFormat dateTimeInGMT = new SimpleDateFormat("MMM dd, yyyy");
				dateTimeInGMT.setTimeZone(TimeZone.getTimeZone("EST"));
				lblCurrentDate.setText(dateTimeInGMT.format(new Date()));
				lblUser.setText(customer.getFirstName());
				
				int convert = (int) customer.getAccountinfo().getAccountBalance(); 
				String str1 = Integer.toString(convert);		 
				lblAccountBalance.setText(str1);
				
				
				int convert2 = (int) customer.getAccountinfo().getAccountNumber(); 
				String str2 = Integer.toString(convert2);		 
				lblSavingAccAmount.setText(str2);
				
				float convert3 = (float) customer.getAccountinfo().getLoanAmmount(); 
				String str3 = String.valueOf(convert3);		 
				lblLoanAccAmount.setText(str3);
				
			}
		});
		frmDashboarduser.getContentPane().setBackground(new Color(230, 230, 250));
		frmDashboarduser.setTitle("Dashboard");
		frmDashboarduser.setUndecorated(true);
		frmDashboarduser.setBounds(100, 100, 1200, 850);
		frmDashboarduser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDashboarduser.setBackground(new Color(0,0,0,0));
		frmDashboarduser.getContentPane().setLayout(null);
		frmDashboarduser.setLocationRelativeTo(null);
		
		JPanel pnlFundTransfer = new JPanel();
		Image img= new ImageIcon(this.getClass().getResource("/transfer.png")).getImage();
		Image image= new ImageIcon(this.getClass().getResource("/right-arrow.png")).getImage();
		
		
		
		JPanel pnlFixedDeposit = new JPanel();
		Image img3= new ImageIcon(this.getClass().getResource("/deposit.png")).getImage();
		Image image4= new ImageIcon(this.getClass().getResource("/right-arrow.png")).getImage();
		
		
		
		
		JPanel pnlPayCredit = new JPanel();
		Image image5= new ImageIcon(this.getClass().getResource("/pay (1).png")).getImage();
		Image image6= new ImageIcon(this.getClass().getResource("/right-arrow.png")).getImage();
		Image image7= new ImageIcon(this.getClass().getResource("/bill.png")).getImage();
		Image image8= new ImageIcon(this.getClass().getResource("/right-arrow.png")).getImage();
		Image arrow1= new ImageIcon(this.getClass().getResource("/right-arrow.png")).getImage();
		Image call= new ImageIcon(this.getClass().getResource("/chat.png")).getImage();
		Image notifIcon= new ImageIcon(this.getClass().getResource("/Notification Icon.png")).getImage();
		Image accountIcon= new ImageIcon(this.getClass().getResource("/Account Icon 2.png")).getImage();
		Image exitIcon= new ImageIcon(this.getClass().getResource("/Sign Out Icon.png")).getImage();
		Image phoneIcon= new ImageIcon(this.getClass().getResource("/Phone Icon 3.png")).getImage();
		Image messageIcon = new ImageIcon(this.getClass().getResource("/Message Icon.png")).getImage();
		Image infoIcon = new ImageIcon(this.getClass().getResource("/Info Icon.png")).getImage();
		Image gradientBackground = new ImageIcon(this.getClass().getResource("/Gradient.jpg")).getImage();
		/*btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String emailurl= "https://mail.google.com/mail/u/0/#inbox";
					java.awt.Desktop.getDesktop().browse(java.net.URI.create(emailurl));
					
				}catch(Exception exp) {
					exp.printStackTrace();
				}
			}
		});*/
		Image email= new ImageIcon(this.getClass().getResource("/mail.png")).getImage();
		Image SharesArrow= new ImageIcon(this.getClass().getResource("/right-arrow.png")).getImage();
		Image LoanArrow= new ImageIcon(this.getClass().getResource("/right-arrow.png")).getImage();
		Image exit = new ImageIcon(this.getClass().getResource("/cancel (1).png")).getImage();
		Image minimize1 = new ImageIcon(this.getClass().getResource("/minimize (2).png")).getImage();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		JPanel pnlRecentTransactions = new JPanel();
		Image logo = new ImageIcon(this.getClass().getResource("/outkastlogo1.png")).getImage();
		
		JPanel pnlBackground = new JPanel();
		pnlUserBackground = new RoundedCorners(20);
		pnlUserBackground.setBounds(-21, 22, 1180, 828);
		frmDashboarduser.getContentPane().add(pnlUserBackground);
		pnlUserBackground.setLayout(null);
		
		JPanel pnlContactInfo = new JPanel();
		
		JPanel pnlCards = new JPanel();
		
		JPanel pnlMessages = new JPanel();
		
		
		pnlCards_1 = new RoundedCorners(40, Color.white);
		pnlCards_1.setBounds(916, 395, 240, 405);
		pnlUserBackground.add(pnlCards_1);
		pnlCards_1.setLayout(null);
		
		JPanel pnlSavingAccount = new JPanel();
		pnlSavingAccount.setBounds(10, 11, 220, 120);
		pnlCards_1.add(pnlSavingAccount);
		pnlSavingAccount.setBackground(new Color(255, 0, 255));
		pnlSavingAccount.setLayout(null);
		
		JLabel lblSavingAccountTitle = new JLabel("Account  Number");
		lblSavingAccountTitle.setForeground(new Color(0, 0, 0));
		lblSavingAccountTitle.setFont(new Font("Rockwell Condensed", Font.BOLD, 18));
		lblSavingAccountTitle.setBounds(20, 11, 194, 45);
		pnlSavingAccount.add(lblSavingAccountTitle);
		
		//JLabel lblSavingAccAmount = new JLabel("#");
		//lblSavingAccAmount.setText(customerInfo.getAccountNumber());
		lblSavingAccAmount.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblSavingAccAmount.setForeground(new Color(0, 0, 0));
		lblSavingAccAmount.setBounds(69, 67, 98, 25);
		pnlSavingAccount.add(lblSavingAccAmount);
		
		JButton btnSavingArrow = new JButton("");
		btnSavingArrow.setBorderPainted(false);
		btnSavingArrow.setDefaultCapable(false);
		btnSavingArrow.setContentAreaFilled(false);
		btnSavingArrow.setBounds(20, 67, 39, 25);
		pnlSavingAccount.add(btnSavingArrow);
		btnSavingArrow.setIcon(new ImageIcon(arrow1));
		
		JLabel lblSavingAccBackground = new JLabel("");
		lblSavingAccBackground.setBackground(Color.WHITE);
		lblSavingAccBackground.setIcon(new ImageIcon(DashboardUser.class.getResource("/pink.jpg")));
		//lblSavingAccBackground = new RoundedLabel(20);
		lblSavingAccBackground.setBounds(0, 0, 218, 120);
		pnlSavingAccount.add(lblSavingAccBackground);		
		
		JPanel pnlLoanAccountBal = new JPanel();
		pnlLoanAccountBal.setBounds(10, 273, 220, 120);
		pnlCards_1.add(pnlLoanAccountBal);
		pnlLoanAccountBal.setLayout(null);
		
		JLabel lblLoanAccountBalance = new JLabel("Loan Account Balance");
		lblLoanAccountBalance.setFont(new Font("Rockwell Condensed", Font.BOLD, 18));
		lblLoanAccountBalance.setBounds(22, 21, 168, 27);
		pnlLoanAccountBal.add(lblLoanAccountBalance);
		
		//JLabel lblLoanAccAmount = new JLabel("#");
		lblLoanAccAmount.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblLoanAccAmount.setBounds(52, 59, 120, 28);
		pnlLoanAccountBal.add(lblLoanAccAmount);
		
		JButton btnLoanAccArrow = new JButton("");
		btnLoanAccArrow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnLoanAccArrow.setOpaque(false);
		btnLoanAccArrow.setBorderPainted(false);
		btnLoanAccArrow.setContentAreaFilled(false);
		btnLoanAccArrow.setDefaultCapable(false);
		btnLoanAccArrow.setBounds(10, 86, 49, 23);
		pnlLoanAccountBal.add(btnLoanAccArrow);
		btnLoanAccArrow.setIcon(new ImageIcon(LoanArrow));
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(DashboardUser.class.getResource("/pink.jpg")));
		lblNewLabel_3.setBounds(0, 0, 220, 120);
		pnlLoanAccountBal.add(lblNewLabel_3);
		
		JPanel pnlSharesAcc = new JPanel();
		pnlSharesAcc.setBounds(10, 142, 220, 120);
		pnlCards_1.add(pnlSharesAcc);
		pnlSharesAcc.setBackground(new Color(240, 255, 255));
		pnlSharesAcc.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Account Balance");
		lblNewLabel_1.setBounds(18, 5, 177, 22);
		lblNewLabel_1.setFont(new Font("Rockwell Condensed", Font.BOLD, 18));
		pnlSharesAcc.add(lblNewLabel_1);
		
		//JLabel lblAccountBalance = new JLabel("#");
		lblAccountBalance.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblAccountBalance.setBounds(79, 49, 116, 28);
		pnlSharesAcc.add(lblAccountBalance);
		
	
		
		JButton btnSharesArrow = new JButton("");
		btnSharesArrow.setBorderPainted(false);
		btnSharesArrow.setOpaque(false);
		btnSharesArrow.setDefaultCapable(false);
		btnSharesArrow.setContentAreaFilled(false);
		btnSharesArrow.setBounds(10, 88, 49, 23);
		pnlSharesAcc.add(btnSharesArrow);
		btnSharesArrow.setIcon(new ImageIcon(SharesArrow));
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(DashboardUser.class.getResource("/blue.jpg")));
		lblNewLabel_2.setBounds(0, 1, 220, 119);
		pnlSharesAcc.add(lblNewLabel_2);
		pnlContactInfo_1 = new RoundedCorners(40, Color.white);
		pnlContactInfo_1.setBounds(677, 157, 479, 189);
		pnlUserBackground.add(pnlContactInfo_1);
		pnlContactInfo_1.setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(137, 11, 210, 92);
		pnlContactInfo_1.add(lblLogo);
		lblLogo.setIcon(new ImageIcon(logo));
		
		JLabel lblPhoneIcon = new JLabel("");
		lblPhoneIcon.setIcon(new ImageIcon(phoneIcon));
		lblPhoneIcon.setBounds(64, 114, 30, 30);
		pnlContactInfo_1.add(lblPhoneIcon);
		
		JLabel lblMessageIcon = new JLabel("");
		lblMessageIcon.setIcon(new ImageIcon(messageIcon));
		lblMessageIcon.setBounds(231, 114, 30, 30);
		pnlContactInfo_1.add(lblMessageIcon);
		
		JLabel lblInfoIcon = new JLabel("");
		lblInfoIcon.setIcon(new ImageIcon(infoIcon));
		lblInfoIcon.setBounds(382, 114, 30, 30);
		pnlContactInfo_1.add(lblInfoIcon);
		
		JLabel lblCall = new JLabel("(876) 949-4762");
		lblCall.setFont(new Font("Rockwell Condensed", Font.PLAIN, 18));
		lblCall.setBounds(74, 155, 46, 14);
		pnlContactInfo_1.add(lblCall);
		
		JLabel lblMessage = new JLabel("Message");
		lblMessage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmUserMessages messages = new frmUserMessages();
				messages.setVisible(true);
			}
		});
		lblMessage.setFont(new Font("Rockwell Condensed", Font.PLAIN, 18));
		lblMessage.setBounds(222, 155, 70, 14);
		pnlContactInfo_1.add(lblMessage);
		
		JLabel lblInfo = new JLabel("OutKast@gmail.com");
		lblInfo.setFont(new Font("Rockwell Condensed", Font.PLAIN, 18));
		lblInfo.setBounds(338, 151, 131, 23);
		pnlContactInfo_1.add(lblInfo);
		
		pnlRecentTransactions_1 = new RoundedCorners(40);
		pnlRecentTransactions_1.setBounds(25, 297, 574, 503);
		pnlUserBackground.add(pnlRecentTransactions_1);
		//pnlRecentTransactions.setBorder(new TitledBorder(null, "Recent Transactions", TitledBorder.CENTER, TitledBorder.TOP, null, null));
		pnlRecentTransactions_1.setBackground(new Color(255, 255, 255));
		pnlRecentTransactions_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 22, 530, 429);
		pnlRecentTransactions_1.add(scrollPane);
		
		tblTransactions = new JTable();
		scrollPane.setViewportView(tblTransactions);
		tblTransactions.setFont(new Font("Tahoma", Font.PLAIN, 14));
		tblTransactions.setGridColor(new Color(211, 211, 211));
		tblTransactions.setSelectionBackground(new Color(255, 0, 255));
		tblTransactions.setShowVerticalLines(false);
		tblTransactions.setRowMargin(20);
		tblTransactions.setRowHeight(60);
		
		
		
	/*DefaultTableCellRenderer render= new DefaultTableCellRenderer();
		render.setHorizontalAlignment(JLabel.LEFT);
		for(int i = 0 ; i<5; i++) {
			tblTransactions.getColorModel().getColumn(i).setCellBenderer(render);
		}
		*/
		
		tblTransactions.setModel(new DefaultTableModel(
				
				new Object[][] {
					
					
				},
				new String[] {
						 "Withdraw", "Deposite", "Date","Time","Balance"
					}
				
			
				));
		
		JLabel lblNewLabel_8 = new JLabel("Recent Transactions");
		lblNewLabel_8.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
		lblNewLabel_8.setBounds(22, 0, 193, 24);
		pnlRecentTransactions_1.add(lblNewLabel_8);
		
		JButton btnShowTransaction = new JButton("Show Transaction");
		btnShowTransaction.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				int accountNumber = currentAccountNumber;
			    customerMethods customerMet = new customerMethods();
			    transactionInformation trans= new transactionInformation();
			
			    List<transactionInformation> transList= null;
			    
			    transList = customerMet.getTransaction(accountNumber);
			    
			DefaultTableModel model = (DefaultTableModel)tblTransactions.getModel();
			Object[] row = new Object[5];
			System.out.println("size of array "+transList.size());
			 for(int i =0; i< transList.size();i++)
		        {
				
				
				
				row[0]= transList.get(i).getWithdraw();
				row[1]= transList.get(i).getDeposite();
				row[2]= transList.get(i).getDate();
				row[3]= transList.get(i).getTime();
				row[4]= transList.get(i).getBalance();
				
		        }
			 
			 model.addRow(row);
			}
				
	
		});
		btnShowTransaction.setBounds(167, 462, 121, 30);
		pnlRecentTransactions_1.add(btnShowTransaction);
		
		JButton btnMinimize = new JButton("----");
		btnMinimize.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnMinimize.setBounds(1131, 11, 48, 23);
		pnlUserBackground.add(btnMinimize);
		btnMinimize.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmDashboarduser.setState(JFrame.ICONIFIED);
			}
		});
		btnMinimize.setOpaque(false);
		btnMinimize.setBorderPainted(false);
		btnMinimize.setContentAreaFilled(false);
		
		
		
		JPanel plnFundTransfer = new JPanel();
		plnFundTransfer.setVisible(false);
		
		
		JPanel pnlPayBills = new JPanel();
		pnlPayBills_1 = new RoundedCorners(40);
		
		pnlPayBills_1.setBounds(469, 157, 130, 115);
		pnlUserBackground.add(pnlPayBills_1);
		pnlPayBills_1.setBackground(Color.white);
		pnlPayBills_1.setLayout(null);
		
		JLabel lblPayBills = new JLabel("");
		lblPayBills.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		lblPayBills.setBounds(28, 5, 77, 64);
		pnlPayBills_1.add(lblPayBills);
		lblPayBills.setIcon(new ImageIcon(image7));
		
		JLabel lblNewLabel_7 = new JLabel("Pay Loan");
		/*lblNewLabel_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
			}
		});*/
		lblNewLabel_7.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(30, 89, 67, 15);
		pnlPayBills_1.add(lblNewLabel_7);
		pnlPayCredit_1 = new RoundedCorners(40);
		pnlPayCredit_1.setBounds(260, 157, 130, 115);
		pnlUserBackground.add(pnlPayCredit_1);
		pnlPayCredit_1.setBackground(Color.WHITE);
		pnlPayCredit_1.setLayout(null);
		
		JLabel lblPayCreditcardBill = new JLabel("");
		lblPayCreditcardBill.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		lblPayCreditcardBill.setBounds(28, 5, 76, 70);
		pnlPayCredit_1.add(lblPayCreditcardBill);
		lblPayCreditcardBill.setIcon(new ImageIcon(image5));
		
		JLabel lblNewLabel_4 = new JLabel("Buy Credit");
		lblNewLabel_4.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(7, 86, 97, 18);
		pnlPayCredit_1.add(lblNewLabel_4);
		
		//JLabel lblUser = new JLabel(customerInfo.getFirstName());
		//String user = customerInfo.getFirstName();
		//JLabel lblUser = new JLabel();
		lblUser.setText("User");
		lblUser.setVisible(true);
		lblUser.setForeground(Color.white);
		lblUser.setBounds(137, 109, 143, 37);
		pnlUserBackground.add(lblUser);
		lblUser.setFont(new Font("Rockwell Condensed", Font.BOLD, 35));
		
		JLabel lblHe = new JLabel("Hello,");
		lblHe.setForeground(Color.WHITE);
		lblHe.setBounds(37, 109, 90, 37);
		pnlUserBackground.add(lblHe);
		lblHe.setFont(new Font("Rockwell Condensed", Font.BOLD, 35));
		
		lblCurrentDate = new JLabel("DATE");
		lblCurrentDate.setForeground(Color.WHITE);
		lblCurrentDate.setBounds(41, 81, 95, 17);
		pnlUserBackground.add(lblCurrentDate);
		lblCurrentDate.setFont(new Font("Rockwell Condensed", Font.PLAIN, 16));
		
		JLabel lblWeather = new JLabel("|");
		lblWeather.setForeground(Color.WHITE);
		lblWeather.setBounds(137, 82, 25, 14);
		pnlUserBackground.add(lblWeather);
		lblWeather.setFont(new Font("Rockwell Condensed", Font.PLAIN, 15));
		
		JLabel lblWeather_1 = new JLabel("WEATHER");
		lblWeather_1.setForeground(Color.WHITE);
		lblWeather_1.setBounds(160, 82, 67, 14);
		pnlUserBackground.add(lblWeather_1);
		lblWeather_1.setFont(new Font("Rockwell Condensed", Font.PLAIN, 16));
		pnlFundTransfer_1 = new RoundedCorners(40, Color.white);
		
		
		
		
		pnlFundTransfer_1.setBounds(47, 157, 130, 115);
		pnlUserBackground.add(pnlFundTransfer_1);
		//Image img= new ImageIcon(this.getClass().getResource("/transfer.png")).getImage();
		//panFundTransfer.add(new ImageIcon(img));
		pnlFundTransfer_1.setBackground(new Color(255, 255, 255));
		pnlFundTransfer_1.setLayout(null);
		
		JLabel lblFundTransfer = new JLabel("");
		lblFundTransfer.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		lblFundTransfer.setBounds(35, 11, 80, 64);
		pnlFundTransfer_1.add(lblFundTransfer);
		lblFundTransfer.setIcon(new ImageIcon(img));
		
		JLabel lblNewLabel_5 = new JLabel("Fund Transfer");
		lblNewLabel_5.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 86, 105, 14);
		pnlFundTransfer_1.add(lblNewLabel_5);
		
		final JButton btnInvestments = new JButton("LOANS");
		btnInvestments.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnInvestments.setForeground(Color.magenta);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnInvestments.setForeground(Color.white);
			}
		});
		btnInvestments.setForeground(Color.WHITE);
		btnInvestments.setBounds(567, 22, 160, 40);
		pnlUserBackground.add(btnInvestments);
		btnInvestments.setFont(new Font("Rockwell", Font.BOLD, 16));
		btnInvestments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInvestments.setOpaque(false);
		btnInvestments.setContentAreaFilled(false);
		btnInvestments.setBorderPainted(false);
		
		final JButton btnCreditCard = new JButton("CREDIT CARD");
		btnCreditCard.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnCreditCard.setForeground(Color.magenta);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnCreditCard.setForeground(Color.white);
			}
		});
		btnCreditCard.setForeground(Color.WHITE);
		btnCreditCard.setBounds(366, 22, 155, 40);
		pnlUserBackground.add(btnCreditCard);
		btnCreditCard.setFont(new Font("Rockwell", Font.BOLD, 16));
		btnCreditCard.setOpaque(false);
		btnCreditCard.setContentAreaFilled(false);
		btnCreditCard.setBorderPainted(false);
		
		final JButton btnHome = new JButton("HOME");
		btnHome.setForeground(Color.MAGENTA);
		btnHome.setBounds(37, 22, 150, 40);
		pnlUserBackground.add(btnHome);
		btnHome.setFont(new Font("Rockwell", Font.BOLD, 16));
		btnHome.setBorderPainted(false);
		btnHome.setAlignmentY(0.0f);
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnHome.setOpaque(false);
		btnHome.setContentAreaFilled(false);
		
		final JButton btnBanking = new JButton("BANKING");
		btnBanking.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				btnBanking.setForeground(Color.magenta);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnBanking.setForeground(Color.white);
			}
		});
		btnBanking.setForeground(Color.WHITE);
		btnBanking.setBounds(190, 22, 150, 40);
		pnlUserBackground.add(btnBanking);
		btnBanking.setFont(new Font("Rockwell", Font.BOLD, 16));
		btnBanking.setOpaque(false);
		btnBanking.setContentAreaFilled(false);
		btnBanking.setBorderPainted(false);
		
		JLabel lblExit = new JLabel("");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Object[] options = {"Yes","No"};
				
				int choice = JOptionPane.showOptionDialog(frmDashboarduser, "Are you sure you want to sign out?", "Sign Out", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE ,null, options, options[1]);
				if(choice == 0) {
					System.exit(0);
				}
			}
		});
		lblExit.setIcon(new ImageIcon(exitIcon));
		lblExit.setBounds(1040, 11, 31, 31);
		pnlUserBackground.add(lblExit);
		
		JLabel lblAccount = new JLabel("");
	//lblAccount.setText(customerInfo.getAccountNumber());
		lblAccount.setText(customerInfo.getLastName());
		lblAccount.setIcon(new ImageIcon(accountIcon));
		lblAccount.setBounds(987, 11, 31, 37);
		pnlUserBackground.add(lblAccount);
		
		JLabel lblNotification = new JLabel("");
		lblNotification.setIcon(new ImageIcon(notifIcon));
		lblNotification.setBounds(934, 11, 39, 37);
		pnlUserBackground.add(lblNotification);
		
		JLabel lblUpperBackground = new JLabel("");
		lblUpperBackground.setForeground(Color.WHITE);
		lblUpperBackground.setBounds(0, 10, 1179, 434);
		pnlUserBackground.add(lblUpperBackground);
		lblUpperBackground.setIcon(new ImageIcon(gradientBackground));
		
		
		plnFundTransfer.setBackground(Color.LIGHT_GRAY);
		plnFundTransfer.setBounds(597, 443, 319, 357);
		pnlUserBackground.add(plnFundTransfer);
		plnFundTransfer.setLayout(null);
		
		txtAccountNumber = new JTextField();
		txtAccountNumber.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar(); //Allows input of only Numbers and periods in the textfield
			    if ((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_PERIOD)) {
			        String s = txtAccountNumber.getText();
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
		txtAccountNumber.setBounds(110, 91, 112, 33);
		plnFundTransfer.add(txtAccountNumber);
		txtAccountNumber.setColumns(10);
		
		txtTransferAmount = new JTextField();
		txtTransferAmount.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char c = evt.getKeyChar(); //Allows input of only Numbers and periods in the textfield
			    if ((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_PERIOD)) {
			        String s = txtTransferAmount.getText();
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
		txtTransferAmount.setBounds(104, 198, 118, 37);
		plnFundTransfer.add(txtTransferAmount);
		txtTransferAmount.setColumns(10);
		
		JLabel lblSavingAccountTitle_1_1 = new JLabel("Transfer Amount");
		lblSavingAccountTitle_1_1.setBounds(104, 142, 150, 45);
		plnFundTransfer.add(lblSavingAccountTitle_1_1);
		lblSavingAccountTitle_1_1.setBackground(Color.RED);
		lblSavingAccountTitle_1_1.setForeground(Color.BLACK);
		lblSavingAccountTitle_1_1.setFont(new Font("Rockwell Condensed", Font.BOLD, 18));
		
		JLabel lblSavingAccountTitle_1 = new JLabel("");
		 lblSavingAccountTitle_1.setText("Account Number");
		lblSavingAccountTitle_1.setBounds(104, 35, 150, 45);
		plnFundTransfer.add(lblSavingAccountTitle_1);
		lblSavingAccountTitle_1.setForeground(Color.BLACK);
		lblSavingAccountTitle_1.setFont(new Font("Rockwell Condensed", Font.BOLD, 18));
		pnlFundTransfer_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				if (plnFundTransfer.isVisible()== true) {
					
					plnFundTransfer.setVisible(false);
					
				}
				else if (plnFundTransfer.isVisible()== false) {
					plnFundTransfer.setVisible(true);
					lblSavingAccountTitle_1.setText("Account Number");
					lblSavingAccountTitle_1_1.setText("Transfer Amount");
					txtTransferAmount.show();;
					lblSavingAccountTitle_1.show();
					
				}
					
			}
		});
		
		
		pnlPayBills_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				
				if (plnFundTransfer.isVisible()== true) {
					
			
					plnFundTransfer.setVisible(false);
					
					
				}
				else if (plnFundTransfer.isVisible()== false) {
					plnFundTransfer.setVisible(true);
					lblSavingAccountTitle_1.setText("Pay Loan");
					txtTransferAmount.hide();
					lblSavingAccountTitle_1_1.hide();
					
				}
				
				
			}
		});
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (lblSavingAccountTitle_1.getText()== "Pay Loan") {
					 customerMethods cm2 = new customerMethods();
			
					 transactionClass trans2 = new transactionClass();
					 transactionClass trans3 = new transactionClass();
					
					String accountNumberString = lblSavingAccAmount.getText();
					 int accountNumber = Integer.parseInt(accountNumberString );
					 

						String loanString = lblSavingAccAmount.getText();
						 int loan = Integer.parseInt(loanString );
						 
					 
				trans2.setAccount1(accountNumber);
			 	trans2.setLoanPayment(loan);
			 	trans3=cm2.loanPay(trans2);
			 	
			 	
			 	int input = JOptionPane.showConfirmDialog(null, 
		                   trans3.getMessage1(), "", JOptionPane.DEFAULT_OPTION);
			 	txtAccountNumber.setText("");
			 	txtTransferAmount.setText("");
	         
	         
					
				}
				else {
				 customerMethods cm = new customerMethods();
				transactionClass trans = new transactionClass();
				transactionClass trans1 = new transactionClass();
				String accountNumberString = lblSavingAccAmount.getText();
				 int accountNumber = Integer.parseInt(accountNumberString );
				 
		    	trans.setAccount1(accountNumber); 
				
				trans.setAccount2(Integer.parseInt (txtAccountNumber.getText()));
				trans.setDeposite1(Float.parseFloat( (txtTransferAmount.getText())));
				int callFunction=2;
		    	
		        if (txtAccountNumber.getText().isEmpty()){
		        	txtAccountNumber.setBackground(Color.red);
		            int input = JOptionPane.showConfirmDialog(null, 
			        "User cant be empty", "", JOptionPane.DEFAULT_OPTION);
		            callFunction=callFunction-1;
		            
		        }
		         if (txtTransferAmount.getText().isEmpty() && callFunction==2 ){
		        	 
		        	 txtTransferAmount.setBackground(Color.red);
		           int input = JOptionPane.showConfirmDialog(null, 
		                   "Password cant be empty", "", JOptionPane.DEFAULT_OPTION);
		           		callFunction=callFunction-1;
		       }
		         
		        
		         
		        
		        if (callFunction == 2 ) { 
		        	
					 
		        	trans1=cm.Deposite(trans) ;
		        	
		        	int input = JOptionPane.showConfirmDialog(null, 
			                   trans1.getMessage1(), "", JOptionPane.DEFAULT_OPTION);
		        	
		        	txtAccountNumber.setText("");
		        	txtTransferAmount.setText("");
		        
			     
		        }
				}       
	/*	}
		      catch(Exception ex){
		    	  int input = JOptionPane.showConfirmDialog(null, 
		                   "program have to close", "", JOptionPane.DEFAULT_OPTION);
		          //dispose();
		      } 
		}*/
			}
		});
		btnSubmit.setBounds(122, 278, 103, 37);
		plnFundTransfer.add(btnSubmit);
		
		JPanel pnlPayLoan = new JPanel();
		pnlPayLoan.setBounds(0, 0, 319, 357);
		plnFundTransfer.add(pnlPayLoan);
		pnlPayLoan.setLayout(null);
	}

	
	
	
	
	
	public void setVisible(boolean b) {
		frmDashboarduser.setVisible(true);
	}

	
	
}
