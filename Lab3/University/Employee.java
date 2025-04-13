package Lab3.University;

public class Employee extends Person{

    private String office;
    private int salary;
    private java.util.Date dateHired;

    Employee()
    {
        super();
        this.setName("Unknown Employee");
        this.office = "tak ada";
        this.salary = 0;
        this.dateHired = null;
    }

    Employee(String name,String address,String phoneNum, String email,String office,int salary,java.util.Date dateHired)
    {
        super(name, address, phoneNum, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    @Override
    public String toString()
    {
        return String.format("Employee : %s \n",super.getName());
    }
}