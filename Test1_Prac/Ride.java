package Test1_Prac;

public class Ride{
    private int rideID;
    private Driver d0;
    private Passenger p0;
    private double distance;
    private double fare;

    Ride(int rideID, Driver d0, Passenger p0, double distance)
    {
        this.rideID = rideID;
        this.d0 = d0;
        this.p0 = p0;
        this.distance = distance;
        // System.out.println("Current distance is : "+ this.distance);
        this.fare = distance *10.0;
    }

    public int getRideID()
    {
        return this.rideID;
    }

    public Driver getDriver()
    {
        return this.d0;
    }

    public String getFare()
    {
        return String.format("%.2fm cost %.2fRM.\n", this.distance, this.fare);
    }

}