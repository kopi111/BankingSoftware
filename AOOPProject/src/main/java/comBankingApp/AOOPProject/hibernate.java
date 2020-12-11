package comBankingApp.AOOPProject;

import org.hibernate.HibernateException;
import org.hibernate.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;


public class hibernate {
	
	private static SessionFactory sessionFactory = null;
	
	
	 
    static {
        try{
            loadSessionFactory();
            
        }catch(Exception e){
            System.err.println("Exception while initializing hibernate util.. ");
            e.printStackTrace();
        }
        
       
    }
    
 
    public static void  loadSessionFactory(){
 
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(customerInformation.class); 
        configuration.addAnnotatedClass(customerAddress.class);  
        configuration.addAnnotatedClass(accountInformation.class);
        configuration.addAnnotatedClass(userInformation.class);
        configuration.addAnnotatedClass(transactionInformation.class);
        configuration.addAnnotatedClass(workerLlogin.class);
        configuration.addAnnotatedClass(workerClass.class);
        ServiceRegistry srvcReg = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
        sessionFactory = configuration.buildSessionFactory(srvcReg);
        
        
        
    }
 
    public static Session getSessionFactory() throws HibernateException {
 
        Session retSession=null;
            try {
                retSession = sessionFactory.openSession();
            }catch(Throwable t){
            	 System.out.println( "Exception while getting session" );
            System.err.println("Exception while getting session.. ");
            t.printStackTrace();
            }
            if(retSession == null) {
            	System.out.println( "session in null" );
                System.err.println("session is discovered null");
            }
            System.out.println( "return" );
            return retSession;
    }
    
    public static SessionFactory ReturnSessionFactory() {
    	SessionFactory sf = null;
    	loadSessionFactory();
    	sf = sessionFactory;
    	return sf;
    }
 
    
}
