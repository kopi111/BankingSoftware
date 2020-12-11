package comBankingApp.AOOPProject;

import java.awt.EventQueue;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.SwingConstants;

public class Worker {

	private JFrame frmDashboardadmin;
	private JPanel pnlBackground_1;
	private JPanel pnlTotalUsers_1;
	private JPanel pnlActiveUsers_1;
	private JPanel pnlTotalTasks_1;
	private JLabel lblUser;
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
	private JLabel lblSuccessfulTransactions;
	private JLabel lblFailedTransactions;
	private JLabel lblHomeIcon;
	private JLabel lblLogOutIcon;
	private JLabel lblSettingsIcon;
	private JLabel lblCurentDateTime;
	private JLabel lblAdminMessages;
	private JButton btnAccounts;
	private JButton btnNewButton_2;
	private JButton btnNewButton_3;
	private JButton btnNewButton_4;
	private JLabel lblNewLabel_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Worker window = new Worker();
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
	public Worker() {
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
				lblCurentDateTime.setText(dateTimeInGMT.format(new Date()));
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
		lblLogOutIcon.setBounds(19, 454, 24, 31);
		panel.add(lblLogOutIcon);
		Image logouticon = new ImageIcon(this.getClass().getResource("/Logout Icon.png")).getImage();
		lblLogOutIcon.setIcon(new ImageIcon( logouticon ));
		
		lblSettingsIcon = new JLabel("");
		lblSettingsIcon.setBounds(19, 350, 33, 31);
		panel.add(lblSettingsIcon);
		Image settingsicon = new ImageIcon(this.getClass().getResource("/Settins Icon.png")).getImage();
		lblSettingsIcon.setIcon(new ImageIcon( settingsicon ));
		
		JLabel lblUserIcon = new JLabel("");
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
		
		btnNewButton_3 = new JButton("SETTINGS");
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				btnNewButton_3.setForeground(Color.white);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnNewButton_3.setForeground(Color.magenta);
			}
		});
		btnNewButton_3.setOpaque(false);
		btnNewButton_3.setHorizontalAlignment(SwingConstants.LEFT);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 15));
		btnNewButton_3.setContentAreaFilled(false);
		btnNewButton_3.setBorderPainted(false);
		btnNewButton_3.setAlignmentY(0.0f);
		btnNewButton_3.setBounds(0, 380, 129, 23);
		panel.add(btnNewButton_3);
		
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
		btnNewButton_4.setBounds(0, 482, 129, 23);
		panel.add(btnNewButton_4);
		
		
		JPanel pnlTotalUsers = new JPanel();
		
		JPanel pnlActiveUsers = new JPanel();
		
		JPanel pnlTotalTasks = new JPanel();
		
		JPanel pnlBackground = new JPanel();
		pnlBackground_1 = new RoundedCorners(20);
		pnlBackground_1.setBounds(108, 22, 1180, 828);
		frmDashboardadmin.getContentPane().add(pnlBackground_1);
		pnlBackground_1.setLayout(null);
		
		lblFailedTransactions = new JLabel("  Failed Transactions");
		lblFailedTransactions.setBounds(168, 640, 197, 45);
		pnlBackground_1.add(lblFailedTransactions);
		lblFailedTransactions.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		lblFailedTransactions.setIcon(new ImageIcon(failedTransIcon));
		
		lblSuccessfulTransactions = new JLabel("  Successful Transactions");
		lblSuccessfulTransactions.setBounds(168, 517, 197, 45);
		pnlBackground_1.add(lblSuccessfulTransactions);
		lblSuccessfulTransactions.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		lblSuccessfulTransactions.setIcon(new ImageIcon(succTransIcon));
		
		lblWelcomeIcon = new JLabel("");
		lblWelcomeIcon.setIcon(new ImageIcon(welcomeIcon));
		lblWelcomeIcon.setBounds(806, 56, 179, 216);
		pnlBackground_1.add(lblWelcomeIcon);
		pnlTotalUsers_1 = new RoundedCorners(40, Color.white);
		pnlTotalUsers_1.setBounds(158, 334, 220, 96);
		pnlBackground_1.add(pnlTotalUsers_1);
		pnlTotalUsers_1.setBackground(Color.WHITE);
		pnlTotalUsers_1.setLayout(null);
		
		lblAllUsers = new JLabel("  Create Account");
		lblAllUsers.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		lblAllUsers.setBounds(27, 28, 183, 57);
		pnlTotalUsers_1.add(lblAllUsers);
		pnlActiveUsers_1 = new RoundedCorners(40, Color.white);
		Image AllUsersIcon= new ImageIcon(this.getClass().getResource("/group.png")).getImage();
		lblAllUsers.setIcon(new ImageIcon(AllUsersIcon));
	
		pnlActiveUsers_1.setBounds(415, 334, 214, 96);
		pnlBackground_1.add(pnlActiveUsers_1);
		pnlActiveUsers_1.setBackground(Color.WHITE);
		pnlActiveUsers_1.setLayout(null);
		
		lblActiveUsers = new JLabel("Users Account");
		lblActiveUsers.setBounds(32, 25, 172, 46);
		lblActiveUsers.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		pnlActiveUsers_1.add(lblActiveUsers);
		pnlTotalTasks_1 = new RoundedCorners(40, Color.white);
		pnlTotalTasks_1.setBounds(663, 334, 214, 96);
		pnlBackground_1.add(pnlTotalTasks_1);
		pnlTotalTasks_1.setBackground(Color.WHITE);
		pnlTotalTasks_1.setLayout(null);
		
		lblTodaysUsers = new JLabel("Transaction");
		lblTodaysUsers.setBounds(50, 26, 137, 45);
		lblTodaysUsers.setFont(new Font("Rockwell Condensed", Font.PLAIN, 20));
		pnlTotalTasks_1.add(lblTodaysUsers);
		Image todayusers= new ImageIcon(this.getClass().getResource("/paper-note.png")).getImage();
		lblTodaysUsers.setIcon(new ImageIcon(todayusers));
		Image activeusersIcon= new ImageIcon(this.getClass().getResource("/online-learning.png")).getImage();
		lblActiveUsers.setIcon(new ImageIcon(activeusersIcon));
		Image allusersIcon= new ImageIcon(this.getClass().getResource("/group.png")).getImage();
		
		RoundedCorners pnlTotalTasks_1_1 = new RoundedCorners(40, Color.WHITE);
		pnlTotalTasks_1_1.setBounds(912, 334, 214, 96);
		pnlBackground_1.add(pnlTotalTasks_1_1);
		pnlTotalTasks_1_1.setLayout(null);
		
		lblMessages = new JLabel("   Messages");
		lblMessages.setBounds(52, 0, 123, 45);
		lblMessages.setFont(new Font("Rockwell Condensed", Font.PLAIN, 19));
		pnlTotalTasks_1_1.add(lblMessages);
		Image messageIcon= new ImageIcon(this.getClass().getResource("/chat (1).png")).getImage();
		lblMessages.setIcon(new ImageIcon(messageIcon));
		
		JLabel lblNewLabel_3_3 = new JLabel("#");
		lblNewLabel_3_3.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 18));
		lblNewLabel_3_3.setBounds(100, 71, 25, 14);
		pnlTotalTasks_1_1.add(lblNewLabel_3_3);
		
		
		JPanel pnlWelcome = new JPanel();
		pnlWelcome_1 = new RoundedCorners(40, new Color(65, 105, 225));
		pnlWelcome_1.setBounds(158, 120, 968, 141);
		pnlBackground_1.add(pnlWelcome_1);
		pnlWelcome_1.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome,");
		lblWelcome.setBounds(248, 27, 161, 56);
		lblWelcome.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 27));
		pnlWelcome_1.add(lblWelcome);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 25));
		lblUsername.setBounds(419, 32, 179, 48);
		pnlWelcome_1.add(lblUsername);
		
		JLabel lblNewLabel_2 = new JLabel("Check  Notifications");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 22));
		lblNewLabel_2.setBounds(272, 94, 267, 62);
		pnlWelcome_1.add(lblNewLabel_2);
		
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
		
		RoundedCorners pnlTotalUsers_1_1 = new RoundedCorners(40, Color.WHITE);
		pnlTotalUsers_1_1.setBounds(158, 491, 220, 96);
		pnlBackground_1.add(pnlTotalUsers_1_1);
		pnlTotalUsers_1_1.setLayout(null);
		
		JLabel lblNewLabel_3_4 = new JLabel("#");
		lblNewLabel_3_4.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 18));
		lblNewLabel_3_4.setBounds(106, 71, 25, 14);
		pnlTotalUsers_1_1.add(lblNewLabel_3_4);
		
		
		RoundedCorners pnlActiveUsers_1_1 = new RoundedCorners(40, Color.WHITE);
		pnlActiveUsers_1_1.setBounds(158, 612, 220, 96);
		pnlBackground_1.add(pnlActiveUsers_1_1);
		pnlActiveUsers_1_1.setLayout(null);
		
		JLabel lblNewLabel_3_5 = new JLabel("#");
		lblNewLabel_3_5.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 18));
		lblNewLabel_3_5.setBounds(102, 71, 25, 14);
		pnlActiveUsers_1_1.add(lblNewLabel_3_5);
		
		
		JLabel lblNewLabel = new JLabel("USERS");
		lblNewLabel.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		lblNewLabel.setBounds(158, 280, 89, 31);
		pnlBackground_1.add(lblNewLabel);
		
		lblTransactions = new JLabel("TRANSACTIONS");
		lblTransactions.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 20));
		lblTransactions.setBounds(158, 449, 220, 31);
		pnlBackground_1.add(lblTransactions);
		
		panel_1 = new JPanel();
		RoundedCorners panel_1 = new RoundedCorners(40, Color.WHITE);
		panel_1.setBounds(435, 491, 691, 326);
		pnlBackground_1.add(panel_1);
		panel_1.setLayout(null);
		
		tblRecentTransactions = new JTable();
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
		tblRecentTransactions.setBounds(10, 32, 671, 283);
		panel_1.add(tblRecentTransactions);
		
		lblNewLabel_1 = new JLabel("Recent Transactions");
		lblNewLabel_1.setFont(new Font("Rockwell Condensed", Font.BOLD, 20));
		lblNewLabel_1.setBounds(21, 11, 193, 24);
		panel_1.add(lblNewLabel_1);
		
		lblCurentDateTime = new JLabel("New label");
		lblCurentDateTime.setFont(new Font("Rockwell Condensed", Font.PLAIN, 25));
		lblCurentDateTime.setBounds(168, 90, 241, 31);
		pnlBackground_1.add(lblCurentDateTime);
		
		lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(116, 0, 234, 79);
		pnlBackground_1.add(lblNewLabel_4);
		lblNewLabel_4.setIcon(new ImageIcon(logo));
	}
}
