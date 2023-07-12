package pluralsight_new_in_java17.asynchronous_programming.common;

import lombok.extern.java.Log;
import pluralsight_new_in_java17.asynchronous_programming.common.Quotation;

import java.util.Random;
import java.util.concurrent.Callable;

@Log
public class QuotationCallableGenerator {

    static Random random = new Random();
    public Callable<Quotation> quotationA;
    public Callable<Quotation> quotationB;
    public Callable<Quotation> quotationC;

    public QuotationCallableGenerator() {
        quotationA=fetchQuotationA;
        quotationB=fetchQuotationB;
        quotationC=fetchQuotationC;
    }

    Callable<Quotation> fetchQuotationA =
            () -> {
                Thread.sleep(random.nextInt(80, 120));
                log.info("QA fetched");
                return new Quotation("Server A", random.nextInt(40, 60));
            };
    Callable<Quotation> fetchQuotationB =
            () -> {
                Thread.sleep(random.nextInt(80, 120));
                log.info("QB fetched");
                return new Quotation("Server B", random.nextInt(30, 70));
            };
    Callable<Quotation> fetchQuotationC =
            () -> {
                Thread.sleep(random.nextInt(80, 120));
                log.info("QC fetched");
                return new Quotation("Server C", random.nextInt(40, 80));
            };

}
