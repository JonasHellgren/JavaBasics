# Singleton

You may require only one object of a class, for example, when you are a creating the context of an application, or a thread manageable pool, registry settings, a driver to connect to the input or output console etc. More than one object of that type clearly will cause inconsistency to your program. 

When to use
* There must be exactly one instance of a class, and it must be accessible to clients from a well-known access point.
* When the sole instance should be extensible by sub-classing, and clients should be able to use an extended instance without modifying their code.
