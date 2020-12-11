package comBankingApp.AOOPProject;

import javax.persistence.*;

@Entity
@Table(name="customer_information")
public class customerInformation {
	
	@Id
	@Column(name="account_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name="account_number")
	private int accountNumber;
	

	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="age")
	private int age;
	
	
	@Column(name="Email")
	private String email;
	
	@Column(name="telephone")
	private int telephone;
	

	@Column(name="date")
	private String dob;
	
	@OneToOne(cascade= CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="address_id_geneartion")
	private customerAddress address;
	
	
	@OneToOne(cascade= CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="user_id_geneartion")
	private userInformation  user_info;
	
	@OneToOne(cascade= CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="account_id_geneartion")
	private accountInformation accountinfo;
	

	
	public int getId() {
		return id;
	}
	
	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getTelephone() {
		return telephone;
	}

	public void setTelephone(int telephone) {
		this.telephone = telephone;
	}

	public customerAddress getAddress() {
		return address;
	}

	public void setAddress(customerAddress address) {
		this.address = address;
	}

	//public userInformation getUser_info() {
		//return user_info;
	//}

	//public void setUser_info(userInformation user_info) {
		//this.user_info = user_info;
	//}

	public accountInformation getAccountinfo() {
		return accountinfo;
	}

	public void setAccountinfo( accountInformation accountinfo) {
		this.accountinfo= accountinfo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public customerInformation( String firstName, String lastName, int age, String email,
			int telephone, String dob, customerAddress address, userInformation user_info, accountInformation accountinfo
			) {
		
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.telephone = telephone;
		this.address = address;
		//this.user_info = user_info;
		this.accountinfo = accountinfo;
		this.dob = dob;
	}


	public customerInformation( ) {
		
		this.accountNumber = accountNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.email = email;
		this.telephone = telephone;
		this.address = address;
	//	this.user_info = user_info;
		this.accountinfo = accountinfo;
		this.dob = dob;
	}



	public customerInformation(customerInformation cus ,customerAddress address,  accountInformation account){
		this.firstName = cus.firstName;
		this.lastName = cus.lastName;
		this.age = cus.age;
		this.email = cus.email;
		this.telephone = cus.telephone;
		this.address = address;
		//this.user_info = cus.user_info;
		this.accountinfo = cus.accountinfo;
		this.dob = cus.dob;
		this.accountinfo=account;
		}

	public userInformation getUser_info() {
		return user_info;
	}

	public void setUser_info(userInformation user_info) {
		this.user_info = user_info;
	}
	
	
	
}
