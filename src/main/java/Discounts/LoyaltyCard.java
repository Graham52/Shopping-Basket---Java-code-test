package Discounts;

import Items.Item;

import java.util.ArrayList;

public class LoyaltyCard implements IDiscount {

    public ArrayList<Item> applyDiscount(ArrayList<Item> items) {
        for (Item item : items){
            double discountPrice = item.getPrice() * 0.98;
            item.setPrice(discountPrice);
        }
        return items;
    }
}