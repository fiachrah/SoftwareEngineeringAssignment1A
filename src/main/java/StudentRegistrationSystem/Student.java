package StudentRegistrationSystem;

import java.util.ArrayList;

import org.joda.time.DateTime;

public class Student {

    // Initializing Variables

    private String name;
    private int ID;
    private int age;
    private DateTime DOB;
    private String username;
    private ArrayList<Course> courses;
    private ArrayList<Module> modules;

    private static int numStudents = 0;

    public Student(String name, int age, DateTime DOB){

        // Incrementing Num of Students

        numStudents = numStudents+1;

        // Constructing Student

        this.name = name;
        this.ID = numStudents;
        this.age = age;
        this.DOB = DOB;
        this.username = getUsername();
        this.courses = new ArrayList<Course>();
        this.modules = new ArrayList<Module>();

    }

    // Getters

    public String getName() {
        return name;
    }

    public int getID(){
        return  ID;
    }

    public int getAge() {
        return age;
    }

    public DateTime getDOB() {
        return DOB;
    }

    public String getUsername() {
        return name+age;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    // Setters

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setDOB(DateTime DOB) {
        this.DOB = DOB;
    }

    // Adding Course Method

    public void addCourse(Course course, Boolean firstTimeLink){

        courses.add(course);

        // Two Way Link is Created if Link is Being Made for First Time

        if(firstTimeLink) {

            course.addStudent(this, false);

        }
    }

    // Adding Module Method

    public void addModule(Module module, Boolean firstTimeLink){

        modules.add(module);

        // Two Way Link is Created if Link is Being Made for First Time

        if(firstTimeLink) {

            module.addStudent(this, false);

        }

    }

    // Removing Course Method

    public void removeCourse(Course course, Boolean firstTimeUnLink){

        courses.remove(course);

        // Two Way Link is Broken if Link is Being Broken for First Time

        if(firstTimeUnLink) {

            course.removeStudent(this, false);

        }
    }

    // Removing Module Method

    public void removeModule(Module module, Boolean firstTimeUnLink){

        modules.remove(module);

        // Two Way Link is Broken if Link is Being Broken for First Time

        if(firstTimeUnLink) {

            module.removeStudent(this, false);

        }

    }
}