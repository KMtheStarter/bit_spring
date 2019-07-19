package develop_java;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

//@ComponentScan(basePackages="develop_java") �̰� ���̸� �ؿ� Ŭ������ ���� �� ��.
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
