import StudentRegistrationSystem.Course;
import StudentRegistrationSystem.Module;
import StudentRegistrationSystem.Student;
import org.joda.time.DateTime;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CourseTest {

    // Testing Retrieval and manipulation of Data

    @Test
    @Order(1)
    public void retrievingAndManipulatingData() {

        // Creating Test Course

        Course bct = new Course("bct", new DateTime(2021,9,1,0,0), new DateTime(2022,5,31,0,0));

        // Verifying All Getters Work

        Assertions.assertEquals("bct", bct.getName());
        Assertions.assertEquals(new DateTime(2021,9,1,0,0), bct.getStartDate());
        Assertions.assertEquals(new DateTime(2022,5,31,0,0), bct.getEndDate());

        // Using Setters to Manipulate Data

        bct.setName("Computer Science");
        bct.setStartDate(new DateTime(2018,9,1,0,0));
        bct.setEndDate(new DateTime(2019,4,30,0,0));

        // Verifying All Setters Work

        Assertions.assertEquals("Computer Science", bct.getName());
        Assertions.assertEquals(new DateTime(2018,9,1,0,0), bct.getStartDate());
        Assertions.assertEquals(new DateTime(2019,4,30,0,0), bct.getEndDate());

    }

    // Testing Adding and Removing a Student

    @Test
    @Order(2)
    public void addingAndRemovingStudent() {

        // Creating Test Course and Student

        Course bct = new Course("bct", new DateTime(2021,9,1,0,0), new DateTime(2022,5,31,0,0));
        Student dave = new Student("Dave", 21, new DateTime(2000,4,26,0,0));

        // Adding Student to Course

        bct.addStudent(dave, true);

        // Verifying Course has Student and Student has Course

        Assertions.assertEquals("Dave", bct.getStudents().get(0).getName());
        Assertions.assertEquals("bct", dave.getCourses().get(0).getName());

        // Removing Student from Course

        bct.removeStudent(dave, true);

        // Verifying Course No Longer has Student and Student No Longer has Course

        Assertions.assertTrue(bct.getStudents().isEmpty());
        Assertions.assertTrue(dave.getCourses().isEmpty());

    }

    // Testing Adding and Removing a Module

    @Test
    @Order(3)
    public void addingAndRemovingModule() {

        // Creating Test Course and Test Module

        Course bct = new Course("bct", new DateTime(2021,9,1,0,0), new DateTime(2022,5,31,0,0));
        Module ct417 = new Module("Software Engineering", "CT417");

        // Adding Module to Course

        bct.addModule(ct417, true);

        // Verifying Course Has Module and Module Has Course

        Assertions.assertEquals("Software Engineering", bct.getModules().get(0).getName());
        Assertions.assertEquals("bct", ct417.getCourses().get(0).getName());

        // Removing Module from Course

        bct.removeModule(ct417, true);

        // Verifying Course No Longer has Module and Module No Longer has Course

        Assertions.assertTrue(bct.getModules().isEmpty());
        Assertions.assertTrue(ct417.getCourses().isEmpty());

    }
}