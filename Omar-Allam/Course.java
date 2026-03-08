public class Course {

    private String name;
    private int creditHours;
    private String grade;

    public Course(String name, int creditHours, String grade) {
        this.name = name;
        this.creditHours = creditHours;
        this.grade = grade;
    }

public double getMark() {
    String g = grade.trim().toUpperCase(); 
    switch (g) {
        case "A+": return 4.0;
        case "A":  return 3.7;
        case "A-": return 3.4;
        case "B+": return 3.2;
        case "B":  return 3.0;
        case "B-": return 2.8;
        case "C+": return 2.6;
        case "C":  return 2.4;
        case "C-": return 2.2;
        case "D+": return 2.0;
        case "D":  return 1.5;
        case "D-": return 1.0;
        default:   return 0.0;
    }
}

    public int getCreditHours() {
        return creditHours;
    }
}