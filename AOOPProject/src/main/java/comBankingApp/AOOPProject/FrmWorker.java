package comBankingApp.AOOPProject;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.MatteBorder;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class FrmWorker {

	private JFrame frame;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtFirstName;
	private JLabel lblLastName;
	private JTextField txtLastName;
	workerClass workclass= new workerClass();
	workerLlogin workerlog= new workerLlogin();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmWorker window = new FrmWorker();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public FrmWorker() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 664);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWorkerUserName = new JLabel("Username");
		lblWorkerUserName.setForeground(Color.WHITE);
		lblWorkerUserName.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblWorkerUserName.setBounds(22, 126, 121, 30);
		frame.getContentPane().add(lblWorkerUserName);
		
		txtUserName = new JTextField();
		txtUserName.setBorder(new MatteBorder(0, 0, 4, 4, (Color) Color.CYAN));
		txtUserName.setBounds(169, 118, 205, 45);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPassword.setBounds(22, 195, 121, 30);
		frame.getContentPane().add(lblPassword);
		
		txtPassword = new JTextField();
		txtPassword.setBorder(new MatteBorder(0, 0, 4, 4, (Color) Color.CYAN));
		txtPassword.setColumns(10);
		txtPassword.setBounds(169, 193, 205, 42);
		frame.getContentPane().add(txtPassword);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setForeground(Color.WHITE);
		lblFirstName.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblFirstName.setBounds(22, 273, 129, 36);
		frame.getContentPane().add(lblFirstName);
		
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
		txtFirstName.setBorder(new MatteBorder(0, 0, 4, 4, (Color) Color.CYAN));
		txtFirstName.setColumns(10);
		txtFirstName.setBounds(169, 274, 205, 45);
		frame.getContentPane().add(txtFirstName);
		
		lblLastName = new JLabel("Last Name");
		lblLastName.setForeground(Color.WHITE);
		lblLastName.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblLastName.setBounds(22, 358, 121, 42);
		frame.getContentPane().add(lblLastName);
		
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
		txtLastName.setBorder(new MatteBorder(0, 0, 4, 4, (Color) Color.CYAN));
		txtLastName.setColumns(10);
		txtLastName.setBounds(169, 362, 205, 42);
		frame.getContentPane().add(txtLastName);
		
		JButton btnLogin = new JButton("Create ");
		btnLogin.setBorder(new MatteBorder(3, 3, 3, 3, (Color) Color.CYAN));
		btnLogin.setContentAreaFilled(false);
		btnLogin.setForeground(Color.CYAN);
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
			
			try {

				workerClass workclass = new workerClass();
				workerLlogin worklog = new workerLlogin();
				workerClass workclass2 = new workerClass();
				
				txtFirstName.setBackground(Color.white);
		        txtLastName.setBackground(Color.white);
		        txtPassword.setBackground(Color.white);
		      
		        txtUserName.setBackground(Color.white);
		    
		        
		        boolean val  = true;
		        
		                if(txtFirstName.getText().isEmpty() || txtLastName.getText().isEmpty() || txtPassword.getText().isEmpty() ||
		                		txtUserName.getText().isEmpty() 	){
		                 
		                    if(txtFirstName.getText().isEmpty()){
		                    	txtFirstName.setBackground(Color.red);
		                    	 int input = JOptionPane.showConfirmDialog(null, 
		  			                   "First Name  cant be Empty", "", JOptionPane.DEFAULT_OPTION);
		                    	 val=false;
		                       
		                    }
		                        if(txtLastName.getText().isEmpty()){
		                        	
		                        	txtLastName.setBackground(Color.red);
		                        	int input = JOptionPane.showConfirmDialog(null, 
				  			                   "Last Name cant be Empty", "", JOptionPane.DEFAULT_OPTION);
		                        	val=false;
		                           
		                        }
		                        
		                            if(txtUserName.getText().isEmpty()){
		                            	txtUserName.setBackground(Color.red);
		                            	int input = JOptionPane.showConfirmDialog(null, 
		 		  			                   "user name cant be Empty", "", JOptionPane.DEFAULT_OPTION);
		                            	val=false;
		                    
		                            }
		                            
		                            if(txtPassword.getText().isEmpty()){
		                            	txtPassword.setBackground(Color.red);
		                            	int input = JOptionPane.showConfirmDialog(null, 
		 		  			                   "password cant be Empty", "", JOptionPane.DEFAULT_OPTION);
				                       
				                
		                            
		                                val=false;
		                }        
		                }
		                     
		                        if(val == true){  
		                        	
		                        	
		       workerMethods workMet = new workerMethods();               
		       int id = workMet.workerID();
		       workclass.setFirstName(txtFirstName.getText());
		       workclass.setLastName(txtLastName.getText());
		       workclass.setWorkerIdNumbere(id);
		       worklog.setWorkerIdNumbere(id);
		       worklog.setWorkerUserName(txtUserName.getText());
		       worklog.setPassword(txtPassword.getText());
		       
		       worklog.setAttempts(3);
		       
		       workclass.setWorkerLog(worklog);
		      
		      
		       workclass2=workMet.saveNewWorker(workclass);
		       
		       
		       if (workclass2==null) {
		    	   int input = JOptionPane.showConfirmDialog(null, 
			                   "worker was not addded", "", JOptionPane.DEFAULT_OPTION); 
		    	   
		    	 
		    	   clear();

		       }
		       
		       else {
		    	   int input = JOptionPane.showConfirmDialog(null, 
		                   "worker was  addded", "", JOptionPane.DEFAULT_OPTION);
		    	
		    	  
		       }

		       }
		                        
		                        
		                        
		                }catch (Exception e1) {
           
            	int input = JOptionPane.showConfirmDialog(null, 
		                  "Error  creating customer", "", JOptionPane.DEFAULT_OPTION);
            		System.out.println(e1); 
		                }
    
			}
			
		});
		
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				workclass.setFirstName(txtFirstName.toString());
				workclass.setLastName(txtLastName.toString());
				
				
			}
		});
		btnLogin.setBounds(140, 472, 129, 42);
		frame.getContentPane().add(btnLogin);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBorder(new MatteBorder(4, 1, 4, 1, (Color) Color.CYAN));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clear();
			}
		});
		btnNewButton.setBounds(153, 545, 105, 45);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("egister worker");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(135, 31, 261, 45);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblR = new JLabel("R");
		lblR.setFont(new Font("Script MT Bold", Font.BOLD, 70));
		lblR.setForeground(Color.WHITE);
		lblR.setBounds(78, 11, 65, 82);
		frame.getContentPane().add(lblR);
		
		JLabel lblExit = new JLabel("");
		lblExit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblExit.setBounds(388, 0, 46, 30);
		frame.getContentPane().add(lblExit);
		Image exit = new ImageIcon(this.getClass().getResource("/Sign Out Icon.png")).getImage();
		lblExit.setIcon(new ImageIcon( exit ));
		
		JLabel lblbackground = new JLabel("New label");
		lblbackground.setBounds(0, 0, 434, 625);
		frame.getContentPane().add(lblbackground);
		Image bckground = new ImageIcon(this.getClass().getResource("/Gradient.jpg")).getImage();
		lblbackground.setIcon(new ImageIcon( bckground ));
		
		
	}
	
	public void setVisible(boolean b) {
		frame.setVisible(true);
	}
	
	
	public void clear() {
		
		txtFirstName.setText("");
		txtLastName.setText("");
		txtPassword.setText("");
		txtUserName.setText("");
		
		
	}
}
