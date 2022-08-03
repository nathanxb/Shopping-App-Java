package ShoppingApp;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> itemsInCart = new ArrayList<>();
    private String cartName;
    private double weightLimit = 100.0;
    private double totalWeight = 0;
    private double totalPrice = 0.00;


    ShoppingCart() {
        System.out.println("Shopping Cart is Empty, start shopping!");
    }

    ShoppingCart(Store storeName, Item item) {
        addItemToCart(storeName, item);
    }
    // Methods

    public void addItemToCart(Store store, Item item) {
        itemsInCart.add(item);
        store.removeItemFromInventory(item);
        totalPrice += item.getItemPrice();
        totalWeight += item.getItemWeight();

        System.out.println("YOU HAVE ADDED " + item.getItemName() + " TO YOUR CART");
    }

    public void removeItemFromCart(Store store, Item item) {
        itemsInCart.remove(item);
        store.addItemToInventory(item);
        totalPrice -= item.getItemPrice();
        totalWeight -= item.getItemWeight();

        System.out.println("YOU HAVE REMOVED " + item.getItemName() + " FROM YOUR CART");
    }

    public void showShoppingCart() {
        System.out.println("HERE'S WHAT'S IN YOUR CART:");

        itemsInCart
                .stream()
                .forEach(x -> System.out.println("  " + x.getItemName() + ", $" + x.getItemPrice() + ", " + x.getItemWeight() + " lbs"));
    }



    // Getters & Setters
    public double getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(double weightLimit) {
        this.weightLimit = weightLimit;
    }

    public void getTotalWeight() {
        System.out.println("TOTAL WEIGHT IN CART: " + totalWeight + " lbs");
        System.out.println("    YOU CAN CARRY " + (weightLimit - totalWeight) + " MORE POUNDS");
    }

    private void setTotalWeight(double totalWeight) {
        this.totalWeight = totalWeight;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    private void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
