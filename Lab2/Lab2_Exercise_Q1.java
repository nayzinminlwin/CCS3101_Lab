package Lab2;
public class Lab2_Exercise_Q1{
    public static void main(String[] args) {

        // Intializing Students and Courses
        Student s1 = new Student("Peter Jones");
        Student s2 = new Student("Kim Smith");
        Student s3 = new Student("IU");

        Course c1 = new Course("Data Structure");
        Course c2 = new Course("Database Systems");

        // Registering Courses for each student
        RegisterCourse(s1,c1);
        RegisterCourse(s2,c1);
        RegisterCourse(s2,c2);
        // RegisterCourse(s3,c2);

        // Printing Students in each course
        System.out.printf("Students registered for %s Course\n",c1.getCourseName());
        for(Student s : c1.getClassList())
        {
            System.out.println(s.getStudentName());
        }

        System.out.printf("\nStudents registered for %s Course\n",c2.getCourseName());
        for(Student s : c2.getClassList())
        {
            System.out.println(s.getStudentName());
        }

        // Printing Courses registerd by each students
        System.out.printf("\n%s takes the following courses\n",s1.getStudentName());
        for(Course c : s1.getRegisteredCourses())
        {
            System.out.println(c.getCourseName());
        }
        System.out.printf("\n%s takes the following courses\n",s2.getStudentName());
        for(Course c: s2.getRegisteredCourses())
        {
            System.out.println(c.getCourseName());
        }
        
        if(s3.getRegisteredCourses().isEmpty())
            System.out.printf("\n%s is very bad student, dia dont take any course.\n",s3.getStudentName());
        else
        {
            System.out.printf("\n%s takes the following courses\n",s3.getStudentName());
            for(Course c: s3.getRegisteredCourses())
            {   
                System.out.println(c.getCourseName());
            }
        }
    }
    public static void RegisterCourse(Student s,Course c)
    {
        c.addStudent(s);
        s.addCourse(c);
    }
}