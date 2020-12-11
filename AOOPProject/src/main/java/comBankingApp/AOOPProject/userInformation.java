package comBankingApp.AOOPProject;

import javax.persistence.*;


@Entity
@Table(name="user_information")
public class userInformation  {
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	

	@Column(name="account_number")
	private int accountNumber;

	@Column(name="user_name")
	private String userName;
	
	@Column(name="password")
	private String password;
	
	@Column(name="attempts")
	private int attempts;
	
	@Column(name="message")
	private String message;
	
	@Column(name="user_type")
	private String userType;
	
	
	@OneToOne(mappedBy="user_info",cascade= CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name=" user_infoid")
	private customerInformation customer;

	
	
	

	public userInformation(int userId, String userName, String password, int attempts, String message, String userType,
			customerInformation customer) {
	this.userName = userName;
		this.password = password;
		this.attempts = attempts;
		this.message = message;
		this.userType = userType;
		//this.customer = customer;
	}

	public userInformation(String userName, String password, int attempts, String message, String userType ) {

		
		this.userName = userName;
		this.password = password;
		this.attempts = attempts;
		this.message = message;
		this.userType = userType;
		
	}
    
	public userInformation() {
	
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.attempts = attempts;
		this.message = message;
		this.userType = userType;
		//this.customer = customer;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getAttempts() {
		return attempts;
	}


	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getUserType() {
		return userType;
	}


	public void setUserType(String userType) {
		this.userType = userType;
	}


	//public customerInformation getCustomer() {
	//	return customer;
	//}


//	public void setCustomer(customerInformation customer) {
//		this.customer = customer;
	//}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	
	
	
	
	
	
	
}
