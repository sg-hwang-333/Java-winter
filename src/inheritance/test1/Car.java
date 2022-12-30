package inheritance.test1;

public class Car {
	String manufacturer;
	String name;
	int money;
	
	//public Car() {
	//	System.out.println("Car() 생성자 호출됨");
	//}
	public Car(String manufacturer, String name, int money) {
		super();
		this.manufacturer = manufacturer;
		this.name = name;
		this.money = money;
		System.out.println("Car() 생성자 호출됨");
	}



	public void start() {
		System.out.println("(Car) 시동을 건다");
	}
}
