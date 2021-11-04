import StudentRegistrationSystem.Course;
import StudentRegistrationSystem.Module;
import StudentRegistrationSystem.Student;
import org.joda.time.DateTime;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ModuleTest {

    // Testing Retrieval and Manipulation of Data

    @Test
    @Order(1)
    public void retrievingAndManipulatingData() {

        // Creating Test Module

        Module ct417 = new Module("Software Engineering", "CT417");

        // Verifying all Getters Work

        Assertions.assertEquals("Software Engineering", ct417.getName());
        Assertions.assertEquals("CT417", ct417.getID());

        // Manipulating Data using Setters

        ct417.setName("SE");
        ct417.setID("CT515");

        // Verifying all Setters Work

        Assertions.assertEquals("SE", ct417.getName());
        Assertions.assertEquals("CT515", ct417.getID());

    }

    // Testing Adding and Removing a Course

    @Test
    @Order(2)
    public void addingAndRemovingCourse() {

        // Creating Test Module and Course

        Module ct417 = new Module("Software Engineering", "CT417");
        Course bct = new Course("bct", new DateTime(2021,9,1,0,0), new DateTime(2022,5,31,0,0));

        // Adding Course To Module

        ct417.addCourse(bct, true);

        // Verifying Module Has Course and Course Has Module

        Assertions.assertEquals("Software Engineering", bct.getModules().get(0).getName());
        Assertions.assertEquals("bct", ct417.getCourses().get(0).getName());

        // Removing Course from Module

        ct417.removeCourse(bct, true);

        // Verifying Module No Longer Has Course and Course No Longer Has Module

        Assertions.assertTrue(ct417.getCourses().isEmpty());
        Assertions.assertTrue(bct.getStudents().isEmpty());

    }

    // Testing Adding and Removing a Student

    @Test
    @Order(3)
    public void addingAndRemovingStudent() {

        // Creating Test Module and Student

        Module ct417 = new Module("Software Engineering", "CT417");
        Student dave = new Student("Dave", 21, new DateTime(2000,4,26,0,0));

        // Adding Student to Module

        ct417.addStudent(dave, true);

        // Verifying Module Has Student and Student Has Module

        Assertions.assertEquals("Dave", ct417.getStudents().get(0).getName());
        Assertions.assertEquals("Software Engineering", dave.getModules().get(0).getName());

        // Removing Student from Module

        ct417.removeStudent(dave, true);

        // Verifying Module No Longer Has Student and Student No Longer Has Module

        Assertions.assertTrue(ct417.getStudents().isEmpty());
        Assertions.assertTrue(dave.getModules().isEmpty());

    }
}