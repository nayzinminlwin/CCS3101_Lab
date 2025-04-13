package Lab3.University;

public class Staff extends Employee{

    private String title;

    Staff()
    {
        super();
        this.setName("Unknown Staff");
        this.title = "NULL";
    }

    Staff(String name,String address,String phoneNum, String email,String office,int salary,java.util.Date dateHired,String title)
    {
        super(name, address, phoneNum, email, office, salary, dateHired);
        this.title = title;
    }

    @Override
    public String toString()
    {
        return String.format("Staff : %s \n",this.getName());
    }
}