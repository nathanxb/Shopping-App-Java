package ShoppingApp;

public class Main {
    public static void main(String[] args) {

        // Items
        Item gpu = new Item("RTX 3090", 1999.99, 7.25);
        Item printer = new Item("HP DeskJet", 299.99, 40);
        Item desk = new Item("Standing Desk", 1199.99, 150);
        Item football = new Item("Nike Football", 29.99, 1);


        // Stores
        Store bestBuy = new Store("Best Buy", gpu); //add using constructor
        bestBuy.addItemToInventory(printer); // add using method
        bestBuy.showInventory();

        Store Walmart = new Store("Walmart");
        Walmart.addItemToInventory(football,20);
        Walmart.showInventory();


        // Carts
        ShoppingCart cart1 = new ShoppingCart();
        cart1.addItemToCart(bestBuy, gpu);
        cart1.showShoppingCart();
        cart1.getTotalPrice();
        cart1.getTotalWeight();

        bestBuy.showInventory();




    }
}
