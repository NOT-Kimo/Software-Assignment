/*Project Structure:
-main
-User
    -Customer
    -Admin
-Product
-Cart
-InputValidator  (NEW)
*/

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {


    private static int readInt(Scanner inp) {
        while (true) {
            String line = inp.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a whole number: ");
            }
        }
    }

    private static double readDouble(Scanner inp) {
        while (true) {
            String line = inp.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.print("Invalid input. Please enter a numeric value: ");
            }
        }
    }

    private static String readNonBlank(Scanner inp, String fieldName) {
        while (true) {
            String line = inp.nextLine().trim();
            if (!line.isEmpty()) return line;
            System.out.print(fieldName + " cannot be empty. Try again: ");
        }
    }

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>();

        boolean storeOpen = true;

        while (storeOpen) {
            System.out.println("\nWelcome to the Store!");
            System.out.println("1-Customer");
            System.out.println("2-Admin");
            System.out.println("3-Exit Store");
            System.out.print("Choice: ");
            int choice = readInt(inp);

            switch (choice) {

                case 1:
                    String cName;
                    while (true) {
                        System.out.print("Enter your Name: ");
                        cName = readNonBlank(inp, "Name");
                        if (InputValidation.isValidName(cName)) break;
                        System.out.println("Name must contain letters only");
                    }

                    String cEmail;
                    while (true) {
                        System.out.print("Enter your Email: ");
                        cEmail = readNonBlank(inp, "Email");
                        if (InputValidation.isValidEmail(cEmail)) break;
                        System.out.println("Invalid email format (user@example.com).");
                    }

                    String cPass;
                    while (true) {
                        System.out.print("Enter your Password (min 8 characters): ");
                        cPass = inp.nextLine().trim();
                        if (InputValidation.isValidPassword(cPass)) break;
                        System.out.println("Password must be at least 8 characters.");
                    }

                    int cAge;
                    while (true) {
                        System.out.print("Enter your Age: ");
                        cAge = readInt(inp);
                        if (InputValidation.isValidAge(cAge)) break;
                        System.out.println("Age must be between 10 and 120.");
                    }

                    Customer customer = new Customer(cName, cEmail, cPass, cAge);

                    int choice1;
                    do {
                        System.out.println("\nCustomer Menu:");
                        System.out.println("1. Show products");
                        System.out.println("2. Add to cart");
                        System.out.println("3. View cart");
                        System.out.println("4. Checkout");
                        System.out.println("0. Exit to Main Menu");
                        System.out.print("Choice: ");
                        choice1 = readInt(inp);

                        switch (choice1) {
                            case 1:
                                if (products.isEmpty()) {
                                    System.out.println("No products available.");
                                } else {
                                    System.out.println("Products:");
                                    for (Product p : products) {
                                        p.DisplayProductInfo();
                                        System.out.println("------");
                                    }
                                }
                                break;

                            case 2:
                                if (products.isEmpty()) {
                                    System.out.println("No products available to add.");
                                    break;
                                }
                                System.out.print("Enter ProductID to add to cart: ");
                                int pid = readInt(inp);
                                if (!InputValidation.isValidProductID(pid)) {
                                    System.out.println("Product ID must be a positive number.");
                                    break;
                                }
                                Product selected = null;
                                for (Product p : products) {
                                    if (p.getProductID() == pid) { selected = p; break; }
                                }
                                if (selected != null) {
                                    if (selected.getStock() > 0) {
                                        customer.getCart().addProduct(selected);
                                        System.out.println(selected.getName() + " added to cart!");
                                    } else {
                                        System.out.println("Sorry, this product is out of stock!");
                                    }
                                } else {
                                    System.out.println("Product not found!");
                                }
                                break;

                            case 3:
                                if (customer.getCart().products.isEmpty()) {
                                    System.out.println("Your cart is empty.");
                                } else {
                                    System.out.println("Your Cart:");
                                    customer.getCart().showCart();
                                    System.out.println("Total: $" + customer.getCart().calculateTotal());
                                }
                                break;

                            case 4:
                                if (customer.getCart().products.isEmpty()) {
                                    System.out.println("Your cart is empty. Add items before checking out.");
                                    break;
                                }
                                System.out.println("Checking out...");
                                double total = customer.getCart().calculateTotal();
                                System.out.println("Total Amount: $" + total);
                                for (Product p : customer.getCart().products) {
                                    p.decreaseStock(1);
                                }
                                System.out.println("Thank you for your purchase!");
                                customer.getCart().showCart();
                                customer.getCart().products.clear();
                                break;

                            case 0:
                                System.out.println("Returning to Main Menu...");
                                break;

                            default:
                                System.out.println("Invalid choice! Please enter 0-4.");
                        }
                    } while (choice1 != 0);
                    break;


                case 2:

                    Admin admin = new Admin("Admin1", "admin@test.com", "admin123", 30);

                    System.out.print("Enter Your Password: ");
                    String pass = inp.nextLine().trim();

                    if (!Objects.equals(pass, admin.getPassword())) {
                        System.out.println("Incorrect password!");
                        break;
                    }

                    int choice2;
                    do {
                        System.out.println("\nAdmin Menu:");
                        System.out.println("1-Add new Product");
                        System.out.println("2-Change Profile Info");
                        System.out.println("3-Change Price or Stock");
                        System.out.println("0. Exit to Main Menu");
                        System.out.print("Choice: ");
                        choice2 = readInt(inp);

                        switch (choice2) {
                            case 1:
                                int id;
                                while (true) {
                                    System.out.print("Enter ProductID: ");
                                    id = readInt(inp);
                                    if (!InputValidation.isValidProductID(id)) {
                                        System.out.println("Product ID must be greater than 0.");
                                        continue;
                                    }
                                    boolean duplicate = false;
                                    for (Product p : products) {
                                        if (p.getProductID() == id) { duplicate = true; break; }
                                    }
                                    if (duplicate) {
                                        System.out.println("A product with this ID already exists. Use a different ID.");
                                    } else {
                                        break;
                                    }
                                }

                                String prodName;
                                while (true) {
                                    System.out.print("Enter Product Name: ");
                                    prodName = readNonBlank(inp, "Product Name");
                                    if (!prodName.isEmpty()) break;
                                }

                                double price;
                                while (true) {
                                    System.out.print("Enter Product Price: ");
                                    price = readDouble(inp);
                                    if (InputValidation.isValidPrice(price)) break;
                                    System.out.println("Price must be greater than 0.");
                                }

                                int stock;
                                while (true) {
                                    System.out.print("Enter Product Stock: ");
                                    stock = readInt(inp);
                                    if (InputValidation.isValidStock(stock)) break;
                                    System.out.println("Stock cannot be negative.");
                                }

                                admin.addProduct(products, new Product(id, prodName, price, stock));
                                System.out.println("Product added successfully!");
                                break;

                            case 2:
                                String newEmail;
                                while (true) {
                                    System.out.print("Update Email: ");
                                    newEmail = readNonBlank(inp, "Email");
                                    if (InputValidation.isValidEmail(newEmail)) break;
                                    System.out.println("Invalid email format (e.g. admin@example.com).");
                                }
                                admin.ChangeEmail(newEmail);
                                System.out.println("Email updated to: " + admin.getEmail());
                                break;

                            case 3:
                                System.out.println("1. Change Price");
                                System.out.println("2. Change Stock");
                                System.out.print("Choice: ");
                                int choice3 = readInt(inp);

                                if (choice3 != 1 && choice3 != 2) {
                                    System.out.println("Invalid choice! Enter 1 or 2.");
                                    break;
                                }

                                System.out.print("Enter ProductID: ");
                                int prodId = readInt(inp);
                                if (!InputValidation.isValidProductID(prodId)) {
                                    System.out.println("Product ID must be a positive number.");
                                    break;
                                }

                                Product foundProduct = null;
                                for (Product p : products) {
                                    if (p.getProductID() == prodId) { foundProduct = p; break; }
                                }

                                if (foundProduct == null) {
                                    System.out.println("Product not found!");
                                    break;
                                }

                                if (choice3 == 1) {
                                    double newPrice;
                                    while (true) {
                                        System.out.print("Enter New Price (must be > 0): ");
                                        newPrice = readDouble(inp);
                                        if (InputValidation.isValidPrice(newPrice)) break;
                                        System.out.println("Price must be greater than 0.");
                                    }
                                    foundProduct.ChangePrice((int) newPrice);
                                    System.out.println("Price updated to $" + newPrice);
                                } else {
                                    int newStock;
                                    while (true) {
                                        System.out.print("Enter New Stock (must be >= 0): ");
                                        newStock = readInt(inp);
                                        if (InputValidation.isValidStock(newStock)) break;
                                        System.out.println("Stock cannot be negative.");
                                    }
                                    foundProduct.ChangeStock(newStock);
                                    System.out.println("Stock updated to " + newStock);
                                }
                                break;

                            case 0:
                                System.out.println("Returning to Main Menu...");
                                break;

                            default:
                                System.out.println("Invalid choice! Please enter 0-3.");
                        }
                    } while (choice2 != 0);
                    break;


                case 3:
                    System.out.println("Thank you for visiting the store!");
                    storeOpen = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please select 1, 2, or 3.");
            }
        }
        inp.close();
    }
}