package pluralsight_new_in_java17.java17_best_practices.m8exceptions.src.main.java.com.cloudairlines;

public class SearchRequestDemo {

    public static void main(String[] args) {

        String[] searchInputs = {"From", "To", "50-60-70"};

        var request = new SearchRequest(searchInputs);

    }
}
