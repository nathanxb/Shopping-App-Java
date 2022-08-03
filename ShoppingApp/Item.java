package ShoppingApp;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;

public class Item {
    private String itemName;
    private double itemPrice;
    private double itemWeight;

    Item() {
        System.out.println("STATE NAME, PRICE, AND WEIGHT OF ITEM");
    }

    Item(String itemName, double itemPrice, double itemWeight){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemWeight = itemWeight;
    }


    public void showItemInfo(){
        System.out.println("******* Product Info *******");
        System.out.println("Name: " + itemName);
        System.out.println("Weight: " + itemWeight + " lbs");
        System.out.println("Price Per Unit: " + NumberFormat.getCurrencyInstance().format(itemPrice));
        System.out.println();
    }


    // Getters & Setters
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        double input = itemPrice;
        BigDecimal bd = new BigDecimal(input).setScale(2, RoundingMode.HALF_UP);
        double twoDecimalPrice = bd.doubleValue();
        return twoDecimalPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }

    public double getItemWeight() {
        return itemWeight;
    }

    public void setItemWeight(double itemWeight) {
        this.itemWeight = itemWeight;
    }
}
