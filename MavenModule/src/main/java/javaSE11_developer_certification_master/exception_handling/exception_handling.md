# Exception handling

Exceptions are managed by try-catch blocks, example:

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

A catch block above another must be a sub-class, hence following does not work

    try{
    ...some file operation
    }
    catch(IOExceptione) { }
    catch(FileNotFoundExceptione) { }  //FileNotFoundExceptione is sub-class of IOExceptione


- A checked exception is caught at compile time whereas a runtime or unchecked exception is, as it states, at runtime.
- A checked exception must be handled either by re-throwing or with a try catch block, whereas an unchecked isn't required to be handled.
- For example file reading must be checked

    doThis();  //compiles, exception does not to be checked
    // doThat();  //wont compile, exception needs to be checked
    System.out.println("This will not run");
          

    private static void doThat() throws IOException {
    throw new IOException();
    }

    private static void doThis() throws IllegalArgumentException {
    throw new IllegalArgumentException();
    }


One shall not try to catch an error, example error is OutOfMemoryError. Following will give StackOverflowError

    ------------------
    calculate(1, 2);
    ------------------
    private static void calculate(int a, int b) {
        calculate(a, b);
    }

With key word throws and throw one can raise an exception, in example below it does not need to checked in calling code

    void setAge1(int age) throws IllegalArgumentException {
        if(age <= 0) {
         throw new IllegalArgumentException();
        }
        this.age = age;
    }



