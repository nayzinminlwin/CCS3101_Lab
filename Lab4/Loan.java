package Lab4;

public class Loan
{
    private double amount;
    private double interest;
    private MyDate startingDate;
    private MyDate endDate;
    public int dayCount;

    // Full parameter Constructor
    Loan(double amount,double interest,MyDate sDate, MyDate eDate)
    {
        this.amount = amount;
        this.interest = interest;
        this.startingDate = sDate;
        this.endDate = eDate; 

        // this will substract startdate from enddate and get the total days
        this.dayCount = MyDate.CountDays(this.startingDate, this.endDate);

        // if dayCount is minus value, it mean user inserted endDate and startDate in reversed
        if(this.dayCount<0)
        {   // so i will swap the dates
            MyDate container = this.startingDate;
            this.startingDate = this.endDate;
            this.endDate = container;
            this.dayCount = MyDate.CountDays(this.startingDate, this.endDate); // and recall the function.
        } 
    }

    // Loan Calculation function
    public double calcuateLoan()
    {
        double totalAmont;
        double interestAmount = (this.amount * this.interest * this.dayCount)/(365*100);
        totalAmont = this.amount + interestAmount;

        return totalAmont;
    }

    // getter function for total days between two dates
    public int getDayCount()
    {
        return this.dayCount;
    }

    @Override
    public String toString()
    {
        String rString = String.format("This Loan for %d days from %s will due on %s,with amount : %.2fRM.",this.getDayCount(),this.startingDate, this.endDate,this.calcuateLoan());
        return rString;
    }
}