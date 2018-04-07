package Discounts;

import Items.Item;

import java.util.ArrayList;

public interface IDiscount {

    ArrayList<Item> applyDiscount(ArrayList<Item> items);
}
