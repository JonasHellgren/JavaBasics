package javaSE11_developer_certification_master.exception_handling.m3;

public class TryWithResourcesReverseClose {

    public static void main(String[] args) {

        try (var one = new MyResource("One");
             var two = new MyResource("Two")) {
                throw new RuntimeException();
        }


    }
}
