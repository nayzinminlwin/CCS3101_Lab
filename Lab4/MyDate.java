package Lab4;

public class MyDate
{
    private int day;
    private int month;
    private int year;

    // Full perimeter constructor
    MyDate(int d, int m, int y)
    {
        this.day = d;
        this.month = m;
        this.year = y;
    }

    // getters
    public int getYear()
    {
        return this.year;
    }
    public int getMonth()
    {
        return this.month;
    }
    public int getDay()
    {
        return this.day;
    }

    // the almighty counting days function between two dates
    public static int CountDays(MyDate d1, MyDate d2)
    {
        int yearCount = d2.getYear() - d1.getYear();
        int monthCount = d2.getMonth() - d1.getMonth();
        int dayCount = d2.getDay() - d1.getDay();

        // What if 
        // endDate     : 11.1.2025 
        // startDate   : 12.12.2024
        // so we borrow 30 days from month, and 12 months from year like decimal calcuations.

        if(dayCount<0) // daycount minusValue mean endDay>startDay, so borrow 30days.
        {
            monthCount--;
            dayCount+=30;
        }
        if(monthCount<0) // monthCount minusValue mean endMonth>startMonth, so borrow 12months.
        {
            yearCount--;
            monthCount+=12;
        }

        int totalDay = (yearCount * 365) + (monthCount*30) + dayCount;
        
        // System.out.println("daycount : " +totalDay);

        // if totalDay<0, it is endDate < startDate
        // totalDay = totalDay>=0 ? totalDay: 0;

        return totalDay;
    }

    @Override
    public String toString()
    {
        String rString = String.format("%d-%d-%d", this.getDay(),this.getMonth(),this.getYear());
        return rString;
    }
}