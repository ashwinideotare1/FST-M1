package activities;

public class Car {
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	Car(){
		this.tyres=4;
		this.doors=4;	
	}

	public void displayCharacteristics() {
		System.out.println("tyres is "+ tyres);
		System.out.println("doors is "+ doors);
		System.out.println("Make is "+ make);
		System.out.println("color is "+ color);
		System.out.println("transmission is "+ transmission);
	}
	
	public void brake() {
		System.out.println("Car has stopped.");
	}

	public void accelerate() {
		System.out.println("Car is moving forward.");		
		
	}
}
