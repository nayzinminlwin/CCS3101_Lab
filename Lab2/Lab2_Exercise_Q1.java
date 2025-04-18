package Lab2;
public class Lab2_Exercise_Q1{
    public static void main(String[] args) {

        // Creating Student Objects
        Student s1 = new Student("Peter Jones");
        Student s2 = new Student("Kim Smith");
        Student s3 = new Student("IU");

        // Creating Course Objects
        Course cDataStructure = new Course("Data Structure");
        Course cDatabase = new Course("Database Systems");
        Course cAlgo = new Course("Algorithm Course");

        // Registering Courses for each student
        RegisterCourse(s1,cDataStructure);
        RegisterCourse(s2,cDataStructure);
        RegisterCourse(s2,cDatabase);
        // RegisterCourse(s1, cAlgo);
        // RegisterCourse(s3,cDatabase);

        // Printing Students in each course
        System.out.printf("Students registered for %s Course\n",cDataStructure.getCourseName());
        for(Student s : cDataStructure.getClassList())
        {
            System.out.println(s.getStudentName());
        }

        System.out.printf("\nStudents registered for %s Course\n",cDatabase.getCourseName());
        for(Student s : cDatabase.getClassList())
        {
            System.out.println(s.getStudentName());
        }

        System.out.printf("\nStudents registered for %s Course\n",cAlgo.getCourseName());
        for(Student s : cAlgo.getClassList())
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

        
        // Checking if there are students with no course registration.
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

    // Course registration function 
    public static void RegisterCourse(Student s,Course c)
    {
        // adding student to course and course to student
        c.addStudent(s);
        s.addCourse(c);
    }
}