package basic;

public class Hello {

	private Hello() {
		System.out.println("�ε��Ϸ�");
	}
	
	public Hello getInstance() {
		return new Hello();
	}
}
