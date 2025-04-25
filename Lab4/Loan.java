package Lab4;

public class Loan
{
    private double amount;
    private double interest;
    private MyDate startingDate;
    private MyDate endDate;
    public int dayCount;

    Loan(double amount,double interest,MyDate sDate, MyDate eDate)
    {
        this.amount = amount;
        this.interest = interest;
        this.startingDate = sDate;
        this.endDate = eDate; 
        this.dayCount = MyDate.CountDays(startingDate, endDate);
    }

    public double calcuateLoan()
    {
        double totalAmont;
        double interestAmount = (this.amount * this.interest * this.dayCount)/(365*100);
        totalAmont = this.amount + interestAmount;

        return totalAmont;
    }

    public int getDayCount()
    {
        return this.dayCount;
    }

    public String toString()
    {
        String rString = String.format("This Loan for %d days from %s will due on %s,with amount : %.2fRM.",this.getDayCount(),this.startingDate, this.endDate,this.calcuateLoan());
        return rString;
    }
}