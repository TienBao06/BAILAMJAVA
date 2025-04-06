package Baitap2;

public class Main2 {

	public static void main(String[] args) {
		Circle c1 = new Circle(3);
		System.out.println(c1);
		Circle c2 = new Circle();
		System.out.println(c2);
		
		c1.setRadius(10.3);
		System.out.println(c1);
		
		System.out.printf("area is : %.2f", c1.getArea());
	}

}