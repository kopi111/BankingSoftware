package comBankingApp.AOOPProject;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import org.apache.log4j.BasicConfigurator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class workerLogin {

	private JFrame frame;
	private JTextField txtUserName;
	private JTextField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					workerLogin window = new workerLogin();
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
	public workerLogin() {
		System.out.println("test");
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 519);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		txtUserName = new JTextField();
		txtUserName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char C= evt.getKeyChar();
				
				if(C==KeyEvent.VK_DELETE||C==KeyEvent.VK_SPACE||C==KeyEvent.VK_BACK_SPACE) {
					evt.consume();
				}
			}
		});
		txtUserName.setBorder(new MatteBorder(0, 0, 4, 4, (Color) Color.CYAN));
		txtUserName.setBounds(54, 176, 303, 46);
		frame.getContentPane().add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBorder(new MatteBorder(0, 0, 4, 4, (Color) new Color(0, 255, 255)));
		txtPassword.setColumns(10);
		txtPassword.setBounds(54, 289, 303, 46);
		frame.getContentPane().add(txtPassword);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setContentAreaFilled(false);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 255, 255)));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				
				btnNewButton.setForeground(Color.black);
				int callFunction =2;
				try{
					workerLlogin user = new workerLlogin();
					workerLlogin user2 = new workerLlogin();
					workerClass workclass = new workerClass();
					
					
			        user.setWorkerUserName(txtUserName.getText());  
			        user.setPassword(txtPassword.getText());
			      
			       
			        if (user.getWorkerUserName().isEmpty()){
			            txtUserName.setBackground(Color.red);
			            int input = JOptionPane.showConfirmDialog(null, 
				        "User cant be empty", "", JOptionPane.DEFAULT_OPTION);
			            callFunction=callFunction-1;
			           
			            
			        }
			        if (user.getPassword().isEmpty() && callFunction==2 ){
			        	 
				           txtPassword.setBackground(Color.red);
				           int input = JOptionPane.showConfirmDialog(null, 
				                   "Password cant be empty", "", JOptionPane.DEFAULT_OPTION);
				           		callFunction=callFunction-1;
				       }
			        
			        if (callFunction == 2 ) { 
			        	
			        	workerMethods  worker = new workerMethods();
			        	
			        	user2=worker.testCredentials(user);
			        	
			        	
			        	
			        	if (user2.getAttempts()==2) {
			        		
			        		int id = user2.getWorkerIdNumbere();
				        	workclass = worker.getworkerInformation(id);
				        	DashboardAdmin dba= new DashboardAdmin(workclass);
			        		dba.setVisible(true);
				        	
			        	}
			        	
			        	if(user2.getAttempts()==1) {
			        		
			        		int input = JOptionPane.showConfirmDialog(null, 
					                   "user cant be empty", "", JOptionPane.DEFAULT_OPTION);
					           		callFunction=callFunction-1;
			        		
			        	}
			        	
			        	
			        
			}
			        
				}    
			        catch(Exception ex){
				 		
						
				 	}
				
			}
			
		});
		btnNewButton.setBounds(94, 399, 217, 46);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblUserName = new JLabel("Username");
		lblUserName.setForeground(Color.WHITE);
		lblUserName.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblUserName.setBounds(145, 124, 137, 41);
		frame.getContentPane().add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPassword.setBounds(145, 247, 124, 41);
		frame.getContentPane().add(lblPassword);
		
		JLabel lblLogi = new JLabel("elcome Worker!");
		lblLogi.setForeground(Color.CYAN);
		lblLogi.setFont(new Font("Tahoma", Font.BOLD, 26));
		lblLogi.setBounds(139, 32, 237, 72);
		frame.getContentPane().add(lblLogi);
		
		JLabel lblNewLabel = new JLabel("W");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setFont(new Font("Script MT Bold", Font.BOLD, 87));
		lblNewLabel.setBounds(62, 0, 119, 104);
		frame.getContentPane().add(lblNewLabel);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setContentAreaFilled(false);
		chckbxNewCheckBox.setBounds(365, 302, 21, 23);
		frame.getContentPane().add(chckbxNewCheckBox);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(378, 11, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		
		JLabel lblBackground = new JLabel("New");
		lblBackground.setBounds(0, 0, 434, 480);
		frame.getContentPane().add(lblBackground);
		Image bckground = new ImageIcon(this.getClass().getResource("/Gradient.jpg")).getImage();
		lblBackground.setIcon(new ImageIcon(bckground));
		
		
		
		
		
	}

	public void setvisibility(boolean b) {
		
		frame.setVisible(true);
		
	}
}
