package Baitap2;

public class Circle {
	private double radius;
	private String color;
	
	public Circle() {
		this.radius = 1.0;
		this.color = "red";
	}
	
	public Circle( double radius) {
		this.radius = radius;
		this.color = "red";
	}
	
	public double getRadius () {
		return this.radius;
	}
	
	public void setRadius ( double radius) {
		this.radius = radius;
	}
	
	public double getArea () {
		return this.radius*this.radius*Math.PI; 
	}
	
	public String toString () {
		return "Circle[radius=" + this.radius + "]";
	}
	
}