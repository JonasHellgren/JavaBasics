package ddd.restaurant;

import domain_driven_design.restaurant_booking.domain.menu.Menu;
import domain_driven_design.restaurant_booking.persistence.factories.MenuDbFactory;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestMenu {

    Menu menu;

    @Before
    public void init() {
        menu=new Menu(MenuDbFactory.ofMcD());
    }

    @Test
    public void whenIds_thenCorrect() {
        var ids=menu.getDishIds();
        int size=menu.size();
        Assert.assertEquals(6,ids.size());
        Assert.assertEquals(size,ids.size());
    }

    @Test
    public void whenIdIs1_thenCorrect() {
        var dish=menu.getDish(1);
        Assert.assertEquals("BigMac",dish.getName());
    }


}
