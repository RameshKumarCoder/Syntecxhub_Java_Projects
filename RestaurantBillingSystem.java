import java.util.*;

class MenuItem {
    String name;
    double price;

    MenuItem(String name, double price) {
        this.name = name;
        this.price = price;
    }
}

public class RestaurantBillingSystem {

    static ArrayList<MenuItem> menu = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        menu.add(new MenuItem("Burger", 250));
        menu.add(new MenuItem("Pizza", 500));
        menu.add(new MenuItem("Pasta", 350));

        while (true) {
            System.out.println("\n===== Restaurant Billing System =====");
            System.out.println("1. Display Menu");
            System.out.println("2. Add Menu Item");
            System.out.println("3. Remove Menu Item");
            System.out.println("4. Generate Bill");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    displayMenu();
                    break;
                case 2:
                    addMenuItem();
                    break;
                case 3:
                    removeMenuItem();
                    break;
                case 4:
                    generateBill();
                    break;
                case 5:
                    System.out.println("Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void displayMenu() {
        System.out.println("\nMenu:");

        for (int i = 0; i < menu.size(); i++) {
            MenuItem item = menu.get(i);
            System.out.println((i + 1) + ". " + item.name + " - Rs." + item.price);
        }
    }

    static void addMenuItem() {
        System.out.print("Enter Item Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Price: ");
        double price = sc.nextDouble();

        menu.add(new MenuItem(name, price));
        System.out.println("Item added successfully!");
    }

    static void removeMenuItem() {
        displayMenu();

        System.out.print("Enter item number to remove: ");
        int index = sc.nextInt() - 1;

        if (index >= 0 && index < menu.size()) {
            menu.remove(index);
            System.out.println("Item removed successfully!");
        } else {
            System.out.println("Invalid item number!");
        }
    }

    static void generateBill() {
        double total = 0;

        while (true) {
            displayMenu();

            System.out.print("Enter item number (0 to finish): ");
            int itemNo = sc.nextInt();

            if (itemNo == 0)
                break;

            if (itemNo < 1 || itemNo > menu.size()) {
                System.out.println("Invalid item!");
                continue;
            }

            System.out.print("Enter quantity: ");
            int qty = sc.nextInt();

            MenuItem item = menu.get(itemNo - 1);
            total += item.price * qty;
        }

        double gst = total * 0.18;
        double finalAmount = total + gst;

        System.out.println("\n===== BILL RECEIPT =====");
        System.out.println("Subtotal: Rs." + total);
        System.out.println("GST (18%): Rs." + gst);
        System.out.println("Final Amount: Rs." + finalAmount);
    }
}