package javaSE11_developer_certification_master.exception_handling.m2;

public class TryCatchFlowTwo {

    public static void main(String[] args) {

        StringBuilder sb = new StringBuilder();
        String str = null;
        try {
            sb.append("a");
            str.toUpperCase();  // gives null pointer exception
            sb.append("b");  //not executed
        } catch (IllegalArgumentException e) {   //not catched
            sb.append("c");
        } catch (Exception e) {  //catched
            sb.append("d");
        } finally {
            sb.append("e");  //always executed
        }
        System.out.println(sb);  //always executed
    }
}
