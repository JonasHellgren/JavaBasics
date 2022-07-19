# Composite pattern

Tree data structure, you will know a tree has parents and their children. There can be multiple children to a parent, 
but only one parent per child. In Composite Pattern, elements with children are called as Nodes, and elements without 
children are called as leaves.
The Composite Pattern allows us to build structures of objects in the form of trees that contains both composition of 
objects and individual objects as nodes. Using a composite structure, we can apply the same operations over both 
composites and individual objects. In other words, in most cases we can ignore the differences between compositions 
of objects and individual objects.

* Representations of part-whole hierarchies of objects is wanted.
* When you want clients to be able to ignore the difference between compositions of objects and individual objects. Clients will treat all objects in the composite structure uniformly.
