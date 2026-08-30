package oop_constructs.assigment_problems;

public class Item {

    private String itemName;
    private int stock;

    public Item(String itemName, int stock) {
        this.itemName = itemName;
        this.stock = stock;
    }

    public void restock(int stock) {
        this.stock += stock;
    }

    public void printStock() {
        System.out.println(this.itemName + " | Final Stock: " + this.stock);
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item("Samosa", 15),
            new Item("Tea Powder", 40),
            new Item("Bread", 8),
            new Item("Biscuit Packs", 25)
        };

        for (int i = 0; i < items.length; i++) {
            items[i].restock(20);
            items[i].printStock();
        }
    }
}
