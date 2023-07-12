package pluralsight_new_in_java17.asynchronous_programming.m2.code;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.function.Supplier;

public class QuotationSupplierGenerator {
    static Random random = new Random();
    Supplier<Quotation> quotationA, quotationB, quotationC;

    public QuotationSupplierGenerator() {
        quotationA=fetchQuotationA;
        quotationB=fetchQuotationB;
        quotationC=fetchQuotationC;
    }

    Supplier<Quotation> fetchQuotationA =
            () -> {
                try {
                    Thread.sleep(random.nextInt(80, 120));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return new Quotation("Server A", random.nextInt(40, 60));
            };
    Supplier<Quotation> fetchQuotationB =
            () -> {
                try {
                    Thread.sleep(random.nextInt(80, 120));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return new Quotation("Server B", random.nextInt(30, 70));
            };
    Supplier<Quotation> fetchQuotationC =
            () -> {
                try {
                    Thread.sleep(random.nextInt(80, 120));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return new Quotation("Server C", random.nextInt(40, 80));
            };
    
}
