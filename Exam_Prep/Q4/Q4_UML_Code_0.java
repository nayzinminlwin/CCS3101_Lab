package Q4;

interface Drivable {
	void drive();
}

interface Flyable {
	void fly();
}

abstract class Vehicle {
	protected String id;

	public Vehicle(String id) {
		this.id = id;
	}

	public void start() {
		System.out.println("The vehicle is starting.");
	}

	// missed return type (void)
	public abstract void operate();
}

// missed 's' in implements spellings
abstract class MotorVehicle extends Vehicle implements Drivable {
	protected int numWheels;

	public MotorVehicle(String id) {
		super(id);
		this.numWheels = 4;
	}

	public MotorVehicle(int numWheels, String id) {
		super(id);
		this.numWheels = numWheels;
	}

	public void accelerate() {
		System.out.println("Accelerating");
	}
}

abstract class Aircraft extends Vehicle implements Flyable {
	protected double wingSpan;

	public Aircraft(String id, double wS) {
		super(id);
		this.wingSpan = wS;
	}

	public void deployLandingGear() {
		System.out.println("Learning gear deployed.");
	}
}

class Car extends MotorVehicle implements Drivable {
	protected String model;

	public Car(String model, String id) {
		super(id);
		this.model = model;
	}

	public void drive() {
		System.out.println("Car Driving.");
	}

	@Override
	public void operate() {
		System.out.println("Car is operating.");
	}
}

class Plane extends Aircraft implements Flyable {
	protected String airline;

	public Plane(String id, double wingSpan, String airline) {
		super(id, wingSpan);
		this.airline = airline;
	}

	public void fly() {
		System.out.println("Plane is flying.");
	}

	@Override
	public void operate() {
		System.out.println("Plane is operating.");
	}
}

class AmphibiousVehicle extends Vehicle implements Drivable, Flyable {
	protected int capacity;

	public AmphibiousVehicle(String id, int capacity) {
		super(id);
		this.capacity = capacity;
	}

	public void drive() {
		System.out.println("Driving on land.");
	}

	public void fly() {
		System.out.println("Now i am flying.");
	}

	@Override
	public void operate() {
		System.out.println("Operating well.");
	}
}
