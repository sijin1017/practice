package basic05;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private static ApplicationContext ctx;
	
    public static void main( String[] args ){
    	ctx = new ClassPathXmlApplicationContext("config/basic05_config.xml");
    	
    	MessageBean bean = ctx.getBean("messageBean", basic05.MessageBean.class);
    	bean.sayHello();
    }
}





