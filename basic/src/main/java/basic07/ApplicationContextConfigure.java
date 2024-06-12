package basic07;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationContextConfigure {
	@Bean
	public MessageBean getMessageKr(){
		MessageBeanKr kr = new MessageBeanKr("홍길동", "40", getOutputter());
		return kr;
	}
	
	@Bean
	public MessageBean getMessageEn(){
		MessageBeanEn en = new MessageBeanEn();
		en.setAge("30");
		en.setName("Tom");
		en.setOutputter(getOutputter());
		return en;
	}
	
	public Outputter getOutputter() {
		FileOutputter outputter = new FileOutputter();
		outputter.setFilePath("c:\\netsong7\\greeting.txt");
		return outputter;
	}
}
