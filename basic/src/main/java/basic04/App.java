package basic04;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	private static ApplicationContext ctx;
	
    public static void main( String[] args ){
    	ctx = new ClassPathXmlApplicationContext("config/basic04_config.xml");
    	
        MessageBean bean = ctx.getBean("msgKr", basic04.MessageBeanKr.class);
        bean.sayHello("임꺽정");
        bean.sayHello("홍길동");
        
        bean = ctx.getBean("msgEn", basic04.MessageBeanEn.class);
        bean.sayHello("Tom");
        bean.sayHello("Jane");
        
        bean = ctx.getBean("msgkr", basic04.MessageBeanKr.class);
        bean.sayHello("유비");
        
        bean = ctx.getBean("kr", basic04.MessageBeanKr.class);
        bean.sayHello("관우");
        
        bean = ctx.getBean("mskr", basic04.MessageBeanKr.class);
        bean.sayHello("장비");
    }
}





