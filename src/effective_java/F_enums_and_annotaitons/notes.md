Item 34: Use enums instead of int constants
            
            Lower risk to enter something out of the domain, while entering data and also improves 
            the program readability. Additionally, enums in Java can have more information associated 
            with them, and can also have behaviour.


Item 35: Use instance fields instead of ordinals

            Lowers bug risk when reordering

Item 36: Use EnumSet instead of bit fields
Item 37: Use EnumMap instead of ordinal indexing

            Similar to HashMap but EnumMap requires the key type in the constructor.

Item 38: Emulate extensible enums with interfaces
Item 39: Prefer annotations to naming patterns

            if (p.getClass().isAnnotationPresent(OnlyUpperCase.class)) {

Item 40: Consistently use the Override annotation
Item 41: Use marker interfaces to define types

            Unlike annotations, interfaces allow us to take advantage of polymorphism. 
            As a result, we can add additional restrictions to the marker interface.


https://www.oreilly.com/library/view/effective-java/9780134686097/