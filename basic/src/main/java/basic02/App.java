package basic02;

public class App {
    public static void main( String[] args ){
        MessageBean bean1 = new MessageBeanKr();
        bean1.sayHello("홍길동");
        
        bean1 = new MessageBeanEn();
        bean1.sayHello("Tom");
    }
}
