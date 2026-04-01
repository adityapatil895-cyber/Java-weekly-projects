import java.util.ArrayList;
import java.util.Scanner;

class Product {
    int id;
    String name;
    int quantity;

    Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    void display() {
        System.out.println(id + " | " + name + " | Stock: " + quantity);
    }
}

public class InventorySystem {

    static ArrayList<Product> products = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static Product findProduct(int id) {
        for (Product p : products) {
            if (p.id == id)
                return p;
        }
        return null;
    }

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n1.Add 2.Sell 3.View 4.Exit");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Quantity: ");
                    int qty = sc.nextInt();
                    products.add(new Product(id, name, qty));
                    break;

                case 2:
                    System.out.print("Product ID: ");
                    int pid = sc.nextInt();
                    Product p = findProduct(pid);
                    if (p != null) {
                        System.out.print("Sell Quantity: ");
                        int sell = sc.nextInt();
                        if (sell <= p.quantity) {
                            p.quantity -= sell;
                            System.out.println("Sold Successfully");
                        } else {
                            System.out.println("Insufficient Stock");
                        }
                    }
                    break;

                case 3:
                    for (Product pr : products)
                        pr.display();
                    break;
            }
        } while (choice != 4);
    }
}