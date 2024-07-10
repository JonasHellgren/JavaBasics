package domain_driven_design.restaurant_booking.domain.menu.entities;

import domain_driven_design.restaurant_booking.domain.menu.enums.DishType;
import domain_driven_design.restaurant_booking.domain.shared.value_obj.Price;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class Dish {
    Integer id;
    String name;
    @Builder.Default  String description="";
    Price price;
    @Builder.Default DishType type=DishType.MAIN_COURSE;

    public static Dish mainOfIdNamePriceInEuros(Integer id, String name, double price ) {
        return Dish.builder().id(id).name(name).price(Price.ofEuro(price)).build();
    }

    public static Dish beverageOfIdNamePriceInEuros(Integer id, String name, double price ) {
        return Dish.builder().id(id).name(name).price(Price.ofEuro(price)).type(DishType.BEVERAGE).build();
    }

    public static Dish dessertOfIdNamePriceInEuros(Integer id, String name, double price ) {
        return Dish.builder().id(id).name(name).price(Price.ofEuro(price)).type(DishType.DESSERT).build();
    }


}
