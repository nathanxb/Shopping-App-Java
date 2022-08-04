package Services;

import ShoppingApp.Item;
import ShoppingApp.ShoppingCart;
import ShoppingApp.Store;

    /**
     *  Takes in Cart and Store lists for inventory management
     */
public class CartStoreBridge {

    public static void addingItemToCart(ShoppingCart cartName, Store storeName, Item item) {
        if ((cartName.getTotalWeight() + item.getItemWeight()) > cartName.getWeightLimit()) {
            System.out.println("BUYING a(n) " + item.getItemName() + " WOULD EXCEED " + cartName.getCartName() + "'s WEIGHT LIMIT!");
            System.out.println("    Try to find something that weighs less. Your weight limit is " + cartName.getWeightLimit() + " pounds");
        } else if (!storeName.getStoreInventory().contains(item)) {
            System.out.println(storeName.getStoreName() + " IS OUT OF " + item.getItemName() + "s, PLEASE BUY SOMETHING ELSE");
        } else {
            cartName.addItemToCart(item);
            storeName.removeItemFromInventory(item);
        }
    }
    public static void addingItemsFromCart(ShoppingCart cartName, Store storeName, Item item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            if ((cartName.getTotalWeight() + item.getItemWeight()) > cartName.getWeightLimit()) {
                System.out.println("BUYING a(n) " + item.getItemName() + " WOULD EXCEED " + cartName.getCartName() + "'s WEIGHT LIMIT!");
                System.out.println("    Try to find something that weighs less. Your weight limit is " + cartName.getWeightLimit() + " pounds");
                break;
            } else if (!storeName.getStoreInventory().contains(item)) {
                System.out.println(storeName.getStoreName() + " IS OUT OF " + item.getItemName() + "s, PLEASE BUY SOMETHING ELSE");
                break;
            } else {
                cartName.addItemToCart(item);
                storeName.removeItemFromInventory(item);
            }
        }
    }
    public static void removingItemToCart(ShoppingCart cartName, Store storeName, Item item) {
        if(!cartName.getItemsInCart().contains(item)){
            System.out.println("THIS ISN'T IN YOUR CART");
        }else {
            cartName.removeItemFromCart(item);
            storeName.addItemToInventory(item);
        }
    }
    public static void removingItemsFromCart(ShoppingCart cartName, Store storeName, Item item, int quantity) {
        for (int i = 0; i < quantity; i++) {
            if(!cartName.getItemsInCart().contains(item)){
                System.out.println("THIS ISN'T IN YOUR CART");
                break;
            }else {
                cartName.removeItemFromCart(item);
                storeName.addItemToInventory(item);
            }
        }
    }
}
