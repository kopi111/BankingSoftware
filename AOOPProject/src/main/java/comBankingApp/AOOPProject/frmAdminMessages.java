package comBankingApp.AOOPProject;

import java.awt.EventQueue;
import java.awt.Font;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class frmAdminMessages {

	private JFrame frmAdminMessages;
	private JTextField txtMessage;
	
	static JTextArea txtMessageArea = new JTextArea();
	
	static ServerSocket ss;
	static Socket s;
	static DataInputStream din;
	static DataOutputStream dout;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmAdminMessages window = new frmAdminMessages();
					window.frmAdminMessages.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		
		String messageIn = "";
		try {
			ss = new ServerSocket(1201);
			s = ss.accept();
			
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());
			
			while(!messageIn.equals("exit")) {
				messageIn = din.readUTF();
				txtMessageArea.setText(txtMessageArea.getText().trim() + "\n Client: " + messageIn);
			}
			din.close();
			dout.close();
			s.close();
		}
		catch(Exception ex) {
			
		}
	}

	/**
	 * Create the application.
	 */
	public frmAdminMessages() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAdminMessages = new JFrame();
		frmAdminMessages.setTitle("AdminMessages");
		frmAdminMessages.setBounds(100, 100, 520, 420);
		frmAdminMessages.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAdminMessages.getContentPane().setLayout(null);
		txtMessageArea.setBackground(Color.WHITE);
		txtMessageArea.setEditable(false);
		
		//JTextArea txtMessageArea = new JTextArea();
		txtMessageArea.setFont(new Font("Monospaced", Font.PLAIN, 15));
		txtMessageArea.setBounds(10, 11, 484, 298);
		frmAdminMessages.getContentPane().add(txtMessageArea);
		
		txtMessage = new JTextField();

		txtMessage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtMessage.setBounds(10, 320, 350, 50);
		frmAdminMessages.getContentPane().add(txtMessage);
		txtMessage.setColumns(10);
		
		JButton btnSend = new JButton("Send");
		btnSend.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String messageOut = "";
					messageOut = txtMessage.getText().trim();
					txtMessageArea.append("\n");
					txtMessageArea.append(" You: " + messageOut);
					dout.writeUTF(messageOut);
				}
				catch(Exception ex) {
					
				}
			}
		});
		btnSend.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSend.setBounds(370, 318, 124, 52);
		frmAdminMessages.getContentPane().add(btnSend);
	}
	
	public void setVisible(boolean b) {
		frmAdminMessages.setVisible(true);
	}
}
