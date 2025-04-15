package Lab3.University;

public class Student extends Person{

    private ClassStatus classStatus;

    // Constructor with no parameters
    Student()
    {
        super();
        this.setName("Unknown Student");
        this.classStatus = new ClassStatus("freshman");
    }

    // Constructor with parameters
    Student(String name,String address,String phoneNum, String email,String classStatusString)
    {
        super(name, address, phoneNum, email);
        this.classStatus = new ClassStatus(classStatusString);
    }

    @Override
    public String toString()
    {
        return String.format("Student : %s \nStudent status : %s \n ",this.getName(),this.classStatus.getClassStatus());
    }
}
