package develop_java;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
//의존주입 당하고, 주입된 객체로 일을 수행하기 때문에 Service
public class Develop {
	
	@Autowired
	@Qualifier("programmer")
	private Developer developer;
	
	public Develop() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("develop() 호출");
	}
	
	public Develop(Developer developer) {
		super();
		this.developer = developer;
		System.out.println("인자있는 develop() 호출");
	}



	public void doWorking(){
		developer.gotoOffice();
		System.out.println("일하는 중...");
		developer.getoutOffice();
	}
}
