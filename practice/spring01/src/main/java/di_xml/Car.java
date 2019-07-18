package di_xml;

public class Car {
	private Tire tire;
	private Tire spareTire;
	
	// �⺻������: alt shift s c
	public Car() {}
	// �Ű����� ������: alt shift s o
	public Car(Tire tire) {
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
	// setter/getter: alt shift s r
	public void setTire(Tire tire) {
		System.out.println("setTire ȣ��");
		this.tire = tire;
	}	
	public void setSpareTire(Tire tire) {
		System.out.println("setSpareTire ȣ��");
		this.spareTire = tire;
	}	
}