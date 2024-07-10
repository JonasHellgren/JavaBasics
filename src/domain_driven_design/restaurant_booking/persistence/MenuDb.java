package domain_driven_design.restaurant_booking.persistence;

import domain_driven_design.restaurant_booking.domain.menu.entities.Dish;

import java.util.*;

public class MenuDb implements DataBase<Dish> {

    Map<Integer,Dish> map;

    public MenuDb() {
        this.map=new HashMap<>();
    }

    public static MenuDb empty() {
        return new MenuDb();
    }

    @Override
    public void create(Dish dish) {
        map.put(dish.getId(),dish);
    }

    @Override
    public Dish read(Integer id) {
        return map.get(id);
    }

    @Override
    public List<Dish> getAll() {
        return new ArrayList<>(map.values());
    }
}
