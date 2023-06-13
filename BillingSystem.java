import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Item {
    private String name;
    private double price;
    private int quantity;

    public Item(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }
}

class Bill {
    private List<Item> items;
    private double total;

    public Bill() {
        items = new ArrayList<>();
        total = 0.0;
    }

    public void addItem(Item item) {
        items.add(item);
        total += item.getPrice() * item.getQuantity();
    }

    public void generateBill() {
        System.out.println("----- Bill -----");
        for (Item item : items) {
            System.out.println(item.getName() + " - " + item.getPrice() + " x " + item.getQuantity());
        }
        System.out.println("Total: " + total);
    }
}

public class BillingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Bill bill = new Bill();

        while (true) {
            System.out.print("Enter item name (or 'q' to quit): ");
            String name = scanner.nextLine();

            if (name.equals("q")) {
                break;
            }

            System.out.print("Enter item price: ");
            double price = Double.parseDouble(scanner.nextLine());

            System.out.print("Enter item quantity: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            Item item = new Item(name, price, quantity);
            bill.addItem(item);
        }

        bill.generateBill();

        scanner.close();
    }
}
