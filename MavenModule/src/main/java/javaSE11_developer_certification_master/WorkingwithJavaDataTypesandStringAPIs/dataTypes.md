#Java data types
WorkingwithJavaDataTypesandStringAPIs.

A "widening" cast is a cast from one type to another, where the "destination" type has a larger range or precision than the "source" (e.g. int to long, float to double). A "narrowing" cast is the exact opposite (long to int). A narrowing cast introduces the possibility of overflow.

Cmmas are NOT allowed in numeric literals       
        
    long worldPopulation = 7,674,000,000L;

Underscores are can be used instead         

    long worldPopulation = 7_674_000_000L;

Java supports base-10, octal, hexadecimal and binary number systems

Java supports Scientific Notation, for ex double lightSpeed = 5.88e10;

Pre-Unary Operators increment or decrement integrals/only the integral part

    xInt = 4;    int result = ++xInt  => result = 5
    xInt = 4;    int result = xInt++  => result = 4
    xInt = 1;   int result = xInt++ + xInt + xInt++;  => result = 5 xInt = 3

Compound assignment example

    xInt = 5;   yInt = 3;
    yInt += xInt; // 15,  same as yInt = yInt + xInt

Compound assignments automatically cast the result to the assign type

    byte xByte = 5;  double yDouble = 3.0;
    xByte += yDouble;  //same as  xByte = (byte)(xByte + yDouble);

Can use wrapper to convert
    
    Integer intWrapper = new Integer(7);
    short  shtVal = intWrapper.shortValue( ); // 7

Parse string to number

    String strNum = "1234";
    intVal = Integer.parseInt(strNum); // 1234

AutoboxingUnboxing
    
    Integer integer = 234;  //same as Integer integer2 = new Integer(234);

NamingConventions
avoid using underscores, void abbreviations; use full words, never start with upper case letter, use camel case.

    int totalAmount = 0; // perfect!

Multple numbers arguments

    public static void someMethod(int... nums){
    out.println(Arrays.toString(nums));
    }

    someMethod(5);
    someMethod(3,5,7,9);





