package Lab3.University;

public class Faculty extends Employee{

    private String rank;
    private int officeHour;

    // Constructor with no parameters
    Faculty()
    {
        super();
        this.setName("Unknown Faculty Staff");
        this.rank = "NULL";
        this.officeHour = 0;
    }

    // Constructor with parameters
    Faculty(String name,String address,String phoneNum, String email,String office,int salary,java.util.Date dateHired,String rank, int officeHour)
    {
        super(name, address, phoneNum, email, office, salary, dateHired);
        this.rank = rank;
        this.officeHour = officeHour;
    }

    // getter functions
    public String getRank()
    {
        return this.rank;
    }
    public int getOfficeHour()
    {
        return this.officeHour;
    }

    @Override
    public String toString()
    {
        return String.format("Faculty Staff : %s \n",this.getName());
    }
}