package medium.interface_signatures;

import java.util.ArrayList;
import java.util.List;

/***
 * https://medium.com/java-tips-and-tricks/java-clean-code-a-small-trick-to-simplify-interface-signatures-299a5f47fe65
 */

public class RunnerPortfolio {

    public static void main(String[] args) {

        PortfolioExtractor pp = c ->
                c.name().equals("VCC")
                        ? List.of(Product.of("V40", 10_000), Product.of("V60", 20_000))
                        : List.of(Product.of("FH", 1_000), Product.of("FL", 2_000));

        var swedishProducts = process(List.of(Company.of("VCC"), Company.of("ABV")), pp);
        System.out.println("swedishProducts = " + swedishProducts);

    }

    public static List<Product> process(List<Company> companies,
                                        PortfolioExtractor portfolios) {

        List<Product> products = new ArrayList<>();
        for (Company c : companies) {
            products.addAll(portfolios.apply(c));
        }
        return products;
    }

}
