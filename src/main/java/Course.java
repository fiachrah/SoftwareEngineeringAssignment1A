import java.util.ArrayList;
import org.joda.time.DateTime;

public class Course {

    // Initializing Variables

    private String name;
    private ArrayList<Student> students;
    private ArrayList<Module> modules;
    private DateTime startDate;
    private DateTime endDate;

    public Course(String name, DateTime startDate, DateTime endDate){

        // Constructing Course

        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.students = new ArrayList<Student>();
        this.modules = new ArrayList<Module>();

    }

    // Getters

    public String getName() {
        return name;
    }

    public DateTime getStartDate() {
        return startDate;
    }

    public DateTime getEndDate() {
        return endDate;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(DateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(DateTime endDate) {
        this.endDate = endDate;
    }

    // Adding Student Method

    public void addStudent(Student student, Boolean firstTimeLink){

        students.add(student);

        // Two Way Link is Created if Link is Being Made for First Time

        if(firstTimeLink) {

            student.addCourse(this, false);

        }
    }

    // Adding Module Method

    public void addModule(Module module, Boolean firstTimeLink){

        modules.add(module);

        // Two Way Link is Created if Link is Being Made for First Time

        if(firstTimeLink) {

            module.addCourse(this, false);

        }

    }

    // Removing Student Method

    public void removeStudent(Student student, Boolean firstTimeUnLink){

        students.remove(student);

        // Two Way Link is Broken if Link is Being Broken for First Time

        if(firstTimeUnLink) {

            student.removeCourse(this, false);

        }
    }

    // Removing Module Method

    public void removeModule(Module module, Boolean firstTimeUnLink){

        modules.remove(module);

        // Two Way Link is Broken if Link is Being Broken for First Time

        if(firstTimeUnLink) {

            module.removeCourse(this, false);

        }

    }
}
