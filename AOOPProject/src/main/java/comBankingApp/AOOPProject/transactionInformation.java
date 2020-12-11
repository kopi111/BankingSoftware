package comBankingApp.AOOPProject;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="Transaction")
public class transactionInformation {
	
	@Id
	@Column(name="transaction_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	
	@Column(name="account_number")
	private int accountNumber;


	@Column(name="tme")
	private String time;
	
	
	
	@Column(name="date")
	private String date;
	
	
	@Column(name="withdraw")
	private float withdraw;
	
	
	@Column(name="balance")
	private float balance;
	
	
	
	@Column(name="depositet")
	private float deposite;

	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.REMOVE})
	@JoinColumn(name="transaction_id2")
	private accountInformation accountInform;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Float getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(float withdraw) {
		this.withdraw = withdraw;
	}

	public float getDeposite() {
		return deposite;
	}

	public void setDeposite(float deposite) {
		this.deposite = deposite;
	}

	public accountInformation getAccountInfor() {
		return accountInform;
	}

	public void setAccountInfor(accountInformation accountInfor) {
		this.accountInform = accountInfor;
	}

	public transactionInformation( float withdraw, float deposite) {
	
		this.withdraw = withdraw;
		this.deposite = deposite;
		this.accountInform = accountInform;
	}


	public transactionInformation() {
		
		this.withdraw = withdraw;
		this.deposite = deposite;
		this.accountInform = accountInform;
	}






	public transactionInformation(int id, int accountNumber, String time, String date, float withdraw, float balance,
			float deposite, accountInformation accountInform) {
	
		this.id = id;
		this.accountNumber = accountNumber;
		this.time = time;
		this.date = date;
		this.withdraw = withdraw;
		this.balance = balance;
		this.deposite = deposite;
		this.accountInform = accountInform;
	}

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public accountInformation getAccountInform() {
		return accountInform;
	}

	public void setAccountInform(accountInformation accountInform) {
		this.accountInform = accountInform;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	
	
}
