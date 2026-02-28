
/*Project Structure:
-main
-User
    -Customer
    -Admin
-Product
-Cart
 */



import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<>(); // storing all products

        boolean storeOpen = true;

        while (storeOpen) {
            System.out.println("\nWelcome to the Store!");
            System.out.println("1-Customer");
            System.out.println("2-Admin");
            System.out.println("3-Exit Store");
            int choice = inp.nextInt();
            inp.nextLine(); // consume newline

            switch (choice) {
                case 1: // Customer
                    System.out.println("Enter your Name: ");
                    String CName = inp.nextLine();
                    System.out.println("Enter your Email: ");
                    String CEmail = inp.nextLine();
                    System.out.println("Enter your password: ");
                    String CPass = inp.nextLine();
                    System.out.println("Enter your Age: ");
                    int CAge = inp.nextInt();
                    inp.nextLine();
                    Customer customer = new Customer(CName, CEmail, CPass, CAge);

                    int choice1;
                    do {
                        System.out.println("\nCustomer Menu:");
                        System.out.println("1. Show products");
                        System.out.println("2. Add to cart");
                        System.out.println("3. View cart");
                        System.out.println("4. Checkout");
                        System.out.println("0. Exit to Main Menu");
                        choice1 = inp.nextInt();
                        inp.nextLine(); // consume newline

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
                                System.out.println("Enter ProductID to add to cart:");
                                int pid = inp.nextInt();
                                inp.nextLine();
                                Product selected = null;
                                for (Product p : products) {
                                    if (p.getProductID() == pid) {
                                        selected = p;
                                        break;
                                    }
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
                                System.out.println("Your Cart:");
                                customer.getCart().showCart();
                                System.out.println("Total: $" + customer.getCart().calculateTotal());
                                break;
                            case 4:
                                System.out.println("Checking out...");
                                double total = customer.getCart().calculateTotal();
                                System.out.println("Total Amount: $" + total);

                                // Decrease stock for purchased products
                                for (Product p : customer.getCart().products) {
                                    p.decreaseStock(1); // assuming 1 quantity each
                                }

                                System.out.println("Thank you for your purchase!");
                                customer.getCart().showCart();
                                customer.getCart().products.clear(); // empty cart after checkout
                                break;
                            case 0:
                                System.out.println("Returning to Main Menu...");
                                break;
                            default:
                                System.out.println("Invalid choice!");
                        }
                    } while (choice1 != 0);
                    break;

                case 2:
                    Admin admin = new Admin("Admin1", "admin@test.com", "admin123", 30);
                    int choice2;
                    System.out.println("Enter Your Password: ");
                    String pass = inp.nextLine();
                    if(!Objects.equals(pass, admin.getPassword())) System.out.println("Incorrect");
                    else{
                        do {
                            System.out.println("\nAdmin Menu:");
                            System.out.println("1-Add new Product");
                            System.out.println("2-Change Profile Info");
                            System.out.println("3-Change Price or Stock");
                            System.out.println("0. Exit to Main Menu");
                            choice2 = inp.nextInt();
                            inp.nextLine(); // consume newline

                            switch (choice2) {
                                case 1:
                                    System.out.println("Enter ProductID: ");
                                    int id = inp.nextInt();
                                    inp.nextLine();
                                    System.out.println("Enter Product Name: ");
                                    String name = inp.nextLine();
                                    System.out.println("Enter Product Price: ");
                                    double price = inp.nextDouble();
                                    System.out.println("Enter Product Stock: ");
                                    int stock = inp.nextInt();
                                    inp.nextLine();
                                    Product newProduct = new Product(id, name, price, stock);
                                    admin.addProduct(products, newProduct);
                                    System.out.println("Product added!");
                                    break;
                                case 2:
                                    System.out.println("Update Email:");
                                    String newEmail = inp.nextLine();
                                    admin.ChangeEmail(newEmail);
                                    System.out.println("Email updated to: " + admin.getEmail());
                                    break;
                                case 3:
                                    System.out.println("1. Change Price");
                                    System.out.println("2. Change Stock");
                                    int choice3 = inp.nextInt();
                                    inp.nextLine();

                                    System.out.println("Enter ProductID: ");
                                    int prodId = inp.nextInt();
                                    inp.nextLine();

                                    Product foundProduct = null;

                                    for (Product p : products) {
                                        if (p.getProductID() == prodId) {
                                            foundProduct = p;
                                            break;
                                        }
                                    }

                                    if (foundProduct == null) {
                                        System.out.println("Product not found!");
                                        break;
                                    }

                                    if (choice3 == 1) {
                                        System.out.println("Enter New Price: ");
                                        int newPrice = inp.nextInt();
                                        inp.nextLine();
                                        foundProduct.ChangePrice(newPrice);
                                        System.out.println("Price updated successfully!");
                                    }
                                    else if (choice3 == 2) {
                                        System.out.println("Enter New Stock: ");
                                        int newStock = inp.nextInt();
                                        inp.nextLine();
                                        foundProduct.ChangeStock(newStock);
                                        System.out.println("Stock updated successfully!");
                                    }
                                    else {
                                        System.out.println("Invalid choice!");
                                    }

                                    break;

                                case 0:
                                    System.out.println("Returning to Main Menu...");
                                    break;
                                default:
                                    System.out.println("Invalid choice!");
                            }
                        } while (choice2 != 0);
                        break;
                    }
                    case 3: // Exit Store
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