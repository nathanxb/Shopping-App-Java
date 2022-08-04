package ShoppingApp;

import Services.CartStoreBridge;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> itemsInCart = new ArrayList<>();
    private String cartName;
    private double weightLimit = 100.0;
    private double totalWeight = 0;
    private double totalPrice = 0.00;


    ShoppingCart() {
        this.cartName = "Shopping Cart";
        System.out.println("Shopping Cart is Empty, start shopping!");
    }
    ShoppingCart(String cartName){
        this.cartName = cartName;
        System.out.println(cartName + " has been created. You can now add items to this cart!");
    }

    ShoppingCart(String cartName, Item item) {
        this.cartName = cartName;
        addItemToCart(item);
    }
    // Methods


    public void checkout(){
        System.out.println("THANK YOU FOR YOUR PURCHASE OF $" + getTotalPrice() + "!");
        showReceipt();
        itemsInCart.clear();
    }
    public void showReceipt() {
        System.out.println("ITEMIZED RECEIPT:");

        itemsInCart
                .stream()
                .forEach(x -> System.out.println("  " + x.getItemName() + ", $" + x.getItemPrice()));

        System.out.println("        Total Cost: $" + getTotalPrice());
    }
    public void addItemToCart(Item item) {
        itemsInCart.add(item);
        totalPrice += item.getItemPrice();
        totalWeight += item.getItemWeight();

        System.out.println("YOU HAVE ADDED " + item.getItemName() + " TO YOUR CART");
    }
    public void addItemsToCart(Item item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            itemsInCart.add(item);
            totalPrice += item.getItemPrice();
            totalWeight += item.getItemWeight();
        }

        System.out.println("YOU HAVE ADDED " + quantity + " " + item.getItemName() + "s TO YOUR CART");
    }

    public void removeItemFromCart(Item item) {
        itemsInCart.remove(item);
        totalPrice -= item.getItemPrice();
        totalWeight -= item.getItemWeight();

        System.out.println("YOU HAVE REMOVED " + item.getItemName() + " FROM YOUR CART");
    }
    public void removeItemsFromCart(Item item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            itemsInCart.remove(item);
            totalPrice -= item.getItemPrice();
            totalWeight -= item.getItemWeight();
        }

        System.out.println("YOU HAVE REMOVED " + quantity + " " + item.getItemName() + "s FROM YOUR CART");
    }

    public void showShoppingCart() {
        System.out.println("HERE'S WHAT'S IN YOUR CART:");

        itemsInCart
                .stream()
                .forEach(x -> System.out.println("  " + x.getItemName() + ", $" + x.getItemPrice() + ", " + x.getItemWeight() + " lbs"));

        System.out.println("        Total Cost: $" + getTotalPrice());
        System.out.print("      ");
        displayTotalWeight();
    }



    // Getters & Setters
    public double getWeightLimit() {
        return weightLimit;
    }

    public void setWeightLimit(double weightLimit) {
        this.weightLimit = weightLimit;
    }

    public double getTotalWeight() {
        return totalWeight;
    }
    public void displayTotalWeight() {
        System.out.println("TOTAL WEIGHT IN CART: " + totalWeight + " lbs" +
        "\n         YOU CAN CARRY " + (weightLimit - totalWeight) + " MORE POUNDS"
        );

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

    public List<Item> getItemsInCart() {
        return itemsInCart;
    }

    public void setItemsInCart(List<Item> itemsInCart) {
        this.itemsInCart = itemsInCart;
    }

    public String getCartName() {
        return cartName;
    }

    public void setCartName(String cartName) {
        this.cartName = cartName;
    }
}
