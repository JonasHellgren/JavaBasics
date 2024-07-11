package domain_driven_design.persistence.factories;

import domain_driven_design.domain.menu.entities.Dish;
import domain_driven_design.persistence.MenuDb;

public class MenuDbFactory {

    private MenuDbFactory() {
    }

    public static MenuDb ofMcD() {
        MenuDb menuDb=MenuDb.empty();
        menuDb.create(Dish.mainOfIdNamePriceInEuros(1,"BigMac",2d));
        menuDb.create(Dish.mainOfIdNamePriceInEuros(2,"CheeseBurger",1d));
        menuDb.create(Dish.beverageOfIdNamePriceInEuros(3,"Fanta",1d));
        menuDb.create(Dish.beverageOfIdNamePriceInEuros(4,"Coke",1d));
        menuDb.create(Dish.dessertOfIdNamePriceInEuros(5,"IceCream",1d));
        menuDb.create(Dish.dessertOfIdNamePriceInEuros(6,"Cake",1d));
        return menuDb;
    }

}
