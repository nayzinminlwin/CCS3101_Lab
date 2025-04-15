package Lab3.University;

public class Staff extends Employee{

    private String title;

    // Constructor with no parameters
    Staff()
    {
        super();
        this.setName("Unknown Staff");
        this.title = "NULL";
    }

    // Constructor with parameters
    Staff(String name,String address,String phoneNum, String email,String office,int salary,java.util.Date dateHired,String title)
    {
        super(name, address, phoneNum, email, office, salary, dateHired);
        this.title = title;
    }

    // getter function for title
    public String getTitle()
    {
        return this.title;
    }

    @Override
    public String toString()
    {
        return String.format("Staff : %s \n",this.getName());
    }
}