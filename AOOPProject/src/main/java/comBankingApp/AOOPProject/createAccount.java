package comBankingApp.AOOPProject;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import javax.xml.bind.ParseConversionEvent;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class createAccount {

	private JFrame frmRegister;
	private JTextField txtFirstName;
	private JTextField txtLastName;
	private JTextField txtEmail;
	private JTextField txtStreetNameAndNumber;
	private JTextField txtCityAndParish;
	private JTextField txtTelephone;
	private JPanel panel_2;
	private JPanel panel_3;
	private JTextField txtAge;
	private JTextField txtOpenBalance;
	private JTextField txtDob;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					createAccount window = new createAccount();
					window.frmRegister.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public createAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRegister = new JFrame();
		
		frmRegister.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmRegister.getContentPane().setBackground(new Color(230, 230, 250));
		frmRegister.setTitle("Registration");
		frmRegister.setUndecorated(true);
		frmRegister.setBounds(134, 0, 517, 785);
	
		frmRegister.setBackground(new Color(0,0,0,0));
		frmRegister.getContentPane().setLayout(null);
		frmRegister.setLocationRelativeTo(null);
		
		JPanel panel = new JPanel();
		panel_2=new RoundedCorners(20);
		panel_2.setBounds(0, 0, 715, 785);
		frmRegister.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		//panel_1.setBackground(new Color(65, 105, 225));
		panel_3=new RoundedCorners(50,new Color(0, 51, 102));
		//panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 3, true));
		
		panel_3.setBounds(0, 33, 640, 716);
		panel_2.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(new Color(255, 255, 255));
		lblLastName.setFont(new Font("Rockwell Condensed", Font.PLAIN, 23));
		lblLastName.setBounds(73, 144, 89, 29);
		panel_3.add(lblLastName);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(new Color(255, 255, 255));
		lblFirstName.setFont(new Font("Rockwell Condensed", Font.PLAIN, 23));
		lblFirstName.setBounds(71, 64, 111, 22);
		panel_3.add(lblFirstName);
		
		JLabel lblStreetNameAndNumber = new JLabel("Street Number & Street Name");
		lblStreetNameAndNumber.setForeground(new Color(255, 255, 255));
		lblStreetNameAndNumber.setFont(new Font("Rockwell Condensed", Font.PLAIN, 23));
		lblStreetNameAndNumber.setBounds(33, 240, 241, 29);
		panel_3.add(lblStreetNameAndNumber);
		
		JLabel lblTelephone = new JLabel("Telephone");
		lblTelephone.setForeground(new Color(255, 255, 255));
		lblTelephone.setFont(new Font("Rockwell Condensed", Font.PLAIN, 23));
		lblTelephone.setBounds(208, 510, 111, 31);
		panel_3.add(lblTelephone);
		
		JLabel lblDateOfBirth = new JLabel("Date Of Birth");
		lblDateOfBirth.setForeground(new Color(255, 255, 255));
		lblDateOfBirth.setFont(new Font("Rockwell Condensed", Font.PLAIN, 23));
		lblDateOfBirth.setBounds(380, 61, 101, 29);
		panel_3.add(lblDateOfBirth);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(255, 255, 255));
		lblEmail.setFont(new Font("Rockwell Condensed", Font.PLAIN, 23));
		lblEmail.setBounds(231, 417, 55, 29);
		panel_3.add(lblEmail);
		
		JLabel lblCity = new JLabel("City & Parish");
		lblCity.setForeground(new Color(255, 255, 255));
		lblCity.setFont(new Font("Rockwell Condensed", Font.PLAIN, 23));
		lblCity.setBounds(208, 327, 111, 36);
		panel_3.add(lblCity);
		
		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(255, 255, 255));
		lblAge.setFont(new Font("Rockwell Condensed", Font.PLAIN, 23));
		lblAge.setBounds(273, 64, 46, 22);
		panel_3.add(lblAge);
		
		txtFirstName = new JTextField();
		txtFirstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char C= evt.getKeyChar();
				
				if(!Character.isLetter(C)||C==KeyEvent.VK_SPACE||C==KeyEvent.VK_DELETE||C==KeyEvent.VK_DELETE) {
					evt.consume();
				}
			}
		});
		txtFirstName.setBounds(10, 97, 215, 36);
		panel_3.add(txtFirstName);
		txtFirstName.setColumns(10);
		
		txtLastName = new JTextField();
		txtLastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char C= evt.getKeyChar();
				
				if(!Character.isLetter(C)||C==KeyEvent.VK_SPACE||C==KeyEvent.VK_DELETE||C==KeyEvent.VK_DELETE) {
					evt.consume();
				}
			}
			
		});
		txtLastName.setColumns(10);
		txtLastName.setBounds(10, 184, 215, 32);
		panel_3.add(txtLastName);
		
		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char C= evt.getKeyChar();
				if(C==evt.VK_SPACE) {
					evt.consume();
					
				}
					
			}
		});
		txtEmail.setBounds(14, 457, 467, 42);
		panel_3.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtStreetNameAndNumber = new JTextField();
		txtStreetNameAndNumber.setBounds(14, 280, 260, 42);
		panel_3.add(txtStreetNameAndNumber);
		txtStreetNameAndNumber.setColumns(10);
		
		txtCityAndParish = new JTextField();
		txtCityAndParish.setBounds(10, 362, 471, 44);
		panel_3.add(txtCityAndParish);
		txtCityAndParish.setColumns(10);
		
		txtTelephone = new JTextField();
		txtTelephone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char C= evt.getKeyChar();
				
				if(!Character.isDigit(C)||C==evt.VK_SPACE||txtTelephone.getText().length()>=10) {
					evt.consume();
				}
			}
		});
		txtTelephone.setBounds(151, 549, 215, 36);
		panel_3.add(txtTelephone);
		txtTelephone.setColumns(10);
		
		//JDateChooser dateChooser = new JDateChooser();
		//dateChooser.setBounds(10, 140, 102, 20);
		//panel_3.add(dateChooser);
		
		Image background= new ImageIcon(this.getClass().getResource("/Gradient.jpg")).getImage();
		
		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			try {
				
				
				
				ApplicationContext beanFactory = new ClassPathXmlApplicationContext("SpringFrameWork.xml");
				
				 customerInformation customer  = (customerInformation) beanFactory.getBean("ci");
				 customerAddress address = (customerAddress) beanFactory.getBean("ca");
				 accountInformation account = (accountInformation) beanFactory.getBean("aci");
				
				
				 
				
				
				txtFirstName.setBackground(Color.white);
		        txtLastName.setBackground(Color.white);
		        txtStreetNameAndNumber.setBackground(Color.white);
		        txtCityAndParish.setBackground(Color.white);
		        txtTelephone.setBackground(Color.white);
		        txtEmail.setBackground(Color.white);
		        
		        boolean val  = true;
		        
		                if(txtFirstName.getText().isEmpty() || txtLastName.getText().isEmpty() || txtStreetNameAndNumber.getText().isEmpty() ||
		                		txtCityAndParish.getText().isEmpty() || txtTelephone.getText().isEmpty() || txtEmail.getText().isEmpty() || txtOpenBalance.getText().isEmpty()	){
		                 
		                    if(txtFirstName.getText().isEmpty()){
		                    	txtFirstName.setBackground(Color.red);
		                    	 int input = JOptionPane.showConfirmDialog(null, 
		  			                   "First Name  cant be Empty", "", JOptionPane.DEFAULT_OPTION);
		                       
		                    }
		                        if(txtLastName.getText().isEmpty()){
		                        	txtLastName.setBackground(Color.red);
		                        	
		                        	int input = JOptionPane.showConfirmDialog(null, 
				  			                   "Last Name cant be Empty", "", JOptionPane.DEFAULT_OPTION);
		                           
		                        }
		                        
		                            if(txtStreetNameAndNumber.getText().isEmpty()){
		                            	txtStreetNameAndNumber.setBackground(Color.red);
		                            	int input = JOptionPane.showConfirmDialog(null, 
		 		  			                   "Street name cant be Empty", "", JOptionPane.DEFAULT_OPTION);
		                    
		                            }
		                            
		                            if(txtTelephone.getText().isEmpty()){
		                            	txtTelephone.setBackground(Color.red);
		                            	int input = JOptionPane.showConfirmDialog(null, 
		 		  			                   "Telephone cant be Empty", "", JOptionPane.DEFAULT_OPTION);
				                       
				                    }
				                        if(txtEmail.getText().isEmpty()){
				                        	txtEmail.setBackground(Color.red);
				                        	int input = JOptionPane.showConfirmDialog(null, 
						  			                   "Email cant be Empty", "", JOptionPane.DEFAULT_OPTION);
				                    
				                        }
				                        
				                        if(txtCityAndParish.getText().isEmpty()){
				                        	txtCityAndParish.setBackground(Color.red);
				                        	int input = JOptionPane.showConfirmDialog(null, 
						  			                   "Parish cant be Empty", "", JOptionPane.DEFAULT_OPTION);
				                      
				                        }
				                        
				                        if(txtAge.getText().isEmpty()){
				                        	
				                        	txtAge.setBackground(Color.red);
				                        	int input = JOptionPane.showConfirmDialog(null, 
				                        			
						  			                   "Age Cannot be empty", "", JOptionPane.DEFAULT_OPTION);
				                      
				                        }
				                        
				                        if(txtOpenBalance.getText().isEmpty()){
				                        	txtOpenBalance.setBackground(Color.red);
				                        	int input = JOptionPane.showConfirmDialog(null, 
				                        			
						  			                   "Age Cannot be empty", "", JOptionPane.DEFAULT_OPTION);
				                      
				                        }
		                            
		                                val=false;
		                }        
		               
		                     
		                        if(val == true){  
		                      
		       customerMethods cusmethods = (customerMethods) beanFactory.getBean("cm");            
		         
		       int accountnum = cusmethods.generateAccountNumber();
		       
		       customer.setAge(Integer.parseInt(txtAge.getText()));   
		       customer.setTelephone(Integer.parseInt(txtTelephone.getText()));
		       customer.setFirstName(txtFirstName.getText());
		       customer.setLastName(txtLastName.getText());
		       address.setAccountNumber(accountnum);
		       address.setstreetName(txtStreetNameAndNumber.getText());
		       customer.setEmail(txtEmail.getText());
		       address.setParish(txtCityAndParish.getText());
		       customer.setDob(txtDob.getText());
		       account.setAccountBalance(Integer.parseInt(txtOpenBalance.getText()));
		       account.setLoanAmmount(0);
		       account.setAccountNumber(accountnum);
		       customer.setAccountNumber(accountnum);
		       
		       
		       
		       customerInformation customer1 = new customerInformation(customer, address, account);
		       customer1.setAccountNumber(account.getAccountNumber());
		       System.out.println(customer1.getAccountNumber());
		       
		      
		      
		      
		      
		      cusmethods.saveNewCustomer(customer1);
		      
		      
		      
		      frmRegister.setVisible(false);
		      int input = JOptionPane.showConfirmDialog(null, 
	                   "Customer created", "", JOptionPane.DEFAULT_OPTION);
	           		
		      
		                        }
		                        
		                        
			

		       }   catch (Exception e1) {
           
            	int input = JOptionPane.showConfirmDialog(null, 
		                  "Error  creating customer", "", JOptionPane.DEFAULT_OPTION);
            	System.out.println(e1); 

    
                
		}
		                        
			}
		
		                        
		});
	
		
		
		
		
		
		btnRegister.setFont(new Font("Rockwell Condensed", Font.PLAIN, 17));
		btnRegister.setBackground(new Color(211, 211, 211));
		btnRegister.setBorder(new MatteBorder(2, 2, 2, 2, (Color) new Color(255, 255, 255)));
		btnRegister.setBounds(44, 596, 437, 44);
		panel_3.add(btnRegister);
		
		
		
		
		txtAge = new JTextField();
		txtAge.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c= evt.getKeyChar();
				if(!(Character.isDigit(c)|| (c==KeyEvent.VK_BACK_SPACE)||c==KeyEvent.VK_DELETE )) {
					evt.consume();
				}
			}
		});
		txtAge.setForeground(Color.BLACK);
		txtAge.setBounds(266, 99, 70, 32);
		panel_3.add(txtAge);
		txtAge.setColumns(10);
		
		
		
		JLabel lblOpenBalance = new JLabel("Balance");
		lblOpenBalance.setForeground(Color.WHITE);
//		lblOpenBalance.setFont(new Font("Rockwell Condensed", Font.PLAIN, 23));
//		lblOpenBalance.setBounds(326, 144, 89, 29);
		panel_3.add(lblOpenBalance);
		
		JLabel lblNewLabel_2 = new JLabel("Open Balance");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Rockwell Condensed", Font.PLAIN, 23));
		lblNewLabel_2.setBounds(307, 147, 161, 22);
		panel_3.add(lblNewLabel_2);
		
		txtOpenBalance = new JTextField();
		txtOpenBalance.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char c = evt.getKeyChar(); //Allows input of only Numbers and periods in the textfield
			    if ((Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_PERIOD)) {
			        String s = txtOpenBalance.getText();
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
		txtOpenBalance.setBounds(307, 181, 101, 38);
		panel_3.add(txtOpenBalance);
		txtOpenBalance.setColumns(10);
		
		txtDob = new JTextField();
		txtDob.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				char C= evt.getKeyChar();
				
				if(Character.isAlphabetic(C)) {
					evt.consume();
				}
			
			}
		});
		txtDob.setBounds(380, 101, 101, 32);
		panel_3.add(txtDob);
		txtDob.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(307, 280, 178, 42);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JLabel lblCommenity = new JLabel("Community");
		lblCommenity.setForeground(Color.WHITE);
		lblCommenity.setFont(new Font("Rockwell Condensed", Font.PLAIN, 23));
		lblCommenity.setBounds(335, 240, 241, 29);
		panel_3.add(lblCommenity);
		
		JPanel pnlFooter = new JPanel();
		//pnlFooter= new RoundedCorners(20);
		pnlFooter.setBounds(72, 723, 386, 62);
		panel_2.add(pnlFooter);
		pnlFooter.setLayout(null);
		
		JLabel lblCopyright = new JLabel("Coptright 2020");
		lblCopyright.setBounds(10, 22, 72, 14);
		lblCopyright.setForeground(new Color(255, 255, 255));
		pnlFooter.add(lblCopyright);
		
		JLabel lblNewLabel = new JLabel("Privacy Policy");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(304, 22, 72, 14);
		pnlFooter.add(lblNewLabel);
		
		JLabel lblFooterBackground = new JLabel("");
		lblFooterBackground.setBounds(0, 0, 384, 62);
		pnlFooter.add(lblFooterBackground);
		frmRegister.setLocationRelativeTo(null);
		Image footerbackground= new ImageIcon(this.getClass().getResource("/Gradient.jpg")).getImage();
		lblFooterBackground.setIcon(new ImageIcon(footerbackground));
		
		
		
		
		
		
		JLabel lblMinimize = new JLabel("X");
		lblMinimize.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmRegister.setVisible(false);
				
			}
		});
		lblMinimize.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblMinimize.setBounds(487, 1, 20, 23);
		panel_2.add(lblMinimize);
		
		JLabel lblExit = new JLabel("");
		lblExit.setBounds(391, 0, 36, 25);
		panel_2.add(lblExit);
		Image exitIcon= new ImageIcon(this.getClass().getResource("/Sign Out Icon.png")).getImage();
		lblExit.setIcon(new ImageIcon(exitIcon));
		
		JLabel lblBack = new JLabel("");
		lblBack.setBounds(357, 1, 36, 23);
		panel_2.add(lblBack);
		Image BackIcon= new ImageIcon(this.getClass().getResource("/go-back-arrow.png")).getImage();
		lblBack.setIcon(new ImageIcon(BackIcon));
		
		JLabel lblInfo = new JLabel("<html><center>Please note the following deposits upon registration: Loan Account - $5000 Shares Account - $10000 Saving Account- $1000 </center></html>");
		lblInfo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblInfo.setBounds(32, 699, 448, 23);
		panel_2.add(lblInfo);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Registration");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 23));
		lblNewLabel_1.setBounds(182, 11, 257, 23);
		panel_2.add(lblNewLabel_1);
	}

	public void setVisiable(boolean b) {
		frmRegister.setVisible(true);
		
	}
}
