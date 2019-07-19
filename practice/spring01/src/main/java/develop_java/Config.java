package develop_java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@ComponentScan(basePackages="develop_java") 이걸 붙이면 밑에 클래스에 내용 비어도 됨.
@Configuration
public class Config {

	@Bean
	public Developer programmer() {
		return new Programmer();
	}
	
	@Bean
	public Developer designer() {
		return new Designer();
	}
	
	@Bean
	public Develop develop() {
		return new Develop();
	}
}
