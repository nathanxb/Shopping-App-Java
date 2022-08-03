package ShoppingApp;

import java.util.ArrayList;
import java.util.List;

public class Store {
    private String storeName;
    private List<Item> storeInventory = new ArrayList<>();

    Store() {
        System.out.println("STORE CREATED");
    }
    Store(String storeName){
        this.storeName = storeName;
        System.out.println("STORE CREATED, START ADDING ITEMS TO INVENTORY");
    }
    Store(String name, Item item) {
        this.storeName = name;
        addItemToInventory(item);
    }
    Store(String name, Item item, int quantity) {
        this.storeName = name;
        addItemToInventory(item,quantity);
    }
    // Create constructor that takes in list of Items



    //Methods

    //Adding Single Item
    public void addItemToInventory(Item item) {
        storeInventory.add(item);
        System.out.println("YOU HAVE ADDED " + item.getItemName() + " to " + storeName + "'s inventory");
    }
    // Adding Multiple items
    public void addItemToInventory(Item item, int quantity) {
        for (int i = 0; i < quantity ; i++) {
            storeInventory.add(item);
        }
        System.out.println("YOU HAVE ADDED " + quantity + " " + item.getItemName() + "s to " + storeName + "'s inventory");
    }

    // Removing Single Item
    public void removeItemFromInventory(Item item){
        storeInventory.remove(item);

        System.out.println("YOU HAVE REMOVED " + item.getItemName() + " from " + storeName + "'s inventory");
    }

    // Removing Multiple Items
    public void removeItemFromInventory(Item item, int quantity){
        for (int i = 0; i < quantity; i++) {
            storeInventory.remove(item);
        }

        System.out.println("YOU HAVE REMOVED " + quantity + " " + item.getItemName() + "s from " + storeName + "'s inventory");
    }
    public void showInventory(){
        System.out.println(storeName + "'s Inventory:");
        storeInventory
                .stream()
                .forEach(x -> System.out.println("  " + x.getItemName() + ", $" + x.getItemPrice() + ", " + x.getItemWeight() + "lbs"));

    }
}
