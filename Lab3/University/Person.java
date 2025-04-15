package Lab3.University;

public class Person{
    private String name;
    private String address;
    private String phoneNum;
    private String email; 

    // Constructor with no parameters
    Person()
    {
        this.name="Siapa";
        this.address = "mana";
        this.phoneNum = "berapa";
        this.email = "apa@gmail.com";
    }

    // Constructor with parameters
    Person(String name,String address,String phoneNum, String email)
    {
        this.name= name;
        this.address = address;
        this.phoneNum = phoneNum;
        this.email = email;
    }

    // getter and setter for Name
    public String getName()
    {
        return this.name;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    // getter functions
    public String getAddress()
    {
        return this.address;
    }
    public String getPhoneNum()
    {
        return this.phoneNum;
    }
    public String getEmail()
    {
        return this.email;
    } 

    // Person Walk function
    public void walk()
    {
        System.out.printf("%s is walking.\n",this.getName());
    }

    @Override
    public String toString()
    {
        return String.format("Person : %s \n",this.getName());
    }
}