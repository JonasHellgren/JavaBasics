9 General Programming
Item 57: Minimize the scope of local variables
Item 58: Prefer for-each loops to traditional for loops
Item 59: Know and use the libraries

            lang and util are most important

https://www.tutorialspoint.com/java/lang/index.htm
https://www.tutorialspoint.com/java/util/index.htm
https://docs.oracle.com/en/java/javase/17/docs/api/allpackages-index.html
https://www.javatpoint.com/java-math

Item 60: Avoid float and double if exact answers are required

            Don’t use float or double for any calculations that require an exact answer. 
            Use BigDecimal if you want the system to keep track of the decimal point and you don’t 
            mind the inconvenience and cost of not using a primitive type. Using BigDecimal has the 
            added advantage that it gives you full control over rounding, letting you select from 
            eight rounding modes whenever an operation that entails rounding is performed

           
Item 61: Prefer primitive types to boxed primitives

            Autoboxing reduces the verbosity, but not the danger, of using boxed primitives
            When your program does mixed-type computations involving boxed and unboxed primitives, 
            it slowes down

Item 62: Avoid strings where other types are more appropriate
Item 63: Beware the performance of string concatenation
Item 64: Refer to objects by their interfaces
        
        LinkedHashSet<String> stringSet = new LinkedHashSet();
        we should instead implement something like:
        Set<String> stringSet = new LinkedHashSet();

        So maybe instead of using a LinkedHashSet like defined in the first example we could change it to a 
        HashSet without having to change any other code

Item 65: Prefer interfaces to reflection

Item 66: Use native methods judiciously

Item 67: Optimize judiciously

Item 68: Adhere to generally accepted naming conventions


https://www.oreilly.com/library/view/effective-java/9780134686097/