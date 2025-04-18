package Test1_Prac;

public class Ride{
    private static int rideCounter = 0;
    private String rideID;
    private Driver d0;
    private Passenger p0;
    private double distance;
    private double fare;

    Ride(Driver d0, Passenger p0, double distance)
    {
        this.rideID = "Ride"+(rideCounter+1);
        this.d0 = d0;
        this.p0 = p0;
        this.distance = distance;
        // System.out.println("Current distance is : "+ this.distance);
        this.fare = distance *10.0;

        rideCounter++;
    }

    public String getRideID()
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

    public static int getRideCount()
    {
        return rideCounter;
    }

}