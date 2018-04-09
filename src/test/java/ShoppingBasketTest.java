import Items.Bagpipes;
import Items.Table;
import org.junit.Before;
import org.junit.Test;
import Discounts.*;

import static org.junit.Assert.assertEquals;

public class ShoppingBasketTest {

    ShoppingBasket shoppingBasket;
    Bagpipes bagpipes1;
    Table table1;
    Table table2;
    Bogof bogof;
    TenPercentOff tenPercentOff;
    LoyaltyCard loyaltyCard;


    @Before
    public void before(){
        shoppingBasket = new ShoppingBasket();
        bagpipes1 = new Bagpipes("Bagpipes", 20.0);
        table1 = new Table("Table", 10.0);
        table2 = new Table("Table", 10.0);
        bogof = new Bogof();
        tenPercentOff = new TenPercentOff();
        loyaltyCard = new LoyaltyCard();
    }

    @Test
    public void shoppingBasketIsEmpty(){
        assertEquals(0, shoppingBasket.itemsSize());
    }

    @Test
    public void DiscountsAreEmpty(){
        assertEquals(0, shoppingBasket.discountsSize());
    }

    @Test
    public void canAddItemsToBasket(){
        shoppingBasket.addItems(bagpipes1);
        shoppingBasket.addItems(table1);
        assertEquals(2, shoppingBasket.itemsSize());
    }

    @Test
    public void canRemoveItem() {
        shoppingBasket.addItems(bagpipes1);
        shoppingBasket.addItems(table1);
        shoppingBasket.addItems(table2);
        shoppingBasket.removeItem(table2);
        assertEquals(2, shoppingBasket.itemsSize());
    }

    @Test
    public void canRemoveAllItems() {
        shoppingBasket.addItems(bagpipes1);
        shoppingBasket.addItems(table1);
        shoppingBasket.emptyBaskete();
        assertEquals(0, shoppingBasket.itemsSize());
    }

    @Test
    public void canGetTotalPrice(){
        shoppingBasket.addItems(bagpipes1);
        shoppingBasket.addItems(table1);
        assertEquals(30.00, shoppingBasket.totalPrice(), 0.01);

    }

    @Test
    public void canGetTotalPricePlusDiscounts_1(){
        shoppingBasket.addItems(bagpipes1);
        shoppingBasket.addItems(table1);
        shoppingBasket.addItems(table2);
        assertEquals(40.00, shoppingBasket.totalPrice(), 0.01);
        shoppingBasket.addDiscounts(bogof);
        assertEquals(30.00, shoppingBasket.totalPrice(), 0.01);
    }

    @Test
    public void canGetTotalPricePlusDiscounts_2() {
        shoppingBasket.addItems(bagpipes1);
        shoppingBasket.addItems(table1);
        shoppingBasket.addItems(table2);
        shoppingBasket.addDiscounts(bogof);
        shoppingBasket.addDiscounts(tenPercentOff);
        assertEquals(30.00, shoppingBasket.totalPrice(), 0.1);
    }

    @Test
    public void canGetTotalPricePlusDiscounts_3() {
        shoppingBasket.addItems(bagpipes1);
        shoppingBasket.addItems(table1);
        shoppingBasket.addItems(table2);
        shoppingBasket.addDiscounts(bogof);
        shoppingBasket.addDiscounts(tenPercentOff);
        shoppingBasket.addDiscounts(loyaltyCard);
        assertEquals(30.00, shoppingBasket.totalPrice(), 0.1);
    }
}
