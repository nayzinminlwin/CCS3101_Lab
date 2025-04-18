package Test1_Prac;

public class mainRides{
    public static void main(String[] args)
    {
        Driver d1 = new Driver("Encik", 601777777);
        Driver d2 = new Driver("Tuan",60888888);

        Passenger p1 = new Passenger("Cik", 9999);
        Passenger p2 = new Passenger("Siapa", 898989);

        Ride r1 = new Ride(d2, p2, 333.00);
        Ride r2 = new Ride(d1, p1, 30.00);
        Ride r3 = new Ride(d2, p1, 10.00);
        Ride r4 = new Ride(d1, p2, 0.01);

        Ride[] rides = new Ride[Ride.getRideCount()];
        rides[0] = r1;
        rides[1] = r2;
        rides[2] = r3;
        rides[3] = r4;
        int rideCounts = rides.length;

        for(int i=0;i<rideCounts;i++)
        {
            if(rides[i]==null) continue;
            System.out.printf("Ride ID : %s \nDriver : %s \nFare : %s\n", rides[i].getRideID(),rides[i].getDriver().getName(),rides[i].getFare());
        }

        System.out.println("Total rides created is : "+ Ride.getRideCount());
        
    }
}