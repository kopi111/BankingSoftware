package comBankingApp.AOOPProject;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="account_information")
public class accountInformation  {
	
	@Id
	@Column(name="account_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name="account_number")
	private int accountNumber;
	
	@Column(name="loan_amount")
	private float loanAmmount;
	
	@Column(name="account_Balane")
	private float accountBalance;
	
	@Column(name="trans")
	private float tran;
	
	@OneToOne(mappedBy="accountInform", cascade= CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="transaction_id")
	private transactionInformation  trans = new transactionInformation();
	
	@OneToOne(mappedBy="accountinfo",cascade= CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="account_id")
	private customerInformation customer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	public float getLoanAmmount() {
		return loanAmmount;
	}

	public void setLoanAmmount(float loanAmmount) {
		this.loanAmmount = loanAmmount;
	}


	public void setAccountBalance(float f) {
		this.accountBalance = f;
	}

	public transactionInformation getTrans() {
		return trans;
	}

	public void setTrans(transactionInformation trans) {
		this.trans = trans;
	}


	public accountInformation(int id, int accountNumber, float loanAmmount, int accountBalance,
			transactionInformation trans, customerInformation customer) {
		super();
		this.id = id;
		this.accountNumber = accountNumber;
		this.loanAmmount = loanAmmount;
		this.accountBalance = accountBalance;
		this.trans = trans;
	
	}
	
	public accountInformation( int accountNumber, float loanAmmount, float accountBalance) {
		
		
		this.accountNumber = accountNumber;
		this.loanAmmount = loanAmmount;
		this.accountBalance = accountBalance;
		
	}
	

	public accountInformation( ) {
		
		
		this.accountNumber = accountNumber;
		this.loanAmmount = loanAmmount;
		this.accountBalance = accountBalance;
		
	}

	public float getAccountBalance() {
		return accountBalance;
	}

	public float getTran() {
		return tran;
	}

	public void setTran(float tran) {
		this.tran = tran;
	}

	
}
