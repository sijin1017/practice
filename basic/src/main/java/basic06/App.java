package basic06;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private static ApplicationContext ctx;
	
    public static void main( String[] args ){
    	ctx = new ClassPathXmlApplicationContext("config/basic06_config.xml");
    	//ctx = new AnnotationConfigApplicationContext("basic06");
    	
    	// 한국어로 자기 소개
    	MessageBean bean = ctx.getBean("messageBeanKr", basic06.MessageBean.class);
    	bean.sayHello();
    	
    	// 영어로 자기 소개
    	bean = ctx.getBean("msgEn", basic06.MessageBean.class);
    	bean.sayHello();

    }
}





