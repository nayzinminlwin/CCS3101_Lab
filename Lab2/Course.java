package Lab2;
import java.util.ArrayList;
import java.util.List;

public class Course{
    private String name;

    // constructor
    Course(String courseName)
    {
        this.name = courseName;
    }

    // getter for course name
    public String getCourseName()
    {
        return this.name;
    }

    // private Student[] classList = new Student[10]; // Initialize with a fixed size
    private List<Student> classList = new ArrayList<Student>();
    // Used arraylist instead of array to pass the initialization error and array length limitation
 
    public void addStudent(Student s){
        classList.add(s);
    }

    public List<Student> getClassList()
    {
        return this.classList;
    }
}