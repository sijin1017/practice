package basic06;

import org.springframework.stereotype.Component;

@Component("msgEn")
public class MessageBeanEn implements MessageBean{
	private String name;
	private String age;
	
	public void setName( String name) { this.name = name; }
	public void setAge(String age) { this.age = age; }
	
	public void sayHello() {
		System.out.println("My name is " + name + " and my age is " + age);
	}
}
