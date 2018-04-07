import Items.Bagpipes;
import Items.Table;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ItemTest {


    Bagpipes bagpipes;
    Table table;

    @Before
    public void before(){
        bagpipes = new Bagpipes("Bagpipes", 800.00);
        table = new Table("Table", 250.00);
    }

    @Test
    public void canGetItemName(){
        assertEquals("Bagpipes", bagpipes.getName());
    }

    @Test
    public void canGetItemPrice(){
        assertEquals(250.00, table.getPrice(), 0.01);
    }

    @Test
    public void canSetName(){
        bagpipes.setName("McCallum");
        assertEquals("McCallum", bagpipes.getName());
    }

    @Test
    public void canSetPrice(){
        table.setPrice(230.00);
        assertEquals(230.00, table.getPrice(),0.01);
    }

}
