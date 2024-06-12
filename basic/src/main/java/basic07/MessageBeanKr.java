package basic07;

import org.springframework.stereotype.Component;

@Component
public class MessageBeanKr implements MessageBean{
	private String name;
	private String age;
	private Outputter outputter;
	
	public MessageBeanKr() {}
	public MessageBeanKr(String name, String age, Outputter outputter) {
		this.name = name;
		this.age = age;
		this.outputter = outputter;
	}

	public void sayHello() {
		System.out.println("나의 이름은 " + name + "이고 나이는 " + age + "살입니다.");
		
		try {
			outputter.output("나의 이름은 " + name + "이고 나이는 " + age + "살입니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
