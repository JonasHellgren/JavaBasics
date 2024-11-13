package medium.properties_via_static_block;

public class RunnerPropertyReader {

    public static void main(String[] args) {

        System.out.println(AppConfig.getProperty("name"));
    }
}
