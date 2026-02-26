package project.app;

import java.util.Scanner;
import java.util.ArrayList;
import project.shapes.*;

// import static project.utils.ShapeUtils.RANDOM_ID;
// import static project.utils.ShapeUtils.SYSTEM_NAME;
// import static project.utils.ShapeUtils.largest;
import static project.utils.ShapeUtils.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("System name: " + SYSTEM_NAME + "\nID: " + RANDOM_ID + "\n=============================\r\n"+ "Welcome to the shapes app!");
        ArrayList<Shape> shapes = new ArrayList<Shape>();
        while (true) {

            String menu = """
                    =====================================
                    1: Make a Circle.
                    2: Make a Rectangle.
                    3: Make a RightTriangle.
                    4: List all current shapes.
                    5: Remove a Shape.
                    6: Exit.
                    """;

            System.out.println(menu);
            int choice = scanner.nextInt();

            if (choice == 1) {
                System.out.print("Choose a radius: ");
                double radius = scanner.nextDouble();
                shapes.add(new Circle(radius));
                System.out.println(shapes.getLast().getType() + " is added!");

            } else if (choice == 2) {
                System.out.print("Choose a height: ");
                double height = scanner.nextDouble();

                System.out.print("\nChoose a width: ");
                double wid = scanner.nextDouble();
                shapes.add(new Rectangle(wid, height));
                System.out.println(shapes.getLast().getType() + " is added!");

            } else if (choice == 3) {
                System.out.print("Choose a height: ");
                double height = scanner.nextDouble();

                System.out.print("\nChoose a base: ");
                double base = scanner.nextDouble();
                shapes.add(new RightTriangle(base, height));
                System.out.println(shapes.getLast().getType() + " is added!");

            } else if (choice == 4) {
                if (!shapes.isEmpty()) {
                    int counter = 0;
                    for (Shape sh : shapes) {
                        counter++;
                        System.out.println("Shape order: " + counter);
                        System.out.println("Shape type: " + sh.getType());
                        System.out.println("Area: " + sh.area());
                        System.out.println("perimeter: " + sh.perimeter());
                        System.out.println("=====================================");
                    }
                } else {
                    System.out.println("No shapes were added yet!");
                }

            } else if (choice == 5 && !shapes.isEmpty()) {
                System.out.println("What is the order of the shape to remove?");
                choice = scanner.nextInt();
                System.out.println(shapes.get(choice - 1).getType() + " is removed!");
                shapes.remove(choice - 1);

            } else if (choice == 6) {
                break;

            } else {
                System.out.println("Invalid input try again.");
            }
        }

        scanner.close();
    }
}
