package develop_xml;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Develop {

	private Developer developer;
	
	
	
	public Develop() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("develop() ȣ��");
	}

	
	@Autowired
	public Develop(@Qualifier("programmer")Developer developer) {
		super();
		this.developer = developer;
		System.out.println("�����ִ� develop() ȣ��");
	}



	public void doWorking(){
		developer.gotoOffice();
		System.out.println("���ϴ� ��...");
		developer.getoutOffice();
	}
}
