package comBankingApp.AOOPProject;

public class transactionClass  {
	
	private int account1;
	private int account2;
	private float deposite1;
	private float deposite2;
	private String message1;
	private String message2;
	private float withdraw1;
	private float withdraw2;
	private float loanPayment;
	
	
	
	
	
	
	
	
	public float getLoanPayment() {
		return loanPayment;
	}
	
	
	
	public void setLoanPayment(float loanPayment) {
		this.loanPayment = loanPayment;
	}
	public int getAccount1() {
		return account1;
	}
	public void setAccount1(int account1) {
		this.account1 = account1;
	}
	public int getAccount2() {
		return account2;
	}
	public void setAccount2(int account2) {
		this.account2 = account2;
	}
	public float getDeposite1() {
		return deposite1;
	}
	public void setDeposite1(float deposite1) {
		this.deposite1 = deposite1;
	}
	public float getDeposite2() {
		return deposite2;
	}
	public void setDeposite2(float deposite2) {
		this.deposite2 = deposite2;
	}
	public String getMessage1() {
		return message1;
	}
	public void setMessage1(String message1) {
		this.message1 = message1;
	}
	public String getMessage2() {
		return message2;
	}
	public void setMessage2(String message2) {
		this.message2 = message2;
	}
	public float getWithdraw1() {
		return withdraw1;
	}
	public void setWithdraw1(float withdraw1) {
		this.withdraw1 = withdraw1;
	}
	public float getWithdraw2() {
		return withdraw2;
	}
	public void setWithdraw2(float withdraw2) {
		this.withdraw2 = withdraw2;
	}
	public transactionClass(int account1, int account2, float deposite1, float deposite2, String message1,
			String message2, float withdraw1, float withdraw2) {
		super();
		this.account1 = account1;
		this.account2 = account2;
		this.deposite1 = deposite1;
		this.deposite2 = deposite2;
		this.message1 = message1;
		this.message2 = message2;
		this.withdraw1 = withdraw1;
		this.withdraw2 = withdraw2;
	}
	
	
	public transactionClass() {
		this.account1 = account1;
		this.account2 = account2;
		this.deposite1 = deposite1;
		this.deposite2 = deposite2;
		this.message1 = message1;
		this.message2 = message2;
		this.withdraw1 = withdraw1;
		this.withdraw2 = withdraw2;
	}
	
}
