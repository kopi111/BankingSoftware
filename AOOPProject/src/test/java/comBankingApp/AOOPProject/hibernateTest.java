package comBankingApp.AOOPProject;

import static org.junit.jupiter.api.Assertions.*;

import org.hibernate.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

class hibernateTest {
	private static SessionFactory sessionFactory;
	private static Session session;
	
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		sessionFactory = hibernate.ReturnSessionFactory(); 
		
		System.out.println("SessionFactory created");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		session.close();
	}

	@BeforeEach
	
	void setUp() throws Exception {
		session = sessionFactory.openSession();
	}

	@AfterEach
	void tearDown() throws Exception {
		session.close();
	}

	@Test
	void testCreate() {
		//fail("Not yet implemented");
		
		System.out.println("running insert test.........");
		session.beginTransaction();
		
		customerInformation info = new customerInformation();
		customerAddress add= new customerAddress();
		accountInformation accinfo= new accountInformation();
		customerMethods meth= new customerMethods();
		
		int num= meth.generateAccountNumber();
		add.setCommunity("Watson Grove");
		add.setParish("St.catherine");
		add.setstreetName("Comet Close");
		
		accinfo.setLoanAmmount(0);
		accinfo.setAccountBalance(1000);
		accinfo.setTran(0);
		accinfo.setAccountNumber(num);
		
		
		info.setFirstName("Shamoy");
		info.setLastName("Creary");
		info.setTelephone(444);
		info.setEmail("sham01@gmail.com");
		info.setAge(12);
		info.setAddress(add);
		info.setDob("december 11, 2020");
		info.setAccountNumber(num);
		
		Integer id= (Integer)session.save(info);
		session.getTransaction().commit();
		
		Assertions.assertTrue(id > 0);
		
		
		
		
		
	}
	
	@Test
	void testUpdate() {
		//fail("Not yet implemented");
		System.out.println("running update test.........");
		session.beginTransaction();
		customerAddress ca= new customerAddress();
		customerMethods cusmeth= new customerMethods();
		int gennum=cusmeth.generateAccountNumber();
		
		ca.setCommunity("dddd");
		ca.setParish("dddd");
		ca.setstreetName("dddd");
		
		Integer accountid = 1;
		customerInformation cus= new customerInformation();
	    
		cus.setFirstName("rex");
		cus.setLastName("Atkins");
		cus.setTelephone(5446);
		cus.setEmail("dddd");
		cus.setAge(45);
		
		cus.setAddress(ca);
	    cus.setDob("4/8/8");
	    cus.setAccountNumber(gennum);
	    
	    session.beginTransaction();
	    session.update(cus);
	    session.getTransaction().commit();
	    
	    customerInformation updatedcus = session.find(customerInformation.class, accountid);
	    Assertions.assertEquals("Atkins", updatedcus.getLastName());
	    
		
	}
	
	@Test
	void testDelete() {
		//fail("Not yet implemented");
		System.out.println("running Delete test.........");
		Integer id= 1;
		customerInformation cusdel= session.find(customerInformation.class, id);
		session.beginTransaction();
		session.delete(cusdel);
		session.getTransaction().commit();
		
		customerInformation cusdeleted= session.find(customerInformation.class, id);
		Assertions.assertNull(cusdeleted);
	}
	
	
	@Test
	void testList() {
		//fail("Not yet implemented");
		System.out.println("running List test.........");
		Query<customerInformation> query= session.createQuery("from customerInformation", customerInformation.class);
		List <customerInformation> resultList= query.getResultList();
		Assertions.assertFalse(resultList.isEmpty());
		
		
	}


}
