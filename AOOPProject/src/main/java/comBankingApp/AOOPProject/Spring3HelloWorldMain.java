package comBankingApp.AOOPProject;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spring3HelloWorldMain {

	public static void main(String[] args) {

        ApplicationContext beanFactory = new ClassPathXmlApplicationContext("SpringFrameWork.xml");

        //Spring3HelloWorld myBean = (Spring3HelloWorld) beanFactory.getBean("Spring3HelloWorld");
        customerMethods myBean2 = (customerMethods) beanFactory.getBean("cm");
        customerInformation myBean = (customerInformation) beanFactory.getBean("ci");
        
        customerAddress myBean1 = (customerAddress) beanFactory.getBean("ca");
        
        userInformation myBean5 = (userInformation) beanFactory.getBean("ui");
        
        accountInformation myBea = (accountInformation) beanFactory.getBean("aci");
        
        
        
        int test =74980;
        myBean2.deleteCustomer(test);
        
        
                
       
	}

}
