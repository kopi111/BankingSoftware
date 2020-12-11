package comBankingApp.AOOPProject;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Random;

import javax.persistence.TypedQuery;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class worker {


public class workerMethods {

	private  final Logger logger = LogManager.getLogger(customerMethods.class); 
	
	
	
	@Test
	 public workerClass   saveNewWorker (workerClass work) {
		 
		 
		 try {
	 
		Session session = hibernate.getSessionFactory();
		session.beginTransaction();  
		assertNotNull(work);
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
	 
	 
	 @Test
	 public workerLlogin testCredentials (workerLlogin user){
			
			try {
				
				
				Session session = hibernate.getSessionFactory();
				session.beginTransaction(); 
				System.out.println("uuuuuuuuuuuu");
			    String password = user.getPassword();
			   String name = user.getWorkerUserName();
			   
				
		        String loginQuery = " FROM  workerLlogin u  WHERE u.workerUserName = '" + name + "' AND u.password = '" + password +"'";
		        workerLlogin work = null; 
		        assertNotNull(work);
		        
		        TypedQuery< workerLlogin> typedQuery = session.createQuery(loginQuery,  workerLlogin.class);
		  
		       work = typedQuery.getSingleResult();
		      
		       System.out.println("uuuuuuuuuuuu");
		        	if (work != null) {
		        			System.out.println("user find");
		        			session.close();
		    	  			return work;
		    	  			
		        	}
		        
		        
		        
			}
			
			 	catch(Exception ex){
			 		
					System.out.println(ex);
			 		BasicConfigurator.configure();
			 		logger.info("login error");
				    logger.error("user wasn't found");
			 	}
			
			
		        return null;
			 
		  }
		 
	 
	@Test
	 public  workerClass  getworkerInformation (int id) {
		 
		 Session session = hibernate.getSessionFactory();
		 session.beginTransaction();  
			
		try {
		    int workerID  = id;
		    
		    
			  
	        String findQuery = " FROM  workerClass u  WHERE u.workerIdNumbere = '" + workerID + "'";
	        
	        workerClass worker = null;
	        assertNotNull(worker);
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

}
