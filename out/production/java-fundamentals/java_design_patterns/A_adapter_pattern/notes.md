# Adapter pattern

The Adapter pattern lets you to adapt what an object exposes to what another object or class expects. 
It converts the interface of a class into another interface the client expects. It allows to fix the interface 
between objects without modifying the objects and the classes directly.

You can think of an Adapter as a real world adapter which is used to connect two different pieces of equipment that 
cannot be connected directly. The code that calls the adapter never needs to know that it’s not dealing with the kind of object it thinks it is, 
but an adapted object instead.

Usage
* There is an existing class, and its interface does not match the one you need.
*  You want to create a reusable class that cooperates with unrelated or unforeseen classes, that is, classes that don’t necessarily have compatible interfaces.
* There are several existing subclasses to be use, but it’s impractical to adapt their interface by subclassing every one. An object adapter can adapt the interface of its parent class.
