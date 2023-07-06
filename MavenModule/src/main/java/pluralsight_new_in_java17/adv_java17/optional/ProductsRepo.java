package pluralsight_new_in_java17.adv_java17.optional;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductsRepo {
    public static List<Product> PRODUCTS = List.of(
            new Product(1L,"A"), new Product(2L,"B"),new Product(3L,"C"),new Product(4L,"D"));

    public static Optional<Product> findById(Long id) {
        return PRODUCTS.stream()
                .filter(p -> p.id().equals(id)).findFirst();
    }

    public static String nameOfId(Long id) {
        Optional<Product> product=findById(id);
        return product.map(p -> p.name()).orElse("");
    }

    public static List<String> nameOfDiscounted(List<Long> ids) {
        return PRODUCTS.stream()
                .filter(p -> ids.contains(p.id())).map(p -> p.name()).collect(Collectors.toList());
    }

    public static List<Product> productsDiscounted(List<Long> ids) {
        Function<Optional<Product>, Stream<Product>> optToStreamFcn= (o) -> o.stream(); // Optional::stream;
        return ids.stream()
                .map(id -> findById(id)).flatMap(optToStreamFcn).collect(Collectors.toList());
    }


}
