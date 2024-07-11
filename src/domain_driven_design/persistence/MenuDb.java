package domain_driven_design.persistence;

import domain_driven_design.domain.menu.entities.Dish;

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
    public void delete(Integer id) {
            map.remove(id);
    }

    @Override
    public List<Dish> getAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public Integer largestId() {
        return getAll().isEmpty()
                ? 0
                : Collections.max(getAll().stream().map(Dish::getId).toList());
    }

}
