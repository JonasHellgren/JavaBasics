# Core platform

### Input-and-output-with-streams 

Streams
- Ordered sequence of data
- Unidirectional
- Binary or character based

Try with-resources
- Automates resource clean up
- Implements AutoCloseable

Path object locates a file system item
Files object includes methods for file interaction

### String formatting

StringJoiner simplifies joining sequence of values

String.format is used to format text/numbers. 

### Collections

Common collection classes:
- ArrayList
- LinkedList
- HashSet
- TreeSet

### Properties

Properties class. Inherits from HashTable class. Kays and values as strings.

### Multithreading

Process
- Instance of a program/application
- Has resources such as memory, etc.
- Has at least one thread

Thread
- Sequence of programmed instructions
- The thing that executes a program’s code
- Utilizes process resources

Java offers thread pools
- Creates a queue for tasks
- Assigns tasks into a pool of threads
- Handles details of managing threads

### Annotations
        class Doer {
        @Deprecated
        void doItThisWay () { ...
        void doItThisNewWay () { ...
        }

One can declare custom annotations. Similar do declaring interfaces. @interface


