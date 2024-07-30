class Item {
    private String name;
    private int quantity;
    private double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getTotalPrice() {
        return this.price * this.quantity;
    }

    @Override
    public String toString() {
        return String.format("%-20s %-10d $%-10.2f $%-10.2f", name, quantity, price, getTotalPrice());
    }
}

class Invoice {
    private Item[] items;
    private int itemCount;

    public Invoice(int size) {
        items = new Item[size];
        itemCount = 0;
    }

    public void addItem(Item item) {
        if (itemCount < items.length) {
            items[itemCount] = item;
            itemCount++;
        } else {
            System.out.println("Invoice is full, cannot add more items.");
        }
    }

    public void printInvoice() {
        System.out.println(String.format("%-20s %-10s %-10s %-10s", "Item Name", "Quantity", "Price", "Total"));
        System.out.println("--------------------------------------------------------------");
        for (int i = 0; i < itemCount; i++) {
            System.out.println(items[i].toString());
        }
        System.out.println("--------------------------------------------------------------");
        System.out.println("Total Invoice Amount: $" + getTotalInvoiceAmount());
    }

    public double getTotalInvoiceAmount() {
        double total = 0.0;
        for (int i = 0; i < itemCount; i++) {
            total += items[i].getTotalPrice();
        }
        return total;
    }
}

public class Main {
    public static void main(String[] args) {
        Invoice invoice = new Invoice(10);

        Item item1 = new Item("Laptop", 1, 999.99);
        Item item2 = new Item("Mouse", 2, 25.50);
        Item item3 = new Item("Keyboard", 1, 49.99);

        invoice.addItem(item1);
        invoice.addItem(item2);
        invoice.addItem(item3);

        invoice.printInvoice();
    }
}
