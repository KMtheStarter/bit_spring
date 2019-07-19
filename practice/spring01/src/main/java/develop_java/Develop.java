package develop_java;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
//�������� ���ϰ�, ���Ե� ��ü�� ���� �����ϱ� ������ Service
public class Develop {
	
	@Autowired
	@Qualifier("programmer")
	private Developer developer;
	
	public Develop() {
		super();
		// TODO Auto-generated constructor stub
		System.out.println("develop() ȣ��");
	}
	
	public Develop(Developer developer) {
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
