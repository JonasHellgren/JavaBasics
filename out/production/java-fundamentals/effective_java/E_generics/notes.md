
# Generics
* Item 26: Don’t use raw types
  
        Raw Type is If any generic class reference or instance is created 
        without mentioning the proper Type for the Generic type

* Item 27: Eliminate unchecked warnings
* Item 28: Prefer lists to arrays
  
      Lists checks type at compile time, arrays can fail at run time

* Item 29: Favor generic types
      
      Using generics allows type-safe abstraction without having to use typecasting which is much riskier in the long run.  

* Item 30: Favor generic methods
  
      public static <T> Set<T> union(Set<T> set1, Set<T> set2)
      raw type if not using <T>

* Item 31: Use bounded wildcards to increase API flexibility
  
          //list members are sub class of Number
          public static double sumNumberSubClass(List<? extends Number> list)

          //list members are super class of Integer
          public static double sumIntegerSuperClass(List<? super Integer> list)

          //list members are any class
          public static double sumUnBounded(List<?> list)

          Use the <? extends T> wildcard if you need to retrieve object of type T from a collection.
          Use the <? super T> wildcard if you need to put objects of type T in a collection.
          If you need to satisfy both things, well, don’t use any wildcard. As simple as it is.
          In short, remember the term PECS. Producer extends Consumer super. Really easy to remember.


* Item 32: Combine generics and varargs judiciously
* Item 33: Consider typesafe heterogeneous containers

        Enables multiple types in a data container 
        In summary, the normal use of generics, exemplified by the collections APIs, restricts you to a fixed 
        number of type parameters per container. You can get around this restriction by placing the type parameter 
        on the key rather than the container.

https://www.oreilly.com/library/view/effective-java/9780134686097/