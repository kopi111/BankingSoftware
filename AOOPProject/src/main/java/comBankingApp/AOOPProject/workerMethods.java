package comBankingApp.AOOPProject;

import java.util.Random;

import javax.persistence.TypedQuery;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;

public class workerMethods {

	private static final Logger logger = LogManager.getLogger(customerMethods.class); 
	
	
	
	 
	 public workerClass   saveNewWorker (workerClass work) {
		 
		 
		 try {
	 
		Session session = hibernate.getSessionFactory();
		session.beginTransaction();  
		
       session.persist(work);
     
       session.getTransaction().commit();
       
       
       return work;
      
       
	 }
	
	 	catch(Exception e){
	 		
			
	 		BasicConfigurator.configure();
	 		logger.info("Check saveWorker");
		    logger.error("Worker was not created");
	 	}
	 				return null;
}
	 
	 
	 
	 public workerLlogin testCredentials (workerLlogin user){
			
			try {
				
				
				Session session = hibernate.getSessionFactory();
				session.beginTransaction(); 
				
				
			    String password = user.getPassword();
			   String name = user.getWorkerUserName();
			   
				
		        String loginQuery = " FROM  workerLlogin u  WHERE u.workerUserName = '" + name + "' AND u.password = '" + password +"'";
		        workerLlogin work = null; 
		       
		        TypedQuery< workerLlogin> typedQuery = session.createQuery(loginQuery,  workerLlogin.class);
		  
		       work = typedQuery.getSingleResult();
		      
		      
		        	if (work != null) {
		        			System.out.println("user find");
		        			session.close();
		        			work.setAttempts(2);
		    	  			return work;
		    	  			
		        	}
		        
		        
		        
			}
			
			 	catch(Exception ex){
			 		
			 		BasicConfigurator.configure();
			 		logger.info("login error");
				    logger.error("user wasn't found");
				    workerLlogin log = null;
				    log.setAttempts(1);
				    return log;
					
				    
			 	}
			
			
		        return null;
			 
		  }
		 
	 
	 
	 public  workerClass  getworkerInformation (int id) {
		 
		 Session session = hibernate.getSessionFactory();
		 session.beginTransaction();  
			
		try {
		    int workerID  = id;
		    
		    
			  
	        String findQuery = " FROM  workerClass u  WHERE u.workerIdNumbere = '" + workerID + "'";
	        
	        workerClass worker = null;
	        
	        TypedQuery<  workerClass> typedQuery = session.createQuery(findQuery,workerClass.class);
	        
	        worker = typedQuery.getSingleResult();
	        
	      
	        	return worker;
	        
	        
		}
		catch(Exception e){
			 System.out.println("user dont exits in get user information ");
			 
		 }
	       session.close();
			return null;
	 }
	 
	 
	 public int workerID() {
	 
		 try {
			 Random rand = new Random(); //instance of random class
			 int upperbound = 100000;
	       
			 int intRandom = rand.nextInt(upperbound); 
	      
			 return intRandom;
		 	 
		 
		} 
		catch(Exception e){
	  
 
				BasicConfigurator.configure();
				logger.error("creat id for worker");
				logger.info("Check generate a id worker ");
				logger.fatal("id number was not created");
			}
		 
		 	return (Integer) null;
	    
	 }
}
