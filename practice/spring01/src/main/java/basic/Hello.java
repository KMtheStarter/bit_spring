package basic;

public class Hello {

	private Hello() {
		System.out.println("로딩완료");
	}
	
	public Hello getInstance() {
		return new Hello();
	}
}
