package basic05;

public class MessageBeanImpl implements MessageBean{
	private String name;
	private int age;
	private String greeting;
	private Outputter outputter;
	
	public MessageBeanImpl() {}
	public MessageBeanImpl(String name, int age, String greeting) {
		this.name = name;
		this.age = age;
		this.greeting = greeting;
	}
	
	public void setName(String name) {	this.name = name; }
	public void setAge(int age) { this.age = age; }
	public void setGreeting(String greeting) { this.greeting = greeting; }
	public void setOutputter(Outputter outputter) {
		this.outputter = outputter;
	}
	
	@Override
	public void sayHello() {
		String msg = greeting + "!~~ " + name + "님 이제 당신의 나이는 " + age + "살입니다.";
		System.out.println(msg);
		
		try {
			outputter.output(msg);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
