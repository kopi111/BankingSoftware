package comBankingApp.AOOPProject;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Random;

import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;

class customerMethodsTest {

	
	private static final Logger logger = LogManager.getLogger(customerMethods.class); 
	@Test
	void test() {
		fail("Not yet implemented");
	}
		
	@Test
	public accountInformation deposite1(accountInformation accountInfo) {
		
		 try {
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
		        
		        assertNotNull(customer);
		        
		       trans.setAccountNumber(accountInfo.getAccountNumber());
		       trans.setDeposite(deposite);
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
			    return null;
			    
		 	}
		 
	}	 

			public accountInformation deposite(accountInformation accountInfo) {
				
			 try {
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
			        
			        
			        assertNotNull(customer);
			        
			       trans.setAccountNumber(accountInfo.getAccountNumber());
			       trans.setDeposite(deposite);
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
				Session session = hibernate.getSessionFactory();
				session.beginTransaction();
				
				float withdraw = accountInfo.getTran();
				int account = accountInfo.getAccountNumber();
				transactionInformation trans= new  transactionInformation();
				
				accountInformation customer = new accountInformation();
				customer =null;
				
				System.out.println(withdraw);
				
				 String Query = " FROM  accountInformation u  WHERE u.accountNumber = '" + account + "'";
				 
				 System.out.println("test1");
				 
				  TypedQuery<accountInformation> typedQuery = session.createQuery(Query,   accountInformation.class);
				  
				  System.out.println("test2");
				  
				  customer = typedQuery.getSingleResult();
				  System.out.println("test3");
				  
			        float balance = customer.getAccountBalance();
			        System.out.println("test3");
			        
			        assertNotNull(customer);
			        
			        if (balance > withdraw) {
			        	
			        	float currentValue= balance-withdraw;
			        	
			        	customer.setAccountBalance(currentValue);
			        	trans.setAccountNumber(accountInfo.getAccountNumber());
			 	       trans.setWithdraw(withdraw);
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
					System.out.println("test called");
					
					Session session = hibernate.getSessionFactory();
					session.beginTransaction(); 
					
				    String password = user.getPassword();
				    String name = user.getUserName();
				   
				    
			        String loginQuery = " FROM  userInformation u  WHERE u.userName = '" + name + "' AND u.password = '" + password +"'";
			        userInformation customer = null; 
			        TypedQuery< userInformation> typedQuery = session.createQuery(loginQuery,  userInformation.class);
			      
			        customer = typedQuery.getSingleResult();
			      
			        assertNotNull(customer);
			        
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
			  	        System.out.println(currentAttemp);
			  	      assertNotNull(customer2);
			  	      
			  	        	if (currentAttemp==0) {
			  	        		customer2=null;
			  	        		return customer2;
			  	        	}
			  	        		else {
			  	        	
			  	        	
			  	        		currentAttemp = currentAttemp-1;
			  	        		customer2.setAttempts(currentAttemp);
			  	        		session.persist(customer2);
			  	        		session.getTransaction().commit();
			  	        		customer2=null;
			  	        		return customer2;
			  	        		}
				 		} 
				 			catch(Exception e){
			  	    	  
			  	      
				 					BasicConfigurator.configure();
				 					logger.info("Decrement error"+e.getMessage());
					 				logger.error("decrement was not  found"+e.getMessage());
					 				 logger.fatal("Hibernate session not loaded"+e.getMessage());
			  	      }
				 				return null;
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
			        assertNotNull(customer);
			        	return customer;
			        
				}
				catch(Exception e){
					logger.info("No information is found");
				//	 logger.error("User does not exist"+e.getMessage();
					 
				 }
			       session.close();
					return null;
			 
			 }
			 
			
			 public customerInformation updateCustomerInfo2(customerInformation customer1) {
				 
				 Session session = hibernate.getSessionFactory();
				 session.beginTransaction();  
				 int accunt  = 53776;
				 customerInformation information = new customerInformation();
				 information=customer1;
				 
				 try {
					 
					 String updateQuery = "UPDATE customerInformation c SET c.firstName = :first_name, c.lastName = :last_name, c.age = :age, c.email = :Email, c.telephone = :telephone, c.dob = :date WHERE c.accountNumber = :accountNumber";
				
					 
					 
					 
					
					 Query query = session.createQuery(updateQuery);
					 
					 
					 
					 query.setParameter("first_name", information.getFirstName());
					 
					 query.setParameter("last_name", information.getLastName());
					
					 query.setParameter("age", information.getAge());
					 query.setParameter("Email", information.getEmail());
					
					 query.setParameter("telephone", information.getTelephone());
					 query.setParameter("date", information.getDob());
					 
					 query.setParameter("accountNumber", 53776);
					
					
				    
					 
					 
					 System.out.println("after query");
					 int result = query.executeUpdate();
					 System.out.println("Rows affected: " + result);
				
			 }catch(Exception e) {
				 logger.info("Transfer Unsuccessful");
				 logger.error("Invalid Account Number"+e.getMessage());
			 }
				 
				 return null;
		 }
		 

	
			 
			 
			 public transactionClass Deposite(transactionClass tranClass) {
				 
				 transactionInformation transData= new  transactionInformation();
				 
					Session session = hibernate.getSessionFactory();
					session.beginTransaction();
					transactionClass trans= new transactionClass();
				 	trans = tranClass;
				 	
					 int account1=trans.getAccount1();
					 int account2=trans.getAccount2();
					 float deposite = trans.getDeposite1();
					 
					 accountInformation customer2 = null;
					 accountInformation customer = null;
					 accountInformation customer3 = null;
					 accountInformation customer4 = null;
					 System.out.println(account1);
					    System.out.println(account2);
					 
					try { 
					 String Query = " FROM  accountInformation u  WHERE u.accountNumber = '" + account1 + "'";
					 TypedQuery<accountInformation> typedQuery = session.createQuery(Query,   accountInformation.class);
					 customer = typedQuery.getSingleResult();
					
					 
					 float accountBalance1 = customer.getAccountBalance(); 
					 
					  if (accountBalance1 > deposite) {
						  
						
							 String Query2 = " FROM  accountInformation u  WHERE u.accountNumber = '" + account2 + "'";
							 TypedQuery<accountInformation> typedQuery2 = session.createQuery(Query2,   accountInformation.class);
							 customer2 = typedQuery2.getSingleResult();  
						
							
							float accountBalance2 = customer2.getAccountBalance();
							
						    float newBalance1 = accountBalance1-deposite;
						    float newBalance2 =accountBalance2+deposite;
						   
						    
				
						    String Query3 = " FROM  accountInformation u  WHERE u.accountNumber = '" + account1+ "'";
							  TypedQuery<accountInformation> typedQuery3 = session.createQuery(Query3,   accountInformation.class);
							  customer3 = typedQuery3.getSingleResult();
						
							  System.out.println("look here"  +newBalance1);
						        customer3.setAccountBalance(newBalance1);
						        transData.setAccountNumber(customer3.getAccountNumber());
							    transData.setWithdraw(deposite);
							    customer3.setTrans(transData); 
						        session.persist(customer3);
						        
						        String Query4 = " FROM  accountInformation u  WHERE u.accountNumber = '" + account2+ "'";
								  TypedQuery<accountInformation> typedQuery4 = session.createQuery(Query4,   accountInformation.class);
								  customer4 = typedQuery4.getSingleResult();
							
								  customer4.setAccountBalance(newBalance2);
								  System.out.println("balance"+newBalance2);
								  
								  customer4.setAccountBalance(newBalance1);
							        transData.setAccountNumber(customer3.getAccountNumber());
								    transData.setDeposite(deposite);
								    customer4.setTrans(transData); 
						        session.persist(customer4);
						        
						        session.getTransaction().commit();
						        assertNotNull(customer);
						        assertNotNull(customer3);
						        assertNotNull(customer2);
						        assertNotNull(customer4);
						  
						  
					  }
					  
					} catch(Exception e){
						logger.info("Deposit Unsuccessful");
						 logger.error("Invalid Account Number" +e.getMessage());
						 
						 
					 }
				  
				 return null;
		 }
		 
			 
			 
			  public List<transactionInformation> getTransaction(transactionInformation information) {
				try {  
				  Session session = hibernate.getSessionFactory();
				 session.beginTransaction();
				 int accountNumberPass = 0;
				  
				  System.out.println("function call");
				  System.out.println(accountNumberPass);
				  
				  String getQuery = " FROM transactionInformation  u  WHERE u.accountNumber = '" + accountNumberPass + "'";
				  
				 
			        List<transactionInformation> customer = null; 
			        System.out.println("function after query");
			        TypedQuery<transactionInformation> typedQuery = session.createQuery(getQuery,  transactionInformation.class);
			        System.out.println("function after query111");
			        customer = typedQuery.getResultList();
			        assertNotNull(customer);
			        System.out.println("function after query222");
			       
			      if (customer != null) {
			    	  
			    	  System.out.println("testing");
			    	  
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
					
					 assertNotNull( customerAccount);
					 
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
			 
			
			  
		public userInformation changeUserLogin(userInformation user) {
			 
			try {
			System.out.println("call function 888888888888888888 ");
				  Session session = hibernate.getSessionFactory();
					session.beginTransaction();
					int account1 = user.getAccountNumber();
					 System.out.println("call function 888888888888888888 ");
					
					customerInformation customerInfo = null;
						
						// String Query = " FROM  customerInformation u  WHERE u.accountNumber = '" + account1 + "'";
						 //TypedQuery<customerInformation> typedQuery = session.createQuery(Query,   customerInformation.class);
						 //customerInfo = typedQuery.getSingleResult();
						 
					
					Query query = session.createQuery("update user set userName = :uName" + " where accountNumber = :accnum");
								query.setParameter("uname", user.getUserName());
							query.setParameter("accnum", user.getAccountNumber());
							 query.executeUpdate();
					
					
					
					
				        session.getTransaction().commit();
				        

						}catch(Exception e) {
							logger.info("Change User Login");
							logger.error("Login Information failed to update"+e.getMessage());
							 logger.fatal("Hibernate session not loaded"+e.getMessage());
						}
			
			  						return (null);
					}
						









	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}