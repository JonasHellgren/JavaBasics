package pluralsight_new_in_java17.asynchronous_programming.common;

import lombok.extern.java.Log;
import pluralsight_new_in_java17.asynchronous_programming.common.Quotation;

import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Log
public class QuotationSupplierGenerator {
    static Random random = new Random();
    public Supplier<Quotation> quotationA;
    public Supplier<Quotation> quotationB;
    public Supplier<Quotation> quotationC;

    public QuotationSupplierGenerator() {
        quotationA=fetchQuotationA;
        quotationB=fetchQuotationB;
        quotationC=fetchQuotationC;
    }

    public List<Supplier<Quotation>> buildQuotationTasks() {

        return List.of(quotationA, quotationB, quotationC);
    }

    Supplier<Quotation> fetchQuotationA =
            () -> {
                try {
                    Thread.sleep(random.nextInt(80, 120));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("QA fetched");
                return new Quotation("Server A", random.nextInt(40, 60));
            };
    Supplier<Quotation> fetchQuotationB =
            () -> {
                try {
                    Thread.sleep(random.nextInt(80, 120));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("QB fetched");
                return new Quotation("Server B", random.nextInt(30, 70));
            };
    Supplier<Quotation> fetchQuotationC =
            () -> {
                try {
                    Thread.sleep(random.nextInt(80, 120));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("QC fetched");
                return new Quotation("Server C", random.nextInt(40, 80));
            };
    
}
