package medium.interface_signatures;

import java.util.List;
import java.util.function.Function;

public  interface PortfolioExtractor extends Function<Company, List<Product>> {

}
