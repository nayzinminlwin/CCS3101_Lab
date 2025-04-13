package Lab3.University;

public class Student extends Person{

    private final String classStatus;

    Student()
    {
        super();
        this.setName("Unknown Student");
        this.classStatus = "NULL";
    }

    Student(String name,String address,String phoneNum, String email,String classStatus)
    {
        super(name, address, phoneNum, email);
        this.classStatus = classStatus;
    }

    @Override
    public String toString()
    {
        return String.format("Student : %s \n",this.getName());
    }
}