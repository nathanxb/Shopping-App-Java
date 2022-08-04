package ShoppingApp;

import Services.CartStoreBridge;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Items
        List<Item> itemList = new ArrayList<>();
        Item gpu = new Item("RTX 3090", 1999.99, 7.25);
        Item printer = new Item("HP DeskJet", 299.99, 40);
        Item desk = new Item("Standing Desk", 1199.99, 150);
        Item football = new Item("Nike Football", 29.99, 1);

        itemList.add(gpu);
        itemList.add(printer);
        itemList.add(desk);
        itemList.add(football);



        // Stores
        Store bestBuy = new Store("Best Buy", gpu); //add using constructor
        bestBuy.addItemToInventory(printer); // add using method
        bestBuy.showInventory();

        Store walmart = new Store("Walmart");
        walmart.addItemsToInventory(football,5);
        walmart.showInventory();
        walmart.addListOfItemsToInventory(itemList);
        walmart.showInventory();

        Store officeDepot = new Store("Office Depot",printer,3);
        officeDepot.showInventory();

        // Carts
        ShoppingCart cart1 = new ShoppingCart();
        CartStoreBridge.addingItemToCart(cart1,bestBuy,gpu);
        CartStoreBridge.addingItemToCart(cart1,bestBuy,printer);
        cart1.showShoppingCart();

        bestBuy.showInventory();


        // Trying to buy something out of stock:
        CartStoreBridge.addingItemToCart(cart1,bestBuy,gpu);

        // New Cart, buying something that exceeds weight limit
        ShoppingCart cart2 = new ShoppingCart("Shopping Cart 2");
        CartStoreBridge.addingItemsFromCart(cart2,walmart,football,5);
        CartStoreBridge.addingItemToCart(cart2,walmart,desk);
        cart2.showShoppingCart();

        cart2.checkout();





    }
}
