package basic03;

public class App {
    public static void main( String[] args ){
    	MessageBeanFactory factory = MessageBeanFactory.newInstance();
    	
        MessageBean bean1 = factory.createMessage("kr");
        bean1.sayHello("홍길동");
        
        bean1 = factory.createMessage("en");
        bean1.sayHello("Tom");
    }
}
