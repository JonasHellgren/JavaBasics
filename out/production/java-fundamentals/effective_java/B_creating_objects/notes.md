
# Creating and Destroying Objects

* Item 1: Consider static factory methods instead of constructors

        static Shape createRectangle(int width, int height) {
        return new Rectangle(width, height);
    }

![img.png](img.png)

* Item 2: Consider a builder when faced with many constructor
parameters
  
* Item 3: Enforce the singleton property with a private
constructor or an enum type


    public static ConnectionSingleton getSingletonInstance(String name, String url) {
        if (Objects.isNull(connection)) {
            connection=new ConnectionSingleton(name,url);
        }
        return connection;
    }

* Item 4: Enforce noninstantiability with a private constructor


     public UtilityClass() {
    throw new AssertionError();
    }
  

* Item  5: Avoid creating unnecessary objects
* Item 6: Eliminate obsolete object references

        elements[size] = null; // Eliminate obsolete reference

* Item 7: Avoid finalizers 


https://www.oreilly.com/library/view/effective-java/9780134686097/