import java.util.ArrayList;

public class Student {

    private String name;
    private ArrayList<Course> courses;

    public Student(String name) {
        this.name = name;
        courses = new ArrayList<>();
    }

    public void addCourse(Course c) {
        courses.add(c);
    }

    public double calculateGPA() {

        double total = 0;
        int hours = 0;

        for (Course c : courses) {
            total += c.getMark() * c.getCreditHours();
            hours += c.getCreditHours();
        }

        if (total == 0) return 0.0;

        return total / hours ;
    }
}
