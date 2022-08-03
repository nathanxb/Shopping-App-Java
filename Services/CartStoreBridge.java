package Services;

import ShoppingApp.Item;
import ShoppingApp.ShoppingCart;
import ShoppingApp.Store;

public class CartStoreBridge {
    /**
     *  Takes in Cart and Store lists for inventory management
     */

    public static void updateLists(ShoppingCart cartName, Store storeName, Item item) {
        cartName.addItemToCart(item);
        storeName.removeItemFromInventory(item);
    }
}
