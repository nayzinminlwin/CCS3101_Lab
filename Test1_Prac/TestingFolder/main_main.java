package Test1_Prac.TestingFolder;
// package Test1_Prac;
// //     private String color;

// //     Room(String newColor) {
// //         this.color = newColor;
// //     }

// //     public String getColor() {
// //         return this.color;
// //     }

// //     public void setColor(String newColor) {
// //         this.color = newColor;
// //     }
// // }

// // class House {
// //     private String address;
// //     private Room room;

// //     House(String newAddress, String newRoom) {
// //         this.address = newAddress;
// //         this.room.setColor(newRoom);
// //     }

// //     public void getInfo() {
// //         System.out.println(this.address);
// //         System.out.println(this.room.getColor());
// //     }
// // }

// mock test code goes from here
class People {
    protected String name;
    protected int phone;

    People(String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhone() {
        return this.phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}

class Driver extends People {
    Driver(String name, int phone) {
        super(name, phone);
    }
}

class Passenger extends People {
    Passenger(String name, int phone) {
        super(name, phone);
    }
}

class Ride {
    private Driver driver;
    private Passenger passenger;
    private int ride_id;
    private double distance;
    private double fare;

    Ride(Driver newDriver, Passenger newPassenger, int newRide_id, double newDistance) {
        this.driver = newDriver;
        this.passenger = newPassenger;
        this.ride_id = newRide_id;
        this.distance = newDistance;
        this.fare = newDistance * 10;
    }

    public void printDriver() {
        System.out.println("Name: " + this.driver.getName());
        System.out.println("Number: " + this.driver.getPhone());
    }

    public void printPassenger() {
        System.out.println("Name: " + this.passenger.getName());
        System.out.println("Number: " + this.passenger.getPhone());
    }

    public void printId() {
        System.out.println(this.ride_id);
    }

    public void printDistance() {
        System.out.println(this.distance);
    }

    public void printFare() {
        System.out.println(this.fare);
    }
}

public class main_main {
    public static void main(String[] args) {
        Passenger passenger1 = new Passenger("Ryan", 123);
        Driver driver1 = new Driver("Iqmal", 321);
        Ride newRide = new Ride(driver1, passenger1, 0, 10);

        System.out.println(newRide);
    }
}
