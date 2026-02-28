import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print( "please enter student name : ");
        String studentName = input.nextLine();

        Student s = new Student(studentName);

        System.out.print ("please enter number of courses : ");
        int n = input.nextInt();
        input.nextLine(); // leftover newline

        for (int i = 1; i <= n; i++) {
            System.out.println("\nCourse " + i);

            System.out.print("Course name: ");
            String courseName = input.nextLine();

            System.out.print("Credit hours: ");
            int creditHours = Integer.parseInt(input.nextLine());

            System.out.print("Grade: ");
            String grade = input.nextLine();

            Course c = new Course(courseName, creditHours, grade);
            s.addCourse(c);
        }
                
        double gpa = s.calculateGPA();
        System.out.print(studentName + "'s GPA = " + gpa);

        input.close();
    }
}

// javac Main.java
// java Main