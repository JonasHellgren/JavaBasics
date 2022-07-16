
Item 49: Check parameters for validity

            assert ....   throws AssertionError if true


Item 50: Make defensive copies when needed

     fields can be corrupted despite "immutable, avoided by
     this.start = new Date(start.getTime());

Item 51: Design method signatures carefully
Item 52: Use overloading judiciously
Item 53: Use varargs judiciously
Item 54: Return empty collections or arrays, not nulls
Item 55: Return optionals judiciously
Item 56: Write doc comments for all exposed API elements

        @param provides any useful description about a method's parameter or input it should expect
        @return provides a description of what a method will or can return
        @see will generate a link similar to the {@link} tag, but more in the context of a reference and not inline
        {@code text} Displays text in code font without interpreting the text as HTML markup or nested javadoc tags.

        https://www.baeldung.com/javadoc



https://www.oreilly.com/library/view/effective-java/9780134686097/