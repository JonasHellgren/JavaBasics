package pluralsight_courses.core_platform.multithreading;

public class TestAdderRunnable {

    public static void main(String[] args) {

        String path="src/java_fundamentals/core_platform/multithreading/";
        String[] inFiles= {path+"file1.txt",path+"file2.txt"};
        String[] outFiles= {path+"out1.txt",path+"out2.txt"};

        for(int i=0; i < inFiles.length; i++) {
            System.out.println("inFiles[i] = " + inFiles[i]);
            System.out.println("outFiles[i] = " + outFiles[i]);
        }

        for(int i=0; i < inFiles.length; i++) {
            AdderRunnable adder= new AdderRunnable(inFiles[i], outFiles[i]);
            Thread thread= new Thread(adder);
            thread.start();
        }

    }
}
