package comBankingApp.AOOPProject;

import java.util.List;
import java.util.Random;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.BasicConfigurator;
import org.hibernate.Session;

public interface  allMethods {
	
	

	public accountInformation deposite(accountInformation accountInfo);
	
	
	public accountInformation withdram (accountInformation accountInfo);
	
	 public userInformation  testCredentials (userInformation user);
	 
	 public userInformation  decrementAttempt (userInformation user) ;
	
	 
	 public  void saveNewCustomer (customerInformation customer1);
	 
	 
	 public int generateAccountNumber() ;
	 
	 
	 public  customerInformation generateCustomerInfo (int accountNumber);
	
	 public void updateCustomerInfo2(customerInformation customer1) ;
 
	 
	 public void transferfromCustomertoCustomer(int userAccountNumer , int cusAccountNumber, float amount);
	 
	 public transactionClass Deposite(transactionClass tranClass) ;
	  public List<transactionInformation> getTransaction(transactionInformation information) ;

   
	  public transactionClass loanPay(transactionClass tranClass) ;
	  
	  public userInformation changeUserLogin(userInformation user);

	  public void  deleteCustomer(int account1);
}
