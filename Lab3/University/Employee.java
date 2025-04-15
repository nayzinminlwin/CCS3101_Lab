package Lab3.University;

public class Employee extends Person{

    private String office;
    private int salary;
    private java.util.Date dateHired;

    // Null Constructor
    // Constructor with default values
    Employee()
    {
        super();
        this.setName("Unknown Employee");
        this.office = "tak ada";
        this.salary = 0;
        this.dateHired = null;
    }

    // Constructor with parameters
    Employee(String name,String address,String phoneNum, String email,String office,int salary,java.util.Date dateHired)
    {
        super(name, address, phoneNum, email);
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    // Getter for office, dateHired
    public String getOffice()
    {
        return this.office;
    }
    public java.util.Date getDateHired()
    {
        return this.dateHired;
    }

    // Getter & Setter for Salary
    public int getSalary()
    {
        return this.salary;
    }
    public void setSalary(int salary)
    {
        this.salary = salary;
    }
    
    // toString overriding function
    @Override
    public String toString()
    {
        return String.format("Employee : %s \n",super.getName());
    }
}