# Lambda expressions, collections and streams


## Map methods

The computeIfAbsent() version computes a new value from:
- the key passed as a parameter, that should not be in the map
- the lambda to compute the mapping from the key

Merge method. If key is not in map2: add the key / value pair to the map. If key is in the map: merge the existing value with the passed value using the lambda expression.

## Map filter reduce
Careful with reduction, needs to be associative and proper identity element.

## Stream

- Does not hold data
- Does not modify data it processes
- Source can be infinite

By skip method the can "jump over" initial elements. The method limit, bounds the size.

Three types of matchers: anyMatch(), allMatch() and noneMatch(). They are terminal operations that return a boolean

There are two types of find reduction: findAll() and findAny()