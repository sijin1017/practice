package basic06;

import org.springframework.stereotype.Component;

@Component
public class MessageBeanKr implements MessageBean{
	private String name;
	private String age;
	
	public MessageBeanKr() {}
	public MessageBeanKr(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public void sayHello() {
		System.out.println("나의 이름은 " + name + "이고 나이는 " + age + "살입니다.");
	}
}
