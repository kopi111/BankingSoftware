package comBankingApp.AOOPProject;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class changeUserInfo {

	

	
	
	private JFrame frame;
	private JTextField txtUserName1;
	private JTextField txtUserName2;
	private JTextField textPasswor1;
	private JTextField textPassword2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changeUserInfo window = new changeUserInfo(null);
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @param user1 
	 */
	
	customerInformation user = new  customerInformation();
	private JLabel lblU;
	private JLabel lblNewLabel_1;
	private JLabel lblbckground;
	private JLabel lblExit;
	
	public changeUserInfo(customerInformation user1) {
		initialize();
		user=user1;
	}

	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 505, 579);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtUserName1 = new JTextField();
		txtUserName1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char C= evt.getKeyChar();
				
				if(C==KeyEvent.VK_BACK_SPACE||C==KeyEvent.VK_SPACE||C==KeyEvent.VK_DELETE) {
					evt.consume();
				}
			}
		});
		txtUserName1.setBorder(new MatteBorder(6, 0, 1, 6, (Color) new Color(255, 255, 255)));
		txtUserName1.setBackground(Color.CYAN);
		txtUserName1.setBounds(79, 128, 310, 40);
		frame.getContentPane().add(txtUserName1);
		txtUserName1.setColumns(10);
		
		txtUserName2 = new JTextField();
		txtUserName2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char C=evt.getKeyChar();
				
				if(C==KeyEvent.VK_SPACE||C==KeyEvent.VK_DELETE||C==KeyEvent.VK_BACK_SPACE) {
					evt.consume();
				}
			}
		});
		txtUserName2.setBackground(Color.CYAN);
		txtUserName2.setBorder(new MatteBorder(6, 0, 0, 6, (Color) Color.WHITE));
		txtUserName2.setColumns(10);
		txtUserName2.setBounds(79, 210, 310, 40);
		frame.getContentPane().add(txtUserName2);
		
		textPasswor1 = new JTextField();
		textPasswor1.setBorder(new MatteBorder(6, 0, 0, 6, (Color) Color.WHITE));
		textPasswor1.setBackground(Color.CYAN);
		textPasswor1.setColumns(10);
		textPasswor1.setBounds(79, 303, 310, 40);
		frame.getContentPane().add(textPasswor1);
		
		textPassword2 = new JTextField();
		textPassword2.setBorder(new MatteBorder(6, 0, 0, 6, (Color) Color.WHITE));
		textPassword2.setBackground(Color.CYAN);
		textPassword2.setColumns(10);
		textPassword2.setBounds(79, 396, 310, 40);
		frame.getContentPane().add(textPassword2);
		
		JLabel lblUserName1 = new JLabel("User Name");
		lblUserName1.setForeground(Color.WHITE);
		lblUserName1.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblUserName1.setBounds(70, 90, 128, 31);
		frame.getContentPane().add(lblUserName1);
		
		JLabel lblUserName2 = new JLabel("User Name 2");
		lblUserName2.setForeground(Color.WHITE);
		lblUserName2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblUserName2.setBounds(70, 179, 148, 31);
		frame.getContentPane().add(lblUserName2);
		
		JLabel lblPassword = new JLabel("Password ");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPassword.setBounds(70, 261, 128, 31);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblPassword_2 = new JLabel("Password 2");
		lblPassword_2.setForeground(Color.WHITE);
		lblPassword_2.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPassword_2.setBounds(70, 354, 128, 31);
		frame.getContentPane().add(lblPassword_2);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setBorder(new MatteBorder(6, 6, 6, 6, (Color) new Color(0, 255, 255)));
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				int  callFunction=2;
				
				String userName1= txtUserName1.getText();
				String userName2= txtUserName2.getText();
				String password= textPasswor1.getText();
				String password2= textPassword2.getText();
				
				
			        if (userName1.isEmpty()){
			        	txtUserName1.setBackground(Color.red);
			            int input = JOptionPane.showConfirmDialog(null, 
				        "User name  cant be empty", "", JOptionPane.DEFAULT_OPTION);
			            callFunction=callFunction-1;
			            
			        }
			         if (userName2.isEmpty()){
			        	 
			        	 txtUserName2.setBackground(Color.red);
			           int input = JOptionPane.showConfirmDialog(null, 
			                   "User name 2 cant be empty", "", JOptionPane.DEFAULT_OPTION);
			           		callFunction=callFunction-1;
			       }
			         
			         if (password.isEmpty()){
			        	 textPasswor1.setBackground(Color.red);
				            int input = JOptionPane.showConfirmDialog(null, 
					        "Password one  cant be empty", "", JOptionPane.DEFAULT_OPTION);
				            callFunction=callFunction-1;
				            
				        }
				         if (userName2.isEmpty()){
				        	 
				        	 textPassword2.setBackground(Color.red);
				           int input = JOptionPane.showConfirmDialog(null, 
				                   "Password 2 cant be empty", "", JOptionPane.DEFAULT_OPTION);
				           		callFunction=callFunction-1;
				       }
			        
			        
				         	if (callFunction == 2 ) { 
			        			
				         		customerInformation user1= new customerInformation();
				         		userInformation login = new userInformation();
				         		user1=user;
				         		System.out.print(user1.getAccountNumber());
				         		
				         		
				         		
				         		login.setUserName(userName1);
				         		login.setAttempts(3);
				         		
				         		login.setPassword(password);
				         		user1.setUser_info(login);
				         		
				         		
				         		customerMethods cm = new customerMethods();
				         		
				         		cm.changeUserLogin(user1);
				         }
				         	else {
				         		
				         		
				         	}
			}
		});
				
		
		btnNewButton.setBounds(322, 473, 128, 56);
		frame.getContentPane().add(btnNewButton);
		
		lblU = new JLabel("U");
		lblU.setFont(new Font("Script MT Bold", Font.BOLD, 70));
		lblU.setForeground(Color.CYAN);
		lblU.setBounds(124, 11, 68, 66);
		frame.getContentPane().add(lblU);
		
		lblNewLabel_1 = new JLabel("pdate User");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 31));
		lblNewLabel_1.setForeground(Color.CYAN);
		lblNewLabel_1.setBounds(178, 29, 186, 50);
		frame.getContentPane().add(lblNewLabel_1);
		
		lblExit = new JLabel("");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblExit.setBounds(435, 0, 44, 40);
		frame.getContentPane().add(lblExit);
		Image exit = new ImageIcon(this.getClass().getResource("/Sign Out Icon.png")).getImage();
		lblExit.setIcon(new ImageIcon( exit ));
		
		
		lblbckground = new JLabel("");
		lblbckground.setBounds(0, 0, 489, 540);
		frame.getContentPane().add(lblbckground);
		Image bckground = new ImageIcon(this.getClass().getResource("/Gradient.jpg")).getImage();
		lblbckground.setIcon(new ImageIcon( bckground ));
		
		
	}

	public void setVisible(boolean b) {
		frame.setVisible(true);
		
	}
}
