import org.joda.time.DateTime;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class StudentTest {

    // Testing Retrieval and Manipulation of Data

    @Test
    @Order(1)
    public void retrievingAndManipulatingData() {

        // Creating Test Student

        Student dave = new Student("Dave", 21, new DateTime(2000,4,26,0,0));

        // Verifying all Getters Work and ID/Username are Created Correctly

        Assertions.assertEquals("Dave", dave.getName());
        Assertions.assertEquals(21, dave.getAge());
        Assertions.assertEquals(1, dave.getID());
        Assertions.assertEquals(new DateTime(2000,4,26,0,0), dave.getDOB());
        Assertions.assertEquals("Dave21", dave.getUsername());

        // Manipulating Data using Setters

        dave.setName("David");
        dave.setAge(19);
        dave.setDOB(new DateTime(2002,4,26,0,0));

        // Verifying all Setters Work and Username Updates Accordingly

        Assertions.assertEquals("David", dave.getName());
        Assertions.assertEquals(19, dave.getAge());
        Assertions.assertEquals(new DateTime(2002,4,26,0,0), dave.getDOB());
        Assertions.assertEquals("David19", dave.getUsername());

    }

    // Testing Adding and Removing a Course

    @Test
    @Order(2)
    public void addingAndRemovingCourse() {

        // Creating Test Student and Course

        Student dave = new Student("Dave", 21, new DateTime(2000,4,26,0,0));
        Course bct = new Course("bct", new DateTime(2021,9,1,0,0), new DateTime(2022,5,31,0,0));

        // Adding Course to Student

        dave.addCourse(bct, true);

        // Verifying Student Now Has Course and Course Now Has Student

        Assertions.assertEquals("bct", dave.getCourses().get(0).getName());
        Assertions.assertEquals("Dave", bct.getStudents().get(0).getName());

        // Removing Course from Student

        dave.removeCourse(bct, true);

        // Verifying Student No Longer Has Course and Course No Longer Has Student

        Assertions.assertTrue(dave.getCourses().isEmpty());
        Assertions.assertTrue(bct.getStudents().isEmpty());

    }

    // Testing Adding and Removing a Module

    @Test
    @Order(3)
    public void addingAndRemovingModule() {

        // Creating Test Student and Module

        Student dave = new Student("Dave", 21, new DateTime(2000,4,26,0,0));
        Module ct417 = new Module("Software Engineering", "CT417");

        // Adding Module to Student

        dave.addModule(ct417, true);

        // Verifying Student Now Has Module and Module Now Has Student

        Assertions.assertEquals("Software Engineering", dave.getModules().get(0).getName());
        Assertions.assertEquals("Dave", ct417.getStudents().get(0).getName());

        // Removing Module from Student

        dave.removeModule(ct417, true);

        // Verifying Student No Longer Has Module and Module No Longer Has Student

        Assertions.assertTrue(dave.getModules().isEmpty());
        Assertions.assertTrue(ct417.getStudents().isEmpty());

    }
}