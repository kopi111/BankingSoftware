package comBankingApp.AOOPProject;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import javax.swing.border.MatteBorder;
import javax.swing.border.SoftBevelBorder;

import org.apache.log4j.BasicConfigurator;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.border.BevelBorder;
import java.awt.Component;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.util.Map;
import javax.swing.JList;
import javax.swing.JCheckBox;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class UserLogin {
	
	
	


	
	private JFrame frmUserLogin;
	private JTextField txtUserName;
	private JPasswordField txtUserPassword;
	private JPanel pnlLogin_1;
	private JPanel pnlLogin;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserLogin window = new UserLogin();
					window.frmUserLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the application.
	 */
	public UserLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		frmUserLogin = new JFrame();
		frmUserLogin.setBounds(100, 100, 840, 510);
		frmUserLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUserLogin.getContentPane().setBackground(new Color(230, 230, 250));
		frmUserLogin.setTitle("User Login");
		frmUserLogin.setUndecorated(true);
		
	
		frmUserLogin.setBackground(new Color(0,0,0,0));
		frmUserLogin.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		
		JPanel pnlLogin_1 = new JPanel();
		Image seepassword = new ImageIcon(this.getClass().getResource("/search.png")).getImage();
		
		Image bckground = new ImageIcon(this.getClass().getResource("/Gradient.jpg")).getImage();
		frmUserLogin.setLocationRelativeTo(null);
		Image exitIcon= new ImageIcon(this.getClass().getResource("/Sign Out Icon.png")).getImage();
		pnlLogin = new RoundedCorners(30);
		pnlLogin.setBounds(10, 11, 818, 488);
		frmUserLogin.getContentPane().add(pnlLogin);
		pnlLogin.setBackground(new Color(65, 105, 225));
		
		pnlLogin.setBorder(null);
		pnlLogin.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 60));
		lblNewLabel_2.setBounds(397, 11, 235, 77);
		pnlLogin.add(lblNewLabel_2);
		
		final JLabel lblLogin = new JLabel("");
		lblLogin.addMouseListener(new MouseAdapter() {
			
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
		
			}
		});
		lblLogin.setBounds(306, 329, 400, 57);
		pnlLogin.add(lblLogin);
		lblLogin.setBackground(new Color(65, 105, 225));
		lblLogin.setIcon(new ImageIcon(UserLogin.class.getResource("/log.gif")));
		lblLogin.setFont(new Font("Rockwell Extra Bold", Font.PLAIN, 18));
		lblLogin.setVisible(false);
		
		final JButton btnLogIn = new JButton("Log In");
		btnLogIn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				btnLogIn.setForeground(Color.black);
				int callFunction =2;
				try{
					BasicConfigurator.configure();
					 ApplicationContext beanFactory = new ClassPathXmlApplicationContext("SpringFrameWork.xml");
					 userInformation  user=  (userInformation) beanFactory.getBean("ui");
					 userInformation  user1=  (userInformation) beanFactory.getBean("ui");
					 customerMethods cm= (customerMethods)  beanFactory.getBean("cm");
					 customerInformation customerInfo1 =(customerInformation) beanFactory.getBean("ci");

			    	
			    	 
			    	
					
			        user.setUserName(txtUserName.getText().toString());
			        user.setPassword(txtUserPassword.getText().toString());
			        
			        String name  = txtUserName.getText();
			       String password = txtUserPassword.getText();
			       String name2  = "worker";
			       
			       String password2 = "worker";
			       
			        if (user.getUserName().isEmpty()){
			            txtUserName.setBackground(Color.red);
			            int input = JOptionPane.showConfirmDialog(null, 
				        "User cant be empty", "", JOptionPane.DEFAULT_OPTION);
			            callFunction=callFunction-1;
			            
			        }
			         if (user.getPassword().isEmpty() && callFunction==2 ){
			        	 
			        	 
			           txtUserPassword.setBackground(Color.red);
			           
			           int input = JOptionPane.showConfirmDialog(null, 
			                   "Password cant be empty", "", JOptionPane.DEFAULT_OPTION);
			           		callFunction=callFunction-1;
			       }
			        
			         
			         
			        if (callFunction == 2 ) { 
			        	
			        	if(name.equals(name2)  || password.equals(password2) ) {
			        		 BasicConfigurator.configure();
			        	workerLogin wLogin = new workerLogin();
			        	wLogin.setvisibility(true);
			       
			        	frmUserLogin.setVisible(false);
			        	
			        	
			        	}
			        	
			        
			        	
			        	else {
			        
			        	user1=cm.testCredentials(user); 
			        	
			        	
			        }
			        	
			        	
			        	
				         if(user1.getAccountNumber()==0 ) {
				        	 
				        	   int input = JOptionPane.showConfirmDialog(null, 
					                   user1.getMessage(), "", JOptionPane.DEFAULT_OPTION);
				         
				         
				         }
				         else {
				        	 
				        	 customerInfo1= cm.generateCustomerInfo(user1.getAccountNumber());			         		
				         		DashboardUser userDash = new DashboardUser(customerInfo1);
				         		userDash.setVisible(true);
				         		
				      
				         		frmUserLogin.setVisible(false);
				         }
				         
				         
				         
				         	
				         
				         
				         	if (user1.getUserType()=="customer") {
				         		
				         		
				         		customerInfo1= cm.generateCustomerInfo(user1.getAccountNumber());			         		
				         		DashboardUser userDash = new DashboardUser(customerInfo1);
				         		userDash.setVisible(true);
				         		
				      
				         		frmUserLogin.setVisible(false);
				         		
				         	}
				         	
			        } 	
				         		
			     }
			        
			
			     catch(Exception ex){
			   	  int input = JOptionPane.showConfirmDialog(null, 
			                 "Wrong user was enter", "", JOptionPane.DEFAULT_OPTION);
			        // dispose();
			     }
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				btnLogIn.setForeground(Color.white);
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				btnLogIn.setBackground(new Color(65, 105, 225));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				btnLogIn.setBackground(new Color(25, 25, 112));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				btnLogIn.setVisible(false);
				lblLogin.setVisible(true);
				/*try {
					DashboardUser frmUser = new DashboardUser();

					Thread.sleep(5000);
					frmUserLogin.setVisible(false);
					frmUser.setVisible(true);
					
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}*/
			}
		});
		btnLogIn.setBounds(306, 329, 403, 57);
		pnlLogin.add(btnLogIn);
		btnLogIn.setFont(new Font("Rockwell Extra Bold", Font.BOLD | Font.ITALIC, 30));
		btnLogIn.setForeground(Color.WHITE);
		btnLogIn.setBackground(new Color(25, 25, 112));
		btnLogIn.setBorder(new SoftBevelBorder(BevelBorder.RAISED, new Color(106, 90, 205), new Color(0, 0, 205), new Color(0, 0, 205), new Color(0, 0, 205)));
		
		//JPanel pnlWelcome = new JPanel();
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBounds(242, 253, 144, 20);
		pnlLogin.add(lblPassword);
		lblPassword.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 20));
		
		JLabel lblClose = new JLabel("hhhhhhhhhhhhhhhhhhhhhhhh");
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setBorder(null);
		lblUsername.setBounds(242, 152, 144, 29);
		pnlLogin.add(lblUsername);
		lblUsername.setFont(new Font("Rockwell Extra Bold", Font.BOLD, 20));
		
		txtUserName = new JTextField();
		txtUserName.setFont(new Font("Rockwell Condensed", Font.PLAIN, 18));
		txtUserName.setBounds(422, 148, 303, 38);
		pnlLogin.add(txtUserName);
		txtUserName.setBackground(new Color(255, 255, 255));
		txtUserName.setBorder(new LineBorder(new Color(0, 0, 139), 4, true));
		txtUserName.setColumns(10);
		
		txtUserPassword = new JPasswordField();
		txtUserPassword.setFont(new Font("Rockwell Condensed", Font.PLAIN, 18));
		txtUserPassword.setBounds(422, 245, 303, 38);
		pnlLogin.add(txtUserPassword);
		txtUserPassword.setBackground(new Color(255, 255, 255));
		txtUserPassword.setBorder(new LineBorder(new Color(0, 0, 139), 4, true));
		
		JLabel lbltry = new JLabel("X");
		lbltry.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				System.exit(0);
			}
		});
		lbltry.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbltry.setForeground(Color.WHITE);
		lbltry.setBounds(788, 11, 46, 29);
		pnlLogin.add(lbltry);
		
		JCheckBox chckbxPassword = new JCheckBox("");
		chckbxPassword.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
		        if (e.getStateChange() == ItemEvent.SELECTED) {
		            //txtUserPassword.setEchoChar('*');
		       // } else {
		        	txtUserPassword.setEchoChar((char) 0);
		        }
		        else {
		        	txtUserPassword.setEchoChar('*');
		        }
		    }
			
				
			
			
			
			
		});
		chckbxPassword.setOpaque(false);
		chckbxPassword.setBounds(748, 250, 35, 23);
		pnlLogin.add(chckbxPassword);
		
		JLabel lblLoginBackground = new JLabel("X");
		lblLoginBackground.setFont(new Font("Tahoma", Font.BOLD, 33));
		lblLoginBackground.setBounds(203, 0, 616, 488);
		pnlLogin.add(lblLoginBackground);
		lblLoginBackground.setIcon(new ImageIcon(bckground));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 0, 191, 488);
		pnlLogin.add(lblNewLabel);
		lblNewLabel.setIcon(new ImageIcon(UserLogin.class.getResource("/outkast1.jpg")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(0, 0, 207, 488);
		pnlLogin.add(panel_1);
		panel_1.setLayout(null);
		
	
		lblClose.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblClose.setBackground(Color.YELLOW);
		lblClose.setBounds(762, 11, 46, 38);
		pnlLogin.add(lblClose);
		
		
		
		
		
		Image footerbackground = new ImageIcon(this.getClass().getResource("/Gradient.jpg")).getImage();
	}
}
