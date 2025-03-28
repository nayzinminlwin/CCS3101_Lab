package Lab2;
import java.util.ArrayList;
import java.util.List;

public class Student{
    private String studentName;

    Student(String name)
    {
        this.studentName = name;
    }
    public String getStudentName()
    {
        return this.studentName;
    }

    // private Course[] courseList = new Course[10];
    private List<Course> courseList = new ArrayList<Course>();
    // Used arraylist instead of array to pass the initialization error and array length limitation

    public void addCourse(Course c){
        courseList.add(c);
    }

    public List<Course> getRegisteredCourses()
    {
        return this.courseList;
    }
}