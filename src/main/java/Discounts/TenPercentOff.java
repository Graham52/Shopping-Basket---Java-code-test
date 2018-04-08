package Discounts;

import Items.Item;

import java.util.ArrayList;

public class TenPercentOff implements IDiscount {

    public ArrayList<Item> applyDiscount(ArrayList<Item> items) {
        double totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPrice();
        }

        if (totalPrice > 20) {
            for (Item item : items) {
                double discountPrice = item.getPrice() * 0.9;
                item.setPrice(discountPrice);
            }
        }
        return items;
    }
}