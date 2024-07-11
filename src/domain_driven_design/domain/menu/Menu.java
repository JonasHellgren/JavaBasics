package domain_driven_design.domain.menu;

import domain_driven_design.domain.menu.entities.Dish;
import domain_driven_design.persistence.MenuDb;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    List<Integer> dishes;
    MenuDb menuDb;

    public Menu(MenuDb menuDb) {
        this.dishes=new ArrayList<>(menuDb.getAll().stream().map(Dish::getId).toList());
        this.menuDb = menuDb;
    }

    public void addDish(Dish dish) {
        this.dishes.add(dish.getId());
        this.menuDb.create(dish);
    }

    public List<Integer> getDishIds() {
    return dishes;
    }

    public Dish getDish(Integer id) {
        return menuDb.read(id);
    }

    public int size() {
        return dishes.size();
    }

    public Integer largestId() {
        return menuDb.largestId();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Menu:").append(System.lineSeparator());
        getDishIds().forEach(id ->
                sb.append(getDish(id).toString()).append(System.lineSeparator()));
        return sb.toString();
    }
}
