package di_xml;

public class Car {
	private Tire tire;
	private Tire spareTire;
	
	// 기본생성자: alt shift s c
	public Car() {}
	// 매개변수 생성자: alt shift s o
	public Car(Tire tire) {
		System.out.println("Car(Tire) 호출");
		this.tire = tire;
	}
	public Car(Tire tire, Tire spareTire) {
		System.out.println("Car(Tire, Tire) 호출");
		this.tire = tire;
		this.spareTire = spareTire;
	}
	public Car(Tire tire, Tire spareTire, int num) {
		System.out.println("Car(Tire, Tire, int) 호출: " + num);
		this.tire = tire;
		this.spareTire = spareTire;
	}
	public String getTireBrand() {
		return tire.getBrand();
	}
	public String getSpareTireBrand() {
		if (spareTire == null) {
			return "미장착";
		}
		return spareTire.getBrand();
	}
	// setter/getter: alt shift s r
	public void setTire(Tire tire) {
		System.out.println("setTire 호출");
		this.tire = tire;
	}	
	public void setSpareTire(Tire tire) {
		System.out.println("setSpareTire 호출");
		this.spareTire = tire;
	}	
}