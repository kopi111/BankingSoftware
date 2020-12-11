package comBankingApp.AOOPProject;
import java.awt.Component;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

import javax.persistence.*;
import javax.swing.JOptionPane;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.logging.log4j.core.tools.Generate.CustomLogger;
import org.hibernate.Criteria;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.apache.log4j.BasicConfigurator;


public class customerMethods  {
	
	
	
	private static final Logger logger = LogManager.getLogger(customerMethods.class); 
	FileHandler fh;
	
	
	public accountInformation deposite(accountInformation accountInfo) {
		
	 try {
		 
		 System.out.println("get down to buss");
		 
		 	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
			SimpleDateFormat dateFormats = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date();
			String frmtdDate = dateFormat.format(date);
			String time = dateFormats.format(date);
			
			
			
		Session session = hibernate.getSessionFactory();
		transactionInformation trans= new  transactionInformation(); 
		
		session.beginTransaction();
		float deposite =accountInfo.getTran();
		
	
		int account = accountInfo.getAccountNumber();
		accountInformation customer = new accountInformation();
		customer =null;
	
		
		  String Query = " FROM  accountInformation u  WHERE u.accountNumber = '" + account + "'";
		  TypedQuery<accountInformation> typedQuery = session.createQuery(Query,   accountInformation.class);
		  customer =  typedQuery.getSingleResult();
	        float balance = customer.getAccountBalance();
	        customer.setAccountBalance(deposite+balance);
	        
	        
	        
	       trans.setAccountNumber(accountInfo.getAccountNumber());
	       trans.setDeposite(deposite);
	       trans.setDate(frmtdDate);
	       trans.setDate(time);
	       trans.setBalance(customer.getAccountBalance());
	       customer.setTrans(trans);
	        session.persist(customer);	        
	        session.getTransaction().commit();
	        
	     
	        
	        return customer;
	         
	       
	        
	 }
	
	 	catch(Exception e){
	 		
	 		
	 		BasicConfigurator.configure();
	 		
	 		
	 		logger.info("Deposit"+e.getMessage());
		    logger.error("Deposit Failed"+e.getMessage());
		    logger.fatal("Account number was not created"+e.getMessage());
		    
		    accountInformation acc= new accountInformation();
		    acc.setAccountNumber(1);
		    return acc;
		    
	 	}
	 				
	        
		
	}
	
	
	
	
	public accountInformation withdram (accountInformation accountInfo) {
		
		
		
		
		try {
			
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
			SimpleDateFormat dateFormats = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date();
			String Date = dateFormat.format(date);
			String time = dateFormats.format(date);	
			
		Session session = hibernate.getSessionFactory();
		session.beginTransaction();
		
		float withdraw = accountInfo.getTran();
		int account = accountInfo.getAccountNumber();
		transactionInformation trans= new  transactionInformation();
		
		accountInformation customer = new accountInformation();
		customer =null;
		
		
		
		 String Query = " FROM  accountInformation u  WHERE u.accountNumber = '" + account + "'";
		 
		
		 
		  TypedQuery<accountInformation> typedQuery = session.createQuery(Query,   accountInformation.class);
		  
		
		  
		  customer = typedQuery.getSingleResult();
		
		  
	        float balance = customer.getAccountBalance();
	      
	        
	        if (balance >= withdraw) {
	        	
	        	float currentValue= balance-withdraw;
	        	
	        	customer.setAccountBalance(currentValue);
	        	trans.setAccountNumber(accountInfo.getAccountNumber());
	 	       trans.setWithdraw(withdraw);
	 	       trans.setDate(Date);
	 	       trans.setTime(time);
	 	       trans.setBalance(currentValue);
	 	       customer.setTrans(trans);
	        	session.persist(customer);
		        
		        session.getTransaction().commit();
	        	
		        return customer;
	        }     
	        
	        else {
	        	
	        	accountInformation acc= new accountInformation();
	   		    acc.setAccountNumber(2);
	   		    return acc;
	        }
			       
		        
	   	 }
	   	
	   	 	catch(Exception e){
	   	 		
	   	 		
	   	 		BasicConfigurator.configure();
	   	 	logger.info("withdraw"+e.getMessage());
		    logger.error("withdraw Failed"+e.getMessage());
		    logger.fatal("withdraw fail"+e.getMessage());
	
	   		    accountInformation acc= new accountInformation();
	   		    acc.setAccountNumber(1);
	   		    return acc;
	   		    
	   	 	
	   	 				
	   	 	}       
	   		
	   	}
	   	
	
	
	
	
	

	
	
	 public userInformation  testCredentials (userInformation user){
	
		try {
			
			
			Session session = hibernate.getSessionFactory();
			session.beginTransaction(); 
			
		    String password = user.getPassword();
		    String name = user.getUserName();
		   
		    
	        String loginQuery = " FROM  userInformation u  WHERE u.userName = '" + name + "' AND u.password = '" + password +"'";
	        userInformation customer = null; 
	        TypedQuery< userInformation> typedQuery = session.createQuery(loginQuery,  userInformation.class);
	      
	        customer = typedQuery.getSingleResult();
	      
	       
	        	if (customer != null) {
	        			
	        			session.close();
	    	  			return customer;
	    	  			
	        	}
	        
	        
	        
		}
		
		 	catch(Exception e){
		 	  
		 		
		 		BasicConfigurator.configure();
		 		logger.info("Login Unsuccessful"+e.getMessage());
		 		
			    logger.error("User not found"+e.getMessage());
				 logger.fatal("Hibernate session not loaded"+e.getMessage());
				 System.out.println("user not found");
				 userInformation customer = null;
				 customer=decrementAttempt(user);
				  return customer;
		 	}
		
		
	        return null;
		 
	  }
	 
	 
	 
	 
	 
	 
	 
	 public userInformation  decrementAttempt (userInformation user) {
		 
		 
		 try {
			
				Session session = hibernate.getSessionFactory();
				session.beginTransaction(); 
			
	       
	        	 String name=user.getUserName();
	    	     String Query2 = " FROM  userInformation u  WHERE u.userName = '" + name + "'";
	        	 userInformation customer2 = null; 
	        	  
	  	        TypedQuery< userInformation> attempQuery = session.createQuery(Query2,  userInformation.class);

	  	        customer2 = attempQuery.getSingleResult();
	  	        
	  	        int currentAttemp = customer2.getAttempts();
	  	        
	  	       
	  	        	if (currentAttemp==0) {
	  	        		customer2.setMessage("Use should contact bank");
	  	        		customer2.setAccountNumber(0);
	  	        		return customer2;
	  	        	}
	  	        		else {
	  	        	
	  	        	
	  	        		currentAttemp = currentAttemp-1;
	  	        		customer2.setAttempts(currentAttemp);
	  	        		session.persist(customer2);
	  	        		session.getTransaction().commit();
	  	        		customer2.setMessage("Use Have incorrect Login Information"+ customer2.getAttempts()+ " Attempts leave");
	  	        		customer2.setAccountNumber(0);
	  	        		return customer2;
	  	        		}
		 		} 
		 			catch(Exception e){
	  	    	  
	  	      
		 					BasicConfigurator.configure();
		 					logger.info("Decrement error"+e.getMessage());
			 				logger.error("decrement was not  found"+e.getMessage());
			 				 logger.fatal("Hibernate session not loaded"+e.getMessage());
			 				 return null;
	  	      }
		 				
		 }
		 
		 
	 
	 
	 
	 
	 
	 
	 
	
	 
	 public  void saveNewCustomer (customerInformation customer1) {
		 
	 try {
		Session session = hibernate.getSessionFactory();
		session.beginTransaction();  
		
		
		
		
		userInformation  user = new userInformation();
        user.setAccountNumber(customer1.getAccountNumber());
        
		user.setAttempts(5);
		String str1 = Integer.toString(customer1.getAccountNumber()); 
        user.setPassword("customer");
        user.setUserName(str1);
        user.setUserType("Customer");
     
        
        
     //   customer1.setUser_info(user);
        
        session.persist(customer1);
        session.persist(user);
        session.getTransaction().commit();
        
	 }catch(Exception e) {
	
		 logger.error("Customer not saved"+e.getMessage());
		 logger.fatal("Hibernate session not loaded"+e.getMessage());
	 }
	 }
	 
	 
	 
	 
	 
	 
	 
	 public int generateAccountNumber() {
	 
		 try {
			 Random rand = new Random(); //instance of random class
			 int upperbound = 100000;
	       
			 int intRandom = rand.nextInt(upperbound); 
	      
			 return intRandom;
		 	 
		 
		} 
		catch(Exception e){
	  
 
				BasicConfigurator.configure();
				logger.error("create account");
				logger.info("Check generate a account number");
				logger.fatal("Account number was not created");
			}
		 
		 	return (Integer) null;
	    
	 }
	 
	 
	 
	 
	 
	 
	 public  customerInformation generateCustomerInfo (int accountNumber) {
		 
		 Session session = hibernate.getSessionFactory();
		 session.beginTransaction();  
			
		try {
		    int account  = accountNumber;
		    
		    System.out.println("acccttttttttt"+ account );
			  
	        String findQuery = " FROM  customerInformation u  WHERE u.accountNumber = '" + account + "'";
	        
	        customerInformation customer = null;
	        
	        TypedQuery<  customerInformation> typedQuery = session.createQuery(findQuery,customerInformation.class);
	        System.out.println("user born 1");
	        customer = typedQuery.getSingleResult();
	        System.out.println("user born 2");
	      
	        	return customer;
	        
	        
		}
		catch(Exception e){
			logger.info("No information is found");
		//	 logger.error("User does not exist"+e.getMessage();
			 
		 }
	       session.close();
			return null;
	 
	 }
	 
	
	 public boolean  updateCustomerInfo2(customerInformation customer1) {
		 
		 Session session = hibernate.getSessionFactory();
		 session.beginTransaction();  
		 int account  = customer1.getAccountNumber();
		 customerInformation information = new customerInformation();
		 information=customer1;
		 
		 System.out.println("account number"+account);
		 
		 try {
			 
			 String updateQuery = "UPDATE customerInformation c SET c.firstName = :first_name, c.lastName = :last_name, c.age = :age, c.email = :Email, c.telephone = :telephone, c.dob = :date WHERE c.accountNumber = :accountNumber";
		
			 Query query = session.createQuery(updateQuery);
			 
			
			 query.setParameter("first_name", information.getFirstName());
			 query.setParameter("last_name", information.getLastName());
			 query.setParameter("age", information.getAge());
			 query.setParameter("Email", information.getEmail());
			 query.setParameter("telephone", information.getTelephone());
			 query.setParameter("date", information.getDob());
			 query.setParameter("accountNumber", account);
			
			 String updateQuery2 = "UPDATE customerAddress a SET a.streetName = :street_name, a.community = :community, a.parish = :parish  WHERE a.accountNumber = :accountNumber";
			 Query query2 = session.createQuery(updateQuery2);
			 System.out.println(information.getAddress().getstreetName());
			 System.out.println(information.getAddress().getCommunity());
			 System.out.println(information.getAddress().getParish());
			 query2.setParameter("street_name", information.getAddress().getstreetName());
			 query2.setParameter("community", information.getAddress().getCommunity());
			 query2.setParameter("parish", information.getAddress().getParish());
			 query2.setParameter("accountNumber", account);
			 
			 
			
			 int result = query.executeUpdate();
			 int result2 = query2.executeUpdate();
			  return true;
		
	 }catch(Exception e) {
		 BasicConfigurator.configure();
		 logger.info("Transfer Unsuccessful");
		 logger.error("Invalid Account Number"+e.getMessage());
		 customer1 =null;
		
		 return false;
	 }
 }
 


	 
	 
	 
	 public transactionClass Deposite(transactionClass tranClass) {
		 
		 transactionInformation transData= new  transactionInformation();
		 
		 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd ");
			SimpleDateFormat dateFormats = new SimpleDateFormat("HH:mm:ss");
			Date date = new Date();
			String frmtdDate = dateFormat.format(date);
			String time = dateFormats.format(date);
		 
			Session session = hibernate.getSessionFactory();
			session.beginTransaction();
			transactionClass trans= new transactionClass();
		 	trans = tranClass;
		 	transactionInformation trans2 = new transactionInformation();
		 	
		 	System.out.println("1");
		 	
		 	
			 int account1=trans.getAccount1();
			 int account2=trans.getAccount2();
			 float deposite = trans.getDeposite1();
			 System.out.println("accountnumber" +account1);
			 System.out.println("accoune"+account2);
			 System.out.println("depo"+deposite);
			 
			 
			 accountInformation customer2 = null;
			 accountInformation customer = null;
			 accountInformation customer3 = null;
			 accountInformation customer4 = null;
			 System.out.println("2");		 
	try { 
			 String Query = " FROM  accountInformation u  WHERE u.accountNumber = '" + account1 + "'";
			 TypedQuery<accountInformation> typedQuery = session.createQuery(Query,   accountInformation.class);
			 customer = typedQuery.getSingleResult();
			
			 System.out.println("3");
			 float accountBalance1 = customer.getAccountBalance(); 
			 
			  if (accountBalance1 > deposite) {
				  
				  System.out.println("4");
					 String Query2 = " FROM  accountInformation u  WHERE u.accountNumber = '" + account2 + "'";
					 TypedQuery<accountInformation> typedQuery2 = session.createQuery(Query2,   accountInformation.class);
					 customer2 = typedQuery2.getSingleResult();  
				
					
					float accountBalance2 = customer2.getAccountBalance();
					
				    float newBalance1 = accountBalance1-deposite;
				    float newBalance2 =accountBalance2+deposite;
				   
				    
				    
				    
				    
				    
				    System.out.println("5");
				    String Query3 = " FROM  accountInformation u  WHERE u.accountNumber = '" + account1+ "'";
					  TypedQuery<accountInformation> typedQuery3 = session.createQuery(Query3,   accountInformation.class);
					  customer3 = typedQuery3.getSingleResult();
				
					  
				        customer3.setAccountBalance(newBalance1);
				        transData.setAccountNumber(customer3.getAccountNumber());
					    transData.setWithdraw(deposite);
					    
					    transData.setWithdraw(deposite);
					    transData.setDate(frmtdDate);
					    transData.setDate(time);
					    transData.setBalance(newBalance1);
					    
					    
					    customer3.setTrans(transData); 
				        session.persist(customer3);
				        System.out.println("6");
				        String Query4 = " FROM  accountInformation u  WHERE u.accountNumber = '" + account2+ "'";
						  TypedQuery<accountInformation> typedQuery4 = session.createQuery(Query4,   accountInformation.class);
						  customer4 = typedQuery4.getSingleResult();
					
						  customer4.setAccountBalance(newBalance2);
						  
						  trans2.setAccountNumber(customer4.getAccountNumber());
					       trans2.setDeposite(deposite);
					       System.out.println("8");
						  
						  customer4.setAccountBalance(newBalance2);
					        transData.setAccountNumber(customer4.getAccountNumber());
						    transData.setDeposite(deposite);
						    transData.setDate(frmtdDate);
						    transData.setDate(time);
						    transData.setBalance(newBalance2);
						    customer4.setTrans(transData);;
				        session.persist(customer4);
				        System.out.println("9");
				        session.getTransaction().commit();
				  	  trans.setMessage1("transaction successfull ");
				        return trans;
				  
				  
			  }
			  
			  else {
				  trans.setMessage1("User dont have sufficient sum to trancfer money");
				  return trans;
			  }
			  
			} catch(Exception e){
				logger.info("Deposit Unsuccessful");
				 logger.error("Invalid Account Number" +e.getMessage());
				 trans.setMessage1("User dont bank account number wrong ");
				 return trans;
				 
				 
			 }
		  
		 
 }
 
	 
	 
	  public List<transactionInformation> getTransaction(int accountNumber) {
		try {  
		  Session session = hibernate.getSessionFactory();
		 session.beginTransaction();
		 int accountNumberPass = accountNumber;
		 
		  
		  String getQuery = " FROM transactionInformation  u  WHERE u.accountNumber = '" + accountNumberPass + "'";
		  
		 
	        List<transactionInformation> customer = null; 
	    
	        
	        /*List<Student> students = (List<Student>) session.createQuery(
                "FROM Student s ORDER BY s.firstName ASC").list();*/
	        TypedQuery<transactionInformation> typedQuery = session.createQuery(getQuery,  transactionInformation.class);
	      
	        customer = typedQuery.getResultList();
	      
	       
	      if (customer != null) {
	    	  
	    
	    	  return customer;
	      }
	    
	  }catch(Exception e) {
			 
		  logger.error("Accoun Number does not exist"+e.getMessage());
	  }
    
	  
	  
	  return null;
  }


		
	
   
	  public transactionClass loanPay(transactionClass tranClass) {
		  transactionInformation transData= new  transactionInformation(); 
		 	
			Session session = hibernate.getSessionFactory();
			session.beginTransaction();
			
			transactionClass trans= new transactionClass();
		 	trans = tranClass;
		 	
			 int account1=trans.getAccount1();
			 float loan = trans.getLoanPayment();
			 
			 
		
			 accountInformation customerAccount = null;
			 
		
			 
			try { 
				
			 String Query = " FROM  accountInformation u  WHERE u.accountNumber = '" + account1 + "'";
			 TypedQuery<accountInformation> typedQuery = session.createQuery(Query,   accountInformation.class);
			 customerAccount = typedQuery.getSingleResult();
			
			 
			 
			 float loanBalance = customerAccount.getLoanAmmount();
			 float accountBalance1 = customerAccount.getLoanAmmount(); 
			 
			 
			 if(loanBalance == 0) {
				 
				 trans.setMessage1("you dont have a loan");
				 return trans;
			 }
			 
			 	if (loanBalance > loan) {
				 
			 		trans.setMessage1("You are over paying your loan");
			 		 return trans;
			 	}
			 	
			  if (accountBalance1 > loan) {
				  
				  customerAccount.setAccountBalance(accountBalance1-loan);
				  		
				  customerAccount.setLoanAmmount(loanBalance-loan);
				        
				        
				        session.persist(customerAccount);
				        
				        session.getTransaction().commit();
				        
				        trans.setMessage1("trannsaction ok");
				        
				        return trans;
				  
			  }
			  
			  
			} catch(Exception e){
				logger.info("User account cannot be found");
				logger.error("User account does not exist"+e.getMessage()); 
				 }
			  
			 return null;
	  } 
	 
	
	  
public userInformation changeUserLogin(customerInformation user) {
	 
	try {
	System.out.println("call function 888888888888888888 ");
		  Session session = hibernate.getSessionFactory();
			session.beginTransaction();
			   
		        session.getTransaction().commit();
		        
		        session.persist(user);
				}catch(Exception e) {
					logger.info("Change User Login");
					logger.error("Login Information failed to update"+e.getMessage());
					 logger.fatal("Hibernate session not loaded"+e.getMessage());
				}
	
	  						return (null);
			}
				

public int  deleteCustomer(int account1) {
	
	
	try {
	Session session = hibernate.getSessionFactory();
	 session.beginTransaction();  
		

	    int account  = account1;
	    int numm1;
	    
		  
       String findQuery = " FROM  customerInformation u  WHERE u.accountNumber = '" + account + "'";
       
       customerInformation customer = null;
       
       TypedQuery<  customerInformation> typedQuery = session.createQuery(findQuery,customerInformation.class);
       
       customer = typedQuery.getSingleResult();
  
   
	
	   session.delete(customer);
	   	
	   session.getTransaction().commit();
	   
	   
	   return 1;
	}catch(Exception e) {
		
		logger.info("Remove Customer");
		logger.error("Delete Failed"+e.getMessage());
		 logger.fatal("Hibernate session not loaded"+e.getMessage());
		
	}
	return 2;
}


public int resetCustomer(int accountNumber) {
	
	Session session = hibernate.getSessionFactory();
	 session.beginTransaction();  
	
	 String loginQuery = " FROM  userInformation u  WHERE u.accountNumber = '" + accountNumber+ "'";
     userInformation customer = null; 
     TypedQuery< userInformation> typedQuery = session.createQuery(loginQuery,  userInformation.class);
   
     customer = typedQuery.getSingleResult();
     customer.setAttempts(3);
     session.persist(customer);
	   	
	  session.getTransaction().commit();
	   
	  session.close();
	return 0;
}




}