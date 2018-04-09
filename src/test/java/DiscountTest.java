import Items.Bagpipes;
import Items.Table;
import Discounts.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DiscountTest {

    ShoppingBasket shoppingBasket;
    Bagpipes bagpipes1;
    Bagpipes bagpipes2;
    Bagpipes bagpipes3;
    Table table1;
    Table table2;
    Bogof bogof;
    TenPercentOff tenPercentOff;
    LoyaltyCard loyaltyCard;


    @Before
    public void before(){
        shoppingBasket = new ShoppingBasket();
        bagpipes1 = new Bagpipes("Bagpipes", 950.00);
        bagpipes2 = new Bagpipes("Bagpipes", 950.00);
        bagpipes3 = new Bagpipes("Bagpipes", 950.00);
        table1 = new Table("Table", 150.00);
        table2 = new Table("Table", 150.00);
        bogof = new Bogof();
        tenPercentOff = new TenPercentOff();
        loyaltyCard = new LoyaltyCard();
    }

    @Test
    public void canApplyBogof(){
        shoppingBasket.addItems(bagpipes1);
        shoppingBasket.addItems(bagpipes2);
        shoppingBasket.addItems(bagpipes3);
        shoppingBasket.addItems(table1);
        shoppingBasket.addItems(table2);
        bogof.applyDiscount(shoppingBasket.getItems());
        assertEquals(2050.00, shoppingBasket.totalPrice(),0.01);
    }

    @Test
    public void canApplyTenPercentOff(){
        shoppingBasket.addItems(bagpipes1);
        shoppingBasket.addItems(table1);
        tenPercentOff.applyDiscount(shoppingBasket.getItems());
        assertEquals(990.00, shoppingBasket.totalPrice(),0.01);
    }

    @Test
    public void canApplyLoyaltyCard() {
        shoppingBasket.addItems(bagpipes1);
        shoppingBasket.addItems(table1);
        loyaltyCard.applyDiscount(shoppingBasket.getItems());
        assertEquals(1078.00, shoppingBasket.totalPrice(),0.01);
    }

}
