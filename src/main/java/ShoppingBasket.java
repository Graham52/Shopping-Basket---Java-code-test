import Discounts.*;
import Items.Item;

import java.util.ArrayList;

public class ShoppingBasket {

    private ArrayList<Item> items;
    private ArrayList<IDiscount> discounts;

    public ShoppingBasket() {
        this.items = new ArrayList<>();
        this.discounts = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void addItems(Item item) {
        this.items.add(item);
    }

    public int itemsSize(){
        return items.size();
    }

    public ArrayList<IDiscount> getDiscounts() {
        return discounts;
    }

    public void addDiscounts(IDiscount Idiscount) {
        this.discounts.add(Idiscount);
    }

    public int discountsSize(){
        return discounts.size();
    }

    public void removeItem(Item item){
        this.items.remove(item);
    }

    public void emptyBaskete(){
        this.items.clear();
    }

    public double totalPrice(){
        for (IDiscount discount : discounts) {
            if (discount instanceof Bogof){
                Bogof bogof = new Bogof();
                bogof.applyDiscount(items);
            }
        }
        double totalPrice = 0;
        for (Item item : items){
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

//    public double totalPrice(){
//        for (IDiscount discount : discounts) {
//            if (discount instanceof Bogof){
//                Bogof bogof = new Bogof();
//                bogof.applyDiscount(items);
//            }
//            else if (discount instanceof TenPercentOff){
//                TenPercentOff tenPercentOff = new TenPercentOff();
//                tenPercentOff.applyDiscount(items);
//            }
//            else if (discount instanceof LoyaltyCard){
//                LoyaltyCard loyaltyCard = new LoyaltyCard();
//                loyaltyCard.applyDiscount(items);
//            }
//        }
//        double totalPrice = 0;
//        for (Item item : items){
//            totalPrice += item.getPrice();
//        }
//        return totalPrice;
//    }

}