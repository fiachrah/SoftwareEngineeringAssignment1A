import java.util.ArrayList;

public class Module {

    // Initializing Variables

    private String name;
    private String ID;
    private ArrayList<Course> courses;
    private ArrayList<Student> students;

    public Module(String name, String ID){

        // Constructing Module

        this.name = name;
        this.ID = ID;
        this.courses = new ArrayList<Course>();
        this.students = new ArrayList<Student>();

    }

    // Getters

    public String getName() {
        return name;
    }

    public String getID() {
        return ID;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    // Adding Course Method

    public void addCourse(Course course, Boolean firstTimeLink){

        courses.add(course);

        // Two Way Link is Created if Link is Being Made for First Time

        if(firstTimeLink) {

            course.addModule(this, false);

        }
    }

    // Adding Student Method

    public void addStudent(Student student, Boolean firstTimeLink){

        students.add(student);

        // Two Way Link is Created if Link is Being Made for First Time

        if(firstTimeLink) {

            student.addModule(this, false);

        }

    }

    // Removing Course Method

    public void removeCourse(Course course, Boolean firstTimeUnLink){

        courses.remove(course);

        // Two Way Link is Broken if Link is Being Broken for First Time

        if(firstTimeUnLink) {

            course.removeModule(this, false);

        }
    }

    // Removing Student Method

    public void removeStudent(Student student, Boolean firstTimeUnLink){

        students.remove(student);

        // Two Way Link is Broken if Link is Being Broken for First Time

        if(firstTimeUnLink) {

            student.removeModule(this, false);

        }

    }
}