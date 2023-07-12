package pluralsight_new_in_java17.java17_best_practices.m6stringsnumbers.src.main.java.com.cloudairlines;

public class DutyFreeShop {

    public static void main(String[] args) {

        double total = 0;
        total += 7.6;
        total += 7.8;
        System.out.println(total); // 15.4? no! 15.399999

    }
}
