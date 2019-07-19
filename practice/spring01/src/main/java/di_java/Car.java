package di_java;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Car {
	@Autowired
	@Qualifier("hanTire")
//	@Resource(name="kumTire")
	private Tire tire;
	private Tire spareTire;
	
	// �⺻������: alt shift s c
	public Car() {System.out.println("Car() ȣ��");}
	
	//@Autowired
	// �Ű����� ������: alt shift s o
	// ���⼱ @Autowired ��� �Ұ�
	public Car(/*@Qualifier("kumTire")*/Tire tire) {
		System.out.println("Car(Tire) ȣ��");
		this.tire = tire;
	}
	public Car(Tire tire, Tire spareTire) {
		System.out.println("Car(Tire, Tire) ȣ��");
		this.tire = tire;
		this.spareTire = spareTire;
	}
	public Car(Tire tire, Tire spareTire, int num) {
		System.out.println("Car(Tire, Tire, int) ȣ��: " + num);
		this.tire = tire;
		this.spareTire = spareTire;
	}
	public String getTireBrand() {
		return tire.getBrand();
	}
	public String getSpareTireBrand() {
		if (spareTire == null) {
			return "������";
		}
		return spareTire.getBrand();
	}
	
	
	//@Autowired
	//@Qualifier("hanTire")
	// setter/getter: alt shift s r
	//@Resource
	public void setTire(Tire tire) {
		System.out.println("setTire ȣ��");
		this.tire = tire;
	}	
	public void setSpareTire(Tire tire) {
		System.out.println("setSpareTire ȣ��");
		this.spareTire = tire;
	}
}