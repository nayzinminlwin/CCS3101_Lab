package Lab1;

public class Lab1_Exercise_Q2
{
    public static void main(String[] args)
    {
        // Testing Kosong Constructor method
        Stock nzStock = new Stock();
        System.out.printf("%s,%s Stocks increased %.0f%% in 24hr.\n\n",nzStock.getSymbol(),nzStock.getName(),nzStock.getChangePercentage());
    
        // Tesla Collapse
        Stock tsla = new Stock("TSLA","Tesla Inc",288,89);
        System.out.printf("%s,%s Stocks drifted %.0f%% in 24hr.\n",tsla.getSymbol(),tsla.getName(),tsla.getChangePercentage());
    
        // tsla.currentPrice = -100;
        tsla.setCurrentPrice(-100);
        System.out.printf("Tesla is now bankrupted with dropping from $%.2f to $%.2f with percentage %.0f%%. \n\n",tsla.getPreviousClosingPrice(),tsla.getCurrentPrice(),tsla.getChangePercentage());
    
        // Oracle Corporation Stocks
        Stock newStock = new Stock("ORCL","Oracle Corporation",0,34.5);
        // newStock.currentPrice = 34.35;
        newStock.setCurrentPrice(34.35);

        // Following if block will print stock up and down percentages accordingly utilizing math.absolute function.
        if(newStock.getChangePercentage()>0)
            System.out.printf("%s,%s Stocks climbed from $%.2f to $%.2f with %.2f%% rate in 24hr.\n",newStock.getSymbol(),newStock.getName(),newStock.getPreviousClosingPrice(),newStock.getCurrentPrice(),newStock.getChangePercentage());
        else
            System.out.printf("%s,%s Stocks declined from $%.2f to $%.2f with %.2f%% rate in 24hr.\n",newStock.getSymbol(),newStock.getName(),newStock.getPreviousClosingPrice(),newStock.getCurrentPrice(),Math.abs(newStock.getChangePercentage()));
    }
}

class Stock
{
    private String symbol;
    private String name;

    private double previousClosingPrice;
    private double currentPrice;

    Stock()
    {
        this.symbol = "NZML";
        this.name = "Nay Zin Min Lwin Group of Companies";

        previousClosingPrice = 100;
        currentPrice = 200;
    }

    Stock(String symbol, String name, double previousClosingPrice, double currentPrice)
    {
        this.symbol = symbol;
        this.name = name;
        this.previousClosingPrice = previousClosingPrice;
        this.currentPrice = currentPrice;
    }

    public String getName() {
        return name;
    }
    public String getSymbol() {
        return symbol;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }
    public double getPreviousClosingPrice() {
        return previousClosingPrice;
    }

    public void setCurrentPrice(double currentPrice)
    {
        // when new price come, current price will be stored in the previousClosingPrice.
        this.previousClosingPrice = this.currentPrice;
        this.currentPrice = currentPrice;
    }

    public double getChangePercentage()
    {
        return ((currentPrice-previousClosingPrice)/previousClosingPrice) *100;
    }

}